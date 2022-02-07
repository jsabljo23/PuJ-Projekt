-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 07, 2022 at 04:46 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `PUJCarBuy`
--

-- --------------------------------------------------------

--
-- Table structure for table `Cars`
--

CREATE TABLE `Cars` (
  `idCars` int(11) NOT NULL,
  `Marka` varchar(80) NOT NULL,
  `Model` varchar(80) NOT NULL,
  `Godina` varchar(80) NOT NULL,
  `VIN` varchar(80) NOT NULL,
  `Cijena` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Cars`
--

INSERT INTO `Cars` (`idCars`, `Marka`, `Model`, `Godina`, `VIN`, `Cijena`) VALUES
(1, 'Mercedes', 'E-klasa w214', '2013', 'MBDBW214QEZZ64KGGH', '23,000$'),
(2, 'Mercedes', 'E-klasa w214', '2012', 'MBDBW214QEZDD4KPPH', '19,000$'),
(3, 'Mercedes', 'S-klasa w222', '2013', 'MBDBW222QELLI4KGGH', '35,000$'),
(4, 'Mercedes', 'EQS', '2021', 'MBDBWEQQEZZ6KOOGGH', '130,000$'),
(5, 'Mercedes', 'G-klasa', '2020', 'MBDBW233QEZZ64KGGH', '60,000$'),
(6, 'Mercedes', 'AMG ProjectOne', '2022', 'MBDBWXXYUIA76I', '5,000,000$'),
(7, 'Mercedes', 'C-klasa w205', '2020', 'MBDBW205QEZZZZKGGH', '51,000$'),
(8, 'Volkswagen', 'Golf MK6', '2010', 'VWZZZHU67NKJYY', '8,000$'),
(9, 'Volkswagen', 'Golf MK7', '2017', 'VWZZZKLOOO7NKJYY', '18,000$'),
(10, 'Volkswagen', 'Golf MK7', '2018', 'VWZZZHU67NAXXX9', '20,000$'),
(11, 'Volkswagen', 'ID3', '2021', 'VWZZAKOLZZYY89', '29,000$'),
(12, 'Rimac', 'Nevera', '2022', 'RAPG89JIIANDN', '3,000,000$'),
(13, 'Audi', 'E-tron GT', '2022', 'AGZZZ893KJIHBBK', '123,000$'),
(14, 'Audi', 'A8', '2022', 'AGZZZ893KOAOLS98', '98,000$'),
(15, 'Audi', 'R8', '2022', 'AGZZZXYYY536BBK', '110,000$'),
(16, 'Audi', 'E-tron', '2022', 'AGZZZ8UUUUJIHBBK', '100,000$'),
(17, 'Audi', 'A5 Sportback', '2020', 'AGZZZLKAMMIHBBK', '78,000$'),
(18, 'Porsche', 'Taycan', '2022', 'PGAG897HSNAK', '170,000$'),
(19, 'Porsche', '911', '2022', 'PGAGZZZZOAAK', '120,000$'),
(20, 'Porsche', '911 Turbo S', '2022', 'PGAG8MAAOAJSNAK', '230,000$'),
(21, 'RedBull Racing Honda', 'RB-21', '2021', 'RBRB21MSNIA12', '17,000,000$'),
(22, 'MercedesBenz Petronas AMG', 'W12', '2021', 'MBDB12MWAZZY', '18,000,000$'),
(23, 'Scuderia Ferrari', 'SF21', '2021', 'SPINALABINOTTO', '18,000,000$'),
(24, 'Scuderia AlphaTauri', 'AT03', '2021', 'AT03XXJSNA', '15,000,000$'),
(25, 'Uralkali Haas F1 Team', 'VF-21', '2021', 'VF21BBIA', '5$');

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `idUsers` int(11) NOT NULL,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  `UserName` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`idUsers`, `FirstName`, `LastName`, `UserName`, `Password`) VALUES
(1, 'Admin', 'Admin', 'admin1', '12345678');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Cars`
--
ALTER TABLE `Cars`
  ADD PRIMARY KEY (`idCars`);

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`idUsers`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Cars`
--
ALTER TABLE `Cars`
  MODIFY `idCars` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `Users`
--
ALTER TABLE `Users`
  MODIFY `idUsers` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
