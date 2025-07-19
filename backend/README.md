# IMDB Clone - Backend

Este é o backend do projeto IMDB Clone, desenvolvido em Java com Spring Boot.

## Como rodar

1. **Pré-requisitos:**
   - Java 17+
   - Maven 3.8+

2. **Instale as dependências:**
   ```bash
   mvn clean install
   ```

3. **Execute a aplicação:**
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse:**
   - API: http://localhost:8080
   - H2 Console: http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:imdbdb`, usuário: `sa`, senha: `password`)

## Funcionalidades implementadas
- Listagem de filmes
- Detalhes de filme
- Cadastro e login de usuário (JWT)
- Adição de comentários e avaliações (estrutura pronta)
- Banco de dados em memória (H2) com 3 filmes e 2 usuários de exemplo

## Funcionalidades faltantes (ordem de dificuldade)

### 1. Obter o ID do usuário autenticado via JWT (Fácil)
- **Onde:** Controllers de Rating e Comment (`userId = 1L` está fixo)
- **Como resolver:**
  - Extraia o usuário autenticado do `Authentication` do Spring Security.
  - Dica: `((User) authentication.getPrincipal()).getId()`

### 2. Exibir média de avaliações e quantidade de avaliações no MovieDTO (Fácil)
- **Onde:** `MovieService.convertToDTO()`
- **Como resolver:**
  - Calcule e preencha os campos `averageRating` e `ratingCount` usando o serviço de ratings.

### 3. Implementar endpoint para deletar comentário (Intermediário)
- **Onde:** `CommentController` e `CommentService`
- **Como resolver:**
  - Crie o endpoint DELETE e verifique se o comentário pertence ao usuário antes de deletar.

### 4. Implementar endpoint para adicionar novo filme (Avançado)
- **Onde:** `MovieController`
- **Como resolver:**
  - Crie o endpoint POST e permita apenas para usuários com papel ADMIN.

### 5. Validação real do token JWT no endpoint `/api/auth/validate` (Avançado)
- **Onde:** `AuthController`
- **Como resolver:**
  - Use o `JwtService` para validar o token e retornar informações do usuário.

## Dicas gerais
- Consulte a documentação do Spring Security e JWT.
- Use o H2 Console para inspecionar o banco de dados.
- O frontend espera respostas JSON.

---

Siga a ordem das tarefas para aprender gradualmente sobre autenticação, autorização e manipulação de dados no Spring Boot. 