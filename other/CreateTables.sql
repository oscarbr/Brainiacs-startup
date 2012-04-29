CREATE TABLE Books (
  saleID int(11) NOT NULL,
  isbn int(13) DEFAULT NULL,
  author varchar(100) NOT NULL,
  title varchar(100) NOT NULL,
  edition varchar(45) DEFAULT NULL,
  publYear year(4) DEFAULT NULL,
  course char(6) DEFAULT NULL,
  period varchar(45) DEFAULT NULL,
  bookType varchar(45) DEFAULT NULL,
  sold int(1) DEFAULT NULL,
  price varchar(45) NOT NULL,
  expires date NOT NULL,
  email varchar(45) NOT NULL,
  phone varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY id_UNIQUE (id)
)