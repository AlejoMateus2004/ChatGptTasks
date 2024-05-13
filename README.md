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

```json
POST /api/todo
Content-Type: application/json

{
    "title": "Task 1",
    "description": "Description of Task 1"
}




