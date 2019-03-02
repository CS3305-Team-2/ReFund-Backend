CREATE TABLE `SfiFundingRatio`
(
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `year` INT NOT NULL,
    `annual_time_percent` VARCHAR(14) NOT NULL,
    FOREIGN KEY sfi_funding_ratio_to_user(`user_id`)
    REFERENCES `User`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);


insert into SfiFundingRatio values (NULL,1,2019,"PERCENT_21_40");
