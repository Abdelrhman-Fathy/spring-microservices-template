# spring-microservices-template
This project is a template for spring microservices architecture

### Build and Run the Application

#### Step 1: Navigate to the Project Directory
Using Windows PowerShell, go to your project directory. Here's an example command:

```sh
cd c:/Users/Admin/git/spring-microservices-template/mobile-app-ws
```

#### Step 2: Build the Project
Remove the existing `target` directory and build a new package using the following command:

```sh
mvn clean install
```

#### Step 3: Verify the Build
To list the generated files in the `target` directory, use:

```sh
ls target/*.*
```

#### Step 4: Run the Application
Start the application with the following command:

```sh
java -jar target/mobile-app-ws-0.0.1-SNAPSHOT.jar
```

### Project Overview

This project demonstrates the use of several key technologies and tools in building a robust, scalable Spring Boot application. Below is a summary of the skills and technologies utilized:

- **Java Development Kit (JDK) 22**: Leveraged the latest features and improvements of JDK 22 for optimal performance and security.
- **Spring Boot 3.2.5**: Utilized Spring Boot to create a stand-alone, production-grade Spring-based application with minimal configuration.
- **Jakarta Bean Validations**: Implemented API validation using Jakarta Bean Validations to ensure the integrity and correctness of input data.
- **RESTful APIs**: Designed and developed RESTful APIs to facilitate communication between different components and external systems.
- **XML/JSON Support with Jackson Data Formatter**: Incorporated Jackson for seamless XML and JSON data formatting and parsing.
- **Maven**: Used Maven for project build automation, dependency management, and overall project structure.
- **Git**: Managed source code version control and collaboration through Git.
- **SonarLint**: Conducted static code analysis using SonarLint to identify and fix code quality issues.
- **Dependency Injection**: Applied dependency injection principles to reduce code coupling and enhance modularity and testability.
- **Spring cloud, Eureka discovery service**: To allow micro-services to scale up/down and register themselves with the discovery service.

This combination of technologies and tools ensures a clean, maintainable, and scalable codebase, adhering to industry best practices and standards.