# API de Gerenciamento de Cursos - Spring Boot

<br />

<div align="center">
   <img src="https://i.imgur.com/w8tTOuT.png" title="source: imgur.com" /> 
  </div>

<br />

<div align="center">
  <img alt="Linguagem Principal" src="https://img.shields.io/github/languages/top/Brunogodoy2911/api_cursos?style=flat-square&color=green">
  <img alt="Tamanho do Repositório" src="https://img.shields.io/github/repo-size/Brunogodoy2911/api_cursos?style=flat-square">
  <img alt="Linguagens Utilizadas" src="https://img.shields.io/github/languages/count/Brunogodoy2911/api_cursos?style=flat-square">
  <img alt="Último Commit" src="https://img.shields.io/github/last-commit/Brunogodoy2911/api_cursos?style=flat-square">
  <img alt="Issues" src="https://img.shields.io/github/issues/Brunogodoy2911/api_cursos?style=flat-square&color=orange">
  <img alt="Pull Requests" src="https://img.shields.io/github/issues-pr/Brunogodoy2911/api_cursos?style=flat-square&color=blue">
  <img src="https://img.shields.io/badge/status-em%20desenvolvimento-yellow?style=flat-square" alt="Status: Em Desenvolvimento">
</div>

<br />

## 📝 1. Descrição

A **API de Gerenciamento de Cursos** é um projeto backend desenvolvido como parte de um desafio, com o objetivo de criar uma API RESTful para uma plataforma fictícia de cursos de programação. A API permite o cadastro, listagem, atualização e remoção de cursos, além de gerenciar o status de atividade de cada curso.

Este projeto foi desenvolvido para aplicar e praticar conceitos de desenvolvimento de APIs com **Java** e **Spring Boot**, incluindo a criação de endpoints REST, manipulação de dados, e regras de negócio específicas.

<br />

## 🎯 2. Sobre o Desafio

Nesse desafio, o foco é desenvolver uma API para uma empresa de cursos de programação, implementando funcionalidades de CRUD (Create, Read, Update, Delete) para a entidade `Curso`.

### Funcionalidades Principais da API:
1.  **Criação** de um novo curso.
2.  **Listagem** de todos os cursos cadastrados.
3.  **Atualização** de um curso existente através do seu ID.
4.  **Remoção** de um curso através do seu ID.
5.  **Alternância do status** de um curso (ativo/inativo) através do seu ID.

<br />

## 🏗️ 3. Estrutura da Entidade `Curso`

Cada curso na API possui a seguinte estrutura de dados:

* `id` (Long): Identificador único do curso (gerado automaticamente).
* `name` (String): Nome do curso.
* `category` (String): Categoria à qual o curso pertence (ex: "Java", "Front-end", "Mobile").
* `active` (Boolean): Define se o curso está ativo (`true`) ou inativo (`false`).
* `created_at` (LocalDateTime): Data e hora de quando o curso foi criado (gerado automaticamente).
* `updated_at` (LocalDateTime): Data e hora da última atualização do curso (atualizado automaticamente).

<br />

## 🛣️ 4. Rotas e Regras de Negócio (Endpoints)

A API expõe os seguintes endpoints para interagir com os recursos de cursos:

### `POST /cursos`
* **Descrição:** Cria um novo curso.
* **Request Body:**
    ```json
    {
        "name": "Nome do Curso",
        "category": "Categoria do Curso"
    }
    ```
* **Regras:**
    * Os campos `name` e `category` são obrigatórios no corpo da requisição.
    * Os campos `id`, `created_at` e `updated_at` são preenchidos automaticamente. `active` é definido como `true` por padrão na criação (ou conforme sua implementação).

### `GET /cursos`
* **Descrição:** Lista todos os cursos cadastrados.
* **Query Params (Opcionais para Filtragem):**
    * `name` (String): Filtra cursos pelo nome (busca parcial ou exata, dependendo da implementação).
    * `category` (String): Filtra cursos pela categoria.
* **Exemplo de Requisição com Filtro:** `GET /cursos?name=Java&category=Backend`

### `PUT /cursos/:id`
* **Descrição:** Atualiza um curso existente pelo seu `id`.
* **Path Param:** `id` (Long) - ID do curso a ser atualizado.
* **Request Body:**
    ```json
    {
        "name": "Novo Nome do Curso", // Opcional
        "category": "Nova Categoria"  // Opcional
    }
    ```
* **Regras:**
    * Deve receber `name` e/ou `category` para serem atualizados.
    * Se apenas `name` for enviado, `category` não deve ser alterado, e vice-versa.
    * O campo `active` não é modificado por esta rota.
    * O campo `updated_at` é atualizado automaticamente.

### `DELETE /cursos/:id`
* **Descrição:** Remove um curso pelo seu `id`.
* **Path Param:** `id` (Long) - ID do curso a ser removido.

### `PATCH /cursos/:id/active`
* **Descrição:** Alterna o status de atividade (`active`) de um curso (de `true` para `false` ou vice-versa).
* **Path Param:** `id` (Long) - ID do curso cujo status será alterado.
* **Regras:**
    * Esta rota é específica para modificar o campo `active`.
    * O campo `updated_at` é atualizado automaticamente.

<br />

## 🛠️ 5. Tecnologias Utilizadas

