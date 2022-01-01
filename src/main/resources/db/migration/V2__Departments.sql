CREATE TABLE IF NOT EXISTS `departments` (
    `id` INT AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL UNIQUE,
    CONSTRAINT `department_pk` PRIMARY KEY(`id`)
);