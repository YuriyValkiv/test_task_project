-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Час створення: Лип 11 2020 р., 16:02
-- Версія сервера: 5.7.24
-- Версія PHP: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База даних: `test_project`
--

-- --------------------------------------------------------

--
-- Структура таблиці `cars`
--

DROP TABLE IF EXISTS `cars`;
CREATE TABLE IF NOT EXISTS `cars` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `description` text NOT NULL,
  `date` timestamp NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `cars`
--

INSERT INTO `cars` (`id`, `name`, `description`, `date`) VALUES
(1, 'Mark', 'dededed', '2020-07-15 22:00:00'),
(2, 'Leon', 'dededeweww', '2020-07-15 22:00:00'),
(3, 'Andre', 'ewwrew', '2020-07-15 22:00:00'),
(4, 'Mike', 'wwwwwwwwwwwwwwwww', '2020-07-15 22:00:00'),
(5, 'Luke', 'lllllllllllllllllll', '2020-07-15 22:00:00'),
(6, 'Tim', 'wwwwwwwwwwwwwwwwwwwwwww', '2020-07-15 22:00:00');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
