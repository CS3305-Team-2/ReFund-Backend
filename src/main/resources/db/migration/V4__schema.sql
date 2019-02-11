-- ALTER TABLE `Funding` RENAME TO `Grant`;

ALTER TABLE `TeamMembers` DROP FOREIGN KEY FK_team_member_to_grant;
ALTER TABLE `TeamMembers` ADD CONSTRAINT team_member_to_grant
                              FOREIGN KEY `primary_attribution`
                              REFERENCES `Grant`(`id`)
                              ON UPDATE CASCADE
                              ON DELETE CASCADE;



CREATE TABLE `Impact`
(
    `id` INT AUTO_INCREMENT NOT NULL,
    `title` VARCHAR(50) NOT NULL,
    `category` VARCHAR(60) NOT NULL,
    `primary_beneficiary` INT NOT NULL,
    `primary_attribution` INT NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY impacts_to_user(`primary_beneficiary`)
    REFERENCES `User`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY impacts_to_grants(`primary_attribution`)
    REFERENCES `Grant`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);


CREATE TABLE `EventTypes`
(
    `id` INT AUTO_INCREMENT,
    `name` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `Presentations`
(
    `id` INT AUTO_INCREMENT,
    `year` INT NOT NULL,
    `title` VARCHAR(60) NOT NULL,
    `organising_body` VARCHAR(60) NOT NULL,
    `location` VARCHAR(60) NOT NULL,
    `primary_attribution` INT NOT NULL,
    `event_type` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY funding_to_grant(`primary_attribution`)
    REFERENCES `Grant`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY presentation_to_event_type(`event_type`)
    REFERENCES `EventTypes`(`name`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);
