insert into student(id, first_name, last_name, date_of_birth) values (1, 'Frank', 'Jones', '1982-12-17');
insert into student(id, first_name, last_name) values (2, 'Joe', 'Smith');
insert into student(id, first_name, last_name) values (3, 'Jill', 'Wilson');
insert into student(first_name, last_name) values ('Tom', 'Baker');

insert into course(id, name) values (1, 'Calculus I');
insert into course(id, name) values (2, 'Calculus II');
insert into course(id, name) values (3, 'Calculus III');

insert into students_courses(course_id, student_id) values (2, 1);