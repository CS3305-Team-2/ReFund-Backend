CREATE TABLE UserType 
(
	`type` VARCHAR(50) PRIMARY KEY 
);

CREATE TABLE User 
(
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`type` VARCHAR(50) NOT NULL,
	`first_name` VARCHAR(50) NOT NULL,
	`email` VARCHAR(50) NOT NULL,
	`pass` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`job_title` VARCHAR(50) NOT NULL,
	`title` VARCHAR(50) NOT NULL,
	`suffix` VARCHAR(50),
	`phone_number` VARCHAR(50),
	`phone_country_code` VARCHAR(50),
	`orcid` VARCHAR(50) NOT NULL,
    FOREIGN KEY `user_to_type`(`type`)
    REFERENCES `UserType`(`type`)
    ON UPDATE CASCADE
);

CREATE TABLE Education 
(
	`id` INT AUTO_INCREMENT,
	`degree` VARCHAR(50) NOT NULL,
	`field` VARCHAR(50) NOT NULL,
	`institution` VARCHAR(50) NOT NULL,
	`location` VARCHAR(50) NOT NULL,
	`year` INT NOT NULL,
	`user_id` INT NOT NULL,
    PRIMARY KEY (`id`, `user_id`),
    FOREIGN KEY education_to_user(`user_id`)
    REFERENCES `User`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

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

CREATE TABLE AwardToTeamMembers 
(
	`award_id` INT,
	`team_member_name` VARCHAR(50),
    FOREIGN KEY award_members_to_award(`award_id`)
    REFERENCES `Awards`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE Grants
(
	`id` INT AUTO_INCREMENT PRIMARY KEY
);

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
    PRIMARY KEY (id, `user_id`),
    FOREIGN KEY funding_to_user(`user_id`)
    REFERENCES `User`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY funding_to_grant(`primary_attribution`)
    REFERENCES `Grants`(`id`)
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
    REFERENCES `Grants`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
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

CREATE TABLE `Teams` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL,
	PRIMARY KEY (`id`)
);
