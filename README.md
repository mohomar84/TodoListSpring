# TodoListSpring

**Getting Started**
Todo list Demo API using Spring Boot with  Spring JPA and MySQL for data persistence

**Prerequisites**
JDK8

To build and run the sample from a fresh clone of this repo:
**Installing**
Configure MySQL
Create a database in your MySQL instance.
Update the application.properties file in the src/main/resources folder with the URL, username and password for your MySQL instance. The table schema for the Todo objects will be created for you in the database.

**Running the tests**

mvnw package
java -jar target/ToDoListApi-0.0.1-SNAPSHOT.jar
Open a web browser to http://localhost:8080
As you add and update tasks in the app you can verify the changes in the database through the MySQL console using simple statements like select * from todo_item.
