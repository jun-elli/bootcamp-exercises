
-- Le digo a workbench que quiero usar esa base de datos
use irondb;

-- Borro las tablas que tenía de antes
drop table if exists section;
drop table if exists course;
drop table if exists grade;

-- Creo mis nuevas tablas
create table course(
	course_code VARCHAR(6) not null,
    course_name varchar(255),
    PRIMARY KEY (course_code)
);

create table section( 
	id VARCHAR(8) NOT NULL,
    course_code varchar(6) REFERENCES course(course_code), -- implícita
    room_num SMALLINT,
    instructor VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE grade (
	id INT NOT NULL AUTO_INCREMENT,
    student_name VARCHAR(255),
    section_id VARCHAR(8),
    score INT,
    PRIMARY KEY (id)
);

select c.course_name, s.id from course c, section s where c.course_code = s.course_code;
select c.course_name, s.id from course c inner join section s on c.course_code = s.course_code;



select s.* from section;

INSERT INTO course (course_code, course_name) VALUES
('CS101', 'Intro to Java'),
('CS103',  'Databases');

truncate section;
INSERT INTO section (id, course_code, room_num, instructor) VALUES
('CS101-A', 'CS101', 1802, 'Balderez'),
('CS101-B', 'CS101',  1650, 'Balderez'),
('CS103-A', 'CS103',  1200, 'Rojas'),
('CS103-B', 'CS103',  1208, 'Tonno');


INSERT INTO grade (student_name, section_id, score) VALUES
('Maya Charlotte', 'CS101-A', 98),
('James Fields', 'CS101-A', 82),
('Michael Alcocer', 'CS101-B', 65),
('Maya Charlotte', 'CS103-A', 89),
('Tomas Lacroix', 'CS101-A', 99),
('Sara Bisat', 'CS101-A', 87),
('James Fields', 'CS101-B', 46),
('Helena Sepulvida', 'CS103-A', 72); 

-- describe course;
-- show create table course;

select course_name from course;
select * from course;
select * from course where course_code = 'CS101';
select * from course where course_name like '%java';

select count(id) from section where course_code = 'CS101';

select student_name, score from grade where student_name like 'Tomas%';

-- Selecciona los estudiantes que han realizado la segunda ejecución del curso de introducción a Java
select student_name from grade where section_id = 'CS101-B';

select avg(score) from grade where section_id like 'CS103%';

select sum(score) from grade;
select max(score) from grade;
select min(score) from grade;

select section_id, max(score) from grade group by section_id;

SELECT section_id, AVG(score) from grade group by section_id having section_id = 'CS101-A';

select * from grade where score between 80 and 90;

select * from grade order by score asc;
select * from grade order by score desc limit 2;


select * from section;
select course_code, count(distinct(instructor)) from section group by course_code;

select course_code, instructor from section;

select distinct(course_code) from section;

-- The query for the following information:
-- student name and score for all CS103 sections sorted by the score from highest to lowest.

-- an alphabetical list of distinct students whose first names fall alphabetically from L to R
select student_name from grade where student_name > 'J';


-- Inner join selecciona los registros cuando las dos tablas coinciden en la condición del 'on'
select student_name, score, instructor
from grade
inner join section on grade.section_id = section.id;

-- left join selecciona todos los registros de la izquierda y de los de la derecha que coinciden en la condición del 'on'
select student_name, score, instructor
from section
left join grade
on section.id = grade.section_id;


