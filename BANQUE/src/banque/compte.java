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
		System.out.println("Bonjour " + nomTitulaire + ", votre compte num�ro : " + numero + " � un solde de : " + solde);
	}
	
	// Proc�dure de d�p�t d'argent sur le compte en banque.
	public void deposer(double val)
	{
		solde = solde + val;
		System.out.println("Vous avez d�pos� : " + val + " euros sur votre compte.");
		System.out.println("Vous avez donc maintenant " + solde + "euros sur votre compte.");
	}
	// Proc�dure de retrait d'argent sur le compte en banque.
	public void retirer(double val)
	{
		solde = solde - val;
		System.out.println("Vous avez fait un retrait de " + val + " euros.");
		System.out.println("Vous disposez d�sormais de " + solde + " euros sur votre compte.");
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
