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
	
	public void consulte()
	{
		// Je consulte.
	}
	
	// Procédure de dépôt d'argent sur le compte épargne.
	public void deposer(double val)
	{
		soldeBIS = super.getSolde() + val;
		System.out.println("Vous avez déposé : " + val + " euros sur votre compte.");
		System.out.println("Vous avez donc maintenant " + soldeBIS + " euros sur votre compte.");
		super.setSolde(soldeBIS);
	}
	
	public double retirer(double val)
	{
		// Je retire
	}
}
