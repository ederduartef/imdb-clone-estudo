package com.imdbclone.service;

import com.imdbclone.model.Movie;
import com.imdbclone.model.Rating;
import com.imdbclone.model.User;
import com.imdbclone.repository.MovieRepository;
import com.imdbclone.repository.RatingRepository;
import com.imdbclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    
    @Autowired
    private RatingRepository ratingRepository;
    
    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public Rating addRating(Long movieId, Long userId, Integer score) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        // Verificar se o usuário já avaliou este filme
        Optional<Rating> existingRating = ratingRepository.findByUserIdAndMovieId(userId, movieId);
        
        if (existingRating.isPresent()) {
            // Atualizar avaliação existente
            Rating rating = existingRating.get();
            rating.setScore(score);
            return ratingRepository.save(rating);
        } else {
            // Criar nova avaliação
            Rating rating = new Rating(score, user, movie);
            return ratingRepository.save(rating);
        }
    }
    
    public List<Rating> getRatingsByMovieId(Long movieId) {
        return ratingRepository.findByMovieId(movieId);
    }
    
    public List<Rating> getRatingsByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }
    
    public Double getAverageRatingByMovieId(Long movieId) {
        return ratingRepository.getAverageRatingByMovieId(movieId);
    }
    
    public Long getRatingCountByMovieId(Long movieId) {
        return ratingRepository.getRatingCountByMovieId(movieId);
    }
    
    public Optional<Rating> getUserRatingForMovie(Long userId, Long movieId) {
        return ratingRepository.findByUserIdAndMovieId(userId, movieId);
    }
} 