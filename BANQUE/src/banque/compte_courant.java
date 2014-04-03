package banque;
public class compte_courant extends compte
{
	private double decouvertAutorise, soldeBIS;
	
	// Constructeur
	public compte_courant(int no, String nm, double s, double d)
	{
		// Appel au constructeur de la classe m�re (compte)
		super(no, nm, s);
		decouvertAutorise = d;		
	}
	
	public void consulte()
	{
		// Je consulte.
	}
	
	// Proc�dure de d�p�t d'argent sur le compte �pargne.
	public void deposer(double val)
	{
		soldeBIS = super.getSolde() + val;
		System.out.println("Vous avez d�pos� : " + val + " euros sur votre compte.");
		System.out.println("Vous avez donc maintenant " + soldeBIS + " euros sur votre compte.");
		super.setSolde(soldeBIS);
	}
	
	public double retirer(double val)
	{
		// Je retire
	}
}
