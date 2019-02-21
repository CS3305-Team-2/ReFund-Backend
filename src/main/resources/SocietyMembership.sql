CREATE TABLE SocietyMembership 
(
	`id` INT AUTO_INCREMENT,
	`start_date` datetime NOT NULL,
	`end_date` datetime NOT NULL,
	`name` VARCHAR(50) NOT NULL,
	`type` VARCHAR(50) NOT NULL,
	`status` VARCHAR(50) NOT NULL,
	`user_id` INT,
    PRIMARY KEY (`id`, `user_id`),
    FOREIGN KEY society_membership_to_user(`user_id`)
    REFERENCES `User`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE    
);
