package com.example.userservice.common;

public class BaseEvent<T> {
    public final T id;
    public BaseEvent(T id) {
        this.id = id;
    }
}
