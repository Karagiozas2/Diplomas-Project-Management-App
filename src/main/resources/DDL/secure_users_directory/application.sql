CREATE TABLE application (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             student_id INT,
                             thesis_id INT,
                             status VARCHAR(255),
                             FOREIGN KEY (student_id) REFERENCES secure_users_directory.student(id),
                             FOREIGN KEY (thesis_id) REFERENCES secure_users_directory.thesis(id)
);