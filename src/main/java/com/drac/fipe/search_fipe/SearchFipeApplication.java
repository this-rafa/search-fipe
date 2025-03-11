package com.drac.fipe.search_fipe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.drac.fipe.search_fipe.service.HttpGetService;

@SpringBootApplication
public class SearchFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SearchFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(new HttpGetService()
				.getCallApi("https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/anos/2014-3"));

	}

}
