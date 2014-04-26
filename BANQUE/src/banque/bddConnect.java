package banque;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class bddConnect
{
	String url = "jdbc:mysql://localhost:3306/banque?user=root&password=''";
    String utilisateur = "root";
    String motDePasse = "";
	Connection connexion = null;
	Statement statement = null;
	ResultSet resultat = null;
	
	/**
	 * Constructeur par défaut
	 * Il se charge de la connexion à la base de donnée
	 */
	public bddConnect()
	{
		try
		{
		    /* 
		     * Ouverture de la connexion, initialisation d'un Statement, initialisation d'un ResultSet, etc.
		     */
			connexion = DriverManager.getConnection( url, utilisateur, motDePasse);
			System.out.println("Driver OK");
			/* Création de l'objet gérant les requêtes */
	        statement = connexion.createStatement();
	        System.out.println("Connexion OK");
	        

		}
		catch ( SQLException e )
		{
		    /* Traiter les erreurs éventuelles ici. */
			//System.out.println("TUTUUUU");
			System.out.println("Connection problem " + e.getMessage());
		}
	}
	/**
	 * Procédure d'insertion en base d'un compte
	 * @param num
	 * 		: Envoi du numéro de compte
	 * @param nom
	 * 		: Envoi du nom du titulaire du compte
	 * @param solde
	 * 		: Le solde initial à l'ouverture du compte
	 * @param type
	 * 		: Ce paramètre va nous permettre de connaitre le type de compte (classique, épargne ou courant)
	 */
	public void insertionCompte(int num, String nom, double solde, int type)
	{
		/* Exécution d'une requête d'écriture */
        try {
        	//System.out.println("numéro : " + num + " nom : " + nom + " solde : " + solde);
			int statut = statement.executeUpdate( "INSERT INTO compte (NUMERO, NOMTITULAIRE, SOLDE, TYPE) VALUES (" + num + ", " + "'" + nom + "'" + " ," + solde + ", " + type + ");" );
		} catch (SQLException e) {
			// création de la frame
			JFrame frame = null;
			//fenetre d'erreur
			JOptionPane.showMessageDialog(frame,
			    "Compte existant",
			    "Erreur de création",
			    JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Procédure d'insertion en base d'un compte épargne
	 * @param taux
	 * 		: taux de rémunération du compte
	 * @see insertionCompte
	 */
	public void insertionCompteEpargne(int num, String nom, double solde, int type, double taux)
	{
		/* Exécution d'une requête d'écriture */
        try {
        	//System.out.println("numéro : " + num + " nom : " + nom + " solde : " + solde + "taux : " + taux);
			int statut = statement.executeUpdate( "INSERT INTO compte_epargne (NUMERO, NOMTITULAIRE, SOLDE, TYPE, TAUX) VALUES (" + num + ", " + "'" + nom + "'" + " ," + solde + "," + type + "," + taux +");" );
		} catch (SQLException e) {
			// création de la frame
			JFrame frame = null;
			//fenetre d'erreur
			JOptionPane.showMessageDialog(frame,
			    "Compte existant",
			    "Erreur de création",
			    JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Procédure d'instertion en base d'un compte courant
	 * @param decouvertAuto
	 * 		: Paramètre permettant de connaitre le découvert auquel a le droit le client
	 * @see insertionCompte
	 */
	public void insertionCompteCourant(int num, String nom, double solde, int type, double decouvertAuto)
	{
		/* Exécution d'une requête d'écriture */
        try {
        	//System.out.println("numéro : " + num + " nom : " + nom + " solde : " + solde + "découvert autorisé : " + decouvertAuto);
			int statut = statement.executeUpdate( "INSERT INTO compte_courant (NUMERO, NOMTITULAIRE, SOLDE, TYPE, DECOUVERTAUTORISE) VALUES (" + num + ", " + "'" + nom + "'" + " ," + solde + "," + type + "," + decouvertAuto + ");" );
		} catch (SQLException e) {
			// création de la frame
			JFrame frame = null;
			//fenetre d'erreur
			JOptionPane.showMessageDialog(frame,
			    "Compte existant",
			    "Erreur de création",
			    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Procédure de mise à jour en base du taux de rémunération d'un compte épargne
	 * @param taux
	 * 		: reçoit en paramètre le nouveau taux définit par le banquier
	 * @see insertionCompteEpargne
	 */
	public void mise_a_jour_taux(double taux)
	{
		/* Exécution d'une requête d'écriture */
        try {
        	//System.out.println("Nouveau taux : " + taux);
			int statut = statement.executeUpdate( "UPDATE compte_epargne SET TAUX = " + taux + ";" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("PROBLEME UPDATE TAUX " + e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	 * Procédure de mise à jour d'un découvert autorisé en passant en paramètre
	 * @param num
	 * 		: le numéro de compte du client
	 * @param decouv
	 * 		: le nouveau montant du découvert autorisé
	 * @see insertionCompteCourant
	 */
	public void mise_a_jour_decouvert(int num, double decouv)
	{
		/* Exécution d'une requête d'écriture */
        try {
        	//System.out.println("Nouveau decouvert : " + decouv);
			int statut = statement.executeUpdate( "UPDATE compte_courant SET DECOUVERTAUTORISE = " + decouv + " WHERE NUMERO = " + num + ";" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("PROBLEME UPDATE DECOUVERT " + e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	 * Requête affichant le solde du compte
	 * @param num
	 * @return Le solde du client
	 * 
	 */
	public double consulte(int num)
	{
		 double soldeCom = 0;
		/* Exécution d'une requête de lecture */
		try
		{
			ResultSet resultat = statement.executeQuery( "SELECT NUMERO, SOLDE, NOMTITULAIRE  FROM compte WHERE " + num +" = NUMERO;" );

			/* Récupération des données du résultat de la requête de lecture */
			while ( resultat.next() )
			{
			    int numeroCom = resultat.getInt( "NUMERO" );
			    soldeCom = resultat.getDouble("SOLDE");
			    String nomTit = resultat.getString("NOMTITULAIRE");

			}
		}
			catch (SQLException e)
			{
			// TODO Auto-generated catch block
			System.out.println("PROBLEME SELECT " + e.getMessage());
			e.printStackTrace();
		}
		return soldeCom;
	}
	/**
	 * Requête permettant de déposer une somme entrée par le client.
	 * @param num
	 * 		: Envoi du numéro de compte
	 * @param somme
	 * 		: Envoi de la somme que veut déposer le client
	 */
	public void deposer(int num, double somme)
	{
		/* Exécution d'une requête d'écriture */
        try {
        	//System.out.println("Nouveau solde : " + somme);
			int statut = statement.executeUpdate("UPDATE compte SET SOLDE = SOLDE + " + somme + " WHERE NUMERO = " + num + ";" );
			int statutBis = statement.executeUpdate("INSERT INTO consultations (NUMERO_COMPTE, TYPEOPERATION, MONTANT, DATE) VALUES (" + num + ", 'Dépôt', " + somme + ", NOW());" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("PROBLEME UPDATE DEPOT " + e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	 * Requête permettant d'effectuer un retrait sur le compte du client
	 * @param num
	 * 		: Envoi du numéro de compte
	 * @param somme
	 * 		: Envoi de la somme à retirer
	 */
	public void retirer(int num, double somme)
	{
		/* Exécution d'une requête d'écriture */
        try {
        	//System.out.println("Nouveau solde : " + somme);
			int statut = statement.executeUpdate("UPDATE compte SET SOLDE = SOLDE - " + somme + " WHERE NUMERO = " + num + ";" );
			int statutBis = statement.executeUpdate("INSERT INTO consultations (NUMERO_COMPTE, TYPEOPERATION, MONTANT, DATE) VALUES (" + num + ", 'Retrait', " + somme + ", NOW());" );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("PROBLEME UPDATE RETRAIT " + e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	 * Requête de recherche de type de compte
	 * @param num
	 * 		: Envoi du numéro de compte qui permet la recherche du type de compte (épargne, courant, classique)
	 * @return Le type de compte 1 pour classique 2 pour épargne et 3 pour un compte courant
	 */
	public int recupType(int num)
	{
		int type = 0;
		/* Exécution d'une requête de lecture */
		try
		{
			ResultSet resultat = statement.executeQuery( "SELECT TYPE  FROM compte WHERE " + num +" = NUMERO;" );

			/* Récupération des données du résultat de la requête de lecture */
			while ( resultat.next() )
			{
			    type = resultat.getInt( "TYPE" );
			    /* Traiter ici les valeurs récupérées. */
			}
		}
			catch (SQLException e)
			{
			// TODO Auto-generated catch block
			System.out.println("PROBLEME SELECT " + e.getMessage());
			e.printStackTrace();
		}
		return type;
	}
	/**
	 * Requête permettant de récupéré le taux de rémunération des comptes
	 * @param num
	 * 		: Envoi du numéro de compte afin de pouvoir récupéré le taux de réùunération
	 * @return Le taux de rémunération du compte
	 */
	public double recupTaux(int num)
	{
		double taux = 0;
		/* Exécution d'une requête de lecture */
		try
		{
			ResultSet resultat = statement.executeQuery( "SELECT TAUX  FROM compte_epargne;" );

			/* Récupération des données du résultat de la requête de lecture */
			while ( resultat.next() )
			{
			    taux = resultat.getDouble( "TAUX" );
			    /* Traiter ici les valeurs récupérées. */
			}
		}
			catch (SQLException e)
			{
			// TODO Auto-generated catch block
			System.out.println("PROBLEME SELECT " + e.getMessage());
			e.printStackTrace();
		}
		return taux;
	}
	/**
	 * Requête permettant de récupéré le découvert pour un compte courant
	 * @param num
	 * 		: Envoi du numéro de compte afin de récupérer le découvert
	 * @return Le découvert autorisé pour le compte en cours de consultation
	 */
	public double recupDecouvert(int num)
	{
		double decouvert = 0;
		/* Exécution d'une requête de lecture */
		try
		{
			ResultSet resultat = statement.executeQuery( "SELECT DECOUVERTAUTORISE  FROM compte_courant WHERE NUMERO = " + num + ";" );

			/* Récupération des données du résultat de la requête de lecture */
			while ( resultat.next() )
			{
			    decouvert = resultat.getDouble( "DECOUVERTAUTORISE" );
			    /* Traiter ici les valeurs récupérées. */
			}
		}
			catch (SQLException e)
			{
			// TODO Auto-generated catch block
			System.out.println("PROBLEME SELECT " + e.getMessage());
			e.printStackTrace();
		}
		return decouvert;
	}
	/**
	 * Requête qui va rechercher qui possède un compte épargene et un compte courant
	 * @return Retourne le nom du titulaire des deux comptes
	 */
	public String compteEpAndCo()
	{
		String titulaire = "";
		String result = "";
		/* Exécution d'une requête de lecture */
		try
		{
			ResultSet resultat = statement.executeQuery( "SELECT compte_epargne.NOMTITULAIRE AS Epargnant, compte_courant.NOMTITULAIRE AS Client FROM compte_epargne, compte_courant WHERE compte_epargne.NOMTITULAIRE = compte_courant.NOMTITULAIRE;" );

			/* Récupération des données du résultat de la requête de lecture */
			while ( resultat.next() )
			{
				titulaire = resultat.getString( "Epargnant" );
			    /* Traiter ici les valeurs récupérées. */
				result = (result + "\n" + titulaire); 
			}
			/*if (titulaire.equals(""))
			{
				System.out.println("Aucun client ne dispose d'un compte épargne et d'un compte courant.");
			}
			else
			{
				System.out.println(titulaire);
			}*/
			
		}
			catch (SQLException e)
			{
			// TODO Auto-generated catch block
			System.out.println("PROBLEME SELECT " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Reqête de recherche de tous les clients en découvert
	 * @return Le nom de toutes les personnes étant en découvert
	 */
	public String titulaireEnDecouvert()
	{
		double decouvert;
		String titulaire;
		String result = "";
		/* Exécution d'une requête de lecture */
		try
		{
			ResultSet resultat = statement.executeQuery( "SELECT NOMTITULAIRE, SOLDE  FROM compte_courant WHERE SOLDE < 0;" );

			/* Récupération des données du résultat de la requête de lecture */
			while ( resultat.next() )
			{
			    decouvert = resultat.getDouble( "SOLDE" );
			    titulaire = resultat.getString( "NOMTITULAIRE" );
			    /* Traiter ici les valeurs récupérées. */
			    //System.out.println(decouvert + " : " + titulaire);
			    result = (result + "\n" + decouvert+" " + titulaire);
			}
		}
			catch (SQLException e)
			{
			// TODO Auto-generated catch block
			System.out.println("PROBLEME SELECT " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * Requête permettant d'afficher l'historique d'un compte
	 * @param num
	 * 		: Envoi du numéro de compte afin de trouver toutes les opération lié au compte en cours de consultation
	 * @return Tous les dépôts ou retraits effectués par le client
	 */
	public String afficheConsulations(int num)
	{
		double numero;
		String typeOp;
		double montant;
		Date date;
		String result = "";
		/* Exécution d'une requête de lecture */
		try
		{
			ResultSet resultat = statement.executeQuery( "SELECT NUMERO, TYPEOPERATION, MONTANT, DATE  FROM consultations WHERE NUMERO_COMPTE = " + num +";" );

			/* Récupération des données du résultat de la requête de lecture */
			while ( resultat.next() )
			{
				numero = resultat.getInt( "NUMERO" );
				typeOp = resultat.getString( "TYPEOPERATION" );
				montant = resultat.getDouble( "MONTANT" );
				date = resultat.getDate( "DATE" );
			    /* Traiter ici les valeurs récupérées. */
			    //System.out.println(decouvert + " : " + titulaire);
				result = result + "\n" + (String.valueOf(numero) + "   " + typeOp + "   " + String.valueOf(montant) + "   " + String.valueOf(date));
			}
		}
			catch (SQLException e)
			{
			// TODO Auto-generated catch block
			System.out.println("PROBLEME SELECT " + e.getMessage());
			e.printStackTrace();
		}
		//return decouvert;
		return result;
	}
	}
