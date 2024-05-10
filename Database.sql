-- MariaDB dump 10.19-11.3.2-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: UserRegistrationDB
-- ------------------------------------------------------
-- Server version 11.3.2-MariaDB

-- Set session variables
SET NAMES utf8mb4;
SET TIME_ZONE='+00:00';
SET SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

-- Create new database if not exists
CREATE DATABASE IF NOT EXISTS UserRegistrationDB;
USE UserRegistrationDB;

-- Drop tables if they exist
DROP TABLE IF EXISTS `Event`;
DROP TABLE IF EXISTS `EventPlan`;
DROP TABLE IF EXISTS `eventplanner`;
DROP TABLE IF EXISTS `users`;

-- Table structure for table `users`
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insert data into table `users`
INSERT INTO `users` VALUES
(1, 'gayashan', 'gayashan@gmail.com', 'gayashan', '12345678'),
(2, 'aweesha', 'aweesha@gmail.com', 'aweesha', '12345678'),
(3, 'imashi', 'imashi@gmail.com', 'imashi', '12345678'),
(4, 'nimendra', 'nimendra@gmail.com', 'nmdra', '12345678');

-- Table structure for table `Event`
CREATE TABLE `Event` (
  `eventId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `category` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `dateTime` varchar(20) DEFAULT NULL,
  `attendees` int(100) DEFAULT NULL,
  `specialReq` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`eventId`),
  KEY `Event_users_id_fk` (`userId`),
  CONSTRAINT `Event_users_id_fk` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insert data into table `Event`
INSERT INTO `Event` VALUES
(1, 1, 'Wedding', 'ITC', '2024-05-10T14:35', 100, 'No'),
(2, 4, 'Workshops', 'SLIIT', '2024-05-10T14:42', 50, 'No');

-- Table structure for table `EventPlan`
CREATE TABLE `EventPlan` (
  `eventPlanId` int(11) NOT NULL AUTO_INCREMENT,
  `eventId` int(11) DEFAULT NULL,
  `eventTheme` varchar(255) DEFAULT NULL,
  `budget` decimal(10,2) DEFAULT NULL,
  `planDescription` varchar(255) DEFAULT NULL,
  `userID` int(11) NOT NULL,
  PRIMARY KEY (`eventPlanId`),
  KEY `EventPlan_Event_eventId_fk` (`eventId`),
  CONSTRAINT `EventPlan_Event_eventId_fk` FOREIGN KEY (`eventId`) REFERENCES `Event` (`eventId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insert data into table `EventPlan`
INSERT INTO `EventPlan` VALUES
(1, 1, 'Purple Theme', 500000.00, 'No', 1),
(2, 2, 'Professional', 300000.00, 'No', 4);

-- Table structure for table `eventplanner`
CREATE TABLE `eventplanner` (
  `plannerid` varchar(15) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`plannerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insert data into table `eventplanner`
INSERT INTO `eventplanner` VALUES
('1', 'imashi', 'imashi@gmail.au.com', 'imashi', '1234', 'eventplanner');
