CREATE TABLE `AnnualReport`
(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `project_id` INT NOT NULL,
    `year` INT NOT NULL,
    `plan_deviation` TEXT NOT NULL,
    `three_highlights` TEXT NOT NULL,
    `challenges` TEXT NOT NULL,
    `planned_activities` TEXT NOT NULL,
    FOREIGN KEY report_to_project(`project_id`)
    REFERENCES `Project`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

insert into AnnualReport values(NULL,1,2018,"No deviation", "No highlights","A lot of em", "none");
insert into AnnualReport values(NULL,1,2018,"No deviation", "No highlights","A lot of em", "none");
insert into AnnualReport values(NULL,1,2018,"No deviation", "No highlights","A lot of em", "none");
