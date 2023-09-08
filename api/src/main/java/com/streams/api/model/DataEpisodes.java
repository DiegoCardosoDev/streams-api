package com.streams.api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public record DataEpisodes(@JsonAlias("Title") String titulo,
                           @JsonAlias("imdbRating") String rating,
                           @JsonAlias("Released") String data){

}
