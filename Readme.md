# 💻 REST API Stoom

📝 REST API Stoom - é um projeto desafiador proposto pela empresa **stoom**, que consiste em criar no padrão REST, um CRUD (Create, Read, Update & Delete) de uma entidade endereço.

## ⚙️ Ferramentas utilizadas

💡 Foi utilizado um banco de dados em memória, o **[h2 Database][h2]** para fins de teste da aplicação, caso planejado utilizar algun banco externo, será necessária a adição da dependência do Driver do banco de dados no arquivo **[pom.xml][pom]** do projeto, e posteriormente, a configuração do arquivo **[application.yml][config]**.

- **[Java][java]**
- **[Apache Maven][maven]**
- **[Spring Boot][spring]**
- **[Docker][docker]**
- **[h2 Database][h2]**
- **[Google Geocoding API][geocoding]**

[java]: https://www.java.com/pt-BR/
[maven]: https://maven.apache.org/
[spring]: https://spring.io/
[docker]: https://www.docker.com/
[h2]: https://www.h2database.com/html/main.html
[geocoding]: https://developers.google.com/maps/documentation/geocoding/overview
[pom]: ./pom.xml
[config]: ./main/resources/application.yml

## 💿 Como executar o projeto

### 🎲 **Backend [servidor]**

```bash

# 💡 Existem duas formas de rodar a aplicação,
# A primeira delas é executando através da sua própria JVM,
# Enquanto a segunda opção é rodar utilizando um container docker.
# Caso prefira utilizar a segunda opção, pule para o item 2.

# ======================================================

# 📌 1 - Acesse a pasta do projeto
$ cd rest-api-stoom

# 1.1 - Instale todas as dependências maven
$ ./mvnw install

# 1.2 - Inicie a aplicação
$ ./mvnw spring-boot:run

# ======================================================

# 📌 2 - Acesse a pasta do projeto
$ cd rest-api-stomm

# 2.1 - Enpacote o projeto
$ ./mvnw package

# 2.2 - Construa uma imagem docker
$ docker build -t lukearch/rest-api-stoom .

# 2.3 - Execute a imagem
$ docker run -p 8080:8080 lukearch/rest-api-stoom

# ======================================================

# 📌 3 - Entre em > http://localhost:8080 <

```

Feito por Lucas Larangeira 👋🏽