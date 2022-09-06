# Lesson 4.6

### Lesson Duration: 2 hours

### Setup

- none

> Purpose: This lesson is a paired activity to provide students the opportunity to practice documenting, building, and testing REST APIs. Before you begin, show students what good API documentation looks like.

---

### Learning Objectives

After this lesson, students will be able to:

- feel more confident building and testing REST APIs.

---

### Documenting APIs

> :clock10: 15 min

> Spend 15 minutes explaining the importance of API documentation and looking at some good and bad documentation with students.

#### :pencil2: Check for Understanding - REST APIs

> :clock10: 100 min (+ 30 min Review)

> Monitor student progress closely. Provide additional time if students need it, but be careful not to let students flounder aimlessly for the full 90 minutes. Provide prompting and hints as needed.
>
> **After the activity, pay special attention to DELETE routes in your review**.

<details> 
  <summary> Click for Instructions </summary>
  
 > For this project, assume that you are building an application for an online gardening store. Work in pairs to complete the activity below. Proactively seek help from your peers and your instructor if you feel stuck.
 
1. Create a database with the following tables and add some additional data:

 <br>
 
 #### Department Table

| id  | department        |
| --- | ----------------- |
| 1   | tools             |
| 2   | edible plants     |
| 3   | non-edible plants |
| 4   | edible seeds      |
| 5   | non-edible seeds  |
| 6   | miscellaneous     |

<br>

#### Product Table

| id  | department_id | name                                | quantity |
| --- | ------------- | ----------------------------------- | -------- |
| 1   | 1             | small shovel                        | 50       |
| 2   | 1             | large shovel                        | 150      |
| 3   | 2             | apple tree sapling                  | 10       |
| 4   | 4             | assorted root vegetable seed packet | 2000     |
| 5   | 5             | geranium seed packet                | 1000     |
| 6   | 2             | sprouted carrots                    | 200      |
| 7   | 6             | large brim gardening hat            | 25       |

<br>

2. Create a route for adding new products (validate the payload format)
3. Create a route for decrementing the quantity of a product by an amount specified in a parameter. Throw a custom error and respond with an appropriate response code if the specified amount is less than the quantity of the product in stock.
4. Create a route to get all products by department. Return all products if the department param is empty/null.
5. Create a route to get a product by id. Throw an error and respond with an appropriate response code if the id does not exist.
6. Create a route to add a new department (validate the payload format)
7. Create a DELETE route to delete products from the product list by id.
8. Test all of your routes thoroughly.

</details>
