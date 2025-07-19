import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { movieService } from '../services/movieService';
import { ratingService } from '../services/ratingService';
import { commentService } from '../services/commentService';
import RatingForm from '../components/RatingForm';
import CommentForm from '../components/CommentForm';
import './MovieDetails.css';

const MovieDetails = () => {
  const { id } = useParams();
  const [movie, setMovie] = useState(null);
  const [comments, setComments] = useState([]);
  const [averageRating, setAverageRating] = useState({ average: 0, count: 0 });
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    loadMovieDetails();
  }, [id]);

  const loadMovieDetails = async () => {
    try {
      setLoading(true);
      const [movieData, commentsData, ratingData] = await Promise.all([
        movieService.getMovieById(id),
        commentService.getCommentsByMovie(id),
        ratingService.getAverageRating(id)
      ]);
      
      setMovie(movieData);
      setComments(commentsData);
      setAverageRating(ratingData);
      setError(null);
    } catch (err) {
      setError('Erro ao carregar detalhes do filme');
      console.error('Erro ao carregar detalhes do filme:', err);
    } finally {
      setLoading(false);
    }
  };

  const handleRatingAdded = () => {
    loadMovieDetails();
  };

  const handleCommentAdded = () => {
    loadMovieDetails();
  };

  const renderStars = (rating) => {
    const stars = [];
    const fullStars = Math.floor(rating);
    const hasHalfStar = rating % 1 !== 0;
    
    for (let i = 0; i < fullStars; i++) {
      stars.push(<span key={i} className="star filled">★</span>);
    }
    
    if (hasHalfStar) {
      stars.push(<span key="half" className="star filled">☆</span>);
    }
    
    const emptyStars = 5 - stars.length;
    for (let i = 0; i < emptyStars; i++) {
      stars.push(<span key={`empty-${i}`} className="star">☆</span>);
    }
    
    return stars;
  };

  const formatDate = (dateString) => {
    return new Date(dateString).toLocaleDateString('pt-BR', {
      year: 'numeric',
      month: 'long',
      day: 'numeric',
      hour: '2-digit',
      minute: '2-digit'
    });
  };

  if (loading) {
    return (
      <div className="movie-details-page">
        <div className="loading">
          <h2>Carregando detalhes do filme...</h2>
        </div>
      </div>
    );
  }

  if (error || !movie) {
    return (
      <div className="movie-details-page">
        <div className="error-message">
          <h2>Erro</h2>
          <p>{error || 'Filme não encontrado'}</p>
        </div>
      </div>
    );
  }

  return (
    <div className="movie-details-page">
      <div className="movie-details">
        <div className="movie-poster">
          <img 
            src={movie.imageUrl} 
            alt={movie.title}
            onError={(e) => {
              e.target.src = 'https://via.placeholder.com/300x450/cccccc/666666?text=Sem+Imagem';
            }}
          />
        </div>
        
        <div className="movie-info">
          <h1>{movie.title}</h1>
          
          <div className="movie-rating-overview">
            <div className="rating-stars">
              {renderStars(averageRating.average)}
            </div>
            <span className="rating-text">
              {averageRating.average.toFixed(1)} ({averageRating.count} avaliações)
            </span>
          </div>
          
          <div className="movie-meta">
            <p><strong>Ano:</strong> {movie.releaseYear}</p>
            <p><strong>Diretor:</strong> {movie.director}</p>
            <p><strong>Gênero:</strong> {movie.genre}</p>
          </div>
          
          <div className="movie-description">
            <h3>Sinopse</h3>
            <p>{movie.description}</p>
          </div>
        </div>
      </div>

      <div className="movie-actions">
        <RatingForm movieId={id} onRatingAdded={handleRatingAdded} />
        <CommentForm movieId={id} onCommentAdded={handleCommentAdded} />
      </div>

      <div className="comments-section">
        <h3>Comentários ({comments.length})</h3>
        
        {comments.length === 0 ? (
          <p className="no-comments">Nenhum comentário ainda. Seja o primeiro a comentar!</p>
        ) : (
          <div className="comments-list">
            {comments.map(comment => (
              <div key={comment.id} className="comment">
                <div className="comment-header">
                  <span className="comment-author">{comment.username}</span>
                  <span className="comment-date">{formatDate(comment.createdAt)}</span>
                </div>
                <div className="comment-content">
                  {comment.content}
                </div>
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
};

export default MovieDetails; 