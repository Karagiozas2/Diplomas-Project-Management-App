 CREATE TABLE application (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             student_id INT,
                             subject_id INT,
                             status VARCHAR(255),
                             FOREIGN KEY (student_id) REFERENCES student_directory.student(id),
                             FOREIGN KEY (subject_id) REFERENCES subject_directory.subject(id)
);