CREATE TABLE Education 
(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`degree` VARCHAR(50) NOT NULL,
	`field` VARCHAR(50) NOT NULL,
	`institution` VARCHAR(50) NOT NULL,
	`location` VARCHAR(50) NOT NULL,
	`year` INT NOT NULL,
	`user_id` INT NOT NULL,
    FOREIGN KEY education_to_user(`user_id`)
    REFERENCES `User`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);