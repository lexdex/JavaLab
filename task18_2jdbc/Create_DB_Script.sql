-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema jdbc_library_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema jdbc_library_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jdbc_library_db` DEFAULT CHARACTER SET utf8 ;
USE `jdbc_library_db` ;

-- -----------------------------------------------------
-- Table `jdbc_library_db`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jdbc_library_db`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jdbc_library_db`.`library`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jdbc_library_db`.`library` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `books` INT NOT NULL,
  `magazines` INT NOT NULL,
  `popularity` DOUBLE NOT NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`, `city_id`),
  INDEX `fk_library_city1_idx` (`city_id` ASC) VISIBLE,
  CONSTRAINT `fk_library_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `jdbc_library_db`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jdbc_library_db`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jdbc_library_db`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name_author` VARCHAR(45) NOT NULL,
  `published` YEAR(4) NOT NULL,
  `imdb_id` INT NOT NULL,
  PRIMARY KEY (`id`, `imdb_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jdbc_library_db`.`library_has_book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jdbc_library_db`.`library_has_book` (
  `library_id` INT NOT NULL,
  `book_id` INT NOT NULL,
  PRIMARY KEY (`library_id`, `book_id`),
  INDEX `fk_library_has_book_book1_idx` (`book_id` ASC) VISIBLE,
  INDEX `fk_library_has_book_library_idx` (`library_id` ASC) VISIBLE,
  CONSTRAINT `fk_library_has_book_library`
    FOREIGN KEY (`library_id`)
    REFERENCES `jdbc_library_db`.`library` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_library_has_book_book1`
    FOREIGN KEY (`book_id`)
    REFERENCES `jdbc_library_db`.`book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


#---city-------------------------------------------------------------------------------------
insert into city values (1, 'Lviv');
insert into city values (2, 'Kyiv');
insert into city values (3, 'Ternopil');
insert into city values (4, 'Lutsk');
insert into city values (5, 'Vinnytsa');

#---book-------------------------------------------------------------------------------------
insert into book values (1, '1984 - George Orwell', 1990, 1);
insert into book values (2, 'Pride and Prejudice - Jane Austen', 1967, 2);
insert into book values (3, 'To Kill a Mockingbird - Harper Lee', 1982, 3);
insert into book values (4, 'The Da Vinci Code - Dan Brown', 1991, 4);
insert into book values (5, 'The Catcher in the Rye - J.D.Salinger', 1959, 5);
insert into book values (6, 'The Great Gatsby - F.Scott Fitzgerald', 1990, 6);
insert into book values (7, 'Twilight - Stephenie Meyer', 1995, 7);
insert into book values (8, 'The Hunger Games - Suzanne Collins', 1917, 8);
insert into book values (9, 'Jane Eyre - Charlotte Bronte', 1920, 9);
insert into book values (10, 'The Kite Runner - Khaled Hosseini', 1980, 10);  

#---library-------------------------------------------------------------------------------------
insert into library values (1, 'Franko Library', 30, 50, 18.1, 1);
insert into library values (2, 'Shevchenko Library', 35, 40, 50.0, 2);
insert into library values (3, 'Ternopil Library', 45, 12, 28.5, 3);
insert into library values (4, 'Lutsk Library', 34, 1, 55.7, 4);
insert into library values (5, 'Vinnytsa Library', 25, 14, 18.9, 5);
insert into library values (6, 'Polytechnika Library', 11, 64, 6.0, 1);

#---library-------------------------------------------------------------------------------------
insert into library_has_book values (3, 1);
insert into library_has_book values (2, 2);
insert into library_has_book values (1, 3);
insert into library_has_book values (4, 4);
insert into library_has_book values (5, 5);
insert into library_has_book values (6, 6);
insert into library_has_book values (1, 7);
insert into library_has_book values (2, 8);
insert into library_has_book values (1, 4);
insert into library_has_book values (4, 8);
