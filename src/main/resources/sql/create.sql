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

CREATE TABLE IF NOT EXISTS users (
 id INTEGER PRIMARY KEY auto_increment,
 name VARCHAR,
 address VARCHAR,
 email VARCHAR
);

CREATE TABLE IF NOT EXISTS couriers (
 id INTEGER PRIMARY KEY auto_increment,
 name VARCHAR,
 localToDelivery VARCHAR,
 courirStatusCode INTEGER
);

CREATE TABLE IF NOT EXISTS blacklist (
 id INTEGER PRIMARY KEY auto_increment,
 userId INTEGER,
 courierId INTEGER
);

CREATE TABLE IF NOT EXISTS foods (
 id INTEGER PRIMARY KEY auto_increment,
 restaurantId INTEGER,
 categoryCode INTEGER
);

CREATE TABLE IF NOT EXISTS orders (
 id INTEGER PRIMARY KEY auto_increment,
 userId INTEGER,
 orderAddress VARCHAR,
 orderDate DATE,
 orderStatus INTEGER,
 courierId INTEGER
);

