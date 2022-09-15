package com.ironhack.bootcamp.campus.servicios;

import com.ironhack.bootcamp.campus.models.Course;
import com.ironhack.bootcamp.campus.models.CourseUpdateHoursDto;
import com.ironhack.bootcamp.campus.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public Course get(String id) {
        Optional<Course> course = courseRepository.findById(id);
/*        if (course.isPresent()) {
            return course.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No hemos encontrado el curso con código " + id);
        }
        CS101, CS102,
 */
        return course.orElseThrow(()-> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No hemos encontrado el curso con código " + id));
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(String courseCode, Course requestCourse) {
        Course storedCourse = get(courseCode);
        if (storedCourse == null) {
            throw new IllegalArgumentException("Course doesn't exist");
        }

        return courseRepository.save(requestCourse);
    }

    @Override
    public Course updateCourseHours(String id, CourseUpdateHoursDto hours) {
        Course storedCourse = get(id);
        storedCourse.setHours(hours.getHours());

        return courseRepository.save(storedCourse);
    }

    @Override
    public void delete(Course course) {
        courseRepository.delete(course);

    }

    @Override
    public List<Course> list() {
        return courseRepository.findAll();
    }
}
