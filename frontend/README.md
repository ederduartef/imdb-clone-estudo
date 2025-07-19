# IMDB Clone - Frontend

Este é o frontend do projeto IMDB Clone, desenvolvido em React.

## Como rodar

1. **Pré-requisitos:**
   - Node.js 16+
   - npm ou yarn

2. **Instale as dependências:**
   ```bash
   npm install
   ```

3. **Execute a aplicação:**
   ```bash
   npm start
   ```

4. **Acesse:**
   - http://localhost:3000

## Funcionalidades implementadas
- Página inicial com listagem de filmes
- Página de detalhes do filme
- Sistema de autenticação (login/registro)
- Avaliação de filmes (1-5 estrelas)
- Comentários em filmes
- Busca por título
- Interface responsiva

## Funcionalidades faltantes (ordem de dificuldade)

### 1. Exibir média de avaliações na listagem de filmes (Fácil)
- **Onde:** `MovieCard.js` e `Home.js`
- **Problema:** O backend não está retornando `averageRating` e `ratingCount` no DTO
- **Como resolver:**
  - Implementar o cálculo no backend (MovieService.convertToDTO)
  - Ou fazer chamada adicional para buscar a média de cada filme

### 2. Implementar validação do token JWT no contexto (Fácil)
- **Onde:** `AuthContext.js`
- **Problema:** A validação do token está comentada
- **Como resolver:**
  - Descomentar e implementar a chamada para `authService.validateToken()`

### 3. Adicionar funcionalidade de deletar comentário (Intermediário)
- **Onde:** `CommentForm.js` e `MovieDetails.js`
- **Como resolver:**
  - Implementar o endpoint no backend
  - Adicionar botão de deletar nos comentários do usuário
  - Implementar confirmação antes de deletar

### 4. Adicionar filtros por gênero e ano (Intermediário)
- **Onde:** `Home.js`
- **Como resolver:**
  - Criar componentes de filtro
  - Implementar chamadas para os endpoints existentes no backend
  - Adicionar estado para filtros ativos

### 5. Implementar sistema de favoritos (Avançado)
- **Onde:** Novo componente e serviço
- **Como resolver:**
  - Criar modelo Favorites no backend
  - Implementar endpoints para adicionar/remover favoritos
  - Criar componente de botão de favorito
  - Adicionar página de favoritos

### 6. Adicionar paginação na listagem de filmes (Avançado)
- **Onde:** `Home.js` e backend
- **Como resolver:**
  - Implementar paginação no backend
  - Criar componente de paginação
  - Adicionar estado para página atual

## Dicas gerais
- Use o React DevTools para debugar componentes
- Verifique o console do navegador para erros
- Use o Network tab para ver as chamadas da API
- O backend deve estar rodando na porta 8080

## Estrutura do projeto
```
src/
├── components/     # Componentes reutilizáveis
├── pages/         # Páginas da aplicação
├── services/      # Serviços para comunicação com API
├── contexts/      # Contextos do React
└── utils/         # Utilitários
```

---

Siga a ordem das tarefas para aprender gradualmente sobre React, autenticação e integração com APIs. 