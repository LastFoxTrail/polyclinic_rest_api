# Polyclinik

## Description
Rest-Api backend for the clinic information system, created using Java Spring Framework.

## Technologies used
+ spring Boot;
+ spring Data JPA;
+ spring AOP;
+ hibernate;
+ mySQL Database;
+ global Exception Handling;
+ flyway data migrations;
+ log4j.

## Architecture levels
+ **domain entities (com/lis/projects/entity) -**
        defining system entities and creating links between them;

+ **data layer (com/lis/projects/repository) -**
        implementation of the *repository* pattern using *Spring Data JPA*, to optimize the creation of queries to the database;

+ **domain business logic (com/lis/projects/service) -**
        creation of an additional abstract layer to implement business logic of the system;

+ **rest controllers (com/lis/projects/controller) -**
        layer for processing client requests and sending responses;

+ **controllers global exception handling -**
    - **com/lis/projects/exception -**
            description of the main exception classes;

    - **com/lis/projects/exception/handler (EntityGlobalExceptionHandler.java) -**
            *ControllerAdvice* - class of global controller exception handling. Implements the AOP mechanism and allows you to decouple handling controller exceptions from handling client requests;

    - **com/lis/projects/exception/json_formatter -(IncorrectRequestData.java) -**
            a model describing the structure of the exception. Includes an exception message.

+ **end-to-end logging (com/lis/projects/aspect/logging) -**
    Includes two classes: 
    *ServiceLoggingAspect* - for logging events of the service layer of the system and
    *ControllerLoggingAspect* - for logging controller events.
    This layer implements the AOP mechanism

+ **Project resources (src/main/java/resources) -**
    contains files-settings for connecting to the database, logging settings and flyway resources.
    - **src/main/java/resources/db/migration -**
            contains versioned database migration files.

## Tasks in progress
1. Microservice for user authentication / registration
2. JWT
3. Spring Security
        
    
