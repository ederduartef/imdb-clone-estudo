package com.imdbclone.controller;

import com.imdbclone.dto.MovieDTO;
import com.imdbclone.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {
    
    @Autowired
    private MovieService movieService;
    
    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<MovieDTO>> searchMovies(@RequestParam String title) {
        List<MovieDTO> movies = movieService.searchMoviesByTitle(title);
        return ResponseEntity.ok(movies);
    }
    
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<MovieDTO>> getMoviesByGenre(@PathVariable String genre) {
        List<MovieDTO> movies = movieService.getMoviesByGenre(genre);
        return ResponseEntity.ok(movies);
    }
    
    @GetMapping("/top-rated")
    public ResponseEntity<List<MovieDTO>> getTopRatedMovies() {
        List<MovieDTO> movies = movieService.getTopRatedMovies();
        return ResponseEntity.ok(movies);
    }
    
    // TODO: Implementar endpoint para adicionar novo filme (apenas para admins)
    // @PostMapping
    // public ResponseEntity<MovieDTO> addMovie(@RequestBody Movie movie) {
    //     // Implementar lógica para adicionar filme
    // }
} 