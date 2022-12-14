package com.nikk.schedule.repetition;

import com.nikk.schedule.repetition.config.ScheduleRepetitionConfig;
import com.nikk.schedule.repetition.config.TimeRepetitionConfig;
import com.nikk.schedule.repetition.enums.DaysOfWeekEnum;
import com.nikk.schedule.repetition.enums.MonthEnum;
import com.nikk.schedule.repetition.exceptions.DataMissingException;
import com.nikk.schedule.repetition.exceptions.DateValidationException;
import com.nikk.schedule.repetition.exceptions.ScheduleRepetitionException;
import com.nikk.schedule.repetition.result.ScheduleRepetitionResult;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScheduleRepetition {

    public static List<ScheduleRepetitionResult> createScheduleRepetition (ScheduleRepetitionConfig config) throws ScheduleRepetitionException {

        validateFields(config);
        validateDates(config);

        List<ScheduleRepetitionResult> listScheduleRepetitionResult = new ArrayList<>();
        List<TimeRepetitionConfig> listTimeRepetitionToUse = config.getListTimeRepetition().isEmpty() ? createTimeRepetitionDefault() : config.getListTimeRepetition();
        List<MonthEnum> listMonthToUse = config.getListMonth().isEmpty() ? createMonthEnumDefault() : config.getListMonth();
        List<DaysOfWeekEnum> listDaysOfWeekToUse = config.getListDays().isEmpty() ? createDaysOfWeekEnumDefault() : config.getListDays();

        LocalDate auxDate = config.getBeginDate();

        while (auxDate.compareTo(config.getEndDate()) <= 0) {
            if (!MonthEnum.containsMonth(auxDate.getMonthValue(), listMonthToUse)){
                auxDate = auxDate.plusMonths(1);
                auxDate = auxDate.withDayOfMonth(1);
                continue;
            }

            if (DaysOfWeekEnum.containsDays(auxDate.getDayOfWeek().getValue(), listDaysOfWeekToUse)){
                fillListWithScheduleRepetition(listScheduleRepetitionResult, listTimeRepetitionToUse, auxDate);
            }

            auxDate = auxDate.plusDays(1);
        }

        return listScheduleRepetitionResult;
    }

    private static void fillListWithScheduleRepetition(List<ScheduleRepetitionResult> listScheduleRepetitionResult, List<TimeRepetitionConfig> timeToUse, LocalDate auxDate) {
        for (TimeRepetitionConfig time : timeToUse) {
            listScheduleRepetitionResult.add(buildScheduleRepetitionResult(auxDate, time));
        }
    }

    private static ScheduleRepetitionResult buildScheduleRepetitionResult(LocalDate date, TimeRepetitionConfig time) {
        LocalDateTime begin = LocalDateTime.of(date, time.getInitEventTime());
        LocalDateTime end = LocalDateTime.of(date, time.getEndEventTime());
        return new ScheduleRepetitionResult(begin, end);
    }

    private static List<TimeRepetitionConfig> createTimeRepetitionDefault() {
        List<TimeRepetitionConfig> listTimeRepetition = new ArrayList<>();
        TimeRepetitionConfig timeRepetition = new TimeRepetitionConfig();
        timeRepetition.setInitEventTime(LocalTime.of(8,0,0));
        timeRepetition.setEndEventTime(LocalTime.of(10,0,0));

        listTimeRepetition.add(timeRepetition);
        return listTimeRepetition;
    }

    private static List<MonthEnum> createMonthEnumDefault() {
        Stream<MonthEnum> listMonthEnum = Arrays.stream(MonthEnum.values());
        return listMonthEnum.collect(Collectors.toList());
    }

    private static List<DaysOfWeekEnum> createDaysOfWeekEnumDefault() {
        Stream<DaysOfWeekEnum> listDaysOfWeek = Arrays.stream(DaysOfWeekEnum.values());
        return listDaysOfWeek.collect(Collectors.toList());
    }

    private static void validateFields(ScheduleRepetitionConfig config) throws DataMissingException {
        if (config.getBeginDate() == null || config.getEndDate() == null) {
            throw new DataMissingException("Begin Date or End Date are missing");
        }
    }

    private static void validateDates (ScheduleRepetitionConfig config) throws DateValidationException {
        if (config.getEndDate().compareTo(config.getBeginDate()) < 0) {
            throw new DateValidationException("beginDate must be earlier than endDate");
        }

        if (config.getBeginDate().compareTo(LocalDate.now()) < 0) {
            throw new DateValidationException("beginDate must be in the present or future");
        }
    }

    public static void main(String[] args) throws ScheduleRepetitionException {
        List<TimeRepetitionConfig> timeRepetitionList = new ArrayList<>();
        TimeRepetitionConfig timeRepetition = new TimeRepetitionConfig();
        TimeRepetitionConfig timeRepetition2 = new TimeRepetitionConfig();
        timeRepetition.setInitEventTime(LocalTime.of(10,0,0));
        timeRepetition.setEndEventTime(LocalTime.of(12,0,0));
        timeRepetition2.setInitEventTime(LocalTime.of(20,0,0));
        timeRepetition2.setEndEventTime(LocalTime.of(22,0,0));
        timeRepetitionList.add(timeRepetition);
        timeRepetitionList.add(timeRepetition2);

        List<MonthEnum> monthEnumList = new ArrayList<>();
        monthEnumList.add(MonthEnum.JANUARY);
        monthEnumList.add(MonthEnum.APRIL);
        monthEnumList.add(MonthEnum.JULY);
        monthEnumList.add(MonthEnum.SEPTEMBER);

        List<DaysOfWeekEnum> daysOfWeekEnumList = new ArrayList<>();
        daysOfWeekEnumList.add(DaysOfWeekEnum.MONDAY);
        daysOfWeekEnumList.add(DaysOfWeekEnum.FRIDAY);

        LocalDate beginDate = LocalDate.of(2022,1,31);
        LocalDate endDate = LocalDate.of(2022,9, 30);

        ScheduleRepetitionConfig scheduleRepetitionConfig = new ScheduleRepetitionConfig(beginDate, endDate);
        scheduleRepetitionConfig.setListTimeRepetition(timeRepetitionList);
        scheduleRepetitionConfig.setListMonth(monthEnumList);
        scheduleRepetitionConfig.setListDays(daysOfWeekEnumList);

        List<ScheduleRepetitionResult> scheduleRepetitionResultList = ScheduleRepetition.createScheduleRepetition(scheduleRepetitionConfig);

        scheduleRepetitionResultList.forEach(scheduleRepetitionResult -> {
            System.out.println(scheduleRepetitionResult.getInitEventTime());
            System.out.println(scheduleRepetitionResult.getEndEventTime());
        });
    }
}


