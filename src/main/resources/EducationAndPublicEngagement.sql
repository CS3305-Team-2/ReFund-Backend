CREATE TABLE `EducationAndPublicEngagement`
(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `project_name` VARCHAR(60) NOT NULL,
    `start_date` DATE NOT NULL,
    `end_date` DATE,
    `activity_type` VARCHAR(27) NOT NULL,
    `activity_type_other` VARCHAR(60),
    `project_topic` VARCHAR(13) NOT NULL,
    `target_geographical_area` VARCHAR(13) NOT NULL,
    `primary_attribution` INT NOT NULL,
    FOREIGN KEY education_and_public_engagement_to_user(`user_id`)
    REFERENCES `User`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);


insert into EducationAndPublicEngagement values (NULL,1,"jhfkashjhahb","2019-02-01",null,"PUBLIC_EVENT",NULL,"SCIENCE","NATIONAL",1);
insert into EducationAndPublicEngagement values (NULL,1,"jhfkashjhahb","2019-02-01",null,"OTHER","Idk how to say it","SCIENCE","NATIONAL",1);
