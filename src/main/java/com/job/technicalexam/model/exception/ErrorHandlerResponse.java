package com.job.technicalexam.model.exception;

import lombok.Data;

@Data
public class ErrorHandlerResponse {
    private String error;

    public ErrorHandlerResponse(String error) {
        this.error = error;
    }
}
