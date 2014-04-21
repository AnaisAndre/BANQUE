package banque;
import java.util.Scanner;

public class compte_epargne extends compte
{
	Scanner saisie = new Scanner(System.in);
	private double taux, soldeBIS;
	//genre ici on met la connexion � la base
	
	// Constructeur par defaut
	public compte_epargne()
	{
		// Appel au constructeur de la classe m�re (compte)
		super();
		taux = 0;
	}
	
	// Constructeur
	public compte_epargne(int no, String nm, double s, double t)
	{
		// Appel au constructeur de la classe m�re (compte)
		super(no, nm, s);
		taux = t;
	}
	
	// Consultation du solde du compte et du taux.
	public void consulte()
	{
		//ici on met la requ�te pour afficher le solde ce qui va donner dans le main
		System.out.println("Bonjour " + super.getNom() + ", votre compte num�ro : " + super.getNum() + " � un solde de : " + super.getSolde());
		System.out.println("Vous disposez d'un taux de : " + taux + " %.");
	}
	
	// Proc�dure de d�p�t d'argent sur le compte �pargne.
	public void deposer(double val)
	{
		soldeBIS = super.getSolde() + val;
		System.out.println("Vous avez d�pos� : " + val + " euros sur votre compte.");
		System.out.println("Vous avez donc maintenant " + soldeBIS + " euros sur votre compte.");
		super.setSolde(soldeBIS);
	}
	
	
	// Proc�dure de retrait d'argent sur le compte �pargne.
	public void retirer(double val)
	{
		soldeBIS = super.getSolde() - val;
		System.out.println("Vous avez retir� : " + val + " euros de votre compte.");
		System.out.println("Vous avez donc maintenant " + soldeBIS + " euros sur votre compte.");
		super.setSolde(soldeBIS);
	}
	
	// Modification du taux ?????
	public void mise_a_jour(double val)
	{
		taux = val;
	}
}
