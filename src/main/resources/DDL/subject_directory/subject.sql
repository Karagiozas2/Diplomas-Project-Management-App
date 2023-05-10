CREATE TABLE subject (


                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255),
                         description VARCHAR(255),
                         professor_id INT,
                         FOREIGN KEY (professor_id) REFERENCES secure_users_directory.professor(id)
);