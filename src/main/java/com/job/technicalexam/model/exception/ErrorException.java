package com.job.technicalexam.model.exception;

import lombok.Data;

@Data
public class ErrorException extends Exception{
    private String error;

    public ErrorException(String message) {
        super(message);
        this.error = message;
    }
}
