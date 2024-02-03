# Flight Booking Project

## Overview

The Flight Booking Project is a Spring Boot application that allows users to search for flights, make reservations, and receive confirmation details. It leverages several technologies to provide a seamless experience for users.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Technologies Used](#technologies-used)


## Installation

1. Clone the repository: `git clone <repository-url>`
2. Navigate to the project directory: `cd flight-booking-project`
3. Install dependencies: `mvn install`
4. Check the pom.xml file to see whether some dependencies need updates

## Usage

To run the application, use the following command:
1. `cd FlightBookingApplication`
2. `mvn spring-boot:run`

To run Redis, use `redis-server`

To use Docker
1. Install Docker: https://docs.docker.com/engine/install/
2. Navigate to the directory where Dockerfile is located: `cd Dockerfile`
3. Build the Docker image using the following command:  `docker build -t flight-app .`
4. Run the Docker container with this command: `docker run -p 8081:8081 flight-app`

 
##  Features
Flight search based on departure, arrival, and date
Reservation creation and confirmation
Flight check-in service
Email confirmation
 
## Technologies Used
- Spring Boot
- Spring Data JPA
- Thymeleaf
- Spring Web
- Spring DevTools
- MySQL Connector Java
- Spring Data Redis
- Spring Boot Test
- Spring Boot Mail
- iTextPDF
- Docker
......
