package com.pintarngoding.service;

import com.pintarngoding.utils.response.ResponseStatus;

import java.util.List;

public interface BaseService<T>{

    ResponseStatus addData(T data);

    ResponseStatus<List<T>> getAllData();
}
