package com.imdbclone.service;

import com.imdbclone.dto.CommentDTO;
import com.imdbclone.model.Comment;
import com.imdbclone.model.Movie;
import com.imdbclone.model.User;
import com.imdbclone.repository.CommentRepository;
import com.imdbclone.repository.MovieRepository;
import com.imdbclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    
    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    public Comment addComment(Long movieId, Long userId, String content) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        Comment comment = new Comment(content, user, movie);
        return commentRepository.save(comment);
    }
    
    public List<CommentDTO> getCommentsByMovieId(Long movieId) {
        return commentRepository.findByMovieIdOrderByCreatedAtDesc(movieId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<CommentDTO> getCommentsByUserId(Long userId) {
        return commentRepository.findByUserId(userId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    private CommentDTO convertToDTO(Comment comment) {
        return new CommentDTO(
                comment.getId(),
                comment.getContent(),
                comment.getUser().getUsername(),
                comment.getCreatedAt()
        );
    }
    
    // TODO: Implementar funcionalidade de deletar comentário
    // public void deleteComment(Long commentId, Long userId) {
    //     // Verificar se o comentário pertence ao usuário
    //     // Deletar o comentário
    // }
} 