CREATE TABLE `Proposal` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`status` VARCHAR(30) NOT NULL,
	`primary_attribution` INT NOT NULL,
	`project_id` INT NOT NULL,
    `title` TEXT,
    `duration` INT ,
    `nrp_area` TEXT ,
    `legal_remit_alignment` TEXT ,
    `ethical_issues` TEXT ,
    `applicant_location_statement` TEXT ,
    `scientific_abstract` TEXT ,
    `lay_abstract` TEXT ,
    `file_location` VARCHAR(60)  UNIQUE,
    `declaration` BOOLEAN ,
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
    1,
    "DRAFT",
    1,
    1,
    "Orion proposal",
    20,
    "PRIORITY_AREA_A",
    "The research effort adheres to the SFI's legal remit. After thorough reading of the legal remit documentation provided, we can say we plan to adhere to every single point mentioned in the document.",
    "No animals will be harmed in our research effort, and involves no human participation without their consent.",
    "Currently in Ireland, good country. 10/10.",
    "Curabitur et quam semper, commodo nibh sit amet, auctor velit. Sed eget vulputate metus. Curabitur pharetra pharetra nisl, ac gravida risus posuere et. Phasellus tincidunt velit et fringilla maximus. Proin magna augue, sagittis in massa vel, pulvinar semper erat. Mauris in vulputate arcu, vel consequat sem. Cras feugiat at nibh a commodo. Vestibulum sed sollicitudin metus. Praesent placerat hendrerit dui quis congue. Nulla tristique fermentum porttitor. Nunc vehicula tincidunt semper. Nunc sollicitudin libero et orci fermentum, a tempus.",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec convallis, nisl at vulputate rhoncus, tellus ante commodo ligula, ac imperdiet est lectus a tellus. Nullam vehicula dolor maximus accumsan congue. Suspendisse viverra interdum nibh eget porta. Ut iaculis purus ac risus porttitor, nec consequat tellus rutrum. Sed molestie molestie congue. Vestibulum at faucibus sapien. Proin semper mauris facilisis congue facilisis. Fusce neque sapien, sollicitudin quis tristique sed, pharetra et eros. Donec ornare augue eu lectus rhoncus lacinia ut in metus. Morbi cursus magna ut ultricies tristique. Curabitur eget tempor arcu. Donec hendrerit vestibulum nisl sed malesuada. Nam sagittis leo vel risus viverra condimentum. Duis pulvinar justo velit, sed ullamcorper ligula vulputate ut. Phasellus leo ante, lacinia ac efficitur nec, vestibulum faucibus arcu.",
    "proposal_1.pdf",
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
