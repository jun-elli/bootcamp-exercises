# Lesson 4.1

### Learning Objectives

After this lesson, students will be able to:

- Articulate the meaning of API, REST, and HTTP
- Select the appropriate HTTP verb and response code for a given scenario
- Define parameters and payload as they pertain to RESTful requests

---

### Intro to HTTP + REST

> Understand the practical parts of HTTP not the technicalities. 

Highlights:

- API
- HTTP
- REST

<details>
<summary> Click for Instructions </summary>

Working with a partner, spend 10 minutes researching and writing your own definitions of:

1. API  (Application Programming Interfaces)
2. HTTP [Mozilla http def](https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview)
3. REST [postman REST def](https://blog.postman.com/rest-api-definition/)

</details>

### Request Methods + Response Codes

> spend about 5 minutes introducing each topic. Remember students will learn about this more thoroughly through practice over the next several lessons. This is just the introduction.

Highlights:

- Response Status Codes (1xx, 2xx, 3xx, 4xx, 5xx)
- Request Methods (GET, POST, PUT, PATCH, DELETE)
- Headers

<details>
<summary> Click for Instructions </summary>

With your partner use the [HTTP Status Code Guide](https://www.restapitutorial.com/httpstatuscodes.html) and the [Mozilla Status Code Documentation](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status) to determine the appropriate status code for each of the following situations:

1. A user clicks on a friend on Facebook, but that friend has deleted their profile and the account no longer exists.
2. A user registers for a web service and a new account is successfully created.
3. A user tries to access a Google Doc document but they are not logged in.
4. A user tries to access their bank account. They are logged in and the action is successful.
5. An online hardware store recently underwent a full website restructure. A user tries to access an old book mark, but the product they are looking for has been moved.
6. A user is attempting to transfer money. As the amount to transfer they have specified "jhy$%1"
7. A user attempts to access a resource. The server is in fact not a server but a teapot.

</details>

> We will walk through the code in detail in the next lesson. This should be about high level conceptual understanding.

Highlights:

- REST
- parameters (query params + path params)
- payload
- provide a high-level walk through of a partial code example

<details>
<summary> Click for Code Sample </summary>

Suppose we are creating an e-commerce application where users can trade their homemade products (like Etsy). Use the below partial code example to demonstrate the role of the HTTP Method, Status Code, Params, and Payload.

```java
    @RequestMapping(value="/products", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody Product product) {
      productRepo.save(product);
    }

    @RequestMapping(value="/products/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable long id) {
      return productRepo.findById(id).get();
    }
```

</details>

<details>
<summary> Click for Instructions </summary>

For each of the following prompts determine the appropriate HTTP method, Default Status Code, Param (if any), and payload (if any):

```
example:

A user is registering for a website

method: POST
status code: 201 (Created)
param: none
payload: new User object
```

1. A user clicks on a Google Doc to open it
2. A user creates a new Google Doc
3. A user updates an existing Google Doc
4. A user deletes a Google Doc

</details>
