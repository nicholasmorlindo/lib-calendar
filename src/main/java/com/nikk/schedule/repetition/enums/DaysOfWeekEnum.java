package com.nikk.schedule.repetition.enums;

import java.util.List;

public enum DaysOfWeekEnum {

    MONDAY(1),
    THUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private int numDay;

    DaysOfWeekEnum(int numDay) {
        this.numDay = numDay;
    }

    public static boolean containsDays(int day, List<DaysOfWeekEnum> daysOfWeekEnums) {
        return daysOfWeekEnums.stream().anyMatch(daysOfWeek -> daysOfWeek.getNumDay() == day);
    }

    public int getNumDay() {
        return numDay;
    }
}
