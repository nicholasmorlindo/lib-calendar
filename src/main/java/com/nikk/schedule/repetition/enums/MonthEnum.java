package com.nikk.schedule.repetition.enums;

import java.util.ArrayList;
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

    public static List<Integer> containsMonth(List<MonthEnum> monthEnums) {
        List<Integer> listMonthCode = new ArrayList<>();
        monthEnums.stream().map(monthEnum -> listMonthCode.add(monthEnum.getMonthCode()));
        return listMonthCode;
    }

    public Integer getMonthCode() {
        return monthCode;
    }
}
