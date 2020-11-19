DROP TABLE IF EXISTS buildings;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS builders;
DROP TABLE IF EXISTS machinery;
DROP TABLE IF EXISTS building_types;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS builder_specialties;
DROP TABLE IF EXISTS machinery_types;

CREATE TABLE building_types(
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50)
);
CREATE TABLE user_roles(
    id INT AUTO_INCREMENT PRIMARY KEY,
    role VARCHAR(50)
);
CREATE TABLE builder_specialties(
    id INT AUTO_INCREMENT PRIMARY KEY,
    specialty VARCHAR(50)
);
CREATE TABLE machinery_types(
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50)
);
CREATE TABLE buildings(
    id INT AUTO_INCREMENT PRIMARY KEY,
    progress INT NOT NULL,
    floors INT NOT NULL,
    building_type INT NOT NULL,
    builder_company VARCHAR(50) DEFAULT NULL,
    price INT,
    FOREIGN KEY (building_type) REFERENCES  building_types(id)
);
CREATE TABLE users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(50),
    password VARCHAR(50) NOT NULL,
    secret_key VARCHAR(50) NOT NULL,
    role INT NOT NULL,
    FOREIGN KEY (role) REFERENCES  user_roles(id)
);
CREATE TABLE builders(
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    specialty INT NOT NULL,
    FOREIGN KEY (specialty) REFERENCES  builder_specialties(id)
);
CREATE TABLE machinery(
    id INT AUTO_INCREMENT PRIMARY KEY,
    producer VARCHAR(50),
    quantity INT NOT NULL,
    type INT NOT NULL,
    FOREIGN KEY (type) REFERENCES  machinery_types(id)
);
