-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Ven 25 Avril 2014 à 15:50
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
(1, 'Azerty', 110.00, 3),
(2, 'Qsdfgh', 2500.00, 2),
(3, 'Wxcvbn', 150.00, 1),
(4, 'Tutu', 600.00, 2);

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
(1, 200.00, 'Azerty', 110.00, 3);

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
(2, 25.00, 'Qsdfgh', 2500.00, 2),
(4, 25.00, 'Tutu', 600.00, 2);

-- --------------------------------------------------------

--
-- Structure de la table `consultations`
--

CREATE TABLE IF NOT EXISTS `consultations` (
  `NUMERO` int(11) NOT NULL,
  `NUMERO_COMPOSITION` int(11) NOT NULL,
  `TYPEOPERATION` smallint(6) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  PRIMARY KEY (`NUMERO`),
  KEY `I_FK_CONSULTATIONS_COMPTE` (`NUMERO_COMPOSITION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  ADD CONSTRAINT `consultations_ibfk_1` FOREIGN KEY (`NUMERO_COMPOSITION`) REFERENCES `compte` (`NUMERO`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
