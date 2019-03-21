CREATE TABLE studyGroup(
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

ALTER TABLE student ADD CONSTRAINT FK_student_study_group FOREIGN KEY(study_group_id)
  REFERENCES studyGroup (id);


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