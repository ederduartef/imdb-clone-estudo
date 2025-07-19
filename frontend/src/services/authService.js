import axios from 'axios';

const API_URL = '/api/auth';

export const authService = {
  async login(username, password) {
    try {
      const response = await axios.post(`${API_URL}/login`, {
        username,
        password
      });
      return response.data;
    } catch (error) {
      throw new Error(error.response?.data?.message || 'Erro ao fazer login');
    }
  },

  async register(userData) {
    try {
      const response = await axios.post(`${API_URL}/register`, userData);
      return response.data;
    } catch (error) {
      throw new Error(error.response?.data?.message || 'Erro ao registrar');
    }
  },

  async validateToken(token) {
    try {
      const response = await axios.get(`${API_URL}/validate`, {
        headers: {
          Authorization: `Bearer ${token}`
        }
      });
      return response.data;
    } catch (error) {
      throw new Error('Token inválido');
    }
  }
}; 