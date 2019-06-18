# Societe Generale API
###### Create Database in MySQL with name "societe_generale" and table like below
> CREATE TABLE `societe_generale`.`employee` (
>  `id` INT NOT NULL AUTO_INCREMENT,
>  `first_name` VARCHAR(45) NOT NULL,
>  `last_name` VARCHAR(45) NOT NULL,
>  `gender` VARCHAR(6) NOT NULL,
>  `dob` DATE NOT NULL,
>  `department` VARCHAR(45) NOT NULL,
>  PRIMARY KEY (`id`));

###### Change your db credentials in src\main\resources\application.properties file

## Build
###### Maven clean
> mvn clean

###### Maven install
> mvn install

## Run
###### Get the jar from target folder and run with below command
> java -jar societe_generale-0.0.1-SNAPSHOT.jar

## Swagger URL
###### http://localhost:8080/swagger-ui.html#/employee-controller

## Note
###### Copy http://localhost:8080/api/ url to use in UI project


