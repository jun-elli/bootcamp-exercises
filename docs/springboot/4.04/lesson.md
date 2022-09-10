# Lesson 4.4

### Setup

- none

> Purpose: To help students differentiate between PUT and PATCH

--- 

### Learning Objectives

After this lesson, students will be able to:

- Create a PUT route to replace or modify database entries
- Use PATCH to minimally update database entries

---

### PUT

> In this section, we'll introduce the service layer. Students should be familiar with the concept of a service Layer, but this is the first chance to actually implement a service.

Highlights:

- PUT
- Service Layer

<details>
<summary> Click for Code Sample </summary>

```java
@PutMapping("/product/{id}")
@ResponseStatus(value = HttpStatus.NO_CONTENT)
public void updateProduct(@PathVariable long id, @RequestBody Product product) {
    productService.update(id, product);
}
```

> Don't worry about handling exceptions yet. That will be covered in a later lesson.

```java
public void update(long id, Product product) {
  Optional<Product> productOptional = productRepository.findById(id);
  product.setId(productOptional.get().getId());
  productRepository.save(product);
}
```

</details>

#### :pencil2: Check for Understanding - PUT

<details>
<summary> Click for Instructions </summary>

Create a PUT route to allow users to modify `Student` information.

</details>

<detail>
  <summary>Click for Solution</summary>

```java
@PutMapping("/students/{id}")
@ResponseStatus(value = HttpStatus.NO_CONTENT)
public void updateStudent(@PathVariable int id, @RequestBody Student student) {
    studentService.update(id, student);
}
```

```java
public void update(int id, Student student) {
  Optional<Student> studentOptional = studentRepository.findById(id);
  student.setId(studentOptional.get().getId());
  studentRepository.save(student);
}
```

</detail>

---

#### :pencil2: Independent Learning - PATCH

<details>
<summary> Click for Code Sample </summary>
Many people struggle to understand the difference between PUT and PATCH. The truth is that many companies use PUT for all updates (some companies only use POST and GET for everything!). However, strictly speaking PUT should be used for a full update (i.e. a replacement) rather than a partial update. Using PUT improperly can have serious ramifications at organizations with rapid data updating or very large data resources.

It's time for some independent research on the matter. Google the difference between PUT and PATCH. You'll find a lot of different opinions, but there will be some common themes.

After reading some articles, provide an example of when PUT is the best option and when PATCH is the best option.

</details>

### PATCH

Highlights:

- DynamicUpdate Annotation
- PATCH syntax and use cases
- Use of Data Transfer Objects (DTO)

<details>
<summary> Click for Code Sample </summary>

Run the code below. Show the SQL statements being executed in the console. Note that a full update is still being performed. Note that we create a ProductPriceOnlyDTO to receive only the data we going to update. DTOs can be used as inputs or outputs

```java

@PatchMapping("/products/{id}")
@ResponseStatus(value = HttpStatus.NO_CONTENT)
public void partialUpdatePrice(@PathVariable("id") long id, @RequestBody ProductPriceOnlyDTO partialProduct) {

    productService.save(id, partialProduct.getPrice());
}
```

```java
public class ProductPriceOnlyDTO {

  @Digits(integer = 6, fraction = 2)
  private BigDecimal price;
}
```

```java
public void updatePrice(long id, BigDecimal price) {
  Product product = productRepository.findById(id).get();
  product.setPrice(price);
  productRepository.save(product);
}
```

Add the `@DynamicUpdate` annotation to the Product model and execute the code again. Note that the SQL statement is now only updating the necessary columns.

```java
@Entity
@DynamicUpdate
public class Product {
  private long id;

  @NotEmpty(message = "You must supply a product name")
  private String name;

  @Digits(integer = 6, fraction = 2)
  private BigDecimal price;
  private Category category;
  private Department department;
}
```

</details>

#### :pencil2: Check for Understanding - PATCH

<details>
<summary> Click for Instructions </summary>

Create a PATCH route to allow users to update Scores in the `Grade` model.

</details>

#### :pencil2: Independent Research - DELETE

> :clock10: 20 min (+ 10 min Review)

<details>
<summary> Click for Instructions </summary>

Work with a partner to research Spring Boot DELETE. Implement a DELETE route that allows users to delete Students. Think through the implementation. How should this action cascade through your application?

</details>
