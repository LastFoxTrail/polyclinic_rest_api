CREATE TABLE IF NOT EXISTS `patients` (
    `id` INT AUTO_INCREMENT,
    `first_name` VARCHAR(32) NOT NULL,
    `middle_name` VARCHAR(32) NOT NULL,
    `last_name` VARCHAR(32) NOT NULL,
    `date_of_birth` DATE NOT NULL,
    `phone_number` VARCHAR(32) NOT NULL UNIQUE,
    `address` VARCHAR(255) NOT NULL,
    `policy` VARCHAR(13) NOT NULL UNIQUE,
    CONSTRAINT `patient_pk` PRIMARY KEY(`id`)
);