package com.drac.fipe.search_fipe.service;

import java.util.List;

public interface DataConverter {

    <T> List<T> getDataList(String json, Class<T> dtoClass);
    <T> T getData(String json, Class<T> dtoClass);

}
