package banque;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Banquier extends JPanel 
{
	private JTextField textFieldNom;
	private JTextField textFieldNum1;
	private JTextField textFieldNum2;
	private JTextField textFieldSoldeI;
	private JTextField textFieldNouvTx;
	private JTextField textFieldDecouAut;
	private JTextField textFieldNouvDe;
	private JTextField textFieldTauxActu;
	private JTextField textFieldDecouvActu;
	private GridBagConstraints gbc_textFieldTauxActu;
	private GridBagConstraints gbc_textFieldDecouvActu;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	int numCom = 0;
	int type = 0;
	private JTextField textField;
	private JTextArea textArea;
	private JTextArea textArea_1;

	bddConnect base = new bddConnect();
	
	String titEnDecouvert;
	String titCompteEpAndCo;
	

	/**
	 * Create the panel.
	 */
	public Banquier()
	{
		setBackground(Color.PINK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {150, 150, 0, 150, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		setLayout(gridBagLayout);
		
		JLabel lblBanquier = new JLabel("BANQUIER");
		lblBanquier.setFont(new Font("Urdu Typesetting", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_lblBanquier = new GridBagConstraints();
		gbc_lblBanquier.insets = new Insets(0, 0, 5, 5);
		gbc_lblBanquier.gridx = 0;
		gbc_lblBanquier.gridy = 0;
		add(lblBanquier, gbc_lblBanquier);
		
		
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 2;
		gbc_separator.gridy = 1;
		add(separator, gbc_separator);
		
		
		// Un label CREER UN COMPTE
		JLabel lblCrerUnCompte = new JLabel("Cr\u00E9er un compte");
		lblCrerUnCompte.setFont(new Font("Georgia", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCrerUnCompte = new GridBagConstraints();
		gbc_lblCrerUnCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrerUnCompte.gridx = 0;
		gbc_lblCrerUnCompte.gridy = 2;
		add(lblCrerUnCompte, gbc_lblCrerUnCompte);
		
		
		// Un label
		JLabel lblNom = new JLabel("NOM ");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 0;
		gbc_lblNom.gridy = 3;
		add(lblNom, gbc_lblNom);
		
		// textField récupérant le nom pour la création du compte
		textFieldNom = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		add(textFieldNom, gbc_textField);
		textFieldNom.setColumns(10);
		
		
		// Un label
		JLabel lblNumroDeCompte = new JLabel("Num\u00E9ro de compte");
		GridBagConstraints gbc_lblNumroDeCompte = new GridBagConstraints();
		gbc_lblNumroDeCompte.anchor = GridBagConstraints.EAST;
		gbc_lblNumroDeCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumroDeCompte.gridx = 0;
		gbc_lblNumroDeCompte.gridy = 4;
		add(lblNumroDeCompte, gbc_lblNumroDeCompte);
		
		// textField récupérant le numéro de compte pour la CREATION du compte
		textFieldNum1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		add(textFieldNum1, gbc_textField_1);
		textFieldNum1.setColumns(10);
		
		
		// Un label
		JLabel lblSoldeInitial = new JLabel("Solde initial");
		GridBagConstraints gbc_lblSoldeInitial = new GridBagConstraints();
		gbc_lblSoldeInitial.anchor = GridBagConstraints.EAST;
		gbc_lblSoldeInitial.insets = new Insets(0, 0, 5, 5);
		gbc_lblSoldeInitial.gridx = 0;
		gbc_lblSoldeInitial.gridy = 5;
		add(lblSoldeInitial, gbc_lblSoldeInitial);
		
		// textField récupérant le solde pour la création du compte
		textFieldSoldeI = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 5;
		add(textFieldSoldeI, gbc_textField_2);
		textFieldSoldeI.setColumns(10);
		GridBagConstraints gbc_textField3;
		
		
		// Un label
		JLabel lblCeCompteEstil = new JLabel("Ce compte est-il :");
		GridBagConstraints gbc_lblCeCompteEstil = new GridBagConstraints();
		gbc_lblCeCompteEstil.anchor = GridBagConstraints.EAST;
		gbc_lblCeCompteEstil.insets = new Insets(0, 0, 5, 5);
		gbc_lblCeCompteEstil.gridx = 0;
		gbc_lblCeCompteEstil.gridy = 6;
		add(lblCeCompteEstil, gbc_lblCeCompteEstil);
		
		// Bouton radio du compte COURANT
		final JRadioButton rdbtnCourant = new JRadioButton("Courant    ");
		buttonGroup.add(rdbtnCourant);
		GridBagConstraints gbc_rdbtnCourant = new GridBagConstraints();
		gbc_rdbtnCourant.anchor = GridBagConstraints.WEST;
		gbc_rdbtnCourant.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCourant.gridx = 1;
		gbc_rdbtnCourant.gridy = 6;
		add(rdbtnCourant, gbc_rdbtnCourant);
		
		// Bouton radio du compte EPARGNE
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Epargne   ");
		buttonGroup.add(rdbtnNewRadioButton);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 7;
		add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		GridBagConstraints gbc_textField_5;
		
		// Bouton radio du compte CLASSIQUE
		final JRadioButton rdbtnClassique = new JRadioButton("Classique");
		buttonGroup.add(rdbtnClassique);
		GridBagConstraints gbc_rdbtnClassique = new GridBagConstraints();
		gbc_rdbtnClassique.anchor = GridBagConstraints.WEST;
		gbc_rdbtnClassique.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnClassique.gridx = 1;
		gbc_rdbtnClassique.gridy = 8;
		add(rdbtnClassique, gbc_rdbtnClassique);
		
		
		// Un label
		JLabel lblDcouvertAutoris = new JLabel("D\u00E9couvert autoris\u00E9");
		GridBagConstraints gbc_lblDcouvertAutoris = new GridBagConstraints();
		gbc_lblDcouvertAutoris.anchor = GridBagConstraints.EAST;
		gbc_lblDcouvertAutoris.insets = new Insets(0, 0, 5, 5);
		gbc_lblDcouvertAutoris.gridx = 0;
		gbc_lblDcouvertAutoris.gridy = 10;
		add(lblDcouvertAutoris, gbc_lblDcouvertAutoris);
		
		// textField permettant de définir le découvert autorisé lors de la création du compte courant
		textFieldDecouAut = new JTextField();
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.anchor = GridBagConstraints.WEST;
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.gridx = 1;
		gbc_textField_8.gridy = 10;
		add(textFieldDecouAut, gbc_textField_8);
		textFieldDecouAut.setColumns(10);
		
		
		
		// Un label MANIPULER UN COMPTE
		JLabel lblModifierLeTaux = new JLabel("Manipuler un compte");
		lblModifierLeTaux.setFont(new Font("Georgia", Font.PLAIN, 14));
		GridBagConstraints gbc_lblModifierLeTaux = new GridBagConstraints();
		gbc_lblModifierLeTaux.anchor = GridBagConstraints.EAST;
		gbc_lblModifierLeTaux.insets = new Insets(0, 0, 5, 5);
		gbc_lblModifierLeTaux.gridx = 3;
		gbc_lblModifierLeTaux.gridy = 2;
		add(lblModifierLeTaux, gbc_lblModifierLeTaux);
		
		
		// Un label
		JLabel lblNDuCompte = new JLabel("N\u00B0 du compte");
		GridBagConstraints gbc_lblNDuCompte = new GridBagConstraints();
		gbc_lblNDuCompte.anchor = GridBagConstraints.EAST;
		gbc_lblNDuCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblNDuCompte.gridx = 3;
		gbc_lblNDuCompte.gridy = 3;
		add(lblNDuCompte, gbc_lblNDuCompte);
		
		// textField récupérant le numéro de compte pour MANIPULER le compte
		textFieldNum2 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 2;
		gbc_textField_4.anchor = GridBagConstraints.WEST;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 4;
		gbc_textField_4.gridy = 3;
		add(textFieldNum2, gbc_textField_4);
		textFieldNum2.setColumns(10);
		
		
		// Un label
		JLabel lblTypeDeCompte = new JLabel("Type de compte");
		GridBagConstraints gbc_lblTypeDeCompte = new GridBagConstraints();
		gbc_lblTypeDeCompte.anchor = GridBagConstraints.EAST;
		gbc_lblTypeDeCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblTypeDeCompte.gridx = 3;
		gbc_lblTypeDeCompte.gridy = 5;
		add(lblTypeDeCompte, gbc_lblTypeDeCompte);
		
		// textField permettant l'affichage du type de compte pour la manipulation du compte.
		// Ce champ se remplit seul, pas de modif de la part du banquier.
		textField = new JTextField();
		GridBagConstraints gbc_textField1 = new GridBagConstraints();
		gbc_textField1.anchor = GridBagConstraints.WEST;
		gbc_textField1.insets = new Insets(0, 0, 5, 5);
		gbc_textField1.gridx = 4;
		gbc_textField1.gridy = 5;
		add(textField, gbc_textField1);
		textField.setColumns(10);
		
		
		// Un label
		JLabel lblTauxActuel = new JLabel("Taux actuel");
		GridBagConstraints gbc_lblTauxActuel = new GridBagConstraints();
		gbc_lblTauxActuel.anchor = GridBagConstraints.EAST;
		gbc_lblTauxActuel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTauxActuel.gridx = 3;
		gbc_lblTauxActuel.gridy = 6;
		add(lblTauxActuel, gbc_lblTauxActuel);
		
		// textField permettant d'afficher le taux du compte en cours de manipulation
		textFieldTauxActu = new JTextField();
		gbc_textFieldTauxActu = new GridBagConstraints();
		gbc_textFieldTauxActu.anchor = GridBagConstraints.WEST;
		gbc_textFieldTauxActu.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTauxActu.gridx = 4;
		gbc_textFieldTauxActu.gridy = 6;
		add(textFieldTauxActu, gbc_textFieldTauxActu);
		textFieldTauxActu.setColumns(10);

		
		// Un label
		JLabel lblNouveauTauxDe = new JLabel("Nouveau taux de r\u00E9mun\u00E9ration");
		GridBagConstraints gbc_lblNouveauTauxDe = new GridBagConstraints();
		gbc_lblNouveauTauxDe.anchor = GridBagConstraints.EAST;
		gbc_lblNouveauTauxDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblNouveauTauxDe.gridx = 3;
		gbc_lblNouveauTauxDe.gridy = 7;
		add(lblNouveauTauxDe, gbc_lblNouveauTauxDe);
		
		// textField permettant de définir le nouveau taux lors de la manipulation d'un compte
		textFieldNouvTx = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 4;
		gbc_textField_3.gridy = 7;
		add(textFieldNouvTx, gbc_textField_3);
		textFieldNouvTx.setColumns(10);
		
		
		// Un label
		JLabel lblDcouvertActuel = new JLabel("D\u00E9couvert actuel");
		GridBagConstraints gbc_lblDcouvertActuel = new GridBagConstraints();
		gbc_lblDcouvertActuel.anchor = GridBagConstraints.EAST;
		gbc_lblDcouvertActuel.insets = new Insets(0, 0, 5, 5);
		gbc_lblDcouvertActuel.gridx = 3;
		gbc_lblDcouvertActuel.gridy = 8;
		add(lblDcouvertActuel, gbc_lblDcouvertActuel);
		
		// textField permettant d'afficher le découvert autorisé du compte en cours de manipulation
		textFieldDecouvActu = new JTextField();
		gbc_textFieldDecouvActu = new GridBagConstraints();
		gbc_textFieldDecouvActu.anchor = GridBagConstraints.WEST;
		gbc_textFieldDecouvActu.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDecouvActu.gridx = 4;
		gbc_textFieldDecouvActu.gridy = 8;
		add(textFieldDecouvActu, gbc_textFieldDecouvActu);
		textFieldDecouvActu.setColumns(10);
		
		
		// Un label
		JLabel lblNouveauDcouvert = new JLabel("Nouveau d\u00E9couvert");
		GridBagConstraints gbc_lblNouveauDcouvert = new GridBagConstraints();
		gbc_lblNouveauDcouvert.anchor = GridBagConstraints.EAST;
		gbc_lblNouveauDcouvert.insets = new Insets(0, 0, 5, 5);
		gbc_lblNouveauDcouvert.gridx = 3;
		gbc_lblNouveauDcouvert.gridy = 9;
		add(lblNouveauDcouvert, gbc_lblNouveauDcouvert);
		
		// textField permettant de récupérer le nouveau découvert défini lors de la manipulation du compte
		textFieldNouvDe = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.anchor = GridBagConstraints.WEST;
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.gridx = 4;
		gbc_textField_6.gridy = 9;
		add(textFieldNouvDe, gbc_textField_6);
		textFieldNouvDe.setColumns(10);
		
		
		
		// Un label TITULAIRES D'UN COMPTE EPARGNE ET D'UN COMPTE COURANT
		JLabel lblClientsDisposantsDun = new JLabel("Clients disposants d'un compte \u00E9pargne et d'un compte courant");
		GridBagConstraints gbc_lblClientsDisposantsDun = new GridBagConstraints();
		gbc_lblClientsDisposantsDun.gridwidth = 2;
		gbc_lblClientsDisposantsDun.insets = new Insets(0, 0, 5, 5);
		gbc_lblClientsDisposantsDun.gridx = 0;
		gbc_lblClientsDisposantsDun.gridy = 12;
		add(lblClientsDisposantsDun, gbc_lblClientsDisposantsDun);
		
		// textArea permettant l'affichage des titulaires possédants un compte épargne ET un compte courant
		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 13;
		add(textArea, gbc_textArea);
		textArea.setEditable(false);
		
		// Permet le défilement du textArea --> Titulaire compte épargne + compte courant
		JScrollPane scrollPane = new JScrollPane(textArea);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 13;
		add(scrollPane, gbc_scrollPane);
		
		
		// Un label TITULAIRES EN DECOUVERT
		JLabel lblClientsEnDcouvert = new JLabel("Clients en d\u00E9couvert");
		GridBagConstraints gbc_lblClientsEnDcouvert = new GridBagConstraints();
		gbc_lblClientsEnDcouvert.gridwidth = 2;
		gbc_lblClientsEnDcouvert.insets = new Insets(0, 0, 5, 5);
		gbc_lblClientsEnDcouvert.gridx = 3;
		gbc_lblClientsEnDcouvert.gridy = 12;
		add(lblClientsEnDcouvert, gbc_lblClientsEnDcouvert);
		
		// textArea permettant l'affichage des titulaires en découvert
		textArea_1 = new JTextArea();
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.insets = new Insets(0, 0, 0, 5);
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 4;
		gbc_textArea_1.gridy = 13;
		add(textArea_1, gbc_textArea_1);
		textArea_1.setEditable(false);
		
		// Permet le défilement du textArea_1 --> Titulaires en découvert
		JScrollPane scrollPane_1 = new JScrollPane(textArea_1);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 3;
		gbc_scrollPane_1.gridy = 13;
		add(scrollPane_1, gbc_scrollPane_1);
		
		
		
		
		// CREATION COMPTE
		JButton btnCrer = new JButton("Cr\u00E9er");
		btnCrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				// Récupération des valeurs des textField
				String name = textFieldNom.getText();
				
				String tempo = textFieldNum1.getText(); // Récupération du champ dans une variable temporaire de type String
				int numCom = Integer.parseInt(tempo);  // Conversion de la variable temporaire en int
				
				tempo = textFieldSoldeI.getText();
				double numSol = Double.parseDouble(tempo);
				
				// Le taux est récupéré dans la base à partir des lignes déjà présentes car il est fixe
				// Si aucune ligne --> taux = 0.0 %
				double taux = base.recupTaux(numCom);
				
				// Cas bouton radio de compte épargne
				if (rdbtnNewRadioButton.isSelected())
				{
					// Définition du type
					type = 2;
					
					// Insertion dans la table compte ET la table compte_epargne
					base.insertionCompte(numCom, name, numSol, type);
					base.insertionCompteEpargne(numCom, name, numSol, type, taux);
				}
				
				// Cas du bouton radio de compte courant
				else if (rdbtnCourant.isSelected())
				{
					// Récupération du découvert autorisé défini lors de la création
					tempo = textFieldDecouAut.getText();
					double decouvert = Double.parseDouble(tempo);
					
					// Définition du type
					type = 3;

					// Insertion dans la table compte et compte_courant
					base.insertionCompte(numCom, name, numSol, type);
					base.insertionCompteCourant(numCom, name, numSol, type, decouvert);
				}
				
				else // Ici, le cas d'un compte classique
				{
					//Définition du type
					type = 1;

					// Insertion dans la table compte UNIQUEMENT
					base.insertionCompte(numCom, name, numSol, type);
				}
				
				// Remise à zéro des textField et boutons radio.
				textFieldNom.setText("");
				textFieldNum1.setText("");
				textFieldSoldeI.setText("");
				textFieldDecouAut.setText("");
				buttonGroup.clearSelection();
			}
		});
		GridBagConstraints gbc_btnCrer = new GridBagConstraints();
		gbc_btnCrer.anchor = GridBagConstraints.WEST;
		gbc_btnCrer.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrer.gridx = 1;
		gbc_btnCrer.gridy = 11;
		add(btnCrer, gbc_btnCrer);
		
		
		
		// CONNEXION AU COMPTE
		JButton btnModifier = new JButton("Connexion au compte");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				// Récupération du numéro de compte auquel se connecter
				String tempo = textFieldNum2.getText();
				numCom = Integer.parseInt(tempo);
				
				// Récupère le type de compte auquel appartient le compte sur lequel on est connecté
				type = base.recupType(numCom);
				
				switch (type)
				{
				// Cas compte classique
				case 1 :
					textFieldTauxActu.setText(""); // Mise à zéro du textField taux actuel
					textFieldDecouvActu.setText(""); // Mise à zéro du textField découvert actuel
					
					textField.setText("Classique"); // Affichage du type de compte
					
					textField.setEditable(false);
					textFieldDecouvActu.setEditable(false);
					textFieldNouvDe.setEditable(false);
					textFieldTauxActu.setEditable(false);
					textFieldNouvTx.setEditable(false);
					break;
				case 2 :
					// Cas compte épargne
					textFieldDecouvActu.setText(""); // Mise à zéro du textField découvert actuel
					
					textField.setText("Epargne"); // Affichage du type de compte
					
					// Récupération du taux des comptes épargnes et affichage
					double tauxActu = base.recupTaux(numCom); // Appel à la fonction de récupération du taux
					textFieldTauxActu.setText(String.valueOf(tauxActu)); // Affichage du taux  !!!! setText ne prend que
																								 // les String !!!!!
					
					textFieldNouvTx.setEditable(true);
					textFieldTauxActu.setEditable(false);
					textFieldDecouvActu.setEditable(false);
					textField.setEditable(false);
					textFieldNouvDe.setEditable(false);
					break;
				case 3 :
					// Cas compte courant
					textFieldTauxActu.setText(""); // Mise à zéro du textField du taux actuel
					
					textField.setText("Courant"); // Affichage du type de compte
					
					// Récupération du découvert autorisé actuel pour le compte en cours
					double decouvActu = base.recupDecouvert(numCom); // Appel à la fonction de récupération du découvert
					textFieldDecouvActu.setText(String.valueOf(decouvActu)); // Affichage du découvert actuel
					
					textField.setEditable(false);
					textFieldDecouvActu.setEditable(false);
					textFieldNouvDe.setEditable(true);
					textFieldTauxActu.setEditable(false);
					textFieldNouvTx.setEditable(false);
					break;
				default:
					textField.setText("ERREUR");
				}
			}
		});
		
		GridBagConstraints gbc_btnModifier = new GridBagConstraints();
		gbc_btnModifier.anchor = GridBagConstraints.WEST;
		gbc_btnModifier.insets = new Insets(0, 0, 5, 5);
		gbc_btnModifier.gridx = 4;
		gbc_btnModifier.gridy = 4;
		add(btnModifier, gbc_btnModifier);
		
		
		
		// MODIFICATION D'UN COMPTE APRES CONNEXION
		JButton btnModifier_1 = new JButton("Modifier");
		btnModifier_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				// Cas d'un compte EPARGNE
				if (type == 2)
				{
					// Récupération du nouveau taux à définir
					String tempo = textFieldNouvTx.getText();
					double valeurTx = Double.parseDouble(tempo);
					
					// Vérification de la valeur entrée pour le taux
					if (valeurTx <0)
					{
						textFieldNouvTx.setText("Taux invalide");
					}
					else
					{
						// Fait appelle à la fonction pour mettre à jour le taux + remise à zéro du textField
						base.mise_a_jour_taux(valeurTx);
						textFieldNouvTx.setText("");
					}
					
					// Mise à jour du taux actuel après avoir changé la valeur de ce dernier
					double tauxActu = base.recupTaux(numCom);
					textFieldTauxActu.setText(String.valueOf(tauxActu));
				}
				
				// Cas d'un compte COURANT
				else if (type == 3)
				{
					// Récupération du nouveau découvert à définir
					String tempo = textFieldNouvDe.getText();
					double valeurDecouv = Double.parseDouble(tempo);
					
					// Fait appelle à la fonction pour mettre à jour le découvert + remise à zéro du textField
					base.mise_a_jour_decouvert(numCom, valeurDecouv);
					textFieldNouvDe.setText("");
					
					// Mise à jour du découvert actuel après avoir changé la valeur de ce dernier
					double decouvActu = base.recupDecouvert(numCom);
					textFieldDecouvActu.setText(String.valueOf(decouvActu));
				}
			}
		});
		GridBagConstraints gbc_btnModifier_1 = new GridBagConstraints();
		gbc_btnModifier_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnModifier_1.anchor = GridBagConstraints.WEST;
		gbc_btnModifier_1.gridx = 4;
		gbc_btnModifier_1.gridy = 10;
		add(btnModifier_1, gbc_btnModifier_1);
		
		
		
		// Recherche des titulaires étant en découvert
		// et affichage dans un textArea.
		titEnDecouvert = base.titulaireEnDecouvert();
		textArea_1.setText(titEnDecouvert);
		
		// Recherche des titulaires possédant un compte épargne ET un compte courant
		// et affichage dans un textArea.
		titCompteEpAndCo = base.compteEpAndCo();
		if (titCompteEpAndCo.equals(""))
		{
			textArea.setText("Aucun client ne dispose d'un \n compte épargne et d'un \n compte courant.");
		}
		else
		{
			textArea.setText(titCompteEpAndCo);
		}
	}
	
	//affichage de la fenetre d'erreur lors d'une modification
	public void erreurModif()
	{
		// création de la frame
		JFrame frame = null;
		//fenetre d'erreur
		JOptionPane.showMessageDialog(frame,
		    "Mauvaise modification du taux",	
		    "Modification Impossible",
		    JOptionPane.ERROR_MESSAGE);
	}
}
