import React, { useState, useEffect } from 'react';
import { useAuth } from '../contexts/AuthContext';
import { ratingService } from '../services/ratingService';
import './RatingForm.css';

const RatingForm = ({ movieId, onRatingAdded }) => {
  const { isAuthenticated, token } = useAuth();
  const [rating, setRating] = useState(0);
  const [userRating, setUserRating] = useState(null);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    if (isAuthenticated && token) {
      loadUserRating();
    }
  }, [isAuthenticated, token, movieId]);

  const loadUserRating = async () => {
    try {
      const userRatingData = await ratingService.getUserRating(movieId, token);
      if (userRatingData) {
        setUserRating(userRatingData.score);
        setRating(userRatingData.score);
      }
    } catch (error) {
      console.error('Erro ao carregar avaliação do usuário:', error);
    }
  };

  const handleStarClick = (starValue) => {
    setRating(starValue);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!isAuthenticated) {
      alert('Você precisa estar logado para avaliar filmes');
      return;
    }

    if (rating === 0) {
      alert('Por favor, selecione uma avaliação');
      return;
    }

    setLoading(true);
    try {
      await ratingService.addRating(movieId, rating, token);
      setUserRating(rating);
      if (onRatingAdded) {
        onRatingAdded();
      }
      alert('Avaliação enviada com sucesso!');
    } catch (error) {
      alert('Erro ao enviar avaliação: ' + error.message);
    } finally {
      setLoading(false);
    }
  };

  const renderStars = () => {
    const stars = [];
    for (let i = 1; i <= 5; i++) {
      stars.push(
        <span
          key={i}
          className={`star ${i <= rating ? 'filled' : ''}`}
          onClick={() => handleStarClick(i)}
        >
          ★
        </span>
      );
    }
    return stars;
  };

  if (!isAuthenticated) {
    return (
      <div className="rating-form">
        <h3>Avaliar Filme</h3>
        <p>Você precisa estar logado para avaliar filmes.</p>
      </div>
    );
  }

  return (
    <div className="rating-form">
      <h3>Avaliar Filme</h3>
      {userRating && (
        <p className="user-rating">
          Sua avaliação atual: {userRating} estrelas
        </p>
      )}
      
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Sua Avaliação:</label>
          <div className="rating-stars">
            {renderStars()}
          </div>
          <span className="rating-text">
            {rating > 0 ? `${rating} estrela${rating > 1 ? 's' : ''}` : 'Selecione uma avaliação'}
          </span>
        </div>
        
        <button 
          type="submit" 
          className="btn btn-primary"
          disabled={loading || rating === 0}
        >
          {loading ? 'Enviando...' : 'Enviar Avaliação'}
        </button>
      </form>
    </div>
  );
};

export default RatingForm; 