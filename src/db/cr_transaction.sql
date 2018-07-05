CREATE TABLE `quantum`.`transaction` (
  `tranId` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `secId` INT UNSIGNED NOT NULL,
  `userId` INT UNSIGNED NOT NULL,
  `tranDate` DATE NOT NULL,
  `type` VARCHAR(3) NOT NULL,
  `shares` DOUBLE NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`tranId`),
  UNIQUE INDEX `tranId_UNIQUE` (`tranId` ASC));

