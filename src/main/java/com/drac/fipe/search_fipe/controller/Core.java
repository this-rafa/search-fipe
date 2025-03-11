package com.drac.fipe.search_fipe.controller;

import java.util.List;

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

        System.out.println("Selecione uma marca de " + tipoVeiculo);
        
        marcasDto.stream().forEach(m -> {
            System.out.println("Codigo: " + m.codigo() + " - Marca: " + m.nome());
        });


    }

}
