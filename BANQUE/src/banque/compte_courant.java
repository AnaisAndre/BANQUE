package banque;
public class compte_courant extends compte
{
	private double decouvertAutorise;
	
	// Constructeur
	public compte_courant(int no, String nm, double s, double d)
	{
		// Appel au constructeur de la classe mère (compte)
		super(no, nm, s);
		decouvertAutorise = d;		
	}
	
	public void consulte()
	{
		// Je consulte
	}
	
	public double deposer(double val)
	{
		// Je dépose
	}
	
	public double retirer(double val)
	{
		// Je retire
	}
}
