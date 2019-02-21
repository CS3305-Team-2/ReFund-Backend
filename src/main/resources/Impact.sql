CREATE TABLE `Impact`
(
    `id` INT AUTO_INCREMENT NOT NULL,
    `title` VARCHAR(50) NOT NULL,
    `category` VARCHAR(60) NOT NULL,
    `primary_beneficiary` INT NOT NULL,
    `primary_attribution` INT NOT NULL,
    PRIMARY KEY (`id`,`primary_beneficiary`),
    PRIMARY KEY (`id`, `primary_beneficiary`),
    FOREIGN KEY `impacts_to_user`(`primary_beneficiary`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    FOREIGN KEY `impacts_to_grants`(`primary_attribution`)
    REFERENCES `Grant`(`id`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);