import axios from 'axios';

const API_URL = '/api/comments';

export const commentService = {
  async addComment(movieId, content, token) {
    try {
      const response = await axios.post(`${API_URL}/movies/${movieId}`, 
        { content },
        {
          headers: {
            Authorization: `Bearer ${token}`
          }
        }
      );
      return response.data;
    } catch (error) {
      throw new Error('Erro ao adicionar comentário');
    }
  },

  async getCommentsByMovie(movieId) {
    try {
      const response = await axios.get(`${API_URL}/movies/${movieId}`);
      return response.data;
    } catch (error) {
      throw new Error('Erro ao carregar comentários');
    }
  },

  // TODO: Implementar deletar comentário
  // async deleteComment(commentId, token) {
  //   try {
  //     await axios.delete(`${API_URL}/${commentId}`, {
  //       headers: {
  //         Authorization: `Bearer ${token}`
  //       }
  //     });
  //   } catch (error) {
  //     throw new Error('Erro ao deletar comentário');
  //   }
  // }
}; 