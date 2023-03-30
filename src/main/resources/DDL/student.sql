CREATE DATABASE  IF NOT EXISTS `student_directory`;
USE `student_directory`;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `first_name` varchar(45) DEFAULT NULL,
                             `last_name` varchar(45) DEFAULT NULL,
                             `email` varchar(45) DEFAULT NULL,
                             `year_of_studies` int(11) DEFAULT NULL,
                             `current_average_grade` int(11) DEFAULT NULL,
                             `number_of_remaining_courses_for_graduation` int(11) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `student`
--

INSERT INTO `student` VALUES
                            (1,'Paul','Papa','papa@luv2code.com','6','5.81','4'),
                            (2,'Presi','Marinopoulos','marinopoulos@luv2code.com','5','7.61','2'),
                            (3,'Elsi','Ni','Ni@luv2code.com','7','9.81','1'),
                            (4,'Lola','Lola','lola@luv2code.com','6','6.04','6'),
                            (5,'Vega','Juan','vega@luv2code.com','9','5.05','9');

