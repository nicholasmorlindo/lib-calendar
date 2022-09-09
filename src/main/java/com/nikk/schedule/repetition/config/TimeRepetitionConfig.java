package com.nikk.schedule.repetition.config;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

public class TimeRepetitionConfig {

    @NotNull
    private LocalTime initEventTime;

    @NotNull
    private LocalTime endEventTime;

    public TimeRepetitionConfig(){
    }

    public LocalTime getInitEventTime() {
        return initEventTime;
    }

    public void setInitEventTime(LocalTime initEventTime) {
        this.initEventTime = initEventTime;
    }

    public LocalTime getEndEventTime() {
        return endEventTime;
    }

    public void setEndEventTime(LocalTime endEventTime) {
        this.endEventTime = endEventTime;
    }
}
