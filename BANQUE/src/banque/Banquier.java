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
	public Banquier() {
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
		
		JLabel lblCrerUnCompte = new JLabel("Cr\u00E9er un compte");
		lblCrerUnCompte.setFont(new Font("Georgia", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCrerUnCompte = new GridBagConstraints();
		gbc_lblCrerUnCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrerUnCompte.gridx = 0;
		gbc_lblCrerUnCompte.gridy = 2;
		add(lblCrerUnCompte, gbc_lblCrerUnCompte);
		
		JLabel lblModifierLeTaux = new JLabel("Manipuler un compte");
		lblModifierLeTaux.setFont(new Font("Georgia", Font.PLAIN, 14));
		GridBagConstraints gbc_lblModifierLeTaux = new GridBagConstraints();
		gbc_lblModifierLeTaux.anchor = GridBagConstraints.EAST;
		gbc_lblModifierLeTaux.insets = new Insets(0, 0, 5, 5);
		gbc_lblModifierLeTaux.gridx = 3;
		gbc_lblModifierLeTaux.gridy = 2;
		add(lblModifierLeTaux, gbc_lblModifierLeTaux);
		
		JLabel lblNom = new JLabel("NOM ");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 0;
		gbc_lblNom.gridy = 3;
		add(lblNom, gbc_lblNom);
		
		textFieldNom = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		add(textFieldNom, gbc_textField);
		textFieldNom.setColumns(10);
		
		JLabel lblNDuCompte = new JLabel("N\u00B0 du compte");
		GridBagConstraints gbc_lblNDuCompte = new GridBagConstraints();
		gbc_lblNDuCompte.anchor = GridBagConstraints.EAST;
		gbc_lblNDuCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblNDuCompte.gridx = 3;
		gbc_lblNDuCompte.gridy = 3;
		add(lblNDuCompte, gbc_lblNDuCompte);
		
		textFieldNum2 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 2;
		gbc_textField_4.anchor = GridBagConstraints.WEST;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 4;
		gbc_textField_4.gridy = 3;
		add(textFieldNum2, gbc_textField_4);
		textFieldNum2.setColumns(10);
		
		JLabel lblNumroDeCompte = new JLabel("Num\u00E9ro de compte");
		GridBagConstraints gbc_lblNumroDeCompte = new GridBagConstraints();
		gbc_lblNumroDeCompte.anchor = GridBagConstraints.EAST;
		gbc_lblNumroDeCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumroDeCompte.gridx = 0;
		gbc_lblNumroDeCompte.gridy = 4;
		add(lblNumroDeCompte, gbc_lblNumroDeCompte);
		
		textFieldNum1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		add(textFieldNum1, gbc_textField_1);
		textFieldNum1.setColumns(10);
		
		
		
		JLabel lblSoldeInitial = new JLabel("Solde initial");
		GridBagConstraints gbc_lblSoldeInitial = new GridBagConstraints();
		gbc_lblSoldeInitial.anchor = GridBagConstraints.EAST;
		gbc_lblSoldeInitial.insets = new Insets(0, 0, 5, 5);
		gbc_lblSoldeInitial.gridx = 0;
		gbc_lblSoldeInitial.gridy = 5;
		add(lblSoldeInitial, gbc_lblSoldeInitial);
		
		textFieldSoldeI = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 5;
		add(textFieldSoldeI, gbc_textField_2);
		textFieldSoldeI.setColumns(10);
		GridBagConstraints gbc_textField3;
		
		JLabel lblTypeDeCompte = new JLabel("Type de compte");
		GridBagConstraints gbc_lblTypeDeCompte = new GridBagConstraints();
		gbc_lblTypeDeCompte.anchor = GridBagConstraints.EAST;
		gbc_lblTypeDeCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblTypeDeCompte.gridx = 3;
		gbc_lblTypeDeCompte.gridy = 5;
		add(lblTypeDeCompte, gbc_lblTypeDeCompte);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField1 = new GridBagConstraints();
		gbc_textField1.anchor = GridBagConstraints.WEST;
		gbc_textField1.insets = new Insets(0, 0, 5, 5);
		gbc_textField1.gridx = 4;
		gbc_textField1.gridy = 5;
		add(textField, gbc_textField1);
		textField.setColumns(10);
		
		JLabel lblCeCompteEstil = new JLabel("Ce compte est-il :");
		GridBagConstraints gbc_lblCeCompteEstil = new GridBagConstraints();
		gbc_lblCeCompteEstil.anchor = GridBagConstraints.EAST;
		gbc_lblCeCompteEstil.insets = new Insets(0, 0, 5, 5);
		gbc_lblCeCompteEstil.gridx = 0;
		gbc_lblCeCompteEstil.gridy = 6;
		add(lblCeCompteEstil, gbc_lblCeCompteEstil);
		
		final JRadioButton rdbtnCourant = new JRadioButton("Courant    ");
		buttonGroup.add(rdbtnCourant);
		GridBagConstraints gbc_rdbtnCourant = new GridBagConstraints();
		gbc_rdbtnCourant.anchor = GridBagConstraints.WEST;
		gbc_rdbtnCourant.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCourant.gridx = 1;
		gbc_rdbtnCourant.gridy = 6;
		add(rdbtnCourant, gbc_rdbtnCourant);
		
		JLabel lblTauxActuel = new JLabel("Taux actuel");
		GridBagConstraints gbc_lblTauxActuel = new GridBagConstraints();
		gbc_lblTauxActuel.anchor = GridBagConstraints.EAST;
		gbc_lblTauxActuel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTauxActuel.gridx = 3;
		gbc_lblTauxActuel.gridy = 6;
		add(lblTauxActuel, gbc_lblTauxActuel);
		
		textFieldTauxActu = new JTextField();
		gbc_textFieldTauxActu = new GridBagConstraints();
		gbc_textFieldTauxActu.anchor = GridBagConstraints.WEST;
		gbc_textFieldTauxActu.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTauxActu.gridx = 4;
		gbc_textFieldTauxActu.gridy = 6;
		add(textFieldTauxActu, gbc_textFieldTauxActu);
		textFieldTauxActu.setColumns(10);

		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Epargne   ");
		buttonGroup.add(rdbtnNewRadioButton);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 7;
		add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		GridBagConstraints gbc_textField_5;
		
		JLabel lblNouveauTauxDe = new JLabel("Nouveau taux de r\u00E9mun\u00E9ration");
		GridBagConstraints gbc_lblNouveauTauxDe = new GridBagConstraints();
		gbc_lblNouveauTauxDe.anchor = GridBagConstraints.EAST;
		gbc_lblNouveauTauxDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblNouveauTauxDe.gridx = 3;
		gbc_lblNouveauTauxDe.gridy = 7;
		add(lblNouveauTauxDe, gbc_lblNouveauTauxDe);
		
		textFieldNouvTx = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 4;
		gbc_textField_3.gridy = 7;
		add(textFieldNouvTx, gbc_textField_3);
		textFieldNouvTx.setColumns(10);
		
		final JRadioButton rdbtnClassique = new JRadioButton("Classique");
		buttonGroup.add(rdbtnClassique);
		GridBagConstraints gbc_rdbtnClassique = new GridBagConstraints();
		gbc_rdbtnClassique.anchor = GridBagConstraints.WEST;
		gbc_rdbtnClassique.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnClassique.gridx = 1;
		gbc_rdbtnClassique.gridy = 8;
		add(rdbtnClassique, gbc_rdbtnClassique);
		
		JLabel lblDcouvertActuel = new JLabel("D\u00E9couvert actuel");
		GridBagConstraints gbc_lblDcouvertActuel = new GridBagConstraints();
		gbc_lblDcouvertActuel.anchor = GridBagConstraints.EAST;
		gbc_lblDcouvertActuel.insets = new Insets(0, 0, 5, 5);
		gbc_lblDcouvertActuel.gridx = 3;
		gbc_lblDcouvertActuel.gridy = 8;
		add(lblDcouvertActuel, gbc_lblDcouvertActuel);
		
		textFieldDecouvActu = new JTextField();
		gbc_textFieldDecouvActu = new GridBagConstraints();
		gbc_textFieldDecouvActu.anchor = GridBagConstraints.WEST;
		gbc_textFieldDecouvActu.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDecouvActu.gridx = 4;
		gbc_textFieldDecouvActu.gridy = 8;
		add(textFieldDecouvActu, gbc_textFieldDecouvActu);
		textFieldDecouvActu.setColumns(10);
		
		JLabel lblNouveauDcouvert = new JLabel("Nouveau d\u00E9couvert");
		GridBagConstraints gbc_lblNouveauDcouvert = new GridBagConstraints();
		gbc_lblNouveauDcouvert.anchor = GridBagConstraints.EAST;
		gbc_lblNouveauDcouvert.insets = new Insets(0, 0, 5, 5);
		gbc_lblNouveauDcouvert.gridx = 3;
		gbc_lblNouveauDcouvert.gridy = 9;
		add(lblNouveauDcouvert, gbc_lblNouveauDcouvert);
		
		textFieldNouvDe = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.anchor = GridBagConstraints.WEST;
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.gridx = 4;
		gbc_textField_6.gridy = 9;
		add(textFieldNouvDe, gbc_textField_6);
		textFieldNouvDe.setColumns(10);
		
		JLabel lblDcouvertAutoris = new JLabel("D\u00E9couvert autoris\u00E9");
		GridBagConstraints gbc_lblDcouvertAutoris = new GridBagConstraints();
		gbc_lblDcouvertAutoris.anchor = GridBagConstraints.EAST;
		gbc_lblDcouvertAutoris.insets = new Insets(0, 0, 5, 5);
		gbc_lblDcouvertAutoris.gridx = 0;
		gbc_lblDcouvertAutoris.gridy = 10;
		add(lblDcouvertAutoris, gbc_lblDcouvertAutoris);
		
		textFieldDecouAut = new JTextField();
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.anchor = GridBagConstraints.WEST;
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.gridx = 1;
		gbc_textField_8.gridy = 10;
		add(textFieldDecouAut, gbc_textField_8);
		textFieldDecouAut.setColumns(10);
		
		JLabel lblClientsDisposantsDun = new JLabel("Clients disposants d'un compte \u00E9pargne et d'un compte courant");
		GridBagConstraints gbc_lblClientsDisposantsDun = new GridBagConstraints();
		gbc_lblClientsDisposantsDun.gridwidth = 2;
		gbc_lblClientsDisposantsDun.insets = new Insets(0, 0, 5, 5);
		gbc_lblClientsDisposantsDun.gridx = 0;
		gbc_lblClientsDisposantsDun.gridy = 12;
		add(lblClientsDisposantsDun, gbc_lblClientsDisposantsDun);
		
		JLabel lblClientsEnDcouvert = new JLabel("Clients en d\u00E9couvert");
		GridBagConstraints gbc_lblClientsEnDcouvert = new GridBagConstraints();
		gbc_lblClientsEnDcouvert.gridwidth = 2;
		gbc_lblClientsEnDcouvert.insets = new Insets(0, 0, 5, 5);
		gbc_lblClientsEnDcouvert.gridx = 3;
		gbc_lblClientsEnDcouvert.gridy = 12;
		add(lblClientsEnDcouvert, gbc_lblClientsEnDcouvert);
		
		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 13;
		add(textArea, gbc_textArea);
		textArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 13;
		add(scrollPane, gbc_scrollPane);
		
		textArea_1 = new JTextArea();
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.insets = new Insets(0, 0, 0, 5);
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 4;
		gbc_textArea_1.gridy = 13;
		add(textArea_1, gbc_textArea_1);
		textArea_1.setEditable(false);
		
		JScrollPane scrollPane_1 = new JScrollPane(textArea_1);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 3;
		gbc_scrollPane_1.gridy = 13;
		add(scrollPane_1, gbc_scrollPane_1);
		
		titEnDecouvert = base.titulaireEnDecouvert();
		textArea_1.setText(titEnDecouvert);
		
		titCompteEpAndCo = base.compteEpAndCo();
		if (titCompteEpAndCo.equals(""))
		{
			textArea.setText("Aucun client ne dispose d'un \n compte épargne et d'un \n compte courant.");
		}
		else
		{
			textArea.setText(titCompteEpAndCo);
		}
		
		
		JButton btnCrer = new JButton("Cr\u00E9er");
		btnCrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				// Récupération des valeurs des textField
				String name = textFieldNom.getText();
				//System.out.println("JE SUIS LE NAME : " + name);
				
				String tempo = textFieldNum1.getText();
				int numCom = Integer.parseInt(tempo);
				//System.out.println("JE SUIS LE NUMERO DE COMPTE : " + numCom);
				
				tempo = textFieldSoldeI.getText();
				double numSol = Double.parseDouble(tempo);
				double taux = base.recupTaux(numCom);
				//System.out.println("JE SUIS LE SOLDE : " + numSol);
				
				if (rdbtnNewRadioButton.isSelected())
				{
					/*tempo = textFieldTxRem.getText();
					double tx = Double.parseDouble(tempo);*/
					type = 2;
					//monCompteEp = new compte_epargne(numCom, name, numSol, tx);
					base.insertionCompte(numCom, name, numSol, type);
					base.insertionCompteEpargne(numCom, name, numSol, type, taux);
					//monCompteEp.consulte();
					//System.out.println("VOICI LE TYPE DU COMPTE EP : " + type);
				}
				
				else if (rdbtnCourant.isSelected())
				{
					tempo = textFieldDecouAut.getText();
					double decouvert = Double.parseDouble(tempo);
					type = 3;
					//compte_courant monCompteCo = new compte_courant(numCom, name, numSol, decouvert);
					base.insertionCompte(numCom, name, numSol, type);
					base.insertionCompteCourant(numCom, name, numSol, type, decouvert);
					//monCompteCo.consulte();
					//System.out.println("VOICI LE TYPE DU COMPTE CO : " + type);
				}
				
				else
				{
					//compte monCompte = new compte(numCom,name,numSol);
					type = 1;
					base.insertionCompte(numCom, name, numSol, type);
					//monCompte.consulte();
				}
				
				// Remise à zéro des textField.
				textFieldNom.setText("");
				textFieldNum1.setText("");
				textFieldSoldeI.setText("");
				textFieldDecouAut.setText("");
				buttonGroup.clearSelection();
			}
		});
		
		JButton btnModifier_1 = new JButton("Modifier");
		btnModifier_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				if (type == 2)
				{
					String tempo = textFieldNouvTx.getText();
					double valeurTx = Double.parseDouble(tempo);
					if (valeurTx <0)
					{
						textFieldNouvTx.setText("Taux invalide");
					}
					else
					{
						base.mise_a_jour_taux(valeurTx);
						textFieldNouvTx.setText("");
					}
					//monCompteEp.mise_a_jour(valeurTx);
					double tauxActu = base.recupTaux(numCom);
					textFieldTauxActu.setText(String.valueOf(tauxActu));
					System.out.println(valeurTx);
				}
				
				else if (type == 3)
				{
					String tempo = textFieldNouvDe.getText();
					double valeurDecouv = Double.parseDouble(tempo);
					base.mise_a_jour_decouvert(numCom, valeurDecouv);
					textFieldNouvDe.setText("");
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
		
		GridBagConstraints gbc_btnCrer = new GridBagConstraints();
		gbc_btnCrer.anchor = GridBagConstraints.WEST;
		gbc_btnCrer.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrer.gridx = 1;
		gbc_btnCrer.gridy = 11;
		add(btnCrer, gbc_btnCrer);
		
		JButton btnModifier = new JButton("Connexion au compte");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String tempo = textFieldNum2.getText();
				numCom = Integer.parseInt(tempo);
				//System.out.println("Voici le numéro de compte : " + numCom);
				type = base.recupType(numCom);
				
				//System.out.println("VOICI LE TYPE : " + type);
				switch (type)
				{
				case 1 :
					textFieldTauxActu.setText("");
					textFieldDecouvActu.setText("");
					textField.setText("Classique");
					textField.setEditable(false);
					textFieldDecouvActu.setEditable(false);
					textFieldNouvDe.setEditable(false);
					textFieldTauxActu.setEditable(false);
					textFieldNouvTx.setEditable(false);
					break;
				case 2 :
					textFieldDecouvActu.setText("");
					textField.setText("Epargne");
					double tauxActu = base.recupTaux(numCom);
					textFieldTauxActu.setText(String.valueOf(tauxActu));
					textFieldNouvTx.setEditable(true);
					textFieldTauxActu.setEditable(false);
					textFieldDecouvActu.setEditable(false);
					textField.setEditable(false);
					textFieldNouvDe.setEditable(false);
					break;
				case 3 :
					textFieldTauxActu.setText("");
					textField.setText("Courant");
					double decouvActu = base.recupDecouvert(numCom);
					textFieldDecouvActu.setText(String.valueOf(decouvActu));
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
