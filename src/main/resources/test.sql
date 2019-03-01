 CREATE TABLE `TeamMember` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime DEFAULT NULL,
  `role` varchar(20) NOT NULL,
  `project_id` int(11) NOT NULL,
  /* PRIMARY KEY (`id`,`user_id`), */
  KEY `member_to_user` (`user_id`),
  KEY `member_to_project` (`project_id`),
  CONSTRAINT `member_to_project` FOREIGN KEY (`project_id`) REFERENCES `Project` (`id`),
  CONSTRAINT `member_to_user` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);