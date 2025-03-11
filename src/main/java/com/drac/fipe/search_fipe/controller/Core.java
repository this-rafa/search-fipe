package com.drac.fipe.search_fipe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.drac.fipe.search_fipe.dto.FipeModeloDTO;
import com.drac.fipe.search_fipe.dto.FipeObjectDTO;
import com.drac.fipe.search_fipe.dto.VeiculoDTO;
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

        String codigoModelo = menu.selecionarModeloVeiculo();

        json = fipeServiceCallout.getAnos(tipoVeiculo, codigoMarca, codigoModelo);
        
        List<FipeObjectDTO> anosDto = converter.getDataList(json, FipeObjectDTO.class);

        List<VeiculoDTO> veiculosDto = new ArrayList<>();

        for(FipeObjectDTO ano : anosDto){
            
            String jsonVeiculo = fipeServiceCallout.getVeiculo(tipoVeiculo, codigoMarca, codigoModelo, ano.codigo());
            VeiculoDTO veic = converter.getData(jsonVeiculo, VeiculoDTO.class);
            veiculosDto.add(veic);
        }

        veiculosDto.stream()
            .forEach(v -> {
                System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                System.out.println("Marca: " + v.marca() + " - Modelo: " + v.modelo());
                System.out.println("Cod. referencia: " + v.codigoFipe() + " - Valor: " + v.valor());
                System.out.println("Ano: " + v.anoModelo() + " - Combustivel: " + v.combustivel());
            });

    }

}
