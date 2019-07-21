DROP TABLE IF EXISTS parking_lot;
CREATE TABLE parking_lot(
  id INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(200) NOT NULL,
  capacity INT DEFAULT 0,
  position VARCHAR(200) DEFAULT ''
);