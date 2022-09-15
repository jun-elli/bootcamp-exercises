package com.ironhack.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "section")
@Inheritance(strategy = InheritanceType.JOINED)
public class Section { // --> section

    @Id
    private String id;

    private Integer roomNumber; // --> room_number
    private Integer enrolled;
    @Column(name = "instructor")
    private String instructor; // --> instructor

    private Integer capacity;

//    @JsonIgnore // if we want to fully hide this field
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_code")
    private Course course;


    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public String getId() {
        return id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(Integer enrolled) {
        this.enrolled = enrolled;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Section() {
    }

    public Section(int capacity) {
        this.capacity = capacity;
    }
}

/* -- Single table approach
CREATE TABLE section(
    id VARCHAR(8) NOT NULL,
    course_code VARCHAR(6),
    room_num SMALLINT,
    instructor VARCHAR(255),
    section_type VARCHAR(255),
    capacity INT,
    enrolled INT,
    lab_room_num INT,
    credits INT,
    PRIMARY KEY (id),
    FOREIGN KEY (course_code) REFERENCES course(course_code)
 );
 */


/* table per class
CREATE TABLE section(
    id VARCHAR(8) NOT NULL,
    course_code VARCHAR(6),
    room_num SMALLINT,
    instructor VARCHAR(255),
    capacity INT,
    enrolled INT,
    PRIMARY KEY (id),
    FOREIGN KEY (course_code) REFERENCES course(course_code)
 );

 CREATE TABLE math_section(
    id VARCHAR(8) NOT NULL,
    course_code VARCHAR(6),
    room_num SMALLINT,
    instructor VARCHAR(255),
    capacity INT,
    enrolled INT,
    math_credits INT,
    PRIMARY KEY (id),
    FOREIGN KEY (course_code) REFERENCES course(course_code)
 );

 CREATE TABLE science_section(
    id VARCHAR(8) NOT NULL,
    course_code VARCHAR(6),
    room_num SMALLINT,
    instructor VARCHAR(255),
    capacity INT,
    enrolled INT,
    lab_room_num INT,
    science_credits INT,
    PRIMARY KEY (id),
    FOREIGN KEY (course_code) REFERENCES course(course_code)
 );

 CREATE TABLE computer_section(
    id VARCHAR(8) NOT NULL,
    course_code VARCHAR(6),
    room_num SMALLINT,
    instructor VARCHAR(255),
    capacity INT,
    enrolled INT,
    computer_credits INT,
    PRIMARY KEY (id),
    FOREIGN KEY (course_code) REFERENCES course(course_code)
 );
 */


/* JOIN
CREATE TABLE section(
    id VARCHAR(8) NOT NULL,
    course_code VARCHAR(6),
    room_num SMALLINT,
    instructor VARCHAR(255),
    capacity INT,
    enrolled INT,
    PRIMARY KEY (id),
    FOREIGN KEY (course_code) REFERENCES course(course_code)
 );

 CREATE TABLE math_section(
    id VARCHAR(8) NOT NULL,
    math_credits INT,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES section(id)
 );

 CREATE TABLE science_section(
    id VARCHAR(8) NOT NULL,
    lab_room_num INT,
    science_credits INT,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES section(id)
 );

 CREATE TABLE computer_section(
    id VARCHAR(8) NOT NULL,
    computer_credits INT,
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES section(id)
 );
 */
