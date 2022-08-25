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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScheduleRepetition {

    public List<ScheduleRepetitionResult> createScheduleRepetition (ScheduleRepetitionConfig config) {

        List<ScheduleRepetitionResult> listScheduleRepetitionResult = new ArrayList<>();
        List<TimeRepetition> listTimeRepetitionToUse = config.getListTimeRepetition().isEmpty() ? createTimeRepetitionDefault() : config.getListTimeRepetition();
        List<MonthEnum> listMonthToUse = config.getListMonth().isEmpty() ? createMonthEnumDefault() : config.getListMonth();
        List<DaysOfWeekEnum> listDaysOfWeekToUse = config.getListDays().isEmpty() ? createDaysOfWeekEnumDefault() : config.getListDays();

        LocalDate auxDate = config.getBeginDate();

        while (auxDate.compareTo(config.getEndDate()) <= 0) {
            while (!MonthEnum.containsMonth(auxDate.getMonthValue(), listMonthToUse)){
                auxDate.plusMonths(1);
                auxDate.withDayOfMonth(1);
            }

            if (DaysOfWeekEnum.containsDays(auxDate.getDayOfWeek().getValue(), listDaysOfWeekToUse)){
                fillListWithScheduleRepetition(listScheduleRepetitionResult, listTimeRepetitionToUse, auxDate);
            }

            auxDate = auxDate.plusDays(1);
        }

        return listScheduleRepetitionResult;
    }

    private void fillListWithScheduleRepetition(List<ScheduleRepetitionResult> listScheduleRepetitionResult, List<TimeRepetition> timeToUse, LocalDate auxDate) {
        for (TimeRepetition time : timeToUse) {
            listScheduleRepetitionResult.add(buildScheduleRepetitionResult(auxDate, time));
        }
    }

    private ScheduleRepetitionResult buildScheduleRepetitionResult(LocalDate date, TimeRepetition time) {
        LocalDateTime begin = LocalDateTime.of(date, time.getInitEventTime());
        LocalDateTime end = LocalDateTime.of(date, time.getEndEventTime());
        return new ScheduleRepetitionResult(begin, end);
    }

    private List<TimeRepetition> createTimeRepetitionDefault() {
        List<TimeRepetition> listTimeRepetition = new ArrayList<>();
        TimeRepetition timeRepetition = new TimeRepetition();
        timeRepetition.setInitEventTime(LocalTime.of(8,0,0));
        timeRepetition.setEndEventTime(LocalTime.of(10,0,0));

        listTimeRepetition.add(timeRepetition);
        return listTimeRepetition;
    }

    private List<MonthEnum> createMonthEnumDefault() {
        Stream<MonthEnum> listMonthEnum = Arrays.stream(MonthEnum.values());
        return listMonthEnum.collect(Collectors.toList());
    }

    private List<DaysOfWeekEnum> createDaysOfWeekEnumDefault() {
        Stream<DaysOfWeekEnum> listDaysOfWeek = Arrays.stream(DaysOfWeekEnum.values());
        return listDaysOfWeek.collect(Collectors.toList());
    }
}


