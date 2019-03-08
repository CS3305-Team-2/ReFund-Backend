CREATE TABLE `ProposalReviews` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `proposal_id` INT NOT NULL,
    `score` INT,
	`comments` TEXT,
    FOREIGN KEY `proposal_reviews_to_reviews`(`proposal_id`)
    REFERENCES `Proposal`(`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
