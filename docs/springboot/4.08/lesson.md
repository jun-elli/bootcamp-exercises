# Lesson 3.8

### Lesson Duration: 2 hours

### Setup

- none

> Purpose: This lesson is a paired activity to provide students the oppotunity to practice building applications with authentication and authorization.

---

### Learning Objectives

After this lesson, students will be able to:

- feel more confident leveraging Spring Security

---

#### :pencil2: Check for Understanding - REST APIs

> :clock10: 120 min (+ 30 min Review)

> Monitor student progress closely. Provide additional time if students need, but be careful not let students flounder aimlessly for the full 120 minutes. Provide prompting and hints as needed.

<details> 
  <summary> Click for Instructions </summary>
  
  > Work with a partner to complete the activity below. Use Google heavily and be sure to ask for help if you get stuck. Remember you should always try to solve the problem yourself first using Google. If you are stuck for more than 10 minutes, ask your partner. If together you can't solve the problem in another 10 minutes, ask instructional staff for help. 
  
  For this activity, you will be building a content management system for a blog with multiple authors
  
 1. Create the tables below in your database 
 
     #### Blog Post Table

     | id  | author_id | title | post |
     | --- | --------- | ----- | ---- |
     | 1 | 1 | Boost Your Productivity with 10 Easy Tips | Productivity - we all want it but it seems ... |
     | 2 | 1 | How to Focus | Do you ever sit down to work and find yourself  ... |
     | 3 | 2 | Learn to Speed Read in 30 Days | Knowledge, not ability, is the great determiner of ... |

     #### Author Table

     | id  | name |
     | --- | --- |
     | 1 | Aiko Tanaka |
     | 2 | Jonas Schmidt |
     | 3 | Cas Van Dijk |

2. Use Spring Security to create an admin role.

3. Create the routes below:

   - get post and author
   - add post
   - add author
   - update post
   - update author
   - delete post
   - delete author

4. Use Spring Security to ensure only admins can access every route except the GET route which should be publicly available.

5. Create tests for all routes and document your API.

</details>
