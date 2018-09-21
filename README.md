# jpa-one-to-one-relationship

### Description
A demo Spring Boot Web API app that uses Jpa / Hibernate and persists data to a MySQL database.

Check the article at [RBS Programming](https://www.rbsprogramming.com/articles/spring-boot-web-api-mysql).  

### Requirements
* JDK-1.8+
* Maven-3.2+
* MySQL-5.7

### How to run this project?
1. Clone this repository to your machine with the command - $ `git clone https://github.com/rbs-programming/spring-boot-web-api-mysql.git`.
1. Open the jpa-one-to-one-relationship/src/main/resources/application.properties file and change the spring.datasource.username and spring.datasource.password values to match your mysql username and password.
1. Log into mysql shell and create a MySQL Database with the command - $ `CREATE DATABASE spring_boot_crud_api;`
1. In the project's root directory "jpa-one-to-one-relationship" type the command - $ `mvn spring-boot:run`
1. Open your web browser and type `localhost:4500/api/lecturers` to see the app running.

