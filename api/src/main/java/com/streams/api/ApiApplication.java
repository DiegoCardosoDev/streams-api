package com.streams.api;

import com.streams.api.model.DataService;
import com.streams.api.services.ConsummerApi;
import com.streams.api.services.ConverterData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsummerApi();
		var json = consumoApi.getData("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
//		System.out.println(json);
//		json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);
		ConverterData conversor = new ConverterData();
		DataService dados = conversor.getData(json, DataService.class);
		System.out.println(dados);
	}

}
