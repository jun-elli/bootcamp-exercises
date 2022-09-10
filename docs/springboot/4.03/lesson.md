# Lesson 4.3

> Purpose: This lesson covers POST routes and Validation. Validation is a key part of building robust APIs.

--- 

### Learning Objectives

After this lesson, students will be able to:

- Create POST routes
- Validate the format of POST route payloads

---

### POST


Highlights:

- POST route annotations
- Payload

<details>
<summary> Click for Code Sample </summary>

Walk students through the code below then use Postman to add a new product to the database

```sql
CREATE TABLE product (
  id BIGINT AUTO_INCREMENT NOT NULL,
  name VARCHAR(255),
  price DECIMAL(10,2),
  category VARCHAR(30),
  department VARCHAR(30),
  PRIMARY KEY (id)
);

INSERT INTO product (name, price, category, department) VALUES
('Diamond Necklace', 750.49, 'COMMERCIAL_NEW', 'JEWELRY'),
('Pooka Shell Bracelet', 7.50, 'HANDMADE', 'JEWELRY'),
('Commodore 64', 225.00, 'COMMERCIAL_USED', 'ELECTRONICS'),
('Baby Blue Tuxedo', 65.25, 'COMMERCIAL_USED', 'CLOTHING'),
('Rectangular Persian Rug', 7500.00, 'HANDMADE', 'HOMEGOODS');
```

```java
@PostMapping("/products")
@ResponseStatus(HttpStatus.CREATED)
public void addProduct(@RequestBody Product product) {
  productRepository.save(product);
}

```

</details>

#### :pencil2: Check for Understanding - POST

> :clock10: 10 min (+ 10 min Review)

<details>
<summary> Click for Instructions </summary>

Build a post route to add new students.

</details>

<details>
  <summary> Click for Solution </summary>

```java
@PostMapping("/students")
@ResponseStatus(HttpStatus.CREATED)
public void addStudent(@RequestBody Student student) {
  studentRepository.save(student);
}
```

</details>

---

### Validation


Highlights:

- Bean Validation
- Javax Validation Constraint package

<details>
<summary> Click for Code Sample </summary>

Walk students through the [Javax Validation Constraint Documentation](https://docs.oracle.com/javaee/7/api/javax/validation/constraints/package-summary.html) then walk through the example below. And demonstrate what happens with a malformed POST request.

[validation springboot](https://reflectoring.io/bean-validation-with-spring-boot/)
[validation baeldung](https://www.baeldung.com/javax-validation)

First you have to add spring-boot-starter validation on the pom.xml file

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

If you are using spring-boot-devtools dependency you may want to add this line to the application.properties to avoid trace were printed on the response errors

```
server.error.include-stacktrace=never
```

If you are not using spring-boot-devtools dependency you need to add these lines in the application.properties to print the error messages on the response errors

```
server.error.include-message=always
server.error.include-binding-errors=always
``



```java
public class Product {
  private long id;

  @NotEmpty(message = "You must supply a product name")
  private String name;

  // Validates the maximum number of digits for the integral and fractional parts
  @Digits(integer = 6, fraction = 2)
  private BigDecimal price;
  private Category category;
  private Department department;
}
```

```java
public enum Department {
  CLOTHING, HOMEGOODS, ART, JEWELRY, ELECTRONICS
}
```

```java
public enum Category {
  HANDMADE,  COMMERCIAL_NEW, COMMERCIAL_USED
}
```

In order to actually perform the validation on a request, we have to include the `@Valid` annotation in our controller.

```java
@PostMapping("/products")
@ResponseStatus(HttpStatus.CREATED)
public void addProduct(@RequestBody @Valid Product product) {
  productRepository.save(product);
}
```

</details>

#### :pencil2: Independent Research - Validation

<details>
<summary> Click for Instructions</summary>

Use the the [Javax Validation Constraint Documentation](https://docs.oracle.com/javaee/7/api/javax/validation/constraints/package-summary.html) to add thorough validation to the Course, Faculty, Student, Section, and Grade models

</details>

<details>
  <summary> Click for Solution </summary>

```java
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "First name cannot be empty")
    private String firstName;
    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;

    // constructors, getters, and setters omitted for brevity
}
```

</details>
