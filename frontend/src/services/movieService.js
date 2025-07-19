import axios from 'axios';

const API_URL = '/api/movies';

export const movieService = {
  async getAllMovies() {
    try {
      const response = await axios.get(API_URL);
      return response.data;
    } catch (error) {
      throw new Error('Erro ao carregar filmes');
    }
  },

  async getMovieById(id) {
    try {
      const response = await axios.get(`${API_URL}/${id}`);
      return response.data;
    } catch (error) {
      throw new Error('Erro ao carregar filme');
    }
  },

  async searchMovies(title) {
    try {
      const response = await axios.get(`${API_URL}/search?title=${encodeURIComponent(title)}`);
      return response.data;
    } catch (error) {
      throw new Error('Erro ao buscar filmes');
    }
  },

  async getMoviesByGenre(genre) {
    try {
      const response = await axios.get(`${API_URL}/genre/${encodeURIComponent(genre)}`);
      return response.data;
    } catch (error) {
      throw new Error('Erro ao carregar filmes por gênero');
    }
  },

  async getTopRatedMovies() {
    try {
      const response = await axios.get(`${API_URL}/top-rated`);
      return response.data;
    } catch (error) {
      throw new Error('Erro ao carregar filmes mais avaliados');
    }
  }
}; 