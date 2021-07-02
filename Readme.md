# 💻 REST API Stoom

📝 REST API Stoom - é um projeto desafiador proposto pela empresa **stoom**, que consiste em criar no padrão REST, um CRUD (Create, Read, Update & Delete) de uma entidade endereço.

## ⚙️ Ferramentas utilizadas

💡 Foi utilizado um banco de dados em memória, o **[h2 Database][h2]** para fins de teste da aplicação, caso planejado utilizar algun banco de dados externo, será necessária a adição da dependência do Driver do banco de dados no arquivo **[pom.xml][pom]** do projeto, e posteriormente, a configuração do arquivo **[application.yml][config]**.

💡 Também foi utilizado o **[Thymeleaf][thymeleaf]**, um template enginer server-side compatível com **[Spring Boot][spring]** para criar uma mini-interface, onde é possível testar todo o projeto de forma dinâmica e interativa.

- **[Java][java]**
- **[Apache Maven][maven]**
- **[Spring Boot][spring]**
- **[Thymeleaf][thymeleaf]**
- **[Vue.js][vue]**
- **[Docker][docker]**
- **[h2 Database][h2]**
- **[Google Geocoding API][geocoding]**

[java]: https://www.java.com/pt-BR/
[maven]: https://maven.apache.org/
[spring]: https://spring.io/
[thymeleaf]: https://www.thymeleaf.org/
[vue]: https://vuejs.org/
[docker]: https://www.docker.com/
[h2]: https://www.h2database.com/html/main.html
[geocoding]: https://developers.google.com/maps/documentation/geocoding/overview
[pom]: ./pom.xml
[config]: ./src/main/resources/application.yml

## 💿 Como executar o projeto

### 🎲 **Backend [servidor]**

💡 Existem duas formas de rodar a aplicação, a primeira delas é executando através da sua própria JVM, enquanto a segunda opção é rodar utilizando um container docker.
Caso prefira utilizar a segunda opção, pule para o item 2.

```bash

# 📌 Método 1

# Navegue até a pasta do projeto
$ cd rest-api-stoom

# Instale todas as dependências maven
$ ./mvnw install

# Inicie a aplicação
$ ./mvnw spring-boot:run

# Entre em > http://localhost:8080 <

```
```bash
# 📌 Método 2

# Navegue até a pasta do projeto
$ cd rest-api-stomm

# Enpacote o projeto
$ ./mvnw package

# Construa uma imagem docker
$ docker build -t lukearch/rest-api-stoom .

# Execute a imagem
$ docker run -p 8080:8080 lukearch/rest-api-stoom

# Entre em > http://localhost:8080 <

```

Feito por Lucas Larangeira 👋🏽