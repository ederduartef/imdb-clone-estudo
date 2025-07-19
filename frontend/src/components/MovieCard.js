import React from 'react';
import { Link } from 'react-router-dom';
import './MovieCard.css';

const MovieCard = ({ movie }) => {
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

  return (
    <div className="movie-card">
      <img 
        src={movie.imageUrl} 
        alt={movie.title}
        onError={(e) => {
          e.target.src = 'https://via.placeholder.com/300x450/cccccc/666666?text=Sem+Imagem';
        }}
      />
      <div className="movie-card-content">
        <h3>{movie.title}</h3>
        <p><strong>Ano:</strong> {movie.releaseYear}</p>
        <p><strong>Diretor:</strong> {movie.director}</p>
        <p><strong>Gênero:</strong> {movie.genre}</p>
        
        <div className="movie-rating">
          {renderStars(movie.averageRating || 0)}
          <span>({movie.ratingCount || 0} avaliações)</span>
        </div>
        
        <Link to={`/movie/${movie.id}`} className="btn btn-primary">
          Ver Detalhes
        </Link>
      </div>
    </div>
  );
};

export default MovieCard; 