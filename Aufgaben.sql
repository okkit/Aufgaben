-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema klassenbuch
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema klassenbuch
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `klassenbuch` DEFAULT CHARACTER SET utf8mb3 ;
USE `klassenbuch` ;

-- -----------------------------------------------------
-- Table `klassenbuch`.`Thema`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `klassenbuch`.`Thema` ;

CREATE TABLE IF NOT EXISTS `klassenbuch`.`Thema` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titel` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `klassenbuch`.`aufgabe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `klassenbuch`.`aufgabe` ;

CREATE TABLE IF NOT EXISTS `klassenbuch`.`aufgabe` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(450) NOT NULL,
  `Thema_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Thema_id`),
  INDEX `fk_aufgabe_Thema_idx` (`Thema_id` ASC) VISIBLE,
  CONSTRAINT `fk_aufgabe_Thema`
    FOREIGN KEY (`Thema_id`)
    REFERENCES `klassenbuch`.`Thema` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 39
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
