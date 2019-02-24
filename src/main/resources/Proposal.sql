CREATE TABLE `Proposal` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`status` VARCHAR(30) NOT NULL,
	`primary_attribution` INT NOT NULL,
	`project_id` INT NOT NULL,
    `title` TEXT NOT NULL,
    `duration` INT NOT NULL,
    `nrp_area` TEXT NOT NULL,
    `legal_remit_alignment` TEXT NOT NULL,
    `ethical_issues` TEXT NOT NULL,
    `applicant_location_statement` TEXT NOT NULL,
    `co_applicants_list` TEXT NOT NULL,
    `collaborators_list` TEXT NOT NULL,
    `scientific_abstract` TEXT NOT NULL,
    `lay_abstract` TEXT NOT NULL,
    `file_location` VARCHAR(60) NOT NULL UNIQUE,
    `declaration` BOOLEAN NOT NULL,
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
	`primary_attribution` INT NOT NULL,
	`project_id` INT NOT NULL,
    `title` TEXT NOT NULL, -- 30 words
    `duration` INT NOT NULL, -- months
    `nrp_area` TEXT NOT NULL, --enum needed
    `legal_remit_alignment` TEXT NOT NULL, -- 250 words
    `ethical_issues` TEXT NOT NULL, -- not sure
    `application_location_statement` TEXT NOT NULL, --not sure
    `co_applications_list` TEXT NOT NULL, -- parse this
    `collaborators_list` TEXT NOT NULL, --name, orgainsation, email
    `scientific_abstract` TEXT NOT NULL, -- 200 max
    `lay_abstract` TEXT NOT NULL, -- 100 max
    `file_location` VARCHAR(60) NOT NULL UNIQUE,
    `declaration` BOOLEAN NOT NULL,
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
