-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 17 mars 2019 à 21:57
-- Version du serveur :  5.7.24
-- Version de PHP :  7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `reservations`
--
CREATE DATABASE IF NOT EXISTS `reservations` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `reservations`;

-- --------------------------------------------------------

--
-- Structure de la table `artiste_type`
--

DROP TABLE IF EXISTS `artiste_type`;
CREATE TABLE IF NOT EXISTS `artiste_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `artist_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_artists_arttype` (`artist_id`),
  KEY `fk_type_arttype` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `artiste_type_show`
--

DROP TABLE IF EXISTS `artiste_type_show`;
CREATE TABLE IF NOT EXISTS `artiste_type_show` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `artiste_type_id` int(11) NOT NULL,
  `show_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_arttype_arttypeshow` (`artiste_type_id`),
  KEY `fk_shows_arttypeshow` (`show_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `artists`
--

DROP TABLE IF EXISTS `artists`;
CREATE TABLE IF NOT EXISTS `artists` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(60) NOT NULL,
  `lastname` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `localities`
--

DROP TABLE IF EXISTS `localities`;
CREATE TABLE IF NOT EXISTS `localities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `postal_code` varchar(6) NOT NULL,
  `locality` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `locations`
--

DROP TABLE IF EXISTS `locations`;
CREATE TABLE IF NOT EXISTS `locations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `slug` varchar(60) NOT NULL,
  `designation` varchar(60) NOT NULL,
  `address` varchar(255) NOT NULL,
  `locality_id` int(11) NOT NULL,
  `website` varchar(255) NOT NULL,
  `phone` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_localities_locations` (`locality_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `representations`
--

DROP TABLE IF EXISTS `representations`;
CREATE TABLE IF NOT EXISTS `representations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `show_id` int(11) NOT NULL,
  `when` datetime NOT NULL,
  `location_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_shows_representations` (`show_id`),
  KEY `fk_locations_representations` (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `representation_user`
--

DROP TABLE IF EXISTS `representation_user`;
CREATE TABLE IF NOT EXISTS `representation_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `representation_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `places` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_users_repuser` (`user_id`),
  KEY `fk_representations_repuser` (`representation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `shows`
--

DROP TABLE IF EXISTS `shows`;
CREATE TABLE IF NOT EXISTS `shows` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `slug` varchar(60) NOT NULL,
  `title` varchar(255) NOT NULL,
  `poster_url` varchar(255) NOT NULL,
  `location_id` int(11) NOT NULL,
  `bookable` tinyint(1) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_location_shows` (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `types`
--

DROP TABLE IF EXISTS `types`;
CREATE TABLE IF NOT EXISTS `types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(30) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_id` int(11) NOT NULL,
  `firstname` varchar(60) NOT NULL,
  `lastname` varchar(60) NOT NULL,
  `email` varchar(100) NOT NULL,
  `langue` varchar(2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_roles_users` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `artiste_type`
--
ALTER TABLE `artiste_type`
  ADD CONSTRAINT `fk_artists_arttype` FOREIGN KEY (`artist_id`) REFERENCES `artists` (`id`),
  ADD CONSTRAINT `fk_type_arttype` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`);

--
-- Contraintes pour la table `artiste_type_show`
--
ALTER TABLE `artiste_type_show`
  ADD CONSTRAINT `fk_arttype_arttypeshow` FOREIGN KEY (`artiste_type_id`) REFERENCES `artiste_type` (`id`),
  ADD CONSTRAINT `fk_shows_arttypeshow` FOREIGN KEY (`show_id`) REFERENCES `shows` (`id`);

--
-- Contraintes pour la table `locations`
--
ALTER TABLE `locations`
  ADD CONSTRAINT `fk_localities_locations` FOREIGN KEY (`locality_id`) REFERENCES `localities` (`id`);

--
-- Contraintes pour la table `representations`
--
ALTER TABLE `representations`
  ADD CONSTRAINT `fk_locations_representations` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`),
  ADD CONSTRAINT `fk_shows_representations` FOREIGN KEY (`show_id`) REFERENCES `shows` (`id`);

--
-- Contraintes pour la table `representation_user`
--
ALTER TABLE `representation_user`
  ADD CONSTRAINT `fk_representations_repuser` FOREIGN KEY (`representation_id`) REFERENCES `representations` (`id`),
  ADD CONSTRAINT `fk_users_repuser` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `shows`
--
ALTER TABLE `shows`
  ADD CONSTRAINT `fk_location_shows` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`);

--
-- Contraintes pour la table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_roles_users` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
