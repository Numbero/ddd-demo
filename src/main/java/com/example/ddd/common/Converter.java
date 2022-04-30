package com.example.ddd.common;

public interface Converter<T, R> {

    R serialize(T t);

    T deserialize(R r);

}
