package com.ironhack.bootcamp.campus.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.bootcamp.campus.models.Course;
import com.ironhack.bootcamp.campus.repositories.CourseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.swing.tree.ExpandVetoException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class CourseControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private CourseRepository courseRepository;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Course course1 = new Course("CS101", "Java basics", 15);
        Course course2 = new Course("CS102", "Java medium", 10);

        courseRepository.save(course1);
        courseRepository.save(course2);
//        courseRepository.saveAll(List.of(course1, course2));

    }

    @AfterEach
    void tearDown() {
        courseRepository.deleteAll();
    }

    @Test
    void list() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/courses"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        List<Course> courses = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<Course>>() {});

        assertEquals(2, courses.size());

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Java basics"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Java medium"));
    }

    @Test
    void get_test() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/courses/CS101"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Course course = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Course.class);

        assertEquals(course.getCourseCode(), "CS101");
        assertEquals(course.getCourseName(), "Java basics");
        assertEquals(course.getHours(), 15);


    }

    @Test
    void create() throws Exception{
        Course newCourse = new Course("CS103", "Java Advanced", 10);
        String payload = objectMapper.writeValueAsString(newCourse);
        MvcResult mvcResult = mockMvc.perform(post("/courses")
                        .content(payload)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        Course course = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Course.class);
        assertEquals(newCourse.getCourseCode(), course.getCourseCode());
        assertEquals(newCourse.getCourseName(), course.getCourseName());
        assertEquals(newCourse.getHours(), course.getHours());

        assertTrue(courseRepository.findById("CS103").isPresent());


    }

    @Test
    void update() {
        assertTrue("test Something" == "not yet implemented");
    }

    @Test
    void updateCourseHours() {
        assertTrue("test Something" == "not yet implemented");
    }

    @Test
    void delete() {
        assertTrue("test Something" == "not yet implemented");
    }
}