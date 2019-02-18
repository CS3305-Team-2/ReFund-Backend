CREATE TABLE `Innovation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `title` VARCHAR(60) NOT NULL,
  `type` VARCHAR(30) NOT NULL,
  `year` INT NOT NULL,
  `primary_attribution` INT NOT NULL,
  PRIMARY KEY (`id`,`user_id`),
  FOREIGN KEY `innovation_and_commercialisation_to_grants`(`primary_attribution`)
  REFERENCES `Grant`(`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  FOREIGN KEY `innovation_and_commercialisation_to_user`(`user_id`)
  REFERENCES `User`(`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);
