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
		
		System.out.println("Que désirez vous faire comme opération ?");
		System.out.println("1- Créer un compte bancaire.");
		System.out.println("2- Manipuler un compte bancaire par saisie du numéro de compte.");
		System.out.println("3- Manipuler l'ensemble des comptes soit courants soit d'épargne.");
		System.out.println("4- Quitter l'application.");
		System.out.println("Répondez par 1, 2, 3 ou 4.");
		rep = saisie.nextInt();
		
		while ((rep != 1) && (rep != 2) && (rep != 3) && (rep != 4))
		{
			System.out.println("Vous devez répondre par 1, 2, 3 ou 4.");
			rep = saisie.nextInt();
		}
		
		switch (rep)
		{
		case 1:
		{
			System.out.println("Vous allez créer un nouveau compte bancaire.");
			System.out.println("Donnez un numéro au compte.");
			numC = saisie.nextInt();
			System.out.println("Quel est le nom tu titulaire ?");
			nomT = saisie.toString();
			System.out.println("Quel est le solde de départ ?");
			soldeBis = saisie.nextDouble();
			compte unCompte = new compte(numC,nomT,soldeBis);
			break;
		}
		case 2:
			System.out.println("Désirez-vous consulter le compte, déposer ou retirer de l'argent ?");
			System.out.println("Répondez par C, D ou R");
			break;
		case 3:
			System.out.println("Désirez-vous consulter le compte, déposer ou retirer de l'argent ?");
			System.out.println("Répondez par C, D ou R");
			break;
		case 4:
			System.out.println("A bientôt.");
			break;
		}
	}
}

