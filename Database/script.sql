-- MySQL Script generated by MySQL Workbench
-- 06/06/14 20:03:46
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema PhotoSharing
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `PhotoSharing` ;
CREATE SCHEMA IF NOT EXISTS `PhotoSharing` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `PhotoSharing` ;

-- -----------------------------------------------------
-- Table `PhotoSharing`.`Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PhotoSharing`.`Usuario` ;

CREATE TABLE IF NOT EXISTS `PhotoSharing`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `Apellidos` VARCHAR(45) NULL,
  `Nickname` VARCHAR(30) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(30) NOT NULL,
  `ProfilePhoto` TEXT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `Nickname_UNIQUE` (`Nickname` ASC),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PhotoSharing`.`Foto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PhotoSharing`.`Foto` ;

CREATE TABLE IF NOT EXISTS `PhotoSharing`.`Foto` (
  `idFoto` INT NOT NULL AUTO_INCREMENT,
  `idUsuario` INT NOT NULL,
  `PhotoURL` TEXT NULL,
  `UploadDate` DATETIME NULL,
  `Descripcion` TEXT NULL,
  PRIMARY KEY (`idFoto`),
  INDEX `fk_Fotos_Usuario_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_Fotos_Usuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `PhotoSharing`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PhotoSharing`.`Tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PhotoSharing`.`Tag` ;

CREATE TABLE IF NOT EXISTS `PhotoSharing`.`Tag` (
  `idTag` INT NOT NULL AUTO_INCREMENT,
  `NombreTag` VARCHAR(45) NULL,
  PRIMARY KEY (`idTag`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PhotoSharing`.`Comentario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PhotoSharing`.`Comentario` ;

CREATE TABLE IF NOT EXISTS `PhotoSharing`.`Comentario` (
  `idComentario` INT NOT NULL AUTO_INCREMENT,
  `idUsuario` INT NOT NULL,
  `idFoto` INT NOT NULL,
  `Comentario` TEXT NULL,
  `ComentDate` DATETIME NULL,
  INDEX `fk_Fotos_has_Usuario_Usuario1_idx` (`idUsuario` ASC),
  INDEX `fk_Fotos_has_Usuario_Fotos1_idx` (`idFoto` ASC),
  PRIMARY KEY (`idComentario`),
  CONSTRAINT `fk_Fotos_has_Usuario_Fotos1`
    FOREIGN KEY (`idFoto`)
    REFERENCES `PhotoSharing`.`Foto` (`idFoto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fotos_has_Usuario_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `PhotoSharing`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PhotoSharing`.`Amigo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PhotoSharing`.`Amigo` ;

CREATE TABLE IF NOT EXISTS `PhotoSharing`.`Amigo` (
  `idUsuario1` INT NOT NULL,
  `idUsuario2` INT NOT NULL,
  PRIMARY KEY (`idUsuario1`, `idUsuario2`),
  INDEX `fk_Usuario_has_Usuario_Usuario2_idx` (`idUsuario2` ASC),
  INDEX `fk_Usuario_has_Usuario_Usuario1_idx` (`idUsuario1` ASC),
  CONSTRAINT `fk_Usuario_has_Usuario_Usuario1`
    FOREIGN KEY (`idUsuario1`)
    REFERENCES `PhotoSharing`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_Usuario_Usuario2`
    FOREIGN KEY (`idUsuario2`)
    REFERENCES `PhotoSharing`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PhotoSharing`.`Like`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PhotoSharing`.`Like` ;

CREATE TABLE IF NOT EXISTS `PhotoSharing`.`Like` (
  `idUsuario` INT NOT NULL,
  `idFoto` INT NOT NULL,
  `Liked` TINYINT(1) NULL,
  `LikedDate` DATETIME NULL,
  PRIMARY KEY (`idUsuario`, `idFoto`),
  INDEX `fk_Usuario_has_Fotos_Fotos1_idx` (`idFoto` ASC),
  INDEX `fk_Usuario_has_Fotos_Usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_Usuario_has_Fotos_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `PhotoSharing`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_Fotos_Fotos1`
    FOREIGN KEY (`idFoto`)
    REFERENCES `PhotoSharing`.`Foto` (`idFoto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PhotoSharing`.`Foto_Tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PhotoSharing`.`Foto_Tag` ;

CREATE TABLE IF NOT EXISTS `PhotoSharing`.`Foto_Tag` (
  `idFoto` INT NOT NULL,
  `idTag` INT NOT NULL,
  PRIMARY KEY (`idFoto`, `idTag`),
  INDEX `fk_Fotos_has_Tags_Tags1_idx` (`idTag` ASC),
  INDEX `fk_Fotos_has_Tags_Fotos1_idx` (`idFoto` ASC),
  CONSTRAINT `fk_Fotos_has_Tags_Fotos1`
    FOREIGN KEY (`idFoto`)
    REFERENCES `PhotoSharing`.`Foto` (`idFoto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fotos_has_Tags_Tags1`
    FOREIGN KEY (`idTag`)
    REFERENCES `PhotoSharing`.`Tag` (`idTag`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
