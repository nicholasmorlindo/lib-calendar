package com.tools.model.response;

import java.time.LocalDateTime;

public class CalendarEventResponse {

    private LocalDateTime initEventTime;
    private LocalDateTime endEventTime;

    public CalendarEventResponse(){
    }

    public CalendarEventResponse(LocalDateTime initEventTime, LocalDateTime endEventTime) {
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
