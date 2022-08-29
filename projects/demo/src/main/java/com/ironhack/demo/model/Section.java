package com.ironhack.demo.model;


import javax.persistence.*;

@Entity
@Table(name = "section")
@Inheritance(strategy = InheritanceType.JOINED)
public class Section { // --> section

    @Id
    String id;
    String courseCode; // --> course_code
    Integer roomNumber; // --> room_number
    Integer enrolled;
    @Column(name = "instructor")
    String instructor; // --> instructor

    Integer capacity;

    public Section() {}

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
