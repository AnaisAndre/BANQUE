package banque;
public class compte_courant extends compte
{
	private double decouvertAutorise, soldeBIS;
	
	// Constructeur
	public compte_courant(int no, String nm, double s, double d)
	{
		// Appel au constructeur de la classe mère (compte)
		super(no, nm, s);
		decouvertAutorise = d;		
	}
	
	// Consultation du solde du compte et du taux.
	public void consulte()
	{
		System.out.println("Bonjour " + super.getNom() + ", votre compte numéro : " + super.getNum() + " à un solde de : " + super.getSolde());
		System.out.println("Vous disposez d'une autorisation de découvert de : " + decouvertAutorise + " euros.");
	}
	
	// Procédure de dépôt d'argent sur le compte courant.
	public void deposer(double val)
	{
		soldeBIS = super.getSolde() + val;
		System.out.println("Vous avez déposé : " + val + " euros sur votre compte.");
		System.out.println("Vous avez donc maintenant " + soldeBIS + " euros sur votre compte.");
		super.setSolde(soldeBIS);
	}
	
	// Procédure de retrait d'argent sur le compte courant.
	public void retirer(double val)
	{
		soldeBIS = super.getSolde() - val;
		System.out.println("Vous avez retiré : " + val + " euros de votre compte.");
		System.out.println("Vous avez donc maintenant " + soldeBIS + " euros sur votre compte.");
		super.setSolde(soldeBIS);
	}
}
