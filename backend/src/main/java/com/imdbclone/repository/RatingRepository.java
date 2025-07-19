package com.imdbclone.repository;

import com.imdbclone.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    
    List<Rating> findByMovieId(Long movieId);
    
    List<Rating> findByUserId(Long userId);
    
    Optional<Rating> findByUserIdAndMovieId(Long userId, Long movieId);
    
    @Query("SELECT AVG(r.score) FROM Rating r WHERE r.movie.id = ?1")
    Double getAverageRatingByMovieId(Long movieId);
    
    @Query("SELECT COUNT(r) FROM Rating r WHERE r.movie.id = ?1")
    Long getRatingCountByMovieId(Long movieId);
} 