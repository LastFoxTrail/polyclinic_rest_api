CREATE TABLE IF NOT EXISTS `education_of_doctors` (
    `doctor_id` INT,
    `education_id` INT,
    CONSTRAINT `doctor_education_pk` PRIMARY KEY (`doctor_id`, `education_id`),
    CONSTRAINT `doctor_fk` FOREIGN KEY (`doctor_id`) REFERENCES `doctors`(`id`) ON DELETE CASCADE,
    CONSTRAINT `education_fk` FOREIGN KEY (`education_id`) REFERENCES `educations`(`id`) ON DELETE CASCADE
);