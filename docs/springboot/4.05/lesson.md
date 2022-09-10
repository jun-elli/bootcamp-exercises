# Lesson 4.5

### Lesson Duration: 2 hours

> Purpose: The purpose of this lesson is to round out students' ability to create robust REST APIs by covering custom exception creation and controller testing. Students have had a fairly heavy week, so go as slowly as you need to through this. The next lesson is a practice lesson where students will build a REST API from scratch.

--- 


### Learning Objectives

After this lesson, students will be able to:

- Throw exceptions
- Handle exceptions gracefully in controllers
- Use MockMVC to test their controllers

---

### Exception Handling


> Notes

Highlights:

- ResponseStatusException
- Status Codes and Handling Exceptions in Controllers
- Default Spring Responses

<details>
<summary> Click for Code Sample </summary>

> Before diving into Exception Handling, point out that Spring (especially with Validation Constraints) handles the mass majority of exceptions for us. ResponseStatusException is very useful when our business logic creates constraints specific to our application. For example, we might want to send a 404 rather than a 401 for unauthorized access.

Recall the PUT method that we previously saw

```java
@PutMapping("/products/{id}")
@ResponseStatus(value = HttpStatus.NO_CONTENT)
public void updateProduct(@PathVariable long id, @RequestBody Product product) {
      productService.update(id, product);
}
```

```java
public void update(long id, Product product){
  Optional<Product> productOptional = productRepo.findById(id);
  product.setId(productOptional.get().getId());
  productRepository.save(product);
}
```

In the service layer, productOptional.getId() will result in a null pointer exception if an entity with the supplied id does not exist in the database. Let's add a check to ensure this doesn't happen:

```java
public void update(long id, Product product){
    Product fromRepo = productRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    product.setId(fromRepo.getId());
    productRepository.save(product);
}
```

</details>

#### :pencil2: Check for Understanding - Exception Handling

<details>
<summary> Click for Instructions </summary>

Throw a ResponseStatusException with code 404 on your create, update and delete methods.

</details>

#### :pencil2: Check for Understanding - Exception Handling


<details>
<summary> Click for Instructions </summary>

Throw a ResponseStatusException with code 404 if any `findBy` method in your application returns a null value.

Throw a ResponseStatusException with code 422  if the `id` of any request body of your store method already exist.

</details>

<details>
  <summary>Click for Solution</summary>

CourseServiceImpl
```java
public Course store(Course course) {
    Optional<Course> optionalCourse = courseRepository.findById(course.getCode());
    if (optionalCourse.isPresent()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Course with code " + course.getCode() + " already exist");

    return courseRepository.save(course);
}
```


```java
public Product findById(Long id) {
      return productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
  }

  public void update(Long id, Product product) {
      Product storedProduct = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
      product.setId(storedProduct.getId());
      productRepository.save(product);
  }

  public void updatePrice(Long id, BigDecimal price) {
      Product storedProduct = productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
      storedProduct.setPrice(price);
      productRepository.save(storedProduct);
  }
```

</details>


### MockMVC

> Reinforce the importance of testing every layer of our application. Remind students of the difference between unit tests and integration tests. This is the first time students are seeing integration tests so take your time ensuring that they understand the role integration tests.

Highlights:

- integration tests
- MockMVC

<details>
<summary> Click for Code Sample </summary>

Be sure to make note of the different elements for this test -- `@SpringBootTest`, `WebApplicationContext`, `MockMvc`,`ObjectMapper`

```java
@SpringBootTest
public class CourseControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private CourseRepository courseRepository;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Course course = new Course("CS101", "Intro to Java");
        Course course2 = new Course("CS102", "Databases");
        courseRepository.saveAll(List.of(course, course2));
    }

    @AfterEach
    void tearDown() {
        courseRepository.deleteAll();
    }

    @Test
    void store_Valid_Created() throws Exception {
        Course course = new Course("CS103", "Another course");
        String body = objectMapper.writeValueAsString(course);
        MvcResult mvcResult = mockMvc.perform(post("/courses")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(status().isCreated()).andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Another course"));
    }

    @Test
    void getAll_Valid_AllCourses() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/courses"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Intro to Java"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Databases"));
    }
}
```

</details>

#### :pencil2: Check for Understanding - MockMVC


<details>
<summary> Click for Instructions</summary>

Write integration tests for all the GET and POST routes in your application. The only test for positive cases for now.

Google to determine how to handle path variables and query parameters.

</details>

#### :pencil2: Check for Understanding - MockMVC


<details>
<summary> Click for Instructions</summary>

Write integration tests for your negative cases. These tests should ensure that the appropriate status codes and error messages are in the response.

As a hint you can use the syntax `.andExpect(status().reason(containsString("Bad Request")))` to test if an error message containing "Bad Request" was in the response body.

</details>
