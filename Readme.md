# 💻 REST API Stoom

📝 REST API Stoom - é um projeto desafiador proposto pela empresa **stoom**, que consiste em criar no padrão REST, um CRUD (Create, Read, Update,  Delete) de uma entidade Address.

## ⚙️ Ferramentas utilizadas

💡 Foi utilizado um banco de dados em memória, o **[h2 Database][h2]** para fins de teste da aplicação, caso planejado utilizar algun banco de dados externo, será necessária a adição da dependência do Driver do banco de dados no arquivo **[pom.xml][pom]** do projeto, e posteriormente, a configuração do arquivo **[application.yml][config]**.

- **[Java][java]**
- **[Apache Maven][maven]**
- **[Spring Boot][spring]**
- **[Docker][docker]**
- **[h2 Database][h2]**
- **[Google Geocoding API][geocoding]**

## 🚀 Como funciona

 A classe **[AddressController.java][addressController]**, é responsável por mapear as URLs utilizadas no projeto.

 A interface **[AddressRepository.java][addressRepository]**, é responsável por estabelecer a comunicação com o banco de dados H2 e fornecer os métodos necessários para compor o CRUD.

 As classes do pacote **[br.com.lukearch.stoom.api.config][config]** são responsáveis por interceptar os erros de formulário ao enviar um **[POST]** para *http://localhost:8080/address* sem preencher todas as informações obrigatórias.
No exemplo abaixo, seguem os campos mapeados pela classe **[Address.java][address]**:
```JSON

  {
    "streetName": "",         
    "number": "",             
    "complement": "",         
    "neighbourhood": "",      
    "city": "",              
    "state": "",             
    "country": "",           
    "zipcode": "",           
    "latitude": "",          
    "longitude": ""          
  }

```

Todos os campos são obrigatórios, exceto os de Latitude e Longitude.

Caso não sejam informados os campos de Latitude e/ou Longitude, a API irá utilizar todos os outros campos obrigatórios informados para realizar uma busca através da API do Google Maps, **[Google Geocoding API][geocoding]**, e carregar automáticamente os valores de Latitude e Longitude com base no endereço.

[address]: ./src/main/java/br/com/lukearch/stoom/api/model/Address.java
[config]: ./src/main/java/br/com/lukearch/stoom/api/config
[addressController]: ./src/main/java/br/com/lukearch/stoom/api/controller/AddressController.java
[addressRepository]: ./src/main/java/br/com/lukearch/stoom/api/repository/AddressRepository.java

## 💿 Como executar o projeto

### 🎲 **Backend [servidor]**

💡 Existem duas formas de rodar a aplicação, a primeira delas é executando através da sua própria JVM, enquanto a segunda opção é rodar utilizando um container docker.
Caso prefira utilizar a segunda opção, pule para o item 2.

💡 A versão do Java nativa para esse projeto é a **[Java SE JDK 11][java se 11]**, sendo necessária a instalação prévia da mesma para executar o servidor através do maven no método 1. 

💡 A imagem docker cria um ambiente com a versão correta do Java instalado, porém ainda assim é necessária a instalação da JVM para compilar o pacote do projeto.

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

### 🎲 **URLs Mapeadas**

💡 Requisição **[GET]** retorna todas as entidades Endereço cadastradas no banco de dados.

💡 Requisição **[POST]** cadastra uma nova entidade Endereço no banco de dados.

💡 Requisição **[PUT]** modifica uma entidade Endereço já cadastrada no banco de dados, substitua a expressão {id} pelo ID verdadeiro da entidade.

💡 Requisição **[DELETE]** remove uma entidade Endereço do banco de dados, substitua a expressão {id} pelo ID verdadeiro da entidade.

**[GET]** http://localhost:8080/address


**[POST]** http://localhost:8080/address


**[PUT]** http://localhost:8080/address/{id}


**[DELETE]** http://localhost:8080/address/{id}

### 🎲 **Dinâmica de Testes**

📝 Os testes unitários estão presentes em **[src/test][test]**.

📝 Foram realizados testes para as classes **[AddressRepositoryTest.java][addressRepositoryTest]** e **[AddressControllerTest.java][addressControllerTest]**, com o objetivo de verificar o funcionamento do CRUD.







[postman]: https://www.postman.com/
[addressControllerTest]: ./src/test/java/br/com/lukearch/stoom/api/controllerTest/AddressControllerTest.java
[addressRepositoryTest]: ./src/test/java/br/com/lukearch/stoom/api/repositoryTest/AddressRepositoryTest.java
[java]: https://www.java.com/pt-BR/
[maven]: https://maven.apache.org/
[spring]: https://spring.io/
[thymeleaf]: https://www.thymeleaf.org/
[vue]: https://vuejs.org/
[docker]: https://www.docker.com/
[h2]: https://www.h2database.com/html/main.html
[geocoding]: https://developers.google.com/maps/documentation/geocoding/overview
[pom]: ./pom.xml
[test]: ./src/test/java/br/com/lukearch/stoom/api
[config]: ./src/main/resources/application.yml
[java se 11]: https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html
