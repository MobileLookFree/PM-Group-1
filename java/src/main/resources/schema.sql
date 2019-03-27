
CREATE TABLE study_group(
                          id int NOT NULL PRIMARY KEY,
                          name text NOT NULL
);


CREATE TABLE student(
                      id int NOT NULL PRIMARY KEY,
                      surname text NOT NULL,
                      name text NOT NULL,
                      second_name text NOT NULL,
                      study_group_id int NOT NULL
);


CREATE TABLE student_local(
                      id int NOT NULL PRIMARY KEY,
                      surname text NOT NULL,
                      name text NOT NULL,
                      second_name text NOT NULL,
                      study_group_id int NOT NULL
);

ALTER TABLE student_local ADD CONSTRAINT FK_student_study_group FOREIGN KEY(study_group_id)
  REFERENCES study_group (id);

CREATE TABLE subject(
                      id int NOT NULL PRIMARY KEY,
                      name text NOT NULL,
                      short_name text NOT NULL
);


CREATE TABLE exam_type(
                        id int NOT NULL PRIMARY KEY,
                        type text NOT NULL
);


CREATE TABLE study_plan(
                         id int NOT NULL PRIMARY KEY,
                         subject_id int NOT NULL,
                         exam_type_id int NOT NULL
);

ALTER TABLE study_plan ADD CONSTRAINT FK_study_plan_exam_type FOREIGN KEY(exam_type_id)
  REFERENCES exam_type (id);


ALTER TABLE study_plan ADD CONSTRAINT FK_study_plan_subject FOREIGN KEY(subject_id)
  REFERENCES subject(id);

CREATE TABLE mark(
                   id int NOT NULL PRIMARY KEY,
                   name text NOT NULL,
                   value text NOT NULL
);

CREATE TABLE journal(
                      id int NOT NULL PRIMARY KEY,
                      student_id int NOT NULL,
                      study_plan_id int NOT NULL,
                      in_time bit NOT NULL,
                      count int NOT NULL,
                      mark_id int NOT NULL);

ALTER TABLE journal ADD CONSTRAINT FK_journal_mark FOREIGN KEY(mark_id)
  REFERENCES mark(id);

ALTER TABLE journal ADD CONSTRAINT FK_journal_student FOREIGN KEY(student_id)
  REFERENCES student(id);

ALTER TABLE journal ADD CONSTRAINT FK_journal_study_plan FOREIGN KEY(study_plan_id)
  REFERENCES study_plan(id);


insert into study_group (ID, NAME)
VALUES (1, 'ИВБО-02-15-1');

insert into STUDENT_LOCAL (ID, SURNAME, NAME, SECOND_NAME, study_group_id)
VALUES(1, 'Алешин', 'Илья', 'Константинович', 1),
      (2, 'Борзых', 'Никита', 'Юрьевич', 1),
      (3,'Воронцов', 'Юрий', 'Алексеевич', 1),
      (4, 'Гафланов', 'Руслан', 'Ингарович', 1),
      (5, 'Джураев', 'Халим', 'Акбарович', 1),
      (6, 'Звонников' , 'Александр', 'Сергеевич', 1),
      (7, 'Зубкова', 'Марина', 'Геннадьевна', 1),
      (8, 'Манджиева', 'Данара', 'Альбертовна', 1),
      (9, 'Мацарский', 'Валерий', 'Александрович', 1),
      (10, 'Меркулов', 'Максим', 'Евгеньевич', 1),
      (11, 'Мусин', 'Антон', 'Игоревич', 1),
      (12, 'Паперно', 'Виктор', 'Александрович', 1),
      (13, 'Прохоров', 'Андрей', 'Валерьевич', 1),
      (14, 'Сергеев', 'Юрий', 'Дмитриевич', 1),
      (15, 'Штендер', 'Владислав', 'Андреевич', 1);



insert into SUBJECT (ID, NAME, SHORT_NAME)
VALUES(1, 'Проектирование информационных систем', 'ПрИС'),
      (2, 'Системы искусственного интеллекта', 'СИИ'),
      (3, 'Программная инженерия', 'ПИ'),
      (4, 'Национальная система информационной безопасности', 'НСИБ'),
      (5, 'Системный анализ', 'СисАнал'),
      (6, 'Распределенные базы данных', 'РБД'),
      (7, 'Системное программное обеспечение', 'СПО');

insert into EXAM_TYPE (ID, TYPE)
VALUES(1, 'Экзамен'),
      (2, 'Зачет'),
      (3, 'Зачет с оценкой'),
      (4, 'Курсовая');

insert into STUDY_PLAN (ID, SUBJECT_ID, EXAM_TYPE_ID)
VALUES(1, 1, 1),
      (2, 1, 4),
      (3, 2, 1),
      (4, 3, 1),
      (5, 4, 2),
      (6, 5, 1),
      (7, 6, 2),
      (8, 7, 1);

insert into MARK (ID, NAME, VALUE)
VALUES(1, 'Отлично', 5),
      (2, 'Хорошо', 4),
      (3, 'Удовлетворительно', 3),
      (4, 'Неудовлетворительно', 2),
      (5, 'Зачет', 'з'),
      (6, 'Незачет', 'н'),
      (7, 'Неявка', '');
