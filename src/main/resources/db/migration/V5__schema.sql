ALTER TABLE `Presentations`
ADD `user_id` INT NOT NULL;

ALTER TABLE `Presentations`
MODIFY `id` INT,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`, `user_id`);

ALTER TABLE `Presentations`
ADD FOREIGN KEY `presentation_to_user`(`user_id`)
REFERENCES `User`(`id`)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE `Impact`
MODIFY `id` INT,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`, `primary_beneficiary`);
