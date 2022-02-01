## Sistema simples de login

Importe os testes no Postman

~~~Postman
https://www.getpostman.com/collections/d2780909fe1ac845fa75
~~~
## Ferramentas utilizadas

* Spring boot 2.6.3
* Maven 3.8.2
* Java 11

## Database

* MySQL 

**Configuração do properties** 

~~~MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/sistema_login
spring.datasource.username=root
spring.datasource.password=Arthur08102019
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
~~~~
