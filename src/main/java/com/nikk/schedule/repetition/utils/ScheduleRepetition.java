package com.nikk.schedule.repetition.utils;

import com.nikk.schedule.repetition.enums.MonthEnum;
import com.nikk.schedule.repetition.TimeRepetition;
import com.nikk.schedule.repetition.enums.DaysOfWeekEnum;
import com.nikk.schedule.repetition.config.ScheduleRepetitionConfig;
import com.nikk.schedule.repetition.result.ScheduleRepetitionResult;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleRepetition {

    public List<ScheduleRepetitionResult> createScheduleRepetition (ScheduleRepetitionConfig config) {

        List<ScheduleRepetitionResult> listScheduleRepetitionResult = new ArrayList<>();
        List<Integer> weekDaysByCode = DaysOfWeekEnum.containsDays(config.getListDays());
        List<Integer> monthByCode = MonthEnum.containsMonth(config.getListMonth());

        if (config.getListMonth().isEmpty()) {

                for (LocalDate auxDate = config.getBeginDate(); auxDate.isEqual(config.getEndDate()); auxDate = auxDate.plusDays(1)) {
                    if (config.getListDays().isEmpty()) {
                        if (config.getListTimeRepetition().isEmpty()) {
                            TimeRepetition defaultTimeRepetition = createTimeRepetitionDefault();
                            listScheduleRepetitionResult.add(buildScheduleRepetitionResult(auxDate, defaultTimeRepetition));
                        } else {
                            for (TimeRepetition time : config.getListTimeRepetition()) {
                                listScheduleRepetitionResult.add(buildScheduleRepetitionResult(auxDate, time));
                            }
                        }
                    } else {
                        for (Integer day : weekDaysByCode) {
                            if (day == auxDate.)
                        }
                    }

                }

        } else {

        }




//        for (int daysCount = config.getBeginDate().getDayOfMonth(); daysCount <= config.getBeginDate().getMonth().maxLength(); daysCount++) {
//
//        }

//        request.getListMonth().forEach(month -> {
//            LocalDate auxDate = LocalDate.of(request.getYear(), month.ordinal(), 01);
//            weekDaysByCode.forEach(day -> {
//                for (int daysCount = 1; daysCount <= auxDate.getMonth().maxLength(); daysCount++, auxDate.plusDays(daysCount)) {
//                    if (day == auxDate.getDayOfWeek().getValue()) {
//                        int finalDaysCount = daysCount;
//                        request.getListDateTime().forEach(time -> {
//                            listEventCalendarResponse.add(buildCalendarEventResponse(request, month, finalDaysCount, time));
//                        });
//                    }
//                }
//            });
//        });

        return listScheduleRepetitionResult;
    }

    private ScheduleRepetitionResult buildScheduleRepetitionResult(LocalDate date, TimeRepetition time) {
        LocalDateTime beginEvent = LocalDateTime.of(date, time.getInitEventTime());
        LocalDateTime endEvent = LocalDateTime.of(date, time.getEndEventTime());

        ScheduleRepetitionResult scheduleRepetitionResult = new ScheduleRepetitionResult(beginEvent, endEvent);
        return scheduleRepetitionResult;
    }

    private LocalDateTime buildLocalDateTime(Integer daysEnum, Integer monthEnum, LocalTime time, Integer year) {
        LocalDate localDate = LocalDate.of(year, monthEnum, daysEnum);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, time);
        return localDateTime;
    }

    public static void main(String[] args) {

        LocalDateTime teste = LocalDateTime.now().minusDays(1);
        System.out.println(teste.getDayOfMonth());
        System.out.println(teste.getMonthValue());
        System.out.println(teste.getDayOfWeek().getValue());
    }

    private boolean isTimeEmpty(List<TimeRepetition> listTimeRepetition) {
        if (listTimeRepetition.isEmpty()){
            return true;
        }
        return false;
    }

    private TimeRepetition createTimeRepetitionDefault() {
        TimeRepetition timeRepetition = new TimeRepetition();
        timeRepetition.setInitEventTime(LocalTime.of(8,0,0));
        timeRepetition.setEndEventTime(LocalTime.of(10,0,0));
        return timeRepetition;
    }
}


