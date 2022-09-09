package com.nikk.schedule.repetition.exceptions;

import com.nikk.schedule.repetition.config.ScheduleRepetitionConfig;

public class DataMissingException extends ScheduleRepetitionException{

    public DataMissingException(String message) {
        super(message);
    }

    public static void validateFields(ScheduleRepetitionConfig config) throws DataMissingException {
        if (config.getBeginDate() == null || config.getEndDate() == null) {
            throw new DataMissingException("Begin Date or End Date are missing");
        }
    }
}
