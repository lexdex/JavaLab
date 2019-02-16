
CREATE SCHEMA IF NOT EXISTS book_store DEFAULT CHARACTER SET utf8 ;
USE book_store ;

CREATE TABLE IF NOT EXISTS book (
  book_id BIGINT NOT NULL AUTO_INCREMENT,
  book_name VARCHAR(45) NOT NULL,
  author VARCHAR(45) NOT NULL,
  publisher VARCHAR(50) NULL,
  imprint_year INT NULL,
  amount INT NOT NULL,
  PRIMARY KEY (book_id)
  ) ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS city (
  city_id BIGINT NOT NULL AUTO_INCREMENT,
  city VARCHAR(25) NOT NULL,
  PRIMARY KEY (city_id)
  ) ENGINE = InnoDB
AUTO_INCREMENT = 1 
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS customer (
  customer_id BIGINT NOT NULL AUTO_INCREMENT,
  surname VARCHAR(25) NULL,
  name VARCHAR(25) NOT NULL,
  email VARCHAR(45) NOT NULL,
  city_id BIGINT NULL,
  street VARCHAR(30) NULL,
  apartment VARCHAR(10) NULL,
  PRIMARY KEY (customer_id),
  CONSTRAINT fk_customer_city1
    FOREIGN KEY (city_id)
    REFERENCES book_store.city (city_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS customer_book (
  customer_id BIGINT NOT NULL,
  book_id BIGINT NOT NULL,
  PRIMARY KEY (customer_id, book_id),
  CONSTRAINT customerbook_ibfk_1
    FOREIGN KEY (customer_id)
    REFERENCES book_store.customer (customer_id),
  CONSTRAINT customerbook_ibfk_2
    FOREIGN KEY (book_id)
    REFERENCES book_store.book (book_id)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS purchase (
  purchase_id BIGINT NOT NULL AUTO_INCREMENT,
  customer VARCHAR(50) NOT NULL,
  book VARCHAR(90) NOT NULL,
  action VARCHAR(10) NOT NULL,
  time_stamp DATETIME NOT NULL,
  user VARCHAR(50) NULL,
  PRIMARY KEY (purchase_id)
) ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;


#-----------------------------------------------------------------------------------------------


INSERT INTO book (book_name, author, publisher, imprint_year, amount) VALUES
('1984', 'George Orwell', 'Litra Pub', 1990, 6),
('Pride and Prejudice', 'Jane Austen', 'Litra Pub', 2000, 3),
('To Kill a Mockingbird', 'Harper Lee', 'Booklab', 2002, 2),
('The Da Vinci Code', 'Dan Brown', 'Publishing', 2005, 2),
('The Catcher in the Rye', 'J.D.Salinger', 'Booklab', 2002, 1),
('The Great Gatsby', 'F.Scott Fitzgerald', ' Publishing', 2005, 4),
('Twilight', 'Stephenie Meyer', 'Booklab', 2001, 5),
('The Hunger Games', 'Suzanne Collins', 'Litra Pub', 2010, 2);

INSERT INTO city (city_id, city) VALUES
(1, 'Minsk'),
(2, 'Kyiv'),
(3, 'Lviv'),
(4, 'Vilnius'),
(5, 'Riga');

INSERT INTO customer (surname, name, email, city_id, street, apartment) VALUES
('Smith', 'John', 'johnsmith@gmail.com', 1, 'Suhafe', '1/5'),
('Petrina', 'Sergiy', 'petrinaserg@gmail.com', 1, 'Vikaliv', '8/1b'),
('Petan', 'Denis', 'denispetan@gmail.com', 4, 'Soborna', '18'),
('Vertsimaha', 'Andriy', 'vertsimaha94@gmail.com', 3, 'Lazarenka', '47/12'),
('Gusiev', 'Mykola', 'gusievmuk@gmail.com', 2, 'Ferea', '3/5'),
('Glebova', 'Viktoria', 'vika.glebova@gmail.com', 4, 'Samsona', '11'),
('Malasnyak', 'Petro', 'petro.malas@gmail.com', 2, 'Maidan Nezalezhnosti', '3'),
('Herera', 'Petris', 'hererasuper@gmail.com', 5, 'Fitihata', '2/a');






