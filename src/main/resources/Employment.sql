CREATE TABLE Employment 
(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`institution` VARCHAR(50) NOT NULL,
	`location` VARCHAR(50) NOT NULL,
	`years` INT NOT NULL,
	`user_id` INT,
    FOREIGN KEY employment_to_user(`user_id`)
    REFERENCES `User`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);