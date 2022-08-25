package com.nikk.schedule.repetition.enums;

import java.util.ArrayList;
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

    public static List<Integer> containsDays(List<DaysOfWeekEnum> daysOfWeekEnums) {
        List<Integer> listDayCode = new ArrayList<>();
        daysOfWeekEnums.stream().map(monthEnum -> listDayCode.add(monthEnum.getNumDay()));
        return listDayCode;
    }

//    public static boolean containsDaysOfWeek(int num) {
//        if (num == )
//    }

    public int getNumDay() {
        return numDay;
    }
}
