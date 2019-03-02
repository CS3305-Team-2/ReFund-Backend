CREATE TABLE `AnnualReport`
(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `year` INT NOT NULL,
    `plan_deviation` TEXT NOT NULL,
    `three_highlights` TEXT NOT NULL,
    `challenges` TEXT NOT NULL,
    `planned_activities` TEXT NOT NULL,
    FOREIGN KEY report_to_user(`user_id`)
    REFERENCES `User`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);
