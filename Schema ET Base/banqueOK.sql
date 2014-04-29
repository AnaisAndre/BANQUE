-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Sam 26 Avril 2014 à 15:58
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `banque`
--
CREATE DATABASE IF NOT EXISTS `banque` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `banque`;

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE IF NOT EXISTS `compte` (
  `NUMERO` int(10) NOT NULL,
  `NOMTITULAIRE` varchar(30) DEFAULT NULL,
  `SOLDE` double(10,2) DEFAULT NULL,
  `TYPE` int(1) DEFAULT NULL,
  PRIMARY KEY (`NUMERO`),
  KEY `NOMTITULAIRE` (`NOMTITULAIRE`),
  KEY `TYPE` (`TYPE`),
  KEY `SOLDE` (`SOLDE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`NUMERO`, `NOMTITULAIRE`, `SOLDE`, `TYPE`) VALUES
(1, 'Azerty', -150.00, 3),
(2, 'Qsdfgh', 1902.00, 2),
(3, 'Wxcvbn', 150.00, 1),
(4, 'Tutu', 600.00, 2),
(5, 'Titi', -150.00, 3);

-- --------------------------------------------------------

--
-- Structure de la table `compte_courant`
--

CREATE TABLE IF NOT EXISTS `compte_courant` (
  `NUMERO` int(10) NOT NULL,
  `DECOUVERTAUTORISE` double(5,2) DEFAULT NULL,
  `NOMTITULAIRE` varchar(30) DEFAULT NULL,
  `SOLDE` double(10,2) DEFAULT NULL,
  `TYPE` int(1) DEFAULT NULL,
  PRIMARY KEY (`NUMERO`),
  KEY `NOMTITULAIRE` (`NOMTITULAIRE`),
  KEY `SOLDE` (`SOLDE`),
  KEY `TYPE` (`TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compte_courant`
--

INSERT INTO `compte_courant` (`NUMERO`, `DECOUVERTAUTORISE`, `NOMTITULAIRE`, `SOLDE`, `TYPE`) VALUES
(1, 200.00, 'Azerty', -150.00, 3),
(5, -900.00, 'Titi', -150.00, 3);

-- --------------------------------------------------------

--
-- Structure de la table `compte_epargne`
--

CREATE TABLE IF NOT EXISTS `compte_epargne` (
  `NUMERO` int(10) NOT NULL,
  `TAUX` double(5,2) DEFAULT NULL,
  `NOMTITULAIRE` varchar(30) DEFAULT NULL,
  `SOLDE` double(10,2) DEFAULT NULL,
  `TYPE` int(1) DEFAULT NULL,
  PRIMARY KEY (`NUMERO`),
  KEY `NOMTITULAIRE` (`NOMTITULAIRE`),
  KEY `SOLDE` (`SOLDE`),
  KEY `TYPE` (`TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compte_epargne`
--

INSERT INTO `compte_epargne` (`NUMERO`, `TAUX`, `NOMTITULAIRE`, `SOLDE`, `TYPE`) VALUES
(2, 25.00, 'Qsdfgh', 1902.00, 2),
(4, 25.00, 'Tutu', 600.00, 2);

-- --------------------------------------------------------

--
-- Structure de la table `consultations`
--

CREATE TABLE IF NOT EXISTS `consultations` (
  `NUMERO` int(10) NOT NULL AUTO_INCREMENT,
  `NUMERO_COMPTE` int(10) NOT NULL,
  `TYPEOPERATION` varchar(15) DEFAULT NULL,
  `MONTANT` double(10,2) NOT NULL,
  `DATE` date DEFAULT NULL,
  PRIMARY KEY (`NUMERO`),
  KEY `I_FK_CONSULTATIONS_COMPTE` (`NUMERO_COMPTE`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=73 ;

--
-- Contenu de la table `consultations`
--

INSERT INTO `consultations` (`NUMERO`, `NUMERO_COMPTE`, `TYPEOPERATION`, `MONTANT`, `DATE`) VALUES
(1, 1, 'Dépôt', 0.00, '2014-04-26'),
(2, 1, 'Dépôt', 250.00, '2014-04-26'),
(3, 1, 'Dépôt', 900.00, '2014-04-26'),
(4, 1, 'Dépôt', 1.00, '2014-04-26'),
(5, 1, 'Dépôt', 1.00, '2014-04-26'),
(6, 1, 'Dépôt', 1.00, '2014-04-26'),
(7, 1, 'Dépôt', 1.00, '2014-04-26'),
(8, 1, 'Dépôt', 1.00, '2014-04-26'),
(9, 1, 'Dépôt', 1.00, '2014-04-26'),
(10, 1, 'Dépôt', 1.00, '2014-04-26'),
(11, 1, 'Dépôt', 1.00, '2014-04-26'),
(12, 1, 'Dépôt', 1.00, '2014-04-26'),
(13, 1, 'Dépôt', 1.00, '2014-04-26'),
(14, 1, 'Dépôt', 1.00, '2014-04-26'),
(15, 1, 'Dépôt', 1.00, '2014-04-26'),
(16, 1, 'Dépôt', 1.00, '2014-04-26'),
(17, 1, 'Dépôt', 1.00, '2014-04-26'),
(18, 1, 'Dépôt', 1.00, '2014-04-26'),
(19, 1, 'Dépôt', 1.00, '2014-04-26'),
(20, 1, 'Dépôt', 1.00, '2014-04-26'),
(21, 1, 'Dépôt', 1.00, '2014-04-26'),
(22, 1, 'Dépôt', 1.00, '2014-04-26'),
(23, 1, 'Dépôt', 1.00, '2014-04-26'),
(24, 1, 'Dépôt', 15.00, '2014-04-26'),
(25, 2, 'Dépôt', 2.00, '2014-04-26'),
(26, 2, 'Dépôt', 0.00, '2014-04-26'),
(27, 2, 'Retrait', 500.00, '2014-04-26'),
(28, 2, 'Dépôt', 0.00, '2014-04-26'),
(29, 2, 'Retrait', 100.00, '2014-04-26'),
(30, 1, 'Dépôt', 0.00, '2014-04-26'),
(31, 1, 'Retrait', 1395.00, '2014-04-26'),
(32, 1, 'Dépôt', 150.00, '2014-04-26'),
(33, 1, 'Dépôt', 0.00, '2014-04-26'),
(34, 1, 'Retrait', 150.00, '2014-04-26'),
(35, 1, 'Dépôt', 0.00, '2014-04-26'),
(36, 1, 'Dépôt', 150.00, '2014-04-26'),
(37, 1, 'Dépôt', 0.00, '2014-04-26'),
(38, 1, 'Retrait', 150.00, '2014-04-26'),
(39, 1, 'Dépôt', 150.00, '2014-04-26'),
(40, 1, 'Dépôt', 150.00, '2014-04-26'),
(41, 1, 'Retrait', 0.00, '2014-04-26'),
(42, 1, 'Dépôt', 150.00, '2014-04-26'),
(43, 1, 'Retrait', 300.00, '2014-04-26'),
(44, 1, 'Dépôt', 0.00, '2014-04-26'),
(45, 1, 'Retrait', 300.00, '2014-04-26'),
(46, 1, 'Dépôt', 0.00, '2014-04-26'),
(47, 1, 'Dépôt', 0.00, '2014-04-26'),
(48, 1, 'Retrait', 10.00, '2014-04-26'),
(49, 1, 'Dépôt', 0.00, '2014-04-26'),
(50, 1, 'Retrait', 10.00, '2014-04-26'),
(51, 1, 'Dépôt', 0.00, '2014-04-26'),
(52, 1, 'Retrait', 10.00, '2014-04-26'),
(53, 1, 'Dépôt', 0.00, '2014-04-26'),
(54, 1, 'Retrait', 10.00, '2014-04-26'),
(55, 1, 'Dépôt', 0.00, '2014-04-26'),
(56, 1, 'Retrait', 10.00, '2014-04-26'),
(57, 1, 'Dépôt', 0.00, '2014-04-26'),
(58, 1, 'Dépôt', 100.00, '2014-04-26'),
(59, 1, 'Retrait', 0.00, '2014-04-26'),
(60, 1, 'Dépôt', 100.00, '2014-04-26'),
(61, 1, 'Retrait', 0.00, '2014-04-26'),
(62, 1, 'Dépôt', 100.00, '2014-04-26'),
(63, 1, 'Dépôt', 100.00, '2014-04-26'),
(64, 1, 'Retrait', 0.00, '2014-04-26'),
(65, 1, 'Dépôt', 0.00, '2014-04-26'),
(66, 1, 'Retrait', 200.00, '2014-04-26'),
(67, 1, 'Dépôt', 0.00, '2014-04-26'),
(68, 1, 'Dépôt', 300.00, '2014-04-26'),
(69, 1, 'Dépôt', 0.00, '2014-04-26'),
(70, 1, 'Retrait', 300.00, '2014-04-26'),
(71, 1, 'Dépôt', 150.00, '2014-04-26'),
(72, 1, 'Retrait', 300.00, '2014-04-26');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `compte_courant`
--
ALTER TABLE `compte_courant`
  ADD CONSTRAINT `compte_courant_ibfk_4` FOREIGN KEY (`TYPE`) REFERENCES `compte` (`TYPE`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `compte_courant_ibfk_1` FOREIGN KEY (`NUMERO`) REFERENCES `compte` (`NUMERO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `compte_courant_ibfk_2` FOREIGN KEY (`NOMTITULAIRE`) REFERENCES `compte` (`NOMTITULAIRE`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `compte_courant_ibfk_3` FOREIGN KEY (`SOLDE`) REFERENCES `compte` (`SOLDE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `compte_epargne`
--
ALTER TABLE `compte_epargne`
  ADD CONSTRAINT `compte_epargne_ibfk_4` FOREIGN KEY (`TYPE`) REFERENCES `compte` (`TYPE`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `compte_epargne_ibfk_1` FOREIGN KEY (`NUMERO`) REFERENCES `compte` (`NUMERO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `compte_epargne_ibfk_2` FOREIGN KEY (`NOMTITULAIRE`) REFERENCES `compte` (`NOMTITULAIRE`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `compte_epargne_ibfk_3` FOREIGN KEY (`SOLDE`) REFERENCES `compte` (`SOLDE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `consultations`
--
ALTER TABLE `consultations`
  ADD CONSTRAINT `consultations_ibfk_1` FOREIGN KEY (`NUMERO_COMPTE`) REFERENCES `compte` (`NUMERO`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
