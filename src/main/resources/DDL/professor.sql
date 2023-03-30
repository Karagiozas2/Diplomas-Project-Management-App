CREATE DATABASE  IF NOT EXISTS `professor_directory`;
USE `professor_directory`;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;

CREATE TABLE `professor` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `first_name` varchar(45) DEFAULT NULL,
                             `last_name` varchar(45) DEFAULT NULL,
                             `email` varchar(45) DEFAULT NULL,
                             `specialty` varchar(45) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `professor`
--

INSERT INTO `professor` VALUES
                            (1,'Leslie','Andrews','leslie@luv2code.com','software engineer'),
                            (2,'Emma','Baumgarten','emma@luv2code.com','software engineer'),
                            (3,'Avani','Gupta','avani@luv2code.com','hardware'),
                            (4,'Yuri','Petrov','yuri@luv2code.com','mathematician'),
                            (5,'Juan','Vega','juan@luv2code.com','software engineer');

