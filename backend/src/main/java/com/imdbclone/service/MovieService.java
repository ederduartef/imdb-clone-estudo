package com.imdbclone.service;

import com.imdbclone.dto.MovieDTO;
import com.imdbclone.model.Movie;
import com.imdbclone.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository movieRepository;
    
    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public Optional<MovieDTO> getMovieById(Long id) {
        return movieRepository.findById(id)
                .map(this::convertToDTO);
    }
    
    public List<MovieDTO> searchMoviesByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<MovieDTO> getMoviesByGenre(String genre) {
        return movieRepository.findByGenreIgnoreCase(genre).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<MovieDTO> getTopRatedMovies() {
        return movieRepository.findTopRatedMovies().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    private MovieDTO convertToDTO(Movie movie) {
        MovieDTO dto = new MovieDTO(
                movie.getId(),
                movie.getTitle(),
                movie.getDescription(),
                movie.getImageUrl(),
                movie.getReleaseYear(),
                movie.getDirector(),
                movie.getGenre()
        );
        
        // TODO: Implementar cálculo da média de avaliações
        // dto.setAverageRating(movie.getAverageRating());
        // dto.setRatingCount(movie.getRatingCount());
        
        return dto;
    }
    
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }
} 