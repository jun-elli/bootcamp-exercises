
-- describe course;
-- show create table course;

select course_name from course;
select * from course;
select * from course where course_code = 'CS101';
select * from course where course_name like '%java';

select c.course_name, s.id from course c, section s where c.course_code = s.course_code;
select c.course_name, s.id from course c inner join section s on c.course_code = s.course_code;

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
select student_name, score 
from grade, section where grade.section_id = section.id and section.course_code = 'CS103';

select student_name, score from grade where grade.section_id LIKE '%CS103$';

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


USE irondb;

CREATE TABLE student (
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255)
);

insert into student (first_name, last_name) values 
		('James', 'Fields'),
        ('Maya',  'Charlotte'),
		('Michael', 'Alcocer'),
		('Maya', 'Charlotte'),
		('Tomas', 'Lacroix'),
		('Sara', 'Bisat'),
		('James', 'Fields'),
		('Helena', 'Sepulvida'); 


