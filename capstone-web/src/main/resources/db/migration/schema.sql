CREATE SEQUENCE IF NOT EXISTS administrator_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS course_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS faculty_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS instructor_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS student_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE administrator
(
    admin_id   BIGINT NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    email      VARCHAR(255),
    password   VARCHAR(255),
    phone      VARCHAR(255),
    address    VARCHAR(255),
    city       VARCHAR(255),
    state      VARCHAR(255),
    zip        VARCHAR(255),
    CONSTRAINT pk_administrator PRIMARY KEY (admin_id)
);

CREATE TABLE course
(
    course_id     BIGINT  NOT NULL,
    name          VARCHAR(255),
    description   VARCHAR(255),
    instructor_id BIGINT,
    credits       INTEGER NOT NULL,
    capacity      INTEGER NOT NULL,
    CONSTRAINT pk_course PRIMARY KEY (course_id)
);

CREATE TABLE course_student
(
    course_id  BIGINT NOT NULL,
    student_id BIGINT NOT NULL,
    CONSTRAINT pk_course_student PRIMARY KEY (course_id, student_id)
);

CREATE TABLE faculty
(
    faculty_id BIGINT NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    email      VARCHAR(255),
    password   VARCHAR(255),
    phone      VARCHAR(255),
    address    VARCHAR(255),
    city       VARCHAR(255),
    state      VARCHAR(255),
    zip        VARCHAR(255),
    CONSTRAINT pk_faculty PRIMARY KEY (faculty_id)
);

CREATE TABLE instructor
(
    instructor_id BIGINT NOT NULL,
    first_name    VARCHAR(255),
    last_name     VARCHAR(255),
    email         VARCHAR(255),
    password      VARCHAR(255),
    phone         VARCHAR(255),
    address       VARCHAR(255),
    city          VARCHAR(255),
    state         VARCHAR(255),
    zip           VARCHAR(255),
    CONSTRAINT pk_instructor PRIMARY KEY (instructor_id)
);

CREATE TABLE student
(
    student_id BIGINT  NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    email      VARCHAR(255),
    password   VARCHAR(255),
    phone      VARCHAR(255),
    address    VARCHAR(255),
    city       VARCHAR(255),
    state      VARCHAR(255),
    zip        VARCHAR(255),
    credits    INTEGER NOT NULL,
    CONSTRAINT pk_student PRIMARY KEY (student_id)
);

ALTER TABLE course
    ADD CONSTRAINT FK_COURSE_ON_INSTRUCTOR FOREIGN KEY (instructor_id) REFERENCES instructor (instructor_id);

ALTER TABLE course_student
    ADD CONSTRAINT fk_coustu_on_course FOREIGN KEY (course_id) REFERENCES course (course_id);

ALTER TABLE course_student
    ADD CONSTRAINT fk_coustu_on_student FOREIGN KEY (student_id) REFERENCES student (student_id);