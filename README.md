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

