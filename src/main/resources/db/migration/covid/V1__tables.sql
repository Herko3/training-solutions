CREATE TABLE citizens (
    citizen_id BIGINT NOT NULL AUTO_INCREMENT,
    citizen_name VARCHAR(200) NOT NULL,
    zip VARCHAR(4) NOT NULL,
    age BIGINT NOT NULL,
    email VARCHAR(200),
    taj VARCHAR(10),
    number_of_vaccination BIGINT,
    last_vaccination DATETIME,
    PRIMARY KEY(citizen_id)
);

CREATE TABLE vaccinations (
    vaccination_id BIGINT NOT NULL AUTO_INCREMENT,
    citizen_id BIGINT NOT NULL,
    vaccination_date DATETIME NOT NULL,
    status VARCHAR(10),
    note VARCHAR(200),
    vaccination_type VARCHAR(20),
    PRIMARY KEY (vaccination_id),
    FOREIGN KEY (citizen_id) REFERENCES citizens (citizen_id)
);

CREATE TABLE cities(
    city_id BIGINT NOT NULL AUTO_INCREMENT,
    zip VARCHAR(4) NOT NULL,
    city VARCHAR(40) NOT NULL,
    PRIMARY KEY (city_id)
);