package com.nikk.schedule.repetition.result;

import java.time.LocalDateTime;

public class ScheduleRepetitionResult {

    private LocalDateTime initEventTime;
    private LocalDateTime endEventTime;

    public ScheduleRepetitionResult(){
    }

    public ScheduleRepetitionResult(LocalDateTime initEventTime, LocalDateTime endEventTime) {
        this.initEventTime = initEventTime;
        this.endEventTime = endEventTime;
    }

    public LocalDateTime getInitEventTime() {
        return initEventTime;
    }

    public void setInitEventTime(LocalDateTime initEventTime) {
        this.initEventTime = initEventTime;
    }

    public LocalDateTime getEndEventTime() {
        return endEventTime;
    }

    public void setEndEventTime(LocalDateTime endEventTime) {
        this.endEventTime = endEventTime;
    }
}
