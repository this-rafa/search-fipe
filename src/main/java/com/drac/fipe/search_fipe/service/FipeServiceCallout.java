package com.drac.fipe.search_fipe.service;

public class FipeServiceCallout {

    private final String URL_CORE = "https://parallelum.com.br/fipe/api/v1/";

    private HttpGetService service = new HttpGetService();

    public String getMarcas(String tipoVeiculo){
        return service.getCallApi(URL_CORE + String.format("%s/marcas", tipoVeiculo));
    }

    public String getModelos(String tipoVeiculo, String codigoMarca){
        return service.getCallApi(URL_CORE + 
            String.format("%s/marcas", tipoVeiculo) + "/" +
            String.format("%s/modelos", codigoMarca));
    }

}
