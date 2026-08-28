

-- =====================================================
-- CONFIGURACIÓN
-- =====================================================

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- =====================================================
-- CREAR BASE DE DATOS
-- =====================================================

CREATE SCHEMA IF NOT EXISTS `empleado` DEFAULT CHARACTER SET utf8;

USE `empleado`;

-- =====================================================
-- ELIMINAR TABLAS ANTERIORES
-- =====================================================

DROP TABLE IF EXISTS `cajero`;
DROP TABLE IF EXISTS `cocinero`;
DROP TABLE IF EXISTS `empleado`;

-- =====================================================
-- TABLA EMPLEADO
-- =====================================================

CREATE TABLE `empleado` (
    `idEmpleado` INT NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(45) NOT NULL,
    `apellido` VARCHAR(45) NOT NULL,
    `dni` BIGINT NOT NULL,
    `fechaNacimiento` DATE NOT NULL,
    `ingreso` DATE NOT NULL,

    PRIMARY KEY (`idEmpleado`)
) ENGINE = InnoDB;

-- =====================================================
-- TABLA COCINERO
-- =====================================================

CREATE TABLE `cocinero` (
    `idEmpleado` INT NOT NULL,
    `especialidad` VARCHAR(45) NOT NULL,

    PRIMARY KEY (`idEmpleado`),

    CONSTRAINT `fk_cocinero_empleado`
        FOREIGN KEY (`idEmpleado`)
        REFERENCES `empleado` (`idEmpleado`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
) ENGINE = InnoDB;

-- =====================================================
-- TABLA CAJERO
-- =====================================================

CREATE TABLE `cajero` (
    `idEmpleado` INT NOT NULL,
    `turno` VARCHAR(45) NOT NULL,

    PRIMARY KEY (`idEmpleado`),

    CONSTRAINT `fk_cajero_empleado`
        FOREIGN KEY (`idEmpleado`)
        REFERENCES `empleado` (`idEmpleado`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
) ENGINE = InnoDB;

-- =====================================================
-- RESTAURAR CONFIGURACIÓN
-- =====================================================

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- =====================================================
-- VER LAS TABLAS
-- =====================================================

SHOW TABLES;

-- =====================================================
-- VER LOS DATOS
-- =====================================================

SELECT * FROM empleado;