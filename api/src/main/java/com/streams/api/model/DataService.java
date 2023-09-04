package com.streams.api.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public record DataService(@JsonAlias("Title") String titulo,
                          @JsonAlias("totalSeasons") Integer totalTemporadas,
                          @JsonAlias("imdbRating") String avaliacao) {

}
