# csc340-assignement3
Simple CRUD API for Student Objects with JPA (Hibernate)

### Version
1.0.0

## Installation
- Get the project
    - clone
        ```
      git clone https://github.com/IsaiahHames/csc340-assignment3.git
        ```
    - OR download zip.
- Open the project in VS Code.
- This project is built to run with jdk 21.
- [Dependencies](https://github.com/csc340-uncg/f25-jpa-crud-api/blob/7142cb123bc1444fb579ece9735062f1c3a15a86/pom.xml#L33) to JPA and Postgres in addition to the usual Spring Web. JPA handles the persistence, Postgresql is the database to be used.
- [`/src/main/resources/application.properties`](https://github.com/csc340-uncg/f25-jpa-crud-api/blob/6b2860c4ad01ca46b6b62852ca966bfadc8dfc6a/src/main/resources/application.properties) This file has the configuration for the PostgreSQL database to use for the API.
  - You MUST have the database up and running before running the project!
    - Login to your neon.tech account.
    - Locate your database project.
    - On the project dashboard, click on "Connect" and select Java.
    - Copy the connection string provided.
    - Paste it as a value for the property `spring.datasource.url`. No quotation marks.
- Build and run the main class. You should see a new table created in the Neon database.
## Notes
### Java - [Spring ORM with JPA and Hibernate](https://medium.com/@burakkocakeu/jpa-hibernate-and-spring-data-jpa-efa71feb82ac)
- We are using ORM (Object-Relational Mapping) to deal with databases. This is a technique that allows us to interact with a relational database using object-oriented programming principles.
- JPA (Jakarta Persistence, formerly Java Persistence API) is a specification that defines ORM standards in Java. It provides an abstraction layer for ORM frameworks to make concrete implementations.
- Hibernate: Hibernate is a popular ORM framework that implements JPA. It simplifies database operations by mapping Java objects to database tables and handling queries efficiently.
Spring ORM allows seamless integration of Hibernate and JPA, making database interactions more manageable and reducing boilerplate code.
### StudentX Java classes have different purposes: Separation of concerns!
- [Entity](https://github.com/csc340-uncg/f25-jpa-crud-api/blob/6b2860c4ad01ca46b6b62852ca966bfadc8dfc6a/src/main/java/com/csc340/crud_jpa_demo/student/Student.java#L9)
  - The Student class is annotated as an `@Entity `. This is used to map class attributes to database tables and SQL types.
  - We also annotated with `@Table` to give Hibernate directions to use this specific table name. This is optional but it helps with naming conventions.
  - Any Entity must have at least one attribute that is annotated as an `@Id`. In our case it's conveniently the `studentId` attribute.
    - We are also using an autogeneration strategy for the ID. This way we are not manually assigning IDs to our students. This is optional.
       - For this reason, we also added a constructor to make a Student without an ID.
  - An Entity must have a no-argument constructor.
- [Repository](https://github.com/csc340-uncg/f25-jpa-crud-api/blob/6b2860c4ad01ca46b6b62852ca966bfadc8dfc6a/src/main/java/com/csc340/crud_jpa_demo/student/StudentRepository.java)
  - We are using an extension of the JPA Repository that comes with prebuilt database operations such as select all, select by id, select by any other reference, insert, delete, etc.
  - Annotate it as a `@Repository`.
  - We parametrize this using our object and its ID type.
    - `public interface StudentRepository extends JpaRepository<Student, Long>` => We want to apply the JPA repository operations on the `Student` type. The `Student` has an ID of type `long`.
  - If we need special database queries that are not the standard ones mentioned above, we can create [a method with a special purpose query](https://github.com/csc340-uncg/f25-jpa-crud-api/blob/6b2860c4ad01ca46b6b62852ca966bfadc8dfc6a/src/main/java/com/csc340/crud_jpa_demo/student/StudentRepository.java#L17) as shown. This is an interface so no implementation body.
- [Service](https://github.com/csc340-uncg/f25-jpa-crud-api/blob/6b2860c4ad01ca46b6b62852ca966bfadc8dfc6a/src/main/java/com/csc340/crud_jpa_demo/student/StudentService.java)
  - Annotated as a `@Service`.
  - It is the go-between from controller to database. In here we define what functions we need from the repository. A lot of the functions are default functions that our repository inherits from JPA (save, delete, findAll, findByX), some of them are custom made (getHonorsStudents, getStudentsByName).
  - It asks the repository to perform SQL queries.
  - The Repository class is [`@Autowired`](https://github.com/csc340-uncg/f25-jpa-crud-api/blob/6b2860c4ad01ca46b6b62852ca966bfadc8dfc6a/src/main/java/com/csc340/crud_jpa_demo/student/StudentService.java#L15). This is for managing the dependency to the repository. Do not use a constructor to make a Repository object, you will get errors.
- [Rest Controller](https://github.com/csc340-uncg/f25-jpa-crud-api/blob/6b2860c4ad01ca46b6b62852ca966bfadc8dfc6a/src/main/java/com/csc340/crud_jpa_demo/student/StudentController.java#L15)
  - Annotated as a `@RestController`.
  - It asks the Service class to perform data access functions.
  - The Service class is [`@Autowired`](https://github.com/csc340-uncg/f25-jpa-crud-api/blob/6b2860c4ad01ca46b6b62852ca966bfadc8dfc6a/src/main/java/com/csc340/crud_jpa_demo/student/StudentController.java#L18) here as well :)

## API Endpoints
Base URL: [`http://localhost:8080/students`](http://localhost:8080/students)


1. ### [`/`](http://localhost:8080/students) (GET)
Gets a list of all Students in the database.

#### Response - A JSON array of Student objects.

 ```
[
  {
    "catId": 1,
    "name": "Simba",
    "description": "The king of the lion pride",
    "breed": "Lion",
    "age": 31
  },
  {
    "catId": 2,
    "name": "Tigger",
    "description": "The tiger from Winnie the Pooh",
    "breed": "tiger",
    "age": 29
  }
]
```

2. ### [`/{catId}`](http://localhost:8080/cats/1) (GET)
Gets an individual Cat in the system. Each Cat is identified by a numeric `catId`

#### Parameters
- Path Variable: `catId` &lt;Long &gt; - REQUIRED

#### Response - A single Cat

```
  {
    "catId": 1,
    "name": "Simba",
    "description": "The king of the lion pride",
    "breed": "Lion",
    "age": 31
  }
```

3. ### [`/name`](http://localhost:8080/cats/name?key=sim) (GET)
Gets a list of cat with a name that contains the given string.

#### Parameters
- query parameter: `search` &lt; String &gt; - REQUIRED

#### Response - A JSON array of Cat objects.

```
[
  {
    "catId": 1,
    "name": "Simba",
    "description": "The king of the lion pride",
    "breed": "Lion",
    "age": 31
  }
]
```

4. ### [`/breed/{breed}`](http://localhost:8080/cats/breed/Lion) (GET)
Gets a list of cats for a named breed.

#### Parameters
- path variable: `breed` &lt; String &gt; - REQUIRED

#### Response - A JSON array of Cat objects.

```
[
  {
    "catId": 1,
    "name": "Simba",
    "description": "The king of the lion pride",
    "breed": "Lion",
    "age": 31
  }
]
```
5. ### [`/age`](http://localhost:8080/students/age?gpa=30) (GET)
Gets a list of cats with a Age meeting the Threshold.

#### Parameters
- query parameter: `age` &lt;int&gt; - REQUIRED

#### Response - A JSON array of Cat objects.

```
[
  {
    "catId": 1,
    "name": "Simba",
    "description": "The king of the lion pride",
    "breed": "Lion",
    "age": 31
  }
]
```
6. ### [`/`](http://localhost:8080/cats) (POST)
Create  a new Cat entry

#### Request Body
A cat object. Note the object does not include an ID as this is autogenerated.
```
{
    "name": "Nala",
    "description": "Simba's childhood friend from the Lion King",
    "breed": "Lion",
    "age": 31
  }
```
#### Response - The newly created Cat.

```
  {
    "catId": 3,
    "name": "Nala",
    "description": "Simba's childhood friend from the Lion King",
    "breed": "Lion",
    "age": 31
  }
```

7. ### [`/{catId}`](http://localhost:8080/cat/1) (PUT)
Update an existing Cat.

#### Parameters
- Path Variable: `catId` &lt;integer&gt; - REQUIRED

#### Request Body
A cat object with the updates.
```
{
    "catId": 1,
    "name": "Simba",
    "description": "The main character of the Lion King",
    "breed": "Lion",
    "age": 31
  }
```
#### Response - the updated Cat object.
```
{
    "catId": 1,
    "name": "Simba",
    "description": "The main character of the Lion King",
    "breed": "Lion",
    "age": 31
  }
```

8. ### [`/{CatId}`](http://localhost:8080/cats/3) (DELETE)
Delete an existing Cat.

#### Parameters
- Path Variable: `catId` &lt;integer&gt; - REQUIRED

#### Response - the updated list of Cat.
```
[
 {
    "catId": 1,
    "name": "Simba",
    "description": "The king of the lion pride",
    "breed": "Lion",
    "age": 31
  },
  {
    "catId": 2,
    "name": "Tigger",
    "description": "The tiger from Winnie the Pooh",
    "breed": "tiger",
    "age": 29
  }
]
```
