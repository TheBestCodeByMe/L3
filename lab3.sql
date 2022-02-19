create database if not exists ris;

use ris;

CREATE TABLE customer(
id INT PRIMARY KEY NOT NULL,
zip INT NOT NULL,
`name` VARCHAR(50) NOT NULL,
firstaddress VARCHAR(50) NOT NULL,
secondaddress VARCHAR(50) NOT NULL,
numbFax INT NOT NULL,
city VARCHAR(50) NOT NULL);