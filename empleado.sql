-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema empleado
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema empleado
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empleado` DEFAULT CHARACTER SET utf8 ;
USE `empleado` ;

-- -----------------------------------------------------
-- Table `empleado`.`cocinero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empleado`.`cocinero` (
  `idCocinero` INT NOT NULL,
  `especialidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCocinero`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `empleado`.`cajero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empleado`.`cajero` (
  `idCajero` INT NOT NULL,
  `turno` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCajero`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empleado`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empleado`.`empleado` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `dni` long not NULL,
  `fechaDeNacimiento` DATETIME NOT NULL,
  `ingreso` DATETIME NOT NULL,
  `cocinero_idCocinero` INT NOT NULL,
  `cajero_idCajero` INT NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  INDEX `fk_empleado_cocinero_idx` (`cocinero_idCocinero` ASC) VISIBLE,
  INDEX `fk_empleado_cajero1_idx` (`cajero_idCajero` ASC) VISIBLE,
  CONSTRAINT `fk_empleado_cocinero`
    FOREIGN KEY (`cocinero_idCocinero`)
    REFERENCES `empleado`.`cocinero` (`idCocinero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleado_cajero1`
    FOREIGN KEY (`cajero_idCajero`)
    REFERENCES `empleado`.`cajero` (`idCajero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
