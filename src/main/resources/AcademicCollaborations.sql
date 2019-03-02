CREATE TABLE `AcademicCollaborations`
(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `start_date` DATE NOT NULL,
    `end_date` DATE,
    `institution_name` VARCHAR(60) NOT NULL,
    `institution_department` VARCHAR(60) NOT NULL,
    `location` VARCHAR(60) NOT NULL,
    `name_of_collaborator` VARCHAR(60) NOT NULL,
    `goal_of_collaboration` VARCHAR(60) NOT NULL,
    `interaction_frequency` VARCHAR(60) NOT NULL,
    `primary_attribution` INT NOT NULL,
    FOREIGN KEY academic_collaboration_to_user(`user_id`)
    REFERENCES `User`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY academic_collaboration_to_grants(`primary_attribution`)
    REFERENCES `Grants`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);


insert into AcademicCollaborations values (NULL,1,"2019-02-01",NULL,"UCC","Comp Sci","Cork","Dude","ACCESS_TO_SOFTWARE_DATA_MATERIAL_EQUIPMENT","too much",1);
