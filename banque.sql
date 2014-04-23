-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mer 23 Avril 2014 à 09:11
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
  KEY `SOLDE` (`SOLDE`),
  KEY `TYPE` (`TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  KEY `DECOUVERTAUTORISE` (`DECOUVERTAUTORISE`),
  KEY `DECOUVERTAUTORISE_2` (`DECOUVERTAUTORISE`),
  KEY `NOMTITULAIRE` (`NOMTITULAIRE`),
  KEY `SOLDE` (`SOLDE`),
  KEY `TYPE` (`TYPE`),
  KEY `DECOUVERTAUTORISE_3` (`DECOUVERTAUTORISE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `compte_epargne`
--

CREATE TABLE IF NOT EXISTS `compte_epargne` (
  `NUMERO` int(10) NOT NULL,
  `TAUX` double(3,2) DEFAULT NULL,
  `NOMTITULAIRE` varchar(30) DEFAULT NULL,
  `SOLDE` double(10,2) DEFAULT NULL,
  `TYPE` int(1) DEFAULT NULL,
  PRIMARY KEY (`NUMERO`),
  KEY `NOMTITULAIRE` (`NOMTITULAIRE`),
  KEY `SOLDE` (`SOLDE`),
  KEY `TYPE` (`TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `consultations`
--

CREATE TABLE IF NOT EXISTS `consultations` (
  `NUMERO` int(10) NOT NULL AUTO_INCREMENT,
  `TYPEOPERATION` int(1) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `NUMCOMPTE` int(10) NOT NULL,
  PRIMARY KEY (`NUMERO`),
  KEY `NUMCOMPTE` (`NUMCOMPTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

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
  ADD CONSTRAINT `consultations_ibfk_1` FOREIGN KEY (`NUMCOMPTE`) REFERENCES `compte` (`NUMERO`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
