package com.pintarngoding.utils.response;

public class FailedResponse<T> extends ResponseStatus {
    public FailedResponse(String message) {
        super(false, message, null);
    }
}
