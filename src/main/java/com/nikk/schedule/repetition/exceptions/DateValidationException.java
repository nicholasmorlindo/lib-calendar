package com.nikk.schedule.repetition.exceptions;

import com.nikk.schedule.repetition.config.ScheduleRepetitionConfig;

import java.time.LocalDate;

public class DateValidationException extends ScheduleRepetitionException{

    public DateValidationException(String message) {
        super(message);
    }

    public static void validateDates (ScheduleRepetitionConfig config) throws DateValidationException {
        if (config.getEndDate().compareTo(config.getBeginDate()) < 0) {
            throw new DateValidationException("beginDate must be earlier than endDate");
        }

        if (config.getBeginDate().compareTo(LocalDate.now()) < 0) {
            throw new DateValidationException("beginDate must be in the present or future");
        }
    }
}
