/*
DROP TABLE IF EXISTS `restaurants`;
*/


CREATE TABLE IF NOT EXISTS restaurants (
 id INTEGER PRIMARY KEY auto_increment,
 name VARCHAR,
 address VARCHAR,
 email VARCHAR
);

CREATE TABLE IF NOT EXISTS jobopportunity (
 id INTEGER PRIMARY KEY auto_increment,
 positionCode INTEGER,
 restaurantId INTEGER,
 dateStartannounce VARCHAR
);

