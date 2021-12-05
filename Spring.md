# Spring

* provides comprehensive infrastructural support for developing java applications

* provides the plumbing so you focus on business logic

* supports strong OOP practices.

* encourages Don't Repeat Yourself(DRY) principles
  configure once.

* POJO: Plain Old Java Object
  true objects that have state and behaviour
* JavaBeans - Simple objects with only getters and setters.

* Spring Beans - POJOs configured in the application context.

* DTO - Data Transport Object - often java beans used to transfer states between layers of application

## Inversion of Control (IoC)

IoC provides mechanism for dependency injection

* Application Context is technically what we configure when we configure spring and it serves as the IoC container. It is a wrapper for the BeanFactory which provides IoC capability.

* Spring Boot provides auto-configuration of the ApplicationContext.

## Spring Boot

* supports rapid development
* single fastest way to build application in jvm.
* removes boilerplate of application setup
  * we no longer need to have application server running to support dev efforts.
* can be used for batch processing, ETL, async message processing etc
* cloud native support but also traditional

### Components
* Embedded Tomcat
* Auto confg of Application Context as well as component scanning
* Automatic servlet mappings
* embedded datatbase support and hibernate/JPA dialect
* Automatic controller mappings to dispatcher servlet

> mvn clean package
> java -jar target/learning-spring-1.0.0.jar
