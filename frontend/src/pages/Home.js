import React, { useState, useEffect } from 'react';
import MovieCard from '../components/MovieCard';
import { movieService } from '../services/movieService';
import './Home.css';

const Home = () => {
  const [movies, setMovies] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [searchTerm, setSearchTerm] = useState('');

  useEffect(() => {
    loadMovies();
  }, []);

  const loadMovies = async () => {
    try {
      setLoading(true);
      const data = await movieService.getAllMovies();
      setMovies(data);
      setError(null);
    } catch (err) {
      setError('Erro ao carregar filmes');
      console.error('Erro ao carregar filmes:', err);
    } finally {
      setLoading(false);
    }
  };

  const handleSearch = async (e) => {
    e.preventDefault();
    if (!searchTerm.trim()) {
      loadMovies();
      return;
    }

    try {
      setLoading(true);
      const data = await movieService.searchMovies(searchTerm);
      setMovies(data);
      setError(null);
    } catch (err) {
      setError('Erro ao buscar filmes');
      console.error('Erro ao buscar filmes:', err);
    } finally {
      setLoading(false);
    }
  };

  const handleClearSearch = () => {
    setSearchTerm('');
    loadMovies();
  };

  if (loading) {
    return (
      <div className="home">
        <div className="loading">
          <h2>Carregando filmes...</h2>
        </div>
      </div>
    );
  }

  return (
    <div className="home">
      <div className="home-header">
        <h1>Filmes Disponíveis</h1>
        
        <form onSubmit={handleSearch} className="search-form">
          <div className="search-input-group">
            <input
              type="text"
              value={searchTerm}
              onChange={(e) => setSearchTerm(e.target.value)}
              placeholder="Buscar filmes por título..."
              className="search-input"
            />
            <button type="submit" className="btn btn-primary">
              Buscar
            </button>
            {searchTerm && (
              <button 
                type="button" 
                onClick={handleClearSearch}
                className="btn btn-secondary"
              >
                Limpar
              </button>
            )}
          </div>
        </form>
      </div>

      {error && (
        <div className="error-message">
          <p>{error}</p>
          <button onClick={loadMovies} className="btn btn-primary">
            Tentar Novamente
          </button>
        </div>
      )}

      {movies.length === 0 && !loading && !error && (
        <div className="no-movies">
          <h2>Nenhum filme encontrado</h2>
          <p>
            {searchTerm 
              ? `Não encontramos filmes com o título "${searchTerm}"`
              : 'Não há filmes disponíveis no momento'
            }
          </p>
        </div>
      )}

      {movies.length > 0 && (
        <div className="movie-grid">
          {movies.map(movie => (
            <MovieCard key={movie.id} movie={movie} />
          ))}
        </div>
      )}
    </div>
  );
};

export default Home; 