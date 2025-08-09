# 🍽️ NamoralFood API

API REST para gestão de restaurantes, usuários e pedidos.

---

## 📦 Tecnologias

- Java 17
- Spring Boot 3
- Spring Security + JWT
- JPA / Hibernate
- PostgreSQL
- Maven
- Docker / Docker Compose

---

## 🚀 Como rodar o projeto

### ✅ Pré-requisitos

- [Java 17+](https://adoptium.net)
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- [Docker + Docker Compose](https://www.docker.com/) (opcional)

---

## ☕ Rodar com Maven

1. Clone o projeto:

```bash
git clone https://github.com/seu-usuario/namoralfood-api.git
cd namoralfood-api
```

2. Configure seu banco no `application.properties` ou use `.env` com Docker.

3. Gere o `.jar` com Maven:

```bash
mvn clean package
```

4. Rode o projeto:

```bash
java -jar target/api-0.0.1-SNAPSHOT.jar
```

---

## 🐳 Rodar com Docker

1. Crie um arquivo `.env` na raiz do projeto (veja o exemplo abaixo).

2. Rode com:

```bash
docker compose up --build
```

---

## 🔐 Arquivo `.env`

Crie um arquivo chamado `.env` com os seguintes valores:

```env
DB_HOST=localhost
DB_PORT=5432
DB_NAME=namoralfood
DB_USERNAME=postgres
DB_PASSWORD=root
```

---

## 🧪 Rodar os testes

```bash
mvn test
```

---

## 📂 Estrutura do Projeto

```
📦 src
 ┣ 📂main
 ┃ ┣ 📂java/com/namoralfood/api
 ┃ ┃ ┣ 📂controller
 ┃ ┃ ┣ 📂domain
 ┃ ┃ ┣ 📂repository
 ┃ ┃ ┣ 📂service
 ┃ ┃ ┣ 📂infra/security
 ┃ ┃ ┗ ApiApplication.java
 ┃ ┗ 📂resources
 ┃   ┣ application.properties
 ┃   ┗ schema.sql / data.sql
 ┗ 📂test
   ┗ ApiApplicationTests.java
```

---

## 📫 Contato

Criado por **Tiago Held**  
📧 bondtiago@uol.com.br  
📘 Projeto da Pós Tech - FIAP / Alura
