# Lesson 4.2

> Purpose: This lesson is intended to better acquaint students with the syntax and theory of Spring Boot REST APIs. This is an essential lesson. More time has been allotted for activity review.

--- 

### Learning Objectives

After this lesson, students will be able to:

- Create GET routes
- Handle query parameters in the GET requests
- Handle path variables in the GET requests

---

### GET

Highlights:

- Simple GET requests
- Postman
- JSON
- Coding to the Interface

<details>
<summary> Click for Code Sample </summary>

> We will have a database, Data Layer, and Service Layer that data passed through before getting to the controller to return to the user. This is just a syntax introduction.

Use the Postman to access the response from the Course Controller.

```java
public interface CourseControllerInterface {
  List<Course> getCourses();
}
```

```java
package com.ironhack.demo.controller;

import com.ironhack.demo.model.Courses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CourseController implements CourseControllerInterface {

    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> getCourses() {

      //this would typically be a call to your data or service layer
      List<Courses> courseList = new ArrayList<>();

      courseList.add(new Course("MA101", "College Algebra"));
      courseList.add(new Course("MA102", "Calculus 1"));

      return courseList;
    }

}
```

</details>

<details>
<summary> Click for Instructions </summary>

Work with a partner to determine how to return the full course list from the database.

```java
@RestController
public class CourseController implements CourseControllerInterface {

  @Autowired
  private CourseRepository courseRepository;

  @GetMapping("/courses")
  @ResponseStatus(HttpStatus.OK)
  public List<Course> getCourses() {

    //return the full list of courses from the database. Use Postman to confirm the response.
  }

}
```

---

:coffee: **BREAK**

---

### Parameters

Highlights:

- Query params
- Path variables

<details>
<summary> Click for Code Sample </summary>

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
@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private BigDecimal price;
  @Enumerated(EnumType.STRING)
  private Category category;
  @Enumerated(EnumType.STRING)
  private Department department;

  // constructors, getters, and setters omitted for brevity.
}
```

```java
public enum Department {
  CLOTHING, HOMEGOODS, ART, JEWELRY, ELECTRONICS;
}
```

```java
public enum Category {
  HANDMADE, COMMERCIAL_NEW, COMMERCIAL_USED;
}
```

```java
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
```

Path variables (Note that we do not have to use the `(name=)` attribute if the PathVariable matches the parameter name. Ie, `/products/{type}` and `@PathVariable String type`)

```java
@GetMapping("/products/{id}")
@ResponseStatus(HttpStatus.OK)
public Product getProductById(@PathVariable(name="id") long productId) {
  return productRepository.findById(productId).get();
}
```

Request parameters (Note that `Optional` can be used to make a param not required as can adding the attribute `(required=false)`).

```java
@GetMapping("/products")
@ResponseStatus(HttpStatus.OK)
public List<Product> getProductsByCategoryAndDepartment(@RequestParam Optional<String> category, @RequestParam(defaultValue="clothing") String department) {
  return productRepository.findByCategoryAndDepartment(category, department);
}
```

</details>

<details>
<summary> Click for Instructions</summary>

Create a route to get courses by name using both the Path Variables and Query Parameters methods.

</details>
