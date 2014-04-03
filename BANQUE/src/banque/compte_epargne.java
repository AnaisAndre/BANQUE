package banque;
public class compte_epargne extends compte
{
	private double taux, soldeBIS;
	
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
	
	// Modification du taux ?????
	public void mise_a_jour()
	{
		// Changement taux
	}
}
