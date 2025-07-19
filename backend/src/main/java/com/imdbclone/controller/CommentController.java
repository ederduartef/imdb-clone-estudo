package com.imdbclone.controller;

import com.imdbclone.dto.CommentDTO;
import com.imdbclone.model.Comment;
import com.imdbclone.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "http://localhost:3000")
public class CommentController {
    
    @Autowired
    private CommentService commentService;
    
    @PostMapping("/movies/{movieId}")
    public ResponseEntity<Comment> addComment(@PathVariable Long movieId, @RequestBody Map<String, String> request) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            // TODO: Implementar obtenção do ID do usuário a partir do token JWT
            Long userId = 1L; // Placeholder - deve ser obtido do token
            
            String content = request.get("content");
            if (content == null || content.trim().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            
            Comment comment = commentService.addComment(movieId, userId, content);
            return ResponseEntity.ok(comment);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/movies/{movieId}")
    public ResponseEntity<List<CommentDTO>> getCommentsByMovie(@PathVariable Long movieId) {
        List<CommentDTO> comments = commentService.getCommentsByMovieId(movieId);
        return ResponseEntity.ok(comments);
    }
    
    // TODO: Implementar endpoint para deletar comentário
    // @DeleteMapping("/{commentId}")
    // public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
    //     // Implementar lógica para deletar comentário
    // }
} 