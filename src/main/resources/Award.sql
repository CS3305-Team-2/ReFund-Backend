CREATE TABLE Awards 
(
	`id` INT AUTO_INCREMENT,
	`year` INT NOT NULL,
	`awarding_body` VARCHAR(50) NOT NULL,
	`details` VARCHAR(50) NOT NULL,
	`user_id` INT,
    PRIMARY KEY (`id`, `user_id`),
    FOREIGN KEY award_to_user(`user_id`)
    REFERENCES `User`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE    
);