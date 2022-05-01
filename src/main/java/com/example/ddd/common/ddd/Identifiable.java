package com.example.ddd.common.ddd;

public interface Identifiable <T extends Identifier>{

    T getId();

    void serId(T id);

}
