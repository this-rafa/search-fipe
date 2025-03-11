package com.drac.fipe.search_fipe.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Classe responsável por converter dados JSON em objetos Java.
 * Implementa a interface DataConverter.
 * Utiliza a biblioteca Jackson para realizar a conversão.
 * 
 * @autor Rafael Carvalho
 */
public class JsonDataConverter implements DataConverter {

    private ObjectMapper mapper = new ObjectMapper();

    /**
     * Converte uma string JSON em um objeto do tipo especificado.
     *
     * @param <T> o tipo do objeto a ser retornado
     * @param json a string JSON a ser convertida
     * @param dtoClass a classe do tipo T
     * @return o objeto convertido do tipo T
     * @throws RuntimeException se ocorrer um erro durante o processamento do JSON
     */
    @Override
    public <T> List<T> getDataList(String json, Class<T> dtoClass) {
        
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, dtoClass));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public <T> T getData(String json, Class<T> dtoClass) {
        try {
            return mapper.readValue(json, dtoClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
