package com.nikk.schedule.repetition.enums;

import java.util.List;

public enum MonthEnum {

    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    private Integer monthCode;

    MonthEnum(Integer monthCode) {
        this.monthCode = monthCode;
    }

    public static boolean containsMonth(int month, List<MonthEnum> monthEnums) {
        return monthEnums.stream().anyMatch(monthFromList -> monthFromList.getMonthCode() == month);
    }

    public Integer getMonthCode() {
        return monthCode;
    }
}
