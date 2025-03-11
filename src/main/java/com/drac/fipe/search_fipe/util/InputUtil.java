package com.drac.fipe.search_fipe.util;

import java.util.List;


public class InputUtil {

    public boolean validarInput(List<String> valid, String input){
        return valid.stream()
        .filter(i -> i.toUpperCase().contains(input.toUpperCase()))
        .findFirst()
        .isPresent();
    }

}
