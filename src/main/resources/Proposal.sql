CREATE TABLE `Proposal` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`status` VARCHAR(30) NOT NULL,
	`primary_attribution` INT,
	`project_id` INT,
    `title` TEXT,
    `duration` INT ,
    `nrp_area` TEXT ,
    `legal_remit_alignment` TEXT ,
    `ethical_issues` TEXT ,
    `applicant_location_statement` TEXT ,
    `co_applicants_list` TEXT ,
    `collaborators_list` TEXT ,
    `scientific_abstract` TEXT ,
    `lay_abstract` TEXT ,
    `file_location` VARCHAR(60)  UNIQUE,
    `declaration` BOOLEAN ,
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

insert into `Proposal` values (
    NULL,
    "DRAFT",
    1,
    1,
    "TITLE",
    20,
    "PRIORITY_AREA_A",
    "kegak",
    "ethi",
    "aoo",
    "coapp",
    "coll",
    "sci",
    "lay",
    "hi.pdf",
    TRUE
);

CREATE TABLE `Proposal` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`status` VARCHAR(30) NOT NULL,
	`primary_attribution` INT ,
	`project_id` INT ,
    `title` TEXT , -- 30 words
    `duration` INT , -- months
    `nrp_area` TEXT , --enum needed
    `legal_remit_alignment` TEXT , -- 250 words
    `ethical_issues` TEXT , -- not sure
    `application_location_statement` TEXT , --not sure
    `co_applications_list` TEXT , -- parse this
    `collaborators_list` TEXT , --name, orgainsation, email
    `scientific_abstract` TEXT , -- 200 max
    `lay_abstract` TEXT , -- 100 max
    `file_location` VARCHAR(60)  UNIQUE,
    `declaration` BOOLEAN ,
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
