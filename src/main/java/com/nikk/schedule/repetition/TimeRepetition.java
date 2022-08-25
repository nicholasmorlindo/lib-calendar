package com.nikk.schedule.repetition;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

public class TimeRepetition {

    @NotNull
    private LocalTime initEventTime;

    @NotNull
    private LocalTime endEventTime;

    public TimeRepetition(){
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
