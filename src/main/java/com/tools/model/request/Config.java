package com.tools.model.request;

import com.tools.model.DateTimeClass;
import com.tools.model.enums.DaysEnum;
import com.tools.model.enums.MonthEnum;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Config {

    @NotNull
    private List<DateTimeClass> listDateTime;

    @NotNull
    private List<MonthEnum> listMonth;

    @NotNull
    private List<DaysEnum> listDays;

    @NotNull
    private Integer year;

    private String EventDescription;

    public Config(List<DateTimeClass> listDateTime, List<MonthEnum> listMonth, List<DaysEnum> listDays, String eventDescription) {
        this.listDateTime = listDateTime;
        this.listMonth = listMonth;
        this.listDays = listDays;
        EventDescription = eventDescription;
    }

    public List<DateTimeClass> getListDateTime() {
        return listDateTime;
    }

    public void setListDateTime(List<DateTimeClass> listDateTime) {
        this.listDateTime = listDateTime;
    }

    public List<MonthEnum> getListMonth() {
        return listMonth;
    }

    public void setListMonth(List<MonthEnum> listMonth) {
        this.listMonth = listMonth;
    }

    public List<DaysEnum> getListDays() {
        return listDays;
    }

    public void setListDays(List<DaysEnum> listDays) {
        this.listDays = listDays;
    }

    public String getEventDescription() {
        return EventDescription;
    }

    public void setEventDescription(String eventDescription) {
        EventDescription = eventDescription;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
