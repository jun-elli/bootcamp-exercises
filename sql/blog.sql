/*
	Crear un model relacional para una editorial:
    - La editorial puede gestionar blogs y puede editar libros
    - Tanto libros como blogs tendrán un título y una fecha de creación
    - Los libros tendrán un número de páginas
    - los blogs tendrán una url
    - todas las publicaciones tendrán uno o más authores
    - el author tendrá un nombre y apellido.
    
    Implementar este model utilizando herencia con estrategias de una sola tabla y tablas relacionadas con Joins
    Después estudiar y elegir cual sería la estrategia más apropiada si la hay, o en qué casos se elegiría una sobre otra.
*/

/* 
   Añadir en las publicaciones los siguientes atributos:
   - nombre del editor
   - oficina del editor
   - categoría del editor (junior, senior, o freaking boss)
   
   - nombre del supervisor
   - oficina del supervisor
   - categoría del supervisor (senior, freaking boss, por encima de Sauron)
*/
use blog;

drop table if exists author;
drop table if exists publication;
drop table if exists author_publications;



-- Joined tables
create table publication (
  id int primary key auto_increment,
  title varchar(255),
  created_date date,
  
  editor_name varchar(255),
  editor_office varchar(255),
  editor_category varchar(255),
  
  supervisor_name varchar(255),
  supervisor_office varchar(255),
  supervisor_category varchar(255)
);


create table book (
  id int primary key auto_increment,
  pages int,
  
  foreign key (id) references publication(id)
);

create table blog (
  id int primary key auto_increment,
  url varchar(255),
  
  foreign key (id) references publication(id)
);

create table author (
  id int primary key auto_increment,
  first_name varchar(255),
  last_name varchar(255)
);

create table author_publications (
  author_id int references author(id),
  publication_id int references publication(id)
);

  

  
  