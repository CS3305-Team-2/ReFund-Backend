CREATE TABLE `Project` 
(
    `id` INT PRIMARY KEY,
    `pi` INT NOT NULL,
    `ro_approved` BOOLEAN NOT NULL,
    `sfi_approved` BOOLEAN NOT NULL,
    `is_research_center` BOOLEAN NOT NULL,
    `primary_attribution` INT NOT NULL,
    `proposal_id` INT NOT NULL,
    `budget` INT NOT NULL,
    `grant_number` VARCHAR(15),
    `name` VARCHAR(50) NOT NULL,
    FOREIGN KEY pi_to_team_member(`pi`)
    REFERENCES `TeamMember`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY attribution_to_grant(`primary_attribution`)
    REFERENCES `Grants`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);