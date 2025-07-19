import React, { useState } from 'react';
import { useAuth } from '../contexts/AuthContext';
import { commentService } from '../services/commentService';
import './CommentForm.css';

const CommentForm = ({ movieId, onCommentAdded }) => {
  const { isAuthenticated, token } = useAuth();
  const [content, setContent] = useState('');
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    if (!isAuthenticated) {
      alert('Você precisa estar logado para comentar');
      return;
    }

    if (!content.trim()) {
      alert('Por favor, escreva um comentário');
      return;
    }

    setLoading(true);
    try {
      await commentService.addComment(movieId, content.trim(), token);
      setContent('');
      if (onCommentAdded) {
        onCommentAdded();
      }
      alert('Comentário enviado com sucesso!');
    } catch (error) {
      alert('Erro ao enviar comentário: ' + error.message);
    } finally {
      setLoading(false);
    }
  };

  if (!isAuthenticated) {
    return (
      <div className="comment-form">
        <h3>Adicionar Comentário</h3>
        <p>Você precisa estar logado para comentar.</p>
      </div>
    );
  }

  return (
    <div className="comment-form">
      <h3>Adicionar Comentário</h3>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="comment">Seu Comentário:</label>
          <textarea
            id="comment"
            value={content}
            onChange={(e) => setContent(e.target.value)}
            placeholder="Escreva seu comentário sobre o filme..."
            rows="4"
            maxLength="1000"
          />
          <small className="char-count">
            {content.length}/1000 caracteres
          </small>
        </div>
        
        <button 
          type="submit" 
          className="btn btn-primary"
          disabled={loading || !content.trim()}
        >
          {loading ? 'Enviando...' : 'Enviar Comentário'}
        </button>
      </form>
    </div>
  );
};

export default CommentForm; 