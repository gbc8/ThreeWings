# Teste Técnico Full Stack
A aplicação é um sistema no qual é possível gerenciar uma coleção de objetos Produto, cuja assinatura é (Long id, String nome, String categoria, String descricao, String quantidade), incluindo tanto o front-end quanto o back-end.

### Sobre o Backend

O projeto foi desenvolvido utilizando uma abordagem de arquitetura em camadas para o backend. Apesar de ser um exagero para um projeto CRUD, ela foi adotada com base em um cenário hipotético no qual existiria uma futura necessidade de extensão da aplicação. Dessa forma, pode-se explorar e discutir as vantagens (e desvantagens) dessa arquitetura. Além disso, as tecnologias utilizadas foram Java e Spring.

### Sobre o Frontend

Para o frontend do projeto, utilizou-se o framework Angular com Typescript e a biblioteca Angular Material para o design das interfaces e componentes.
 
## Instruções de execução
### Docker

Execute `docker-compose up` no diretório do projeto.

### Manual

##### Pré-requisitos:
Banco de dados PostgreSQL executando com os seguintes parâmentros:\
URL: localhost\
Porta: 5432\
Nome de usuário: postgres\
Senha: password\
Nome do banco: produtodb

Nota: Esses parâmetros podem ser alterados no arquivo `properties.yml` dentro do diretório `produto-backend` ou passados como variáveis de ambiente (DB_HOST,DB_PORT,DB_NAME,DB_USERNAME,DB_PASSWORD) para o programa.

##### Comandos:
###### Backend:
Execute `mvn clean install -DskipTests` e `mvn spring-boot:run` dentro do diretório `produto-backend`.

###### Backend com variáveis de ambiente:
Execute `mvn clean install -DskipTests` dentro do diretório `produto-backend`.\
Execute `java -D"DB_HOST={url}" -D"DB_PORT={porta}" -D"DB_NAME={nome}" -D"DB_USERNAME={dbName}" -D"DB_PASSWORD={dbPassword}" -jar {Nome do Programa}.jar` dentro do diretório `produto-backend/target`.

Nota: Substitua `{valor}` pelos valores da máquina local. `{}` não devem ser incluídas.

###### Frontend:
Execute `npm install` e `ng serve` dentro do diretório `produto-frontend`.

##### Portas utilizadas:
Backend: 8081\
Frontend: 4200