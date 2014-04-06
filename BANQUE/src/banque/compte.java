package banque;
public class compte
{
	private int numero;
	private String nomTitulaire;
	private double solde;
	
	// Constructeur
	public compte(int no, String nm, double s)
	{
		numero = no;
		nomTitulaire = nm;
		solde = s;
	}
	
	public void consulte()
	{
		// Je consulte
		System.out.println("Bonjour " + nomTitulaire + ", votre compte numéro : " + numero + " à un solde de : " + solde);
	}
	
	// Procédure de dépôt d'argent sur le compte en banque.
	public void deposer(double val)
	{
		solde = solde + val;
		System.out.println("Vous avez déposé : " + val + " euros sur votre compte.");
		System.out.println("Vous avez donc maintenant " + solde + "euros sur votre compte.");
	}
	// Procédure de retrait d'argent sur le compte en banque.
	public void retirer(double val)
	{
		solde = solde - val;
		System.out.println("Vous avez fait un retrait de " + val + " euros.");
		System.out.println("Vous disposez désormais de " + solde + " euros sur votre compte.");
	}
	
	public double getSolde()
	{
		return solde;
	}
	
	public double getNum()
	{
		return numero;
	}
	
	public String getNom()
	{
		return nomTitulaire;
	}
	
	public void setSolde(double newSolde)
	{
		solde = newSolde;
	}
}
