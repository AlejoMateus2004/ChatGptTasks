# Todo List Application

This is a simple Todo List application built using Spring Boot, Hibernate, and MySQL. It provides RESTful API endpoints to manage todo items, allowing users to create, read, update, and delete todo items. Each todo item has a title and a description.

## Requirements

- Java 17 
- Maven
- MySQL

## Installation

1. Clone this repository: git clone https://github.com/your_username/todo-list-application.git

2. Navigate to the project directory: cd GPTFisrtTask

3. Set up MySQL database:
    - Create a MySQL database named `todo_db`.
    - Update `application.properties` file in `src/main/resources` directory with your MySQL username and password.

4. Build the project using Maven: mvn clean package

## Usage

1. Run the application: 
java -jar target/GPTFisrtTask-0.0.1-SNAPSHOT.jar

2. The application will start and the API will be available at `http://localhost:8080/api/todo`.

## API Endpoints

- GET `/api/todo`: Get all todo items.
- GET `/api/todo/{id}`: Get a todo item by ID.
- POST `/api/todo`: Create a new todo item.
- PUT `/api/todo/{id}`: Update an existing todo item.
- DELETE `/api/todo/{id}`: Delete a todo item by ID.

## Sample Request and Response

### Create Todo Item

**Request:**


POST /api/todo
Content-Type: application/json

{
    "title": "Task 1",
    "description": "Description of Task 1"
}

# Feedback

Was it easy to complete the task using AI?

- R/ It was easy since ChatGpt gave me all the code and I just had to create the classes and paste the provided code

How long did task take you to complete? (Please be honest, we need it to gather anonymized statistics)

- R/ It took me approximately 30 minutes, the longest it took me was creating the db configuration

Was the code ready to run after generation? What did you have to change to make it usable?

- R/ In addition to having to create the classes, copy and paste the code, I had to modify the database property settings, as needed.

Which challenges did you face during completion of the task?

- R/ MySql driver dependency did not want to work correctly due to missing configuration parameter in application.properties

Which specific prompts you learned as a good practice to complete the task?

- R/ 
  - Read the following text, analyze the context step by step and ask me for additional information if necessary, so you can get the job done.
    "the text is the original prompt"

  - Act as (role) that need to perform the following task.
    "Task"
    Analyze the context step by step and ask me for additional information if necessary, so you can get the job done.
    
    Output: titles in bold, features in list format (feature (bold): description)




