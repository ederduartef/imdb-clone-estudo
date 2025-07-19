import axios from 'axios';

const API_URL = '/api/ratings';

export const ratingService = {
  async addRating(movieId, score, token) {
    try {
      const response = await axios.post(`${API_URL}/movies/${movieId}`, 
        { score },
        {
          headers: {
            Authorization: `Bearer ${token}`
          }
        }
      );
      return response.data;
    } catch (error) {
      throw new Error('Erro ao adicionar avaliação');
    }
  },

  async getRatingsByMovie(movieId) {
    try {
      const response = await axios.get(`${API_URL}/movies/${movieId}`);
      return response.data;
    } catch (error) {
      throw new Error('Erro ao carregar avaliações');
    }
  },

  async getAverageRating(movieId) {
    try {
      const response = await axios.get(`${API_URL}/movies/${movieId}/average`);
      return response.data;
    } catch (error) {
      throw new Error('Erro ao carregar média de avaliações');
    }
  },

  async getUserRating(movieId, token) {
    try {
      const response = await axios.get(`${API_URL}/movies/${movieId}/user`, {
        headers: {
          Authorization: `Bearer ${token}`
        }
      });
      return response.data;
    } catch (error) {
      if (error.response?.status === 404) {
        return null; // Usuário não avaliou este filme
      }
      throw new Error('Erro ao carregar avaliação do usuário');
    }
  }
}; 