/**
 * Um Objeto de Transferência de Dados (DTO) representando um objeto Fipe.
 * 
 * @param codigo O código do objeto Fipe.
 * @param nome O nome do objeto Fipe.
 */
package com.drac.fipe.search_fipe.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FipeObjectDTO(@JsonAlias("codigo") String codigo, @JsonAlias("nome") String nome) {

}
