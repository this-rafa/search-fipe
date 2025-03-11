package com.drac.fipe.search_fipe.controller;

import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);

    public void showMenuInicial() {
        System.out.println("|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");
        System.out.println("|-------- Pesquisa FIPE ----------|");
        System.out.println("|_________________________________|");
    }

    public String selecionarTipoVeiculo() {
        System.out.println("Selecione uma marca de veiculo:");
        return scanner.nextLine();
    }

    public String selecionarMarcaVeiculo() {
        System.out.println("Selecione uma modelo de veiculo:");
        return scanner.nextLine();
    }

    public String selecionarModeloVeiculo(){
        System.out.println("Selecione um modelo de veiculo:");
        return scanner.nextLine();
    }

}
