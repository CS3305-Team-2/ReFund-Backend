CREATE TABLE User
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`type` VARCHAR(50) NOT NULL,
	`first_name` VARCHAR(50) NOT NULL,
	`email` VARCHAR(50) NOT NULL,
	`pass` VARCHAR(60) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`job_title` VARCHAR(50) NOT NULL,
	`title` VARCHAR(50) NOT NULL,
	`suffix` VARCHAR(50),
	`phone_number` VARCHAR(50),
	`phone_country_code` VARCHAR(50),
    `orcid` VARCHAR(19),
	`host_institution_id` INT NOT NULL,
    FOREIGN KEY `user_to_type`(`type`)
    REFERENCES `UserType`(`type`)
    ON UPDATE CASCADE
);
