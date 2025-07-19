package com.imdbclone.repository;

import com.imdbclone.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    
    List<Movie> findByTitleContainingIgnoreCase(String title);
    
    List<Movie> findByGenreIgnoreCase(String genre);
    
    List<Movie> findByReleaseYear(Integer releaseYear);
    
    @Query("SELECT m FROM Movie m ORDER BY m.ratings.size DESC")
    List<Movie> findTopRatedMovies();
} 