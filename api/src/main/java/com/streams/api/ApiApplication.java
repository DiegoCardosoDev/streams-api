package com.streams.api;

import com.streams.api.model.DataEpisodes;
import com.streams.api.model.SeasonData;
import com.streams.api.services.ConsummerApi;
import com.streams.api.services.ConverterData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ApiApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsummerApi();
		var json = consumoApi.getData("https://www.omdbapi.com/?t=one-piece&season1&apikey=6585022c");
//		System.out.println(json);
//		json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);
		ConverterData conversor = new ConverterData();
		SeasonData dados = conversor.getData(json, SeasonData.class);

		List<SeasonData> seasonDataList = new ArrayList<>();
		for (int i = 1; i<= dados.totalSeasons(); i++){

			json = consumoApi.getData("https://www.omdbapi.com/?t=one-piece&season=" + i + "&apikey=6585022c");
			SeasonData seasonData = conversor.getData(json, SeasonData.class);
			seasonDataList.add(seasonData);
		}
		seasonDataList.forEach(System.out::println);
	}


}
