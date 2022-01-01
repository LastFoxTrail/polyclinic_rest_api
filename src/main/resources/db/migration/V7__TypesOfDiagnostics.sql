CREATE TABLE IF NOT EXISTS `types_of_diagnostics` (
    `id` INT AUTO_INCREMENT,
    `type_name` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255) NOT NULL,
    `price` DECIMAL NOT NULL,
    CONSTRAINT `type_of_diagnostics_pk` PRIMARY KEY(`id`)
);