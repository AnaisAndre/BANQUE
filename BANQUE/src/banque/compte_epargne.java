package banque;
public class compte_epargne extends compte
{
	private double taux, soldeBIS;
	
	// Constructeur
		public compte_epargne(int no, String nm, double s, double t)
		{
			// Appel au constructeur de la classe m�re (compte)
			super(no, nm, s);
			taux = t;
		}
		
		public void consulte()
		{
			// Je consulte
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
	
	// Modification du taux ?????
	public void mise_a_jour()
	{
		// Changement taux
	}
}
