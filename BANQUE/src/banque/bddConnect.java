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
			System.out.println("TUTUUUU");
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
	public void insertionCompte(int num, String nom, double solde)
	{
		/* Exécution d'une requête d'écriture */
        try {
        	System.out.println("numéro : " + num + " nom : " + nom + " solde : " + solde);
			int statut = statement.executeUpdate( "INSERT INTO compte (NUMERO, NOMTITULAIRE, SOLDE) VALUES (" + num + ", " + "'" + nom + "'" + " ," + solde + ");" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("PROBLEME " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void insertionCompteEpargne(int num, String nom, double solde, double taux)
	{
		/* Exécution d'une requête d'écriture */
        try {
        	System.out.println("numéro : " + num + " nom : " + nom + " solde : " + solde + "taux : " + taux);
			int statut = statement.executeUpdate( "INSERT INTO compte_epargne (NUMERO, NOMTITULAIRE, SOLDE, TAUX) VALUES (" + num + ", " + "'" + nom + "'" + " ," + solde + "," + taux + ");" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("PROBLEME " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void insertionCompteCourant(int num, String nom, double solde, double decouvertAuto)
	{
		/* Exécution d'une requête d'écriture */
        try {
        	System.out.println("numéro : " + num + " nom : " + nom + " solde : " + solde + "découvert autorisé : " + decouvertAuto);
			int statut = statement.executeUpdate( "INSERT INTO compte_courant (NUMERO, NOMTITULAIRE, SOLDE, DECOUVERTAUTORISE) VALUES (" + num + ", " + "'" + nom + "'" + " ," + solde + "," + decouvertAuto + ");" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("PROBLEME " + e.getMessage());
			e.printStackTrace();
		}
	}
	}
