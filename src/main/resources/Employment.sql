CREATE TABLE Employment 
(
	`id` INT AUTO_INCREMENT,
	`institution` VARCHAR(50) NOT NULL,
	`location` VARCHAR(50) NOT NULL,
	`years` INT NOT NULL,
	`user_id` INT,
    PRIMARY KEY (`id`, `user_id`),
    FOREIGN KEY employment_to_user(`user_id`)
    REFERENCES `User`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);