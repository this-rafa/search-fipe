package com.drac.fipe.search_fipe.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FipeModeloDTO(@JsonAlias("codigo") Integer codigo,
                            @JsonAlias("nome") String nome,
                            @JsonAlias("modelos") List<FipeModeloDTO> modelos) {

}
