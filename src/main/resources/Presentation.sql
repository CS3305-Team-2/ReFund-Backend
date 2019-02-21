CREATE TABLE `Presentations`
(
    `id` INT AUTO_INCREMENT,
    `year` INT NOT NULL,
    `title` VARCHAR(60) NOT NULL,
    `organising_body` VARCHAR(60) NOT NULL,
    `location` VARCHAR(60) NOT NULL,
    `primary_attribution` INT NOT NULL,
    `event_type` VARCHAR(30) NOT NULL,
    `user_id` INT NOT NULL,
    PRIMARY KEY (`id`, `user_id`),
    FOREIGN KEY `funding_to_grant`(`primary_attribution`)
    REFERENCES `Grant`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY `presentation_to_user`(`user_id`)
    REFERENCES `User`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);