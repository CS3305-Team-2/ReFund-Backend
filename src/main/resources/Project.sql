CREATE TABLE `Project` 
(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `pi` INT NOT NULL,
    `is_research_center` BOOLEAN NOT NULL,
    `proposal_id` INT NOT NULL,
    `budget` INT NOT NULL,
    `grant_number` VARCHAR(15),
    `name` VARCHAR(50) NOT NULL,
    `status` VARCHAR(50),
    FOREIGN KEY pi_to_team_member(`pi`)
    REFERENCES `TeamMember`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);