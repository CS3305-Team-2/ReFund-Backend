CREATE TABLE `Proposal` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`status` VARCHAR(30) NOT NULL,
	`file_location` VARCHAR(60) NOT NULL UNIQUE,
	`primary_attribution` INT NOT NULL,
	`project_id` INT NOT NULL,
	PRIMARY KEY (`id`),
    FOREIGN KEY `proposal_to_grants`(`primary_attribution`)
    REFERENCES `Grants`(`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY `proposal_to_project`(`project_id`)
    REFERENCES `Project`(`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
