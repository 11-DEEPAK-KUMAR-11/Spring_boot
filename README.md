# Spring_boot
## Concept building through applications using spring boot

### What is Spring Boot
Spring Boot is a project that is built on the top of the Spring Framework. It provides an easier and faster way to set up, configure, and run both simple and web-based applications.

It is a Spring module that provides the RAD (Rapid Application Development) feature to the Spring Framework. It is used to create a stand-alone Spring-based application that you can just run because it needs minimal Spring configuration.

### What is Spring Boot
In short, Spring Boot is the combination of Spring Framework and Embedded Servers.

In Spring Boot, there is no requirement for XML configuration (deployment descriptor). It uses convention over configuration software design paradigm that means it decreases the effort of the developer.

We can use Spring STS IDE or Spring Initializr to develop Spring Boot Java applications.

### Why should we use Spring Boot Framework?

We should use Spring Boot Framework because:

- The dependency injection approach is used in Spring Boot.
- It contains powerful database transaction management capabilities.
- It simplifies integration with other Java frameworks like JPA/Hibernate ORM, Struts, etc.
- It reduces the cost and development time of the application.
- Along with the Spring Boot Framework, many other Spring sister projects help to build applications addressing modern business needs. There are the following Spring sister projects are as follows:

Spring Data: It simplifies data access from the relational and NoSQL databases.

Spring Batch: It provides powerful batch processing.

Spring Security: It is a security framework that provides robust security to applications.

Spring Social: It supports integration with social networking like LinkedIn.

Spring Integration: It is an implementation of Enterprise Integration Patterns. It facilitates integration with other enterprise applications using lightweight messaging and declarative adapters.

### Advantages of Spring Boot
- It creates stand-alone Spring applications that can be started using Java -jar.
- It tests web applications easily with the help of different Embedded HTTP servers such as Tomcat, Jetty, etc. We don't need to deploy WAR files.
- It provides opinionated 'starter' POMs to simplify our Maven configuration.
- It provides production-ready features such as metrics, health checks, and externalized configuration.
  There is no requirement for XML configuration.
- It offers a CLI tool for developing and testing the Spring Boot application.
- It offers the number of plug-ins.
- It also minimizes writing multiple boilerplate codes (the code that has to be included in many places with little or no alteration), XML configuration, and annotations.
- It increases productivity and reduces development time.

### Limitations of Spring Boot
Spring Boot can use dependencies that are not going to be used in the application. These dependencies increase the size of the application.


### Goals of Spring Boot
The main goal of Spring Boot is to reduce development, unit test, and integration test time.

Provides Opinionated Development approach
Avoids defining more Annotation Configuration
Avoids writing lots of import statements
Avoids XML Configuration.
By providing or avoiding the above points, Spring Boot Framework reduces Development time, Developer Effort, and increases productivity.

### Prerequisite of Spring Boot
To create a Spring Boot application, following are the prerequisites. In this tutorial, we will use Spring Tool Suite (STS) IDE.

Java 1.8
Maven 3.0+
Spring Framework 5.0.0.BUILD-SNAPSHOT
An IDE (Spring Tool Suite) is recommended.
Spring Boot Features
Web Development
SpringApplication
Application events and listeners
Admin features
Externalized Configuration
Properties Files
YAML Support
Type-safe Configuration
Logging
Security
Web Development

It is a well-suited Spring module for web application development. We can easily create a self-contained HTTP application that uses embedded servers like Tomcat, Jetty, or Undertow. We can use the spring-boot-starter-web module to start and run the application quickly.
