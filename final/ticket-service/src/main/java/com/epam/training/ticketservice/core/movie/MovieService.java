package com.epam.training.ticketservice.core.movie;

import com.epam.training.ticketservice.core.movie.model.MovieDto;
import com.epam.training.ticketservice.core.movie.persistence.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<MovieDto> getMovieList();

    Movie findMovieByTitle(String title);

    void createMovie(MovieDto movieDto);

    MovieDto updateMovie(MovieDto movieDto);

    MovieDto deleteMovie(String title);
}
