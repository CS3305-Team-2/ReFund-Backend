CREATE TABLE `Publication`
(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `type` VARCHAR(60) NOT NULL,
    `title` VARCHAR(60) NOT NULL,
    `journal_name` VARCHAR(60) NOT NULL,
    `status` VARCHAR(60) NOT NULL,
    `doi` VARCHAR(60) NOT NULL,
    `primary_attribution` INT NOT NULL,
    FOREIGN KEY publications_to_user(`user_id`)
    REFERENCES `User`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY publications_to_grants(`primary_attribution`)
    REFERENCES `Grants`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);
