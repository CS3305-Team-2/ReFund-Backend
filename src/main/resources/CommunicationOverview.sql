CREATE TABLE `CommunicationOverview`
(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `year` INT NOT NULL,
    `number_of_public_lectures` INT NOT NULL,
    `number_of_visits` INT NOT NULL,
    `number_of_media_interactions` INT NOT NULL,
    FOREIGN KEY communcation_overview_to_user(`user_id`)
    REFERENCES `User`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);


insert into CommunicationOverview values (NULL,1,2019,1,1,1);
