CREATE TABLE `Event`
(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `start_date` DATE NOT NULL,
    `end_date` DATE,
    `title` VARCHAR(60) NOT NULL,
    `event_type` VARCHAR(60) NOT NULL,
    `role` VARCHAR(60) NOT NULL,
    `event_location` VARCHAR(60) NOT NULL,
    `primary_attribution` INT NOT NULL,
    FOREIGN KEY event_to_user(`user_id`)
    REFERENCES `User`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY event_to_grants(`primary_attribution`)
    REFERENCES `Grants`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);


insert into Event values (NULL,1,"2019-02-01",NULL,"Title","CONFERENCE","role","china",1);
