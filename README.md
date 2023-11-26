<h2>Desafio Ziturs - Java Servlet</h2>

<h3>Tecnologias Utilizadas:</h3>

Intellij
Java 19
Maven
 MySQL
JPA + JPQL
Liquibase
Tomcat

<h3>Estrutura da Aplicação:</h3>

Banco de Dados - Temos 3 tabelas em um banco MySQL, solicitações, procedimentos existentes e uma com a regra de negócio, com os perfis aprovados.
Código Java - Usando JPA / EntityManager e JPQL para tratar a camada de persistência e consultas, respectivamente. Temos uma classe Servlet para intermediar as requisições.
View - A interface de usuário nessa aplicação é uma página simples em HTML + CSS (bootstrap) que visa receber as novas solicitações e exibir em tela as anteriores.


<h3>Como executar a aplicação:</h3>

No MySQL, criar o schema "zitrus".

Na pasta raiz do projeto, executar no terminal o comando "mvn clean install -U" para baixar as dependências, criar e inserir dados nas tabelas.

No Intellij, Acesse "Run >> Edit Configurations". Selecione Tomcat Server.
O projeto, em desenvolvimento, rodou com as seguintes configurações:

Server: Tomcat 10.1.16
URL: http://localhost:8080/zitrus_war/
JRE: jdk-19
Deployment: zitrus:war

Após essas configurações, é só rodar a aplicação.
