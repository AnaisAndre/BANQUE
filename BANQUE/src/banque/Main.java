package banque;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner saisie = new Scanner(System.in);
		int rep, numC;
		String nomT;
		double soldeBis;
		
		System.out.println("Que d�sirez vous faire comme op�ration ?");
		System.out.println("1- Cr�er un compte bancaire.");
		System.out.println("2- Manipuler un compte bancaire par saisie du num�ro de compte.");
		System.out.println("3- Manipuler l'ensemble des comptes soit courants soit d'�pargne.");
		System.out.println("4- Quitter l'application.");
		System.out.println("R�pondez par 1, 2, 3 ou 4.");
		rep = saisie.nextInt();
		
		while ((rep != 1) && (rep != 2) && (rep != 3) && (rep != 4))
		{
			System.out.println("Vous devez r�pondre par 1, 2, 3 ou 4.");
			rep = saisie.nextInt();
		}
		
		switch (rep)
		{
		case 1:
		{
			System.out.println("Vous allez cr�er un nouveau compte bancaire.");
			System.out.println("Donnez un num�ro au compte.");
			numC = saisie.nextInt();
			System.out.println("Quel est le nom tu titulaire ?");
			nomT = saisie.toString();
			System.out.println("Quel est le solde de d�part ?");
			soldeBis = saisie.nextDouble();
			compte unCompte = new compte(numC,nomT,soldeBis);
			break;
		}
		case 2:
			System.out.println("D�sirez-vous consulter le compte, d�poser ou retirer de l'argent ?");
			System.out.println("R�pondez par C, D ou R");
			break;
		case 3:
			System.out.println("D�sirez-vous consulter le compte, d�poser ou retirer de l'argent ?");
			System.out.println("R�pondez par C, D ou R");
			break;
		case 4:
			System.out.println("A bient�t.");
			break;
		}
	}
}

