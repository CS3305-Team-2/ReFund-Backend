CREATE TABLE `MemberToProject` 
(
    `project_id` INT NOT NULL,
    `member_id` INT NOT NULL,
    FOREIGN KEY to_team_member(`member_id`)
    REFERENCES `TeamMember`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY to_project(`project_id`)
    REFERENCES `Project`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)