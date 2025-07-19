package com.imdbclone.repository;

import com.imdbclone.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
    List<Comment> findByMovieIdOrderByCreatedAtDesc(Long movieId);
    
    List<Comment> findByUserId(Long userId);
    
    List<Comment> findByMovieIdAndUserId(Long movieId, Long userId);
} 