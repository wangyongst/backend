package com.myweb.jumia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {
    @JsonProperty("ErrorResponse")
    private Head ErrorResponse;

    public Head getErrorResponse() {
        return ErrorResponse;
    }

    public void setErrorResponse(Head errorResponse) {
        ErrorResponse = errorResponse;
    }
}
