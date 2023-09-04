package com.streams.api.services;

public interface IConverterData {

    <T> T  getData(String json, Class<T> classe);
}
