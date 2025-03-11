package com.drac.fipe.search_fipe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.drac.fipe.search_fipe.controller.Core;


@SpringBootApplication
public class SearchFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SearchFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Core core = new Core();
		core.run();
	}

}