| Item                          | Descrição                                      |
| ----------------------------- | ---------------------------------------------- |
| **Linguagem de Programação** | Java 17+                                       |
| **Framework** | Spring Boot 3.x.x                              |
| **ORM** | Spring Data JPA (Hibernate)                    |
| **Banco de Dados (Sugerido)** | H2 (para desenvolvimento), PostgreSQL ou MySQL |
| **Gerenciador de Dependências**| Maven (ou Gradle, conforme seu projeto)        |
| **Servidor Web Embutido** | Tomcat                                         |
| **Documentação da API** | SpringDoc (OpenAPI/Swagger) (Sugerido)         |
| **Testes (Sugerido)** | JUnit 5, Mockito                               |

<br />

## ⚙️ 6. Requisitos para Execução Local

Para executar este projeto localmente, você precisará ter instalado:

* [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) ou superior.
* [Apache Maven](https://maven.apache.org/download.cgi) (ou Gradle, caso seu projeto utilize).
* Sua IDE Java favorita (ex: [IntelliJ IDEA](https://www.jetbrains.com/idea/download/), [STS](https://spring.io/tools), [VS Code com extensões Java](https://code.visualstudio.com/)).
* Um cliente HTTP para testar os endpoints (ex: [Insomnia](https://insomnia.rest/download), [Postman](https://www.postman.com/downloads/)).
* (Opcional) Um sistema de gerenciamento de banco de dados como MySQL ou PostgreSQL, se não for usar o H2 em memória.

<br />

## 🚀 7. Como Executar o Projeto

Siga os passos abaixo para executar a API em seu ambiente local:

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/Brunogodoy2911/api_cursos.git](https://github.com/Brunogodoy2911/api_cursos.git)
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd api_cursos
    ```

3.  **Configure o Banco de Dados (se necessário):**
    * Se estiver usando um banco de dados externo (MySQL, PostgreSQL), certifique-se de que ele esteja em execução.
    * Atualize as configurações de conexão com o banco de dados no arquivo `src/main/resources/application.properties` (ou `application.yml`):
        ```properties
        # Exemplo para PostgreSQL
        # spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_seu_banco
        # spring.datasource.username=seu_usuario
        # spring.datasource.password=sua_senha
        # spring.jpa.hibernate.ddl-auto=update
        # spring.jpa.show-sql=true

        # Exemplo para H2 (banco em memória, bom para desenvolvimento rápido)
        spring.datasource.url=jdbc:h2:mem:db_cursos
        spring.datasource.driverClassName=org.h2.Driver
        spring.datasource.username=sa
        spring.datasource.password=password
        spring.h2.console.enabled=true 
        # Acessar console H2 em: http://localhost:8080/h2-console
        spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
        ```

4.  **Compile e execute o projeto usando Maven (pelo terminal):**
    ```bash
    # Para compilar e empacotar (gera o .jar)
    mvn clean package

    # Para executar o projeto
    mvn spring-boot:run
    ```
    Alternativamente, você pode importar o projeto na sua IDE e executá-lo diretamente por ela.

5.  **Acesse a API:**
    * A API estará disponível em `http://localhost:8080` (ou a porta configurada no `application.properties`).
    * Se você habilitou o SpringDoc/Swagger, a documentação interativa da API geralmente estará disponível em `http://localhost:8080/swagger-ui.html` ou `http://localhost:8080/v3/api-docs`.

<br />

## ✨ 8. Implementações Futuras (Sugestões do Desafio "Indo Além")

- [ ] **Validações:**
    - [ ] Validar se as propriedades `name` e `category` estão presentes e não vazias nas rotas `POST` e `PUT`. (Utilizar Bean Validation, por exemplo).
- [ ] **ENUM para Status `active`:**
    - [ ] Utilizar um `ENUM` (ex: `StatusCurso { ATIVO, INATIVO }`) para o campo `active`, em vez de um `Boolean`, para maior clareza e extensibilidade.
- [ ] **Segurança da Aplicação:**
    - [ ] Implementar autenticação e autorização (ex: Spring Security com JWT).
- [ ] **Testes Automatizados:**
    - [ ] Adicionar testes unitários e de integração para garantir a qualidade e o comportamento esperado da API.
- [ ] **Tratamento de Exceções:**
    - [ ] Melhorar o tratamento de exceções para fornecer respostas de erro mais claras e padronizadas.
- [ ] **Paginação e Ordenação:**
    - [ ] Adicionar suporte para paginação e ordenação na listagem de cursos (`GET /cursos`).
- [ ] **Deploy:**
    - [ ] Configurar o deploy da aplicação em uma plataforma de nuvem (ex: Heroku, AWS, Google Cloud).

<br />

## 🤝 9. Contribuição

Este projeto foi desenvolvido como parte de um desafio educacional. No entanto, se você tiver sugestões, encontrar bugs ou quiser propor melhorias, sinta-se à vontade para:

1.  Abrir uma **Issue** detalhando sua sugestão ou o problema encontrado.
2.  Fazer um **Fork** do repositório, criar uma branch para sua feature/correção e enviar um **Pull Request**.

<br />

## 👨‍💻 10. Autor

Desenvolvido por **Bruno Godoy**

[![GitHub](https://img.shields.io/badge/GitHub-Brunogodoy2911-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Brunogodoy2911)
<br />
