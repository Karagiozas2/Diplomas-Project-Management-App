CREATE DATABASE  IF NOT EXISTS `thesis_directory`;
USE `thesis_directory`;

--
-- Table structure for table `thesis`
--

DROP TABLE IF EXISTS `thesis`;

CREATE TABLE `thesis` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `title` varchar(500) DEFAULT NULL,
                          `objectives` varchar(45) DEFAULT NULL,
                          `professor_id` int(11) NOT NULL,
                          PRIMARY KEY (`id`),
                          CONSTRAINT `fk_thesis_professor_id`
                              FOREIGN KEY (`professor_id`)
                                  REFERENCES `professor_directory`.professor (`id`)
                                  ON DELETE CASCADE
                                  ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `thesis`
--

INSERT INTO `thesis` VALUES
                         (1,'logismiko','obj1','1'),
                         (2,'robot','obj2','2'),
                         (3,'apps','obj3','3');

