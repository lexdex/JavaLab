CREATE DATABASE IF NOT EXISTS Students_progress;
USE Students_progress;

CREATE TABLE student (
	id int AUTO_INCREMENT  PRIMARY KEY ,
	full_name varchar (45) NOT NULL ,
	photo_path varchar (45) NULL ,
	qutobiography_path varchar (45) NULL ,
	birth_year year (4) NOT NULL ,
	address varchar (45) NOT NULL ,
	rating double NOT NULL ,
    scholarship_size double NOT NULL
);

CREATE TABLE group_list (
	id int AUTO_INCREMENT  PRIMARY KEY ,
	code int NOT NULL ,
	enter_year year (4) NOT NULL
);

CREATE TABLE grade (
	id int AUTO_INCREMENT  PRIMARY KEY ,
	module1_results double NOT NULL ,
	module2_results double NOT NULL ,
	exam_type varchar (45) NOT NULL ,
	semester_grade_100 int NOT NULL ,
	semester_grade_5 int NOT NULL ,
	semester_number int NOT NULL
);

CREATE TABLE subject (
	id int AUTO_INCREMENT  PRIMARY KEY ,
	name varchar (45) NOT NULL
);

CREATE TABLE teacher (
	id int AUTO_INCREMENT  PRIMARY KEY ,
	full_name varchar (45) NOT NULL
);

CREATE TABLE speciality (
	id int AUTO_INCREMENT  PRIMARY KEY ,
	name varchar (45) NOT NULL
);


