CREATE TABLE AwardToTeamMembers 
(
	`award_id` INT,
	`team_member_name` VARCHAR(50),
    FOREIGN KEY award_members_to_award(`award_id`)
    REFERENCES `Awards`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);