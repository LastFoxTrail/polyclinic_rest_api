CREATE TABLE IF NOT EXISTS `coupons` (
    `id` INT AUTO_INCREMENT,
    `patient_id` INT,
    `doctor_id` INT,
    `date_of_receipt` DATE NOT NULL,
    `time_of_receipt` TIME NOT NULL,
    `parlor` INT NOT NULL,
    `address` VARCHAR(255) NOT NULL,
    `price` DECIMAL NOT NULL,
    `diagnostic_id` INT,
    `department_id` INT,
    CONSTRAINT `coupon_pk` PRIMARY KEY(`id`),
    CONSTRAINT `patient_id_fk` FOREIGN KEY (`patient_id`) REFERENCES `patients`(`id`) ON DELETE CASCADE,
    CONSTRAINT `doctor_id_fk` FOREIGN KEY (`doctor_id`) REFERENCES `doctors`(`id`) ON DELETE CASCADE,
    CONSTRAINT `diagnostic_type_fk` FOREIGN KEY (`diagnostic_id`) REFERENCES `types_of_diagnostics`(`id`) ON DELETE CASCADE,
    CONSTRAINT `department_fk` FOREIGN KEY (`department_id`) REFERENCES `departments`(`id`) ON DELETE CASCADE
);