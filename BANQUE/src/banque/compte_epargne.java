package banque;
import java.util.Scanner;

public class compte_epargne extends compte
{
	Scanner saisie = new Scanner(System.in);
	private double taux, soldeBIS;
	
	// Constructeur
	public compte_epargne(int no, String nm, double s, double t)
	{
		// Appel au constructeur de la classe mère (compte)
		super(no, nm, s);
		taux = t;
	}
	
	// Consultation du solde du compte et du taux.
	public void consulte()
	{
		System.out.println("Bonjour " + super.getNom() + ", votre compte numéro : " + super.getNum() + " à un solde de : " + super.getSolde());
		System.out.println("Vous disposez d'un taux de : " + taux + " %.");
	}
	
	// Procédure de dépôt d'argent sur le compte épargne.
	public void deposer(double val)
	{
		soldeBIS = super.getSolde() + val;
		System.out.println("Vous avez déposé : " + val + " euros sur votre compte.");
		System.out.println("Vous avez donc maintenant " + soldeBIS + " euros sur votre compte.");
		super.setSolde(soldeBIS);
	}
	
	
	// Procédure de retrait d'argent sur le compte épargne.
	public void retirer(double val)
	{
		soldeBIS = super.getSolde() - val;
		System.out.println("Vous avez retiré : " + val + " euros de votre compte.");
		System.out.println("Vous avez donc maintenant " + soldeBIS + " euros sur votre compte.");
		super.setSolde(soldeBIS);
	}
	
	// Modification du taux ?????
	public void mise_a_jour()
	{
		System.out.println("Quel est le nouveau taux ?");
		taux = saisie.nextDouble();
	}
}
