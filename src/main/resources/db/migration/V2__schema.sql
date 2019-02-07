CREATE TABLE `Funding` 
(
	`id` INT AUTO_INCREMENT,
	`start_date` datetime NOT NULL,
	`end_date` datetime NOT NULL,
	`amount` INT NOT NULL,
	`funding_body` VARCHAR(50) NOT NULL,
	`funding_programme` VARCHAR(50) NOT NULL,
	`status` VARCHAR(50) NOT NULL,
	`primary_attribution` INT NOT NULL,
    `user_id` INT,
    PRIMARY KEY (`id`, `user_id`),
    FOREIGN KEY funding_to_user(`user_id`)
    REFERENCES `User`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE `TeamMembers` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL,
    `start_date` datetime NOT NULL,
    `end_date` datetime NOT NULL,
    `position_in_team` VARCHAR(60) NOT NULL,
    `primary_attribution` INT NOT NULL,
	PRIMARY KEY (`id`),
    FOREIGN KEY team_member_to_grant(`primary_attribution`)
    REFERENCES `Funding`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE `Teams` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `TeamToMembers` (
	`team_id` INT NOT NULL,
	`member_id` INT NOT NULL,
	PRIMARY KEY (`team_id`,`member_id`),
    FOREIGN KEY team_member_to_team_member(`member_id`)
    REFERENCES `TeamMembers`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY team_to_team(`team_id`)
    REFERENCES `Teams`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);