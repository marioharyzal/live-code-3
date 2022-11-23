package com.pintarngoding.utils.response;

public class SuccessResponse<T> extends ResponseStatus {
    public SuccessResponse(String message, T data) {
        super(true, message, data);
    }
}
