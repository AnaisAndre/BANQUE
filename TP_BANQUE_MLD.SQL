DROP DATABASE IF EXISTS Banque;

CREATE DATABASE IF NOT EXISTS Banque;
USE Banque;
# -----------------------------------------------------------------------------
#       TABLE : COMPTE_COURANT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COMPTE_COURANT
 (
   NUMERO INTEGER NOT NULL  ,
   DECOUVERTAUTORISE DECIMAL(5,2) NULL  ,
   NOMTITULAIRE CHAR(20) NULL  ,
   SOLDE DECIMAL(10,2) NULL  
   , PRIMARY KEY (NUMERO) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : COMPTE_EPARGNE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COMPTE_EPARGNE
 (
   NUMERO INTEGER NOT NULL  ,
   TAUX DECIMAL(5,2) NULL  ,
   NOMTITULAIRE CHAR(20) NULL  ,
   SOLDE DECIMAL(10,2) NULL  
   , PRIMARY KEY (NUMERO) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : COMPTE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COMPTE
 (
   NUMERO INTEGER NOT NULL  ,
   NOMTITULAIRE CHAR(20) NULL  ,
   SOLDE DECIMAL(10,2) NULL  
   , PRIMARY KEY (NUMERO) 
 ) 
 comment = "";


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE COMPTE_COURANT 
  ADD FOREIGN KEY FK_COMPTE_COURANT_COMPTE (NUMERO)
      REFERENCES COMPTE (NUMERO) ;


ALTER TABLE COMPTE_EPARGNE 
  ADD FOREIGN KEY FK_COMPTE_EPARGNE_COMPTE (NUMERO)
      REFERENCES COMPTE (NUMERO) ;

