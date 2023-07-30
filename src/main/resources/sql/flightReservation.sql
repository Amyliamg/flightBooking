CREATE DATABASE reservation;

USE reservation;

CREATE TABLE user(
    ID INT NOT NULL AUTO_INCREMENT,
    FIRST_NAME VARCHAR(20),
    LAST_NAME VARCHAR(20),
    EMAIL VARCHAR(20),
    PASSWORD VARCHAR(50),
    PRIMARY KEY (ID),
    UNIQUE KEY (EMAIL)
);

CREATE TABLE flight
(
    ID INT NOT NULL AUTO_INCREMENT,
    FLIGHT_NUMBER VARCHAR(20) NOT NULL,
    OPERATING_AIRLINES VARCHAR(20) NOT NULL,
    DEPARTURE_CITY VARCHAR(20) NOT NULL,
    ARRIVAL_CITY VARCHAR(20) NOT NULL,
    DATE_OF_DEPARTURE DATE NOT NULL,
    ESTIMATED_DEPARTURE_TIME TIMESTAMP,

    PRIMARY KEY (ID)
);

CREATE TABLE passenger
(
    ID INT NOT NULL AUTO_INCREMENT,
    FIRST_NAME VARCHAR(20),
    LAST_NAME VARCHAR(20),
    EMAIL VARCHAR(50),
    PHONE VARCHAR(20),

    PRIMARY KEY (ID)
);

CREATE TABLE reservation(
                            ID INT NOT NULL AUTO_INCREMENT,
                            FLIGHT_ID INT,
                            PASSENGER_ID INT,
                            CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                            CHECKED_IN TINYINT(1),
                            NUMBER_OF_BAGS INT,

                            PRIMARY KEY (ID),
                            FOREIGN KEY (FLIGHT_ID) REFERENCES flight(ID) ON DELETE CASCADE,
                            FOREIGN KEY (PASSENGER_ID) REFERENCES passenger(ID)
)
