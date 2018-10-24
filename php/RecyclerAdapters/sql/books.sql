-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2017 at 09:23 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 7.0.13

--  Collation :  utf8_general_ci	

  
 create database if NOT EXISTS books   CHARACTER SET utf8 COLLATE utf8_general_ci ;

use   books ;
 

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `books`
--

-- --------------------------------------------------------

 

drop TABLE IF EXISTS books ; 

CREATE TABLE books (
id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY ,
 title text NOT NULL ,
description text  NOT NULL  ,
image text   NOT NULL  
 )
  ENGINE=InnoDB DEFAULT CHARSET=utf8;

 
--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `title`, `description`, `image`) VALUES
(1, 'test  title 1', 'test  description 1', 'http://cdn.interestingengineering.com/wp-content/uploads/2016/09/BLUE-SKY.jpg'),
(2, 'test  title 2', 'test  description 2', 'http://eskipaper.com/images/blue-sky-wallpapers-1.jpg'),
(3, 'test title 3', 'test description 3', 'http://www.wallpaperup.com/uploads/wallpapers/2015/11/15/836795/b0075bdea3e860c71d3069229a6262f8.jpg');

 
 
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
