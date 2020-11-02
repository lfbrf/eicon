# Eicon

### Tecnologias usadas:
- Java 8, Spring, Hibernate,  SonarLint, Junit 5, mockito, maven,  HTML, CSS, bootstrap, Jquery.
- Eclipse (STS) e github;
- Consumo e consulta à API por xml.
#
## Instruçes para deploy
## Criar banco de dados no mysql com nome eicon
### As tabelas são criadas ao iniciar a aplicação
#
### Instalar dependências
### Abrindo o projeto no eclipse é possível rodar a instrução clicando com o botão direito na raiz do projeto -> Run as -> Run Configurations -> 
Em goals definir clean install -> Apply -> Run
### É possível instalar as dependências acessando o terminal na pasta raiz e digitando mvn clean install
#
## Rodar aplicação em ambiente local
### Caso abra o projeto no eclipse é possível rodar a aplicação selecionando a classe principal (EiconApplication.java) -> Run as Java Application
### Também é possível rodar acessando a pasta raiz do projeto no terminal e rodar o comando: mvn spring-boot:run
#
### Seguindo esses passos o projeto já deve funcionar
#
## Pensando em agilizar os testes e análise do serviço que desenvolvi. Fiz o deploy da aplicação no heroku também
### https://eicon-test-app.herokuapp.com
#


<details><summary>Exemplo requisição POST de cadastro de pedido (Postman)/summary>

### Referência: 
https://pasteboard.co/JystRea.png
### Url usada: 
http://localhost:8080/save
#
### Xml usado:
#
```
<?xml version="1.0" encoding="UTF-8"?>
<orders>
<order>
<numberControl>5</numberControl>
<dateRegister>2020-05-30 09:00:00</dateRegister>
<name>Produto 01</name>
<quantity>2</quantity>
<value>40</value>
<clientCode>60</clientCode>
</order>
</orders>
```
#

</details>


## Exemplo requisição POST de cadastro de pedido (Postman)
### Referência: 
https://pasteboard.co/JystRea.png
### Url usada: 
http://localhost:8080/save
#
### Xml usado:
#
```
<?xml version="1.0" encoding="UTF-8"?>
<orders>
<order>
<numberControl>5</numberControl>
<dateRegister>2020-05-30 09:00:00</dateRegister>
<name>Produto 01</name>
<quantity>2</quantity>
<value>40</value>
<clientCode>60</clientCode>
</order>
</orders>
```
#
## Exemplo requisição GET de consulta de pedidos (Postman)
### Referência: 
https://pasteboard.co/JysukT4.png
### Url usada: 
http://localhost:8080/search?clientOrderSearch=Prod&numberControl=false&dateRegister=false&client=false&all=true
#
## Exemplo de requisições ajax estão dispoíveis na página inicial.
#
## Caso tenham alguma dificuldade em rodar o projeto por gentileza me avisem
Fico à disposição para uma apresentação e/ou sanar qualquer dúvida, obrigado
luizfelipebasile@gmail.com | 42988313783



