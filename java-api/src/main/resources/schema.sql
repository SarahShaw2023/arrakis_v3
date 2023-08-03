--TODO: Figure out database creation issue?
--DROP DATABASE IF EXISTS FIC;
--CREATE DATABASE FIC;
--use FIC;

DROP TABLE bonds IF EXISTS;

--Original bonds table:
-- CREATE TABLE bonds (
--     id int NOT NULL AUTO_INCREMENT,
--     isin varchar(50) DEFAULT NULL,
--     cusip varchar(50) DEFAULT NULL,
--     issuer_name varchar(255) NOT NULL,
--     bond_maturity date NOT NULL,
--     coupon_percent float NOT NULL,
--     type varchar(255) NOT NULL,
--     face_value float NOT NULL,
--     bond_currency varchar(10) NOT NULL,
--     status varchar(32) DEFAULT NULL,
--     PRIMARY KEY (id)
-- ) ;

CREATE TABLE bonds (
    isin varchar(50) PRIMARY KEY,
    cusip varchar(50),
    bond_currency varchar(10) NOT NULL,
    face_value int NOT NULL,
    bond_maturity varchar(11) NOT NULL,
    coupon_percent float NOT NULL,
    issuer_name varchar(255) NOT NULL,
    status varchar(32) NOT NULL,
    type varchar(255) NOT NULL
);

-- Given DDL format:
DROP TABLE books IF EXISTS;
CREATE TABLE books (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

--Cannot use 'user' keyword unless adding ";NON_KEYWORDS=USER" to the end of the JDBC url
DROP TABLE users IF EXISTS;
CREATE TABLE users (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  role varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

DROP TABLE book_users IF EXISTS;
CREATE TABLE book_users (
  book_id int NOT NULL,
  user_id int NOT NULL,
  -- From 'books' table
  CONSTRAINT FK1_book_id FOREIGN KEY (book_id) REFERENCES books(id),
  -- From 'users' table
  CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(id)
);

DROP TABLE counterparties IF EXISTS;
CREATE TABLE counterparties (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ;

DROP TABLE trades IF EXISTS;
CREATE TABLE trades (
  id int NOT NULL AUTO_INCREMENT,
  book_id int NOT NULL,
  bond_id varchar(12) NOT NULL,
  counterparty_id int NOT NULL,
  type varchar(4) NOT NULL, -- len = 4 for 'buy'/'sell'
  currency varchar(10) NOT NULL,
  status varchar(32) NOT NULL,
  quantity int NOT NULL,
  unit_price float NOT NULL,
  trade_date varchar(11) NOT NULL,
  settlement_date varchar(11) NOT NULL,
  PRIMARY KEY (id),
  -- From 'books' table
    CONSTRAINT FK_security_id FOREIGN KEY (bond_id) REFERENCES bonds(isin),
  -- From 'books' table
    CONSTRAINT FK_counterparty_id FOREIGN KEY (counterparty_id) REFERENCES counterparties(id),
  -- From 'books' table
    CONSTRAINT FK_book_id FOREIGN KEY (book_id) REFERENCES books(id)
) ;


ALTER TABLE book_users ADD PRIMARY KEY(book_id, user_id);

