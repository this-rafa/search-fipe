package com.drac.fipe.search_fipe.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.drac.fipe.search_fipe.dto.FipeModeloDTO;
import com.drac.fipe.search_fipe.dto.FipeObjectDTO;
import com.drac.fipe.search_fipe.service.FipeServiceCallout;
import com.drac.fipe.search_fipe.service.JsonDataConverter;

public class Core {

    private  JsonDataConverter converter = new JsonDataConverter();
    private FipeServiceCallout fipeServiceCallout = new FipeServiceCallout();
    private Menu menu = new Menu();

    public void run(){

        menu.showMenuInicial();
        String tipoVeiculo = menu.selecionarTipoVeiculo();

        String json = fipeServiceCallout.getMarcas(tipoVeiculo);

        List<FipeObjectDTO> marcasDto = converter.getDataList(json, FipeObjectDTO.class);

        marcasDto.stream().forEach(m -> {
            System.out.println("Codigo: " + m.codigo() + " - Marca: " + m.nome());
        });

        String codigoMarca = menu.selecionarMarcaVeiculo();
        json = fipeServiceCallout.getModelos(tipoVeiculo, codigoMarca);
        
        FipeModeloDTO modelosDto = converter.getData(json, FipeModeloDTO.class);

        List<FipeModeloDTO> modelosDtoList = modelosDto.modelos().stream().collect(Collectors.toList());

        modelosDtoList.stream().forEach(m -> {
            System.out.println("Codigo: " + m.codigo() + " - Modelo: " + m.nome());
        });

    }

}
