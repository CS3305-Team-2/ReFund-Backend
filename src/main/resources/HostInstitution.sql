CREATE TABLE `HostInstitution`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(60) NOT NULL,
    `address_1` VARCHAR(60) NOT NULL,
    `address_2` VARCHAR(60),
    `post_code` VARCHAR(20),
    `email` VARCHAR(60) NOT NULL,
    `telephone` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`id`)
);
