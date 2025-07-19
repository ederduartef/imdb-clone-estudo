# IMDB Clone - Projeto Completo

Um clone do IMDb desenvolvido com **Backend em Java (Spring Boot)** e **Frontend em React**, criado especificamente para fins educacionais com funcionalidades propositalmente incompletas para aprendizado.

## 🎯 Objetivo

Este projeto foi criado com **funcionalidades faltando ou incompletas** de forma proposital, para que você possa aprender completando-as. Cada parte tem desafios de diferentes níveis de dificuldade, permitindo um aprendizado gradual.

## 🏗️ Arquitetura

- **Backend:** Java 17 + Spring Boot 3.2.0 + Spring Security + JWT + H2 Database
- **Frontend:** React 18 + React Router + Axios + Context API
- **Comunicação:** REST API com JSON

## 📁 Estrutura do Projeto

```
imdb-clone-project/
├── backend/          # Aplicação Spring Boot
│   ├── src/
│   │   ├── main/java/com/imdbclone/
│   │   │   ├── controller/    # Controllers REST
│   │   │   ├── service/       # Lógica de negócio
│   │   │   ├── repository/    # Acesso a dados
│   │   │   ├── model/         # Entidades JPA
│   │   │   ├── dto/           # Data Transfer Objects
│   │   │   └── config/        # Configurações
│   │   └── resources/
│   └── README.md
├── frontend/         # Aplicação React
│   ├── src/
│   │   ├── components/        # Componentes React
│   │   ├── pages/            # Páginas da aplicação
│   │   ├── services/         # Comunicação com API
│   │   ├── contexts/         # Contextos React
│   │   └── utils/            # Utilitários
│   └── README.md
└── README.md
```

## 🚀 Como Executar

### Backend
```bash
cd backend
mvn clean install
mvn spring-boot:run
```
- **URL:** http://localhost:8080
- **H2 Console:** http://localhost:8080/h2-console

### Frontend
```bash
cd frontend
npm install
npm start
```
- **URL:** http://localhost:3000

## 👥 Usuários de Teste

O sistema já vem com usuários pré-cadastrados:
- **Admin:** `admin` / `admin123`
- **Usuário:** `user` / `user123`

## 🎬 Filmes de Exemplo

O sistema já vem com 3 filmes cadastrados:
1. O Poderoso Chefão (1972)
2. Pulp Fiction (1994)
3. Interestelar (2014)

## ✅ Funcionalidades Implementadas

### Backend
- ✅ Autenticação JWT
- ✅ CRUD de filmes (básico)
- ✅ Sistema de avaliações (1-5 estrelas)
- ✅ Sistema de comentários
- ✅ Banco de dados H2 em memória
- ✅ Dados iniciais carregados automaticamente

### Frontend
- ✅ Página inicial com listagem de filmes
- ✅ Página de detalhes do filme
- ✅ Sistema de login/registro
- ✅ Avaliação de filmes
- ✅ Comentários em filmes
- ✅ Busca por título
- ✅ Interface responsiva

## 🔧 Funcionalidades Faltantes (Para Aprendizado)

### Backend - Ordem de Dificuldade
1. **Fácil:** Obter ID do usuário autenticado via JWT
2. **Fácil:** Exibir média de avaliações no MovieDTO
3. **Intermediário:** Implementar deletar comentário
4. **Avançado:** Endpoint para adicionar novo filme
5. **Avançado:** Validação real do token JWT

### Frontend - Ordem de Dificuldade
1. **Fácil:** Exibir média de avaliações na listagem
2. **Fácil:** Implementar validação do token JWT
3. **Intermediário:** Funcionalidade de deletar comentário
4. **Intermediário:** Filtros por gênero e ano
5. **Avançado:** Sistema de favoritos
6. **Avançado:** Paginação na listagem

## 📚 Dicas de Aprendizado

1. **Comece pelo Backend:** Resolva os problemas do backend primeiro, pois o frontend depende dele
2. **Siga a Ordem:** As tarefas estão ordenadas por dificuldade
3. **Use o H2 Console:** Para inspecionar o banco de dados
4. **Console do Navegador:** Para debugar o frontend
5. **Documentação:** Consulte a documentação do Spring Boot e React

## 🔍 Endpoints da API

### Autenticação
- `POST /api/auth/login` - Login
- `POST /api/auth/register` - Registro
- `GET /api/auth/validate` - Validar token

### Filmes
- `GET /api/movies` - Listar filmes
- `GET /api/movies/{id}` - Detalhes do filme
- `GET /api/movies/search?title={title}` - Buscar por título
- `GET /api/movies/genre/{genre}` - Filmes por gênero

### Avaliações
- `POST /api/ratings/movies/{movieId}` - Adicionar avaliação
- `GET /api/ratings/movies/{movieId}` - Avaliações do filme
- `GET /api/ratings/movies/{movieId}/average` - Média de avaliações

### Comentários
- `POST /api/comments/movies/{movieId}` - Adicionar comentário
- `GET /api/comments/movies/{movieId}` - Comentários do filme

## 🎯 Próximos Passos

1. Leia os READMEs específicos de cada parte (backend/frontend)
2. Execute o projeto e teste as funcionalidades básicas
3. Escolha uma tarefa da lista de funcionalidades faltantes
4. Implemente a solução seguindo as dicas fornecidas
5. Teste sua implementação
6. Continue para a próxima tarefa

## 📖 Recursos de Aprendizado

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Security Reference](https://docs.spring.io/spring-security/reference/)
- [React Documentation](https://react.dev/)
- [React Router Documentation](https://reactrouter.com/)

---

**Boa sorte no seu aprendizado! 🚀** 