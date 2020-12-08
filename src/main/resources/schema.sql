CREATE TABLE IF NOT EXISTS building_types(
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50),
    description VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS building_state(
    id INT AUTO_INCREMENT PRIMARY KEY,
    state VARCHAR(50),
    description VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS user_roles(
    id INT AUTO_INCREMENT PRIMARY KEY,
    role VARCHAR(50),
    description VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS builder_specialties(
    id INT AUTO_INCREMENT PRIMARY KEY,
    specialty VARCHAR(50),
    description VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS machinery_types(
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50),
    description VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS buildings(
    id INT AUTO_INCREMENT PRIMARY KEY,
    building_state INT NOT NULL,
    floors INT NOT NULL,
    building_type INT NOT NULL,
    price INT,
    building_started date DEFAULT NULL,
    building_completed date DEFAULT NULL,
    put_into_operation date DEFAULT NULL,
    FOREIGN KEY (building_state) REFERENCES  building_state(id),
    FOREIGN KEY (building_type) REFERENCES  building_types(id)
);
CREATE TABLE IF NOT EXISTS users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(50),
    password VARCHAR(50) NOT NULL,
    is_active boolean DEFAULT TRUE,
    role INT NOT NULL,
    FOREIGN KEY (role) REFERENCES  user_roles(id)
);
CREATE TABLE IF NOT EXISTS builders(
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(50),
    specialty INT NOT NULL,
    FOREIGN KEY (specialty) REFERENCES  builder_specialties(id)
);
CREATE TABLE IF NOT EXISTS machinery(
    id INT AUTO_INCREMENT PRIMARY KEY,
    producer VARCHAR(50),
    type INT NOT NULL,
    release_date date NOT NULL,
    FOREIGN KEY (type) REFERENCES  machinery_types(id)
);
