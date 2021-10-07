-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 07, 2021 at 08:18 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `atm_machine_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `Accounts`
--

CREATE TABLE `Accounts` (
  `account_no` int(11) NOT NULL,
  `pin` int(11) NOT NULL,
  `opening_balance` double NOT NULL,
  `overdraft` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Accounts`
--

INSERT INTO `Accounts` (`account_no`, `pin`, `opening_balance`, `overdraft`) VALUES
(123456789, 1234, 800, 200),
(987654321, 4321, 1230, 150);

-- --------------------------------------------------------

--
-- Table structure for table `Teller`
--

CREATE TABLE `Teller` (
  `id` int(11) NOT NULL,
  `fifty` int(11) NOT NULL,
  `twenty` int(11) NOT NULL,
  `ten` int(11) NOT NULL,
  `five` int(11) NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Teller`
--

INSERT INTO `Teller` (`id`, `fifty`, `twenty`, `ten`, `five`, `total`) VALUES
(0, 10, 30, 30, 20, 1500);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Accounts`
--
ALTER TABLE `Accounts`
  ADD PRIMARY KEY (`account_no`);

--
-- Indexes for table `Teller`
--
ALTER TABLE `Teller`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
