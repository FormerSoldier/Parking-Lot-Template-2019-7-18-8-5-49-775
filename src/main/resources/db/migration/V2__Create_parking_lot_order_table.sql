DROP TABLE IF EXISTS parking_lot_order;
CREATE TABLE parking_lot_order(
  id INT NOT NULL PRIMARY  KEY AUTO_INCREMENT,
  praking_lot_name VARCHAR(200) NOT NULL,
  car_plate_number  VARCHAR(200) NOT NULL,
  start_time VARCHAR(100) NOT NULL,
  end_time VARCHAR(100) NOT NULL,
  status TINYINT DEFAULT 1,
  FOREIGN KEY(praking_lot_name)REFERENCES parking_lot(name)
);