CREATE TABLE Books (
  saleID int NOT NULL AUTO_INCREMENT,
  isbn bigint DEFAULT NULL,
  author varchar(100) NOT NULL,
  title varchar(100) NOT NULL,
  edition varchar(45) DEFAULT NULL,
  publYear year(4) DEFAULT NULL,
  course char(6) DEFAULT NULL,
  period varchar(45) DEFAULT NULL,
  bookType varchar(45) DEFAULT NULL,
  sold tinyint DEFAULT NULL,
  price varchar(45) NOT NULL,
  expires date NOT NULL,
  email varchar(45) NOT NULL,
  phone varchar(45) NOT NULL,
  comment varchar(150) DEFAULT NULL,
  password varchar(45) NOT NULL,
  PRIMARY KEY (saleID)
)