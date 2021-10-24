-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 05, 2021 at 08:40 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gamestore`
--

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

CREATE TABLE `game` (
  `game_id` int(11) NOT NULL,
  `nama_game` varchar(255) DEFAULT NULL,
  `pembuat_game` varchar(255) DEFAULT NULL,
  `genre_game` varchar(255) DEFAULT NULL,
  `harga_game` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `game`
--

INSERT INTO `game` (`game_id`, `nama_game`, `pembuat_game`, `genre_game`, `harga_game`) VALUES
(10, 'dota2', 'elvin', 'role', 2000);

-- --------------------------------------------------------

--
-- Table structure for table `struk`
--

CREATE TABLE `struk` (
  `strukid` int(11) NOT NULL,
  `game_id` int(11) NOT NULL,
  `nama_game` varchar(255) DEFAULT NULL,
  `pembuat_game` varchar(255) DEFAULT NULL,
  `genre_game` varchar(255) DEFAULT NULL,
  `harga_game` int(11) DEFAULT NULL,
  `uang_pembayaran` int(11) DEFAULT NULL,
  `Total_pembelian` int(11) DEFAULT NULL,
  `kuantitas_game` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `struk`
--

INSERT INTO `struk` (`strukid`, `game_id`, `nama_game`, `pembuat_game`, `genre_game`, `harga_game`, `uang_pembayaran`, `Total_pembelian`, `kuantitas_game`) VALUES
(12, 10, 'dota2', 'elvin', 'role', 2000, 5000, 4000, 2),
(13, 10, 'dota2', 'elvin', 'role', 2000, 5000, 4000, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`game_id`);

--
-- Indexes for table `struk`
--
ALTER TABLE `struk`
  ADD PRIMARY KEY (`strukid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `game`
--
ALTER TABLE `game`
  MODIFY `game_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `struk`
--
ALTER TABLE `struk`
  MODIFY `strukid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
