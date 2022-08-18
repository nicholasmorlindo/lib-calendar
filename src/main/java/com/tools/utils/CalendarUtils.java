package com.tools.utils;

import com.tools.model.DateTimeClass;
import com.tools.model.enums.DaysEnum;
import com.tools.model.enums.MonthEnum;
import com.tools.model.request.Config;
import com.tools.model.response.CalendarEventResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CalendarUtils {

    public List<CalendarEventResponse> createEvent (Config request) {

        List<CalendarEventResponse> listEventCalendarResponse = new ArrayList<>();
        List<Integer> weekDaysByCode = getDaysByCode(request.getListDays());

        request.getListMonth().forEach(month -> {
            LocalDate auxDate = LocalDate.of(request.getYear(), month.ordinal(), 01);
            weekDaysByCode.forEach(day -> {
                for (int daysCount = 1; daysCount <= auxDate.getMonth().maxLength(); daysCount++, auxDate.plusDays(daysCount)) {
                    if (day == auxDate.getDayOfWeek().getValue()) {
                        int finalDaysCount = daysCount;
                        request.getListDateTime().forEach(time -> {
                            listEventCalendarResponse.add(buildCalendarEventResponse(request, month, finalDaysCount, time));
                        });
                    }
                }
            });
        });

        return listEventCalendarResponse;
    }

    private CalendarEventResponse buildCalendarEventResponse(Config request, MonthEnum month, Integer day, DateTimeClass time) {
        LocalDateTime beginLocalDateTime = buildLocalDateTime(day, month.ordinal(), time.getInitDate(), request.getYear());
        LocalDateTime endLocalDateTime = buildLocalDateTime(day, month.ordinal(), time.getEndDate(), request.getYear());
        CalendarEventResponse response = new CalendarEventResponse(beginLocalDateTime, endLocalDateTime);
        return response;
    }

    private LocalDateTime buildLocalDateTime(Integer daysEnum, Integer monthEnum, LocalTime time, Integer year) {
        LocalDate localDate = LocalDate.of(year, monthEnum, daysEnum);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, time);
        return localDateTime;
    }

    private List<Integer> getDaysByCode (List<DaysEnum> daysEnums) {
        List<Integer> listDaysByCode = new ArrayList<>();
        daysEnums.forEach(day -> {
            listDaysByCode.add(day.ordinal());
        });

        return listDaysByCode;
    }

    public static void main(String[] args) {

        LocalDateTime teste = LocalDateTime.now().minusDays(1);
        System.out.println(teste.getDayOfMonth());
        System.out.println(teste.getMonthValue());
        System.out.println(teste.getDayOfWeek().getValue());

    }
}


