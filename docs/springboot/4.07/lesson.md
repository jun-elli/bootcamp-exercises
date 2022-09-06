# Lesson 4.7

### Lesson Duration: 2.5 hours

### Setup

- none

> Purpose: While recent graduates should not be tasked with setting up security, they should be able to use an existing security setup to secure a new route. Walk students through Spring Security, but remember that their only goal is to copy/paste your Spring Security code and use it to secure routes in new applications.

---

### Additional Resources

If you would like to review these concepts before the class here you have some resources below:

- [Student links](https://github.com/ironhack-edu/java-bootcamp/blob/develop/03-lean-lessons/4-the-controller-layer/spring-security/spring-security.md)

--- 

### Learning Objectives

After this lesson, students will be able to:

- leverage Spring Security to add authentication and authorization to their application

---

### Spring Security

> :clock10: 30 min

> Junior developers should not be in charge of setting up security but may be responsible for securing routes and other parts of the application. To mimic the work environment as closely as possible, we will provide students with the Security configuration boilerplate and only expect them to secure routes.

> This section is an opportunity to introduce security and walk through the setup. Reassure students that they are not fully expected to understand how Spring Security works or memorize all the configuration steps. They should leave this section with a general idea of how Spring Security works and an understanding of its importance.

Cover the following steps:

1. The user logs in with a username/password. This is done via a POST request.
2. An authentication token is generated on the server and returned to the user.
3. The user sends an HTTP header Authorization: Bearer TOKEN with each request.
4. The token is destroyed when the user logs out.

Highlights:

- Walkthrough the security template project

<details>
<summary> Click for Code Sample </summary>

> Add your database information to the application.properties file and walk the students through the Security Demo. Seed your database with the below schema.

```sql
CREATE DATABASE IF NOT EXISTS security_demo;
USE security_demo;

CREATE TABLE user (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE role (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(255),
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user (id)
);

INSERT INTO user (username, password) VALUES
("user", "$2a$10$MSzkrmfd5ZTipY0XkuCbAejBC9g74MAg2wrkeu8/m1wQGXDihaX3e"),
("technician", "$2a$10$MSzkrmfd5ZTipY0XkuCbAejBC9g74MAg2wrkeu8/m1wQGXDihaX3e"),
("admin","$2a$10$MSzkrmfd5ZTipY0XkuCbAejBC9g74MAg2wrkeu8/m1wQGXDihaX3e");

INSERT INTO role (name, user_id) VALUES
("TECHNICIAN", 2),
("ADMIN", 3),
("TECHNICIAN", 3);
```

This sets up three users. Every user has the same password `123456`. The passwords are encoded by BCrypt and were generated using the `PasswordUtility` found in the `com.ironhack.util` package. This class is not part of the application but provided for the convenience of creating new users since no sign-up functionality is implemented.

Walk students through the application. There are a lot of pieces, so draw particular attention to the Security Configuration where certain route prefixes are protected. Note the difference between `authenticated()` and `hasRole()`. You can talk about the differences between roles and authorities. Note that `anyRequest().permitAll()` added to the end of this chain leaves any other routes not listed here open to any user, whether they are authenticated or not. Note that roles must be prefixed with `ROLE_` for Spring security, but we mask it in `CustomUserDetails`:

```java
@Override
public void configure(HttpSecurity httpSecurity) throws Exception {

    httpSecurity.httpBasic();

    http.authorizeRequests()
        .mvcMatchers(HttpMethod.GET, "/hello/**/world").authenticated()
        .mvcMatchers(HttpMethod.GET, "/goodbye/**/world").hasRole("ADMIN")
        .mvcMatchers(HttpMethod.GET,"/say-hello").authenticated()
        .mvcMatchers(HttpMethod.POST,"/post-test").hasAnyRole("TECHNICIAN", "ADMIN")
        .anyRequest().permitAll();

}
```

</details>

To demonstrate this application, ensure that you and students have Postman installed. If students are using the provided Linux Virtual Machine, Postman can be installed with the terminal command `sudo snap install postman`. When prompted for a password, simply hit the Enter key -- no password is configured. If not using the VM, Postman can be downloaded from [the Postman webpage](https://www.postman.com/downloads/).

Make requests to each of the routes provided in the application, noting how access is restricted based on role. To authenticate in Postman, click on the `Authentication` tab, then select `Basic Authentication` from the dropdown selection. Enter the credentials in the form that appears before making the request.

---

:coffee: **BREAK**

---

#### :pencil2: Check for Understanding - Security

> :clock10: 45 min (+ 30 min Review)

> Ample time has been provided for this activity to ensure that all students are able to create a secure API. As students complete the activity, assign them to struggle students to help. In remote classes, you can move students from one breakout room to another breakout room to assist other students.

<details>
<summary> Click for Code Sample </summary>

Copy the Security Template and add in the Course, Student, Faculty, Section, and Grade models and repositories. Add in your routes. Make all Update and Delete routes admin protected. Make all GET routes and Create routes User protected.

</details>
