package com.tools.model.enums;

import java.util.ArrayList;
import java.util.List;

public enum DaysEnum {

    SEGUNDA(1),
    TERCA(2),
    QUARTA(3),
    QUINTA(4),
    SEXTA(5),
    SABADO(6),
    DOMINGO(7);

    private int numDay;

    DaysEnum(int numDay) {
        this.numDay = numDay;
    }

    public List<Integer> getDayByCode(List<DaysEnum> listDays) {

        List<Integer> listDaysByCode = new ArrayList<>();

        listDays.forEach(day -> {
            listDaysByCode.add(day.numDay);
        });

        return listDaysByCode;
    }
}
