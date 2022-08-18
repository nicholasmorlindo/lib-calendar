package com.tools.model;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

public class DateTimeClass {

    @NotNull
    private LocalTime initDate;

    @NotNull
    private LocalTime endDate;

    public DateTimeClass(LocalTime initDate, LocalTime endDate) {
        this.initDate = initDate;
        this.endDate = endDate;
    }

    public LocalTime getInitDate() {
        return initDate;
    }

    public void setInitDate(LocalTime initDate) {
        this.initDate = initDate;
    }

    public LocalTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalTime endDate) {
        this.endDate = endDate;
    }
}
