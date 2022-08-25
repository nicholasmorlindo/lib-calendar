package com.nikk.schedule.repetition.config;

import com.nikk.schedule.repetition.TimeRepetition;
import com.nikk.schedule.repetition.enums.DaysOfWeekEnum;
import com.nikk.schedule.repetition.enums.MonthEnum;

import java.time.LocalDate;
import java.util.List;

public class ScheduleRepetitionConfig {

    private List<TimeRepetition> listTimeRepetition;

    private List<MonthEnum> listMonth;

    private List<DaysOfWeekEnum> listDays;

    private LocalDate beginDate;

    private LocalDate endDate;

    public ScheduleRepetitionConfig(LocalDate beginDate, LocalDate endDate) {
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public List<TimeRepetition> getListTimeRepetition() {
        return listTimeRepetition;
    }

    public void setListTimeRepetition(List<TimeRepetition> listTimeRepetition) {
        this.listTimeRepetition = listTimeRepetition;
    }

    public List<MonthEnum> getListMonth() {
        return listMonth;
    }

    public void setListMonth(List<MonthEnum> listMonth) {
        this.listMonth = listMonth;
    }

    public List<DaysOfWeekEnum> getListDays() {
        return listDays;
    }

    public void setListDays(List<DaysOfWeekEnum> listDays) {
        this.listDays = listDays;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
