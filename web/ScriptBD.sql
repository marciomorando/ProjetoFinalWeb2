SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`atendente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`atendente` (
  `id_atendente` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id_atendente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tipochamado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tipochamado` (
  `id_tipochamado` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`id_tipochamado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`classificacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`classificacao` (
  `id_classificacao` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`id_classificacao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`departamento` (
  `id_departamento` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`id_departamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `departamento_id_departamento` INT NOT NULL,
  PRIMARY KEY (`id_usuario`),
  INDEX `fk_usuario_departamento1_idx` (`departamento_id_departamento` ASC),
  CONSTRAINT `fk_usuario_departamento1`
    FOREIGN KEY (`departamento_id_departamento`)
    REFERENCES `mydb`.`departamento` (`id_departamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`chamados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`chamados` (
  `id_chamados` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NULL,
  `descricao` VARCHAR(45) NULL,
  `tipochamado_id_tipochamado` INT NOT NULL,
  `classificacao_id_classificacao` INT NOT NULL,
  `atendente_id_atendente` INT NOT NULL,
  `usuario_id_usuario` INT NOT NULL,
  PRIMARY KEY (`id_chamados`),
  INDEX `fk_chamados_tipochamado1_idx` (`tipochamado_id_tipochamado` ASC),
  INDEX `fk_chamados_classificacao1_idx` (`classificacao_id_classificacao` ASC),
  INDEX `fk_chamados_atendente1_idx` (`atendente_id_atendente` ASC),
  INDEX `fk_chamados_usuario1_idx` (`usuario_id_usuario` ASC),
  CONSTRAINT `fk_chamados_tipochamado1`
    FOREIGN KEY (`tipochamado_id_tipochamado`)
    REFERENCES `mydb`.`tipochamado` (`id_tipochamado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_chamados_classificacao1`
    FOREIGN KEY (`classificacao_id_classificacao`)
    REFERENCES `mydb`.`classificacao` (`id_classificacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_chamados_atendente1`
    FOREIGN KEY (`atendente_id_atendente`)
    REFERENCES `mydb`.`atendente` (`id_atendente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_chamados_usuario1`
    FOREIGN KEY (`usuario_id_usuario`)
    REFERENCES `mydb`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

