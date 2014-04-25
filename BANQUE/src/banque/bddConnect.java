package banque;

import java.sql.*;

public class bddConnect
{
	String url = "jdbc:mysql://localhost:3306/banque?user=root&password=''";
    String utilisateur = "root";
    String motDePasse = "";
	Connection connexion = null;
	Statement statement = null;
	ResultSet resultat = null;
	
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
		} /*finally {
		    if ( resultat != null ) {
		        try {
		             On commence par fermer le ResultSet 
		            resultat.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( statement != null ) {
		        try {
		             Puis on ferme le Statement 
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		             Et enfin on ferme la connexion 
		            connexion.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		}*/
	}
	public void insertionCompte(int num, String nom, double solde, int type)
	{
		/* Exécution d'une requête d'écriture */
        try {
        	//System.out.println("numéro : " + num + " nom : " + nom + " solde : " + solde);
			int statut = statement.executeUpdate( "INSERT INTO compte (NUMERO, NOMTITULAIRE, SOLDE, TYPE) VALUES (" + num + ", " + "'" + nom + "'" + " ," + solde + ", " + type + ");" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("PROBLEME " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void insertionCompteEpargne(int num, String nom, double solde, int type, double taux)
	{
		/* Exécution d'une requête d'écriture */
        try {
        	//System.out.println("numéro : " + num + " nom : " + nom + " solde : " + solde + "taux : " + taux);
			int statut = statement.executeUpdate( "INSERT INTO compte_epargne (NUMERO, NOMTITULAIRE, SOLDE, TYPE, TAUX) VALUES (" + num + ", " + "'" + nom + "'" + " ," + solde + "," + type + "," + taux +");" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("PROBLEME " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void insertionCompteCourant(int num, String nom, double solde, int type, double decouvertAuto)
	{
		/* Exécution d'une requête d'écriture */
        try {
        	//System.out.println("numéro : " + num + " nom : " + nom + " solde : " + solde + "découvert autorisé : " + decouvertAuto);
			int statut = statement.executeUpdate( "INSERT INTO compte_courant (NUMERO, NOMTITULAIRE, SOLDE, TYPE, DECOUVERTAUTORISE) VALUES (" + num + ", " + "'" + nom + "'" + " ," + solde + "," + type + "," + decouvertAuto + ");" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("PROBLEME " + e.getMessage());
			e.printStackTrace();
		}
	}
	
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

			    /* Traiter ici les valeurs récupérées. */
			    //System.out.println("ICI LE NUM : " + numeroCom);
			    //System.out.println("ICI LE SOLDE : " + soldeCom);
			    //System.out.println("ICI LE NOM : " + nomTit);
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
	
	public void deposer(int num, double somme)
	{
		/* Exécution d'une requête d'écriture */
        try {
        	//System.out.println("Nouveau solde : " + somme);
			int statut = statement.executeUpdate("UPDATE compte SET SOLDE = SOLDE + " + somme + " WHERE NUMERO = " + num + ";" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("PROBLEME UPDATE DEPOT " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void retirer(int num, double somme)
	{
		/* Exécution d'une requête d'écriture */
        try {
        	//System.out.println("Nouveau solde : " + somme);
			int statut = statement.executeUpdate("UPDATE compte SET SOLDE = SOLDE - " + somme + " WHERE NUMERO = " + num + ";" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("PROBLEME UPDATE RETRAIT " + e.getMessage());
			e.printStackTrace();
		}
	}
	
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
	
	public void compteEpAndCo()
	{
		String titulaire = "";
		/* Exécution d'une requête de lecture */
		try
		{
			ResultSet resultat = statement.executeQuery( "SELECT compte_epargne.NOMTITULAIRE AS Epargnant, compte_courant.NOMTITULAIRE AS Client FROM compte_epargne, compte_courant WHERE compte_epargne.NOMTITULAIRE = compte_courant.NOMTITULAIRE;" );

			/* Récupération des données du résultat de la requête de lecture */
			while ( resultat.next() )
			{
				titulaire = resultat.getString( "Epargnant" );
			    /* Traiter ici les valeurs récupérées. */
			}
			if (titulaire.equals(""))
			{
				System.out.println("Aucun client ne dispose d'un compte épargne et d'un compte courant.");
			}
			else
			{
				System.out.println(titulaire);
			}
			
		}
			catch (SQLException e)
			{
			// TODO Auto-generated catch block
			System.out.println("PROBLEME SELECT " + e.getMessage());
			e.printStackTrace();
		}
		//return titulaire;
	}
	}
