
CREATE TABLE `burgershop_demo`.`Orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `customerId` VARCHAR(45) NULL,
  `items` VARCHAR(200) NULL,
  `price` INT NULL,
  PRIMARY KEY (`id`));