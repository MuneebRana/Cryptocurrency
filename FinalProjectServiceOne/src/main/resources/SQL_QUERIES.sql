CREATE TABLE `buy` (
  `buy_id` int(11) NOT NULL AUTO_INCREMENT,
  `buyer_id` int(11) DEFAULT NULL,
  `buy_price` int(11) NOT NULL,
  `buy_amount` int(11) NOT NULL,
  `buy_total` int(11) NOT NULL,
  PRIMARY KEY (`buy_id`),
  KEY `FKshvodfhsvl21sm109ydxh610` (`buyer_id`),
  CONSTRAINT `FKshvodfhsvl21sm109ydxh610`
  FOREIGN KEY (`buyer_id`) REFERENCES
    `registration` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `sell` (
  `sell_id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_id` int(11) DEFAULT NULL,
  `sell_price` int(11) NOT NULL,
  `sell_amount` int(11) NOT NULL,
  `sell_total` int(11) NOT NULL,
  PRIMARY KEY (`sell_id`),
  KEY `FKb2xh3hqr5d4l6bts1bh9hwgvn`
    (`seller_id`),
  CONSTRAINT `FKb2xh3hqr5d4l6bts1bh9hwgvn`
  FOREIGN KEY (`seller_id`) REFERENCES
    `registration` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8



CREATE TABLE `registration` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(60) NOT NULL,
  `bitcoins` int(11) NOT NULL,
  `dollars` int(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8