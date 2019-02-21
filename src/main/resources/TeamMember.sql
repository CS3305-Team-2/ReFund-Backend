CREATE TABLE `TeamMember`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `start_date` datetime NOT NULL,
    `end_date` datetime,
    `role` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`id`, `user_id`),
    FOREIGN KEY member_to_user(`user_id`)
    REFERENCES `User`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)