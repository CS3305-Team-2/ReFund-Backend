CREATE TABLE `ProjectReport`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `project_id` INT NOT NULL,
    `file_url` TINYTEXT NOT NULL,
    PRIMARY KEY (`id`, `project_id`),
    FOREIGN KEY report_to_project(`project_id`)
    REFERENCES `Project`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE   
);