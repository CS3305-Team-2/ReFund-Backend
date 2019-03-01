CREATE TABLE `Grants` 
(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`start_date` date NOT NULL,
	`end_date` date NOT NULL,
	`amount` INT NOT NULL,
	`funding_body` VARCHAR(50) NOT NULL,
	`funding_programme` VARCHAR(50) NOT NULL,
	`status` VARCHAR(20) NOT NULL,
    `url` TINYTEXT NOT NULL
);