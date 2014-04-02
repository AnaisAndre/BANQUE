package banque;
public class compte_epargne extends compte
{
	private double taux;
	
	// Constructeur
		public compte_epargne(int no, String nm, double s, double t)
		{
			// Appel au constructeur de la classe mère (compte)
			super(no, nm, s);
			taux = t;		
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
	
	// Modification du taux ?????
	public void mise_a_jour()
	{
		// Changement taux
	}
}
