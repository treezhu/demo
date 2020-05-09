package com.treezhu.demo;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

public class NullToEmptyAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Class<T> rawType = (Class<T>) type.getRawType();
        if (!isRequiredType(rawType)) {
            return null;
        }
        return (TypeAdapter<T>) new BaseNullAdapter<T>();
    }

    private boolean isRequiredType(Class cla){
        return cla == int.class || cla == Integer.class
                || cla == String.class
                || cla == double.class || cla == Double.class
                || cla == boolean.class || cla == Boolean.class;
    }
}
