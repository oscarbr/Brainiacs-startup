DROP TABLE Books;
CREATE TABLE Books(
  author VARCHAR(45) NOT NULL,
  title VARCHAR(45) NOT NULL,
  testPerson VARCHAR(45) NOT NULL,
  PRIMARY KEY (author, title)
);

INSERT INTO Books
	(author, title)
		VALUES ('Emilio', 'Management', 'Rikard Andersson');