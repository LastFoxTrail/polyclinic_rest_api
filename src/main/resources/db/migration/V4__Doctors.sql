CREATE TABLE IF NOT EXISTS `doctors` (
    `id` INT AUTO_INCREMENT,
    `first_name` VARCHAR(32) NOT NULL,
    `middle_name` VARCHAR(32) NOT NULL,
    `last_name` VARCHAR(32) NOT NULL,
    `phone_number` VARCHAR(32) NOT NULL UNIQUE,
    `department_id` INT,
    `position_id` INT,
    `category` VARCHAR(255),
    `work_experience` INT NOT NULL,
    CONSTRAINT `doctor_pk` PRIMARY KEY(`id`),
    CONSTRAINT `doctor_department_fk` FOREIGN KEY (`department_id`) REFERENCES `departments`(`id`) ON DELETE SET NULL,
    CONSTRAINT `doctor_position_fk` FOREIGN KEY (`position_id`) REFERENCES `positions`(`id`) ON DELETE SET NULL
);