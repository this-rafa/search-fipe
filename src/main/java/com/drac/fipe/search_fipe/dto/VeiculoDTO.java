/**
 * Objeto de Transferência de Dados (DTO) para representar informações de veículos.
 * Esta classe é usada para mapear dados JSON para objetos Java usando anotações Jackson.
 * 
 * <p>Campos:</p>
 * <ul>
 *   <li>{@code tipoVeiculo} - O tipo do veículo, mapeado da propriedade JSON "TipoVeiculo".</li>
 *   <li>{@code valor} - O valor do veículo, mapeado da propriedade JSON "Valor".</li>
 *   <li>{@code marca} - A marca do veículo, mapeada da propriedade JSON "Marca".</li>
 *   <li>{@code modelo} - O modelo do veículo, mapeado da propriedade JSON "Modelo".</li>
 *   <li>{@code anoModelo} - O ano do modelo do veículo, mapeado da propriedade JSON "AnoModelo".</li>
 *   <li>{@code combustivel} - O tipo de combustível do veículo, mapeado da propriedade JSON "Combustivel".</li>
 *   <li>{@code codigoFipe} - O código FIPE do veículo, mapeado da propriedade JSON "CodigoFipe".</li>
 *   <li>{@code mesReferencia} - O mês de referência para os dados do veículo, mapeado da propriedade JSON "MesReferencia".</li>
 * </ul>
 * 
 * <p>Nota: Esta classe ignora quaisquer propriedades desconhecidas nos dados JSON.</p>
 */
package com.drac.fipe.search_fipe.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VeiculoDTO(@JsonAlias("TipoVeiculo") Integer tipoVeiculo,
        @JsonAlias("Valor") String valor,
        @JsonAlias("Marca") String marca,
        @JsonAlias("Modelo") String modelo,
        @JsonAlias("AnoModelo") Integer anoModelo,
        @JsonAlias("Combustivel") String combustivel,
        @JsonAlias("CodigoFipe") String codigoFipe,
        @JsonAlias("MesReferencia") String mesReferencia) {

}
