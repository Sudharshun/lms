use schooltest;

set FOREIGN_KEY_CHECKS = 0;
truncate table students;
truncate table klasses;
truncate table teachers;
truncate table grades;
set FOREIGN_KEY_CHECKS = 1;

insert into students (email) values
  ('aaa@example.com'),
  ('bbb@example.com'),
  ('ccc@example.com'),
  ('ddd@example.com');

INSERT INTO teachers (name, age, gender) VALUES
  ('Alice', 35, 'MALE'),
  ('Johnn', 21, 'FEMALE'),
  ('Timbr', 68, 'FEMALE');


INSERT INTO klasses (credits, department, fee, name, semester,teacher_id) VALUES
  (4, 'SCIENCE', 500.0, 'Physics 101', '2017-01-25 00:00:00',1),
  (3, 'ENGINEERING', 550.0, 'Electrical Engineering 101', '2018-01-25 00:00:00',2),
  (2, 'SCIENCE', 430.0, 'Calculus 101', '2019-01-25 00:00:00',3);



insert into grades (student_id, klass_id) values
  (1, 1),
  (2, 1),
  (3, 1),
  (1, 2),
  (2, 2),
  (3, 2),
  (1, 3),
  (2, 3),
  (3, 3);