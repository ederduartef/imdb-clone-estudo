package com.imdbclone.controller;

import com.imdbclone.model.Rating;
import com.imdbclone.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ratings")
@CrossOrigin(origins = "http://localhost:3000")
public class RatingController {
    
    @Autowired
    private RatingService ratingService;
    
    @PostMapping("/movies/{movieId}")
    public ResponseEntity<Rating> addRating(@PathVariable Long movieId, @RequestBody Map<String, Integer> request) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            // TODO: Implementar obtenção do ID do usuário a partir do token JWT
            Long userId = 1L; // Placeholder - deve ser obtido do token
            
            Integer score = request.get("score");
            if (score == null || score < 1 || score > 5) {
                return ResponseEntity.badRequest().build();
            }
            
            Rating rating = ratingService.addRating(movieId, userId, score);
            return ResponseEntity.ok(rating);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/movies/{movieId}")
    public ResponseEntity<List<Rating>> getRatingsByMovie(@PathVariable Long movieId) {
        List<Rating> ratings = ratingService.getRatingsByMovieId(movieId);
        return ResponseEntity.ok(ratings);
    }
    
    @GetMapping("/movies/{movieId}/average")
    public ResponseEntity<Map<String, Object>> getAverageRating(@PathVariable Long movieId) {
        Double average = ratingService.getAverageRatingByMovieId(movieId);
        Long count = ratingService.getRatingCountByMovieId(movieId);
        
        Map<String, Object> response = Map.of(
                "average", average != null ? average : 0.0,
                "count", count != null ? count : 0L
        );
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/movies/{movieId}/user")
    public ResponseEntity<Rating> getUserRating(@PathVariable Long movieId) {
        try {
            // TODO: Implementar obtenção do ID do usuário a partir do token JWT
            Long userId = 1L; // Placeholder - deve ser obtido do token
            
            return ratingService.getUserRatingForMovie(userId, movieId)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
} 