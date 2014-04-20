package banque;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;


public class Banquier extends JPanel 
{
	private JTextField textFieldNom;
	private JTextField textFieldNum1;
	private JTextField textFieldSoldeI;
	private JTextField textFieldNouvTx;
	private JTextField textFieldNum2;
	private JTextField textFieldNum3;
	private JTextField textFieldNouvDe;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldTxRem;
	private JTextField textFieldDecouAut;
	compte monCompte = new compte();
	compte_epargne monCompteEp = new compte_epargne();
	compte_courant monCompteCo = new compte_courant();
	bddConnect base = new bddConnect();


	/**
	 * Create the panel.
	 */
	public Banquier() {
		setBackground(Color.PINK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {255, 100, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblCrerUnCompte = new JLabel("Cr\u00E9er un compte en banque");
		lblCrerUnCompte.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCrerUnCompte = new GridBagConstraints();
		gbc_lblCrerUnCompte.anchor = GridBagConstraints.WEST;
		gbc_lblCrerUnCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrerUnCompte.gridx = 0;
		gbc_lblCrerUnCompte.gridy = 0;
		add(lblCrerUnCompte, gbc_lblCrerUnCompte);
		
		JLabel lblNom = new JLabel("NOM ");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.EAST;
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 0;
		gbc_lblNom.gridy = 1;
		add(lblNom, gbc_lblNom);
		
		textFieldNom = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		add(textFieldNom, gbc_textField);
		textFieldNom.setColumns(10);
		
		JLabel lblNumroDeCompte = new JLabel("Num\u00E9ro de compte");
		GridBagConstraints gbc_lblNumroDeCompte = new GridBagConstraints();
		gbc_lblNumroDeCompte.anchor = GridBagConstraints.EAST;
		gbc_lblNumroDeCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumroDeCompte.gridx = 0;
		gbc_lblNumroDeCompte.gridy = 2;
		add(lblNumroDeCompte, gbc_lblNumroDeCompte);
		
		textFieldNum1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		add(textFieldNum1, gbc_textField_1);
		textFieldNum1.setColumns(10);
		
		JLabel lblSoldeInitial = new JLabel("Solde initial");
		GridBagConstraints gbc_lblSoldeInitial = new GridBagConstraints();
		gbc_lblSoldeInitial.anchor = GridBagConstraints.EAST;
		gbc_lblSoldeInitial.insets = new Insets(0, 0, 5, 5);
		gbc_lblSoldeInitial.gridx = 0;
		gbc_lblSoldeInitial.gridy = 3;
		add(lblSoldeInitial, gbc_lblSoldeInitial);
		
		textFieldSoldeI = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		add(textFieldSoldeI, gbc_textField_2);
		textFieldSoldeI.setColumns(10);
		
		JLabel lblCeCompteEstil = new JLabel("Ce compte est-il :");
		GridBagConstraints gbc_lblCeCompteEstil = new GridBagConstraints();
		gbc_lblCeCompteEstil.insets = new Insets(0, 0, 5, 5);
		gbc_lblCeCompteEstil.gridx = 0;
		gbc_lblCeCompteEstil.gridy = 4;
		add(lblCeCompteEstil, gbc_lblCeCompteEstil);
		
		final JRadioButton rdbtnCourant = new JRadioButton("Courant    ");
		buttonGroup.add(rdbtnCourant);
		GridBagConstraints gbc_rdbtnCourant = new GridBagConstraints();
		gbc_rdbtnCourant.anchor = GridBagConstraints.WEST;
		gbc_rdbtnCourant.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnCourant.gridx = 1;
		gbc_rdbtnCourant.gridy = 4;
		add(rdbtnCourant, gbc_rdbtnCourant);

		final JRadioButton rdbtnNewRadioButton = new JRadioButton("Epargne   ");
		buttonGroup.add(rdbtnNewRadioButton);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 5;
		add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		final JRadioButton rdbtnClassique = new JRadioButton("Classique");
		buttonGroup.add(rdbtnClassique);
		GridBagConstraints gbc_rdbtnClassique = new GridBagConstraints();
		gbc_rdbtnClassique.anchor = GridBagConstraints.WEST;
		gbc_rdbtnClassique.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnClassique.gridx = 1;
		gbc_rdbtnClassique.gridy = 6;
		add(rdbtnClassique, gbc_rdbtnClassique);
		
		JLabel lblTauxDeRmunration = new JLabel("Taux de r\u00E9mun\u00E9ration");
		GridBagConstraints gbc_lblTauxDeRmunration = new GridBagConstraints();
		gbc_lblTauxDeRmunration.anchor = GridBagConstraints.EAST;
		gbc_lblTauxDeRmunration.insets = new Insets(0, 0, 5, 5);
		gbc_lblTauxDeRmunration.gridx = 0;
		gbc_lblTauxDeRmunration.gridy = 7;
		add(lblTauxDeRmunration, gbc_lblTauxDeRmunration);
		
		textFieldTxRem = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.anchor = GridBagConstraints.WEST;
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 7;
		add(textFieldTxRem, gbc_textField_7);
		textFieldTxRem.setColumns(10);
		
		JLabel lblDcouvertAutoris = new JLabel("D\u00E9couvert autoris\u00E9");
		GridBagConstraints gbc_lblDcouvertAutoris = new GridBagConstraints();
		gbc_lblDcouvertAutoris.anchor = GridBagConstraints.EAST;
		gbc_lblDcouvertAutoris.insets = new Insets(0, 0, 5, 5);
		gbc_lblDcouvertAutoris.gridx = 0;
		gbc_lblDcouvertAutoris.gridy = 8;
		add(lblDcouvertAutoris, gbc_lblDcouvertAutoris);
		
		textFieldDecouAut = new JTextField();
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.anchor = GridBagConstraints.WEST;
		gbc_textField_8.insets = new Insets(0, 0, 5, 0);
		gbc_textField_8.gridx = 1;
		gbc_textField_8.gridy = 8;
		add(textFieldDecouAut, gbc_textField_8);
		textFieldDecouAut.setColumns(10);
		
		JButton btnCrer = new JButton("Cr\u00E9er");
		btnCrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				// R�cup�ration des valeurs des textField
				String name = textFieldNom.getText();
				System.out.println("JE SUIS LE NAME : " + name);
				
				String tempo = textFieldNum1.getText();
				int numCom = Integer.parseInt(tempo);
				System.out.println("JE SUIS LE NUMERO DE COMPTE : " + numCom);
				
				tempo = textFieldSoldeI.getText();
				double numSol = Double.parseDouble(tempo);
				System.out.println("JE SUIS LE SOLDE : " + numSol);
				
				if (rdbtnNewRadioButton.isSelected())
				{
					tempo = textFieldTxRem.getText();
					double tx = Double.parseDouble(tempo);
					monCompteEp = new compte_epargne(numCom, name, numSol, tx);
					base.insertionCompte(numCom, name, numSol);
					base.insertionCompteEpargne(numCom, name, numSol, tx);
					monCompteEp.consulte();
				}
				
				else if (rdbtnCourant.isSelected())
				{
					tempo = textFieldDecouAut.getText();
					double decouvert = Double.parseDouble(tempo);
					compte_courant monCompteCo = new compte_courant(numCom, name, numSol, decouvert);
					base.insertionCompte(numCom, name, numSol);
					base.insertionCompteCourant(numCom, name, numSol, decouvert);
					monCompteCo.consulte();
				}
				
				else
				{
					compte monCompte = new compte(numCom,name,numSol);
					base.insertionCompte(numCom, name, numSol);
					monCompte.consulte();
				}
				
				// Remise � z�ro des textField.
				textFieldNom.setText("");
				textFieldNum1.setText("");
				textFieldSoldeI.setText("");
				textFieldTxRem.setText("");
				textFieldDecouAut.setText("");
			}
		});
		
		GridBagConstraints gbc_btnCrer = new GridBagConstraints();
		gbc_btnCrer.anchor = GridBagConstraints.WEST;
		gbc_btnCrer.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrer.gridx = 1;
		gbc_btnCrer.gridy = 9;
		add(btnCrer, gbc_btnCrer);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 2;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 10;
		add(separator, gbc_separator);
		
		JLabel lblModifierLeTaux = new JLabel("Modifier le taux de r\u00E9mun\u00E9ration");
		lblModifierLeTaux.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblModifierLeTaux = new GridBagConstraints();
		gbc_lblModifierLeTaux.anchor = GridBagConstraints.WEST;
		gbc_lblModifierLeTaux.insets = new Insets(0, 0, 5, 5);
		gbc_lblModifierLeTaux.gridx = 0;
		gbc_lblModifierLeTaux.gridy = 11;
		add(lblModifierLeTaux, gbc_lblModifierLeTaux);
		
		JLabel lblNDuCompte = new JLabel("N\u00B0 du compte");
		GridBagConstraints gbc_lblNDuCompte = new GridBagConstraints();
		gbc_lblNDuCompte.anchor = GridBagConstraints.EAST;
		gbc_lblNDuCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblNDuCompte.gridx = 0;
		gbc_lblNDuCompte.gridy = 12;
		add(lblNDuCompte, gbc_lblNDuCompte);
		
		textFieldNum2 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.WEST;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 12;
		add(textFieldNum2, gbc_textField_4);
		textFieldNum2.setColumns(10);
		
		JLabel lblNouveauTauxDe = new JLabel("Nouveau taux de r\u00E9mun\u00E9ration");
		GridBagConstraints gbc_lblNouveauTauxDe = new GridBagConstraints();
		gbc_lblNouveauTauxDe.anchor = GridBagConstraints.EAST;
		gbc_lblNouveauTauxDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblNouveauTauxDe.gridx = 0;
		gbc_lblNouveauTauxDe.gridy = 13;
		add(lblNouveauTauxDe, gbc_lblNouveauTauxDe);
		
		textFieldNouvTx = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 13;
		add(textFieldNouvTx, gbc_textField_3);
		textFieldNouvTx.setColumns(10);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String tempo = textFieldNouvTx.getText();
				double valeur = Double.parseDouble(tempo);
				monCompteEp.mise_a_jour(valeur);
			}
		});
		GridBagConstraints gbc_btnModifier = new GridBagConstraints();
		gbc_btnModifier.anchor = GridBagConstraints.WEST;
		gbc_btnModifier.insets = new Insets(0, 0, 5, 0);
		gbc_btnModifier.gridx = 1;
		gbc_btnModifier.gridy = 14;
		add(btnModifier, gbc_btnModifier);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.gridwidth = 2;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 15;
		add(separator_1, gbc_separator_1);
		
		JLabel lblModifier = new JLabel("Modifier le montant du d\u00E9couvert autoris\u00E9");
		lblModifier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblModifier = new GridBagConstraints();
		gbc_lblModifier.anchor = GridBagConstraints.WEST;
		gbc_lblModifier.insets = new Insets(0, 0, 5, 5);
		gbc_lblModifier.gridx = 0;
		gbc_lblModifier.gridy = 16;
		add(lblModifier, gbc_lblModifier);
		
		JLabel lblNDuCompte_1 = new JLabel("N\u00B0 du compte");
		GridBagConstraints gbc_lblNDuCompte_1 = new GridBagConstraints();
		gbc_lblNDuCompte_1.anchor = GridBagConstraints.EAST;
		gbc_lblNDuCompte_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNDuCompte_1.gridx = 0;
		gbc_lblNDuCompte_1.gridy = 17;
		add(lblNDuCompte_1, gbc_lblNDuCompte_1);
		
		textFieldNum3 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.anchor = GridBagConstraints.WEST;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 17;
		add(textFieldNum3, gbc_textField_5);
		textFieldNum3.setColumns(10);
		
		JLabel lblNouveauDcouvert = new JLabel("Nouveau d\u00E9couvert");
		GridBagConstraints gbc_lblNouveauDcouvert = new GridBagConstraints();
		gbc_lblNouveauDcouvert.anchor = GridBagConstraints.EAST;
		gbc_lblNouveauDcouvert.insets = new Insets(0, 0, 5, 5);
		gbc_lblNouveauDcouvert.gridx = 0;
		gbc_lblNouveauDcouvert.gridy = 18;
		add(lblNouveauDcouvert, gbc_lblNouveauDcouvert);
		
		textFieldNouvDe = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.anchor = GridBagConstraints.WEST;
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 18;
		add(textFieldNouvDe, gbc_textField_6);
		textFieldNouvDe.setColumns(10);
		
		JButton btnModifier_1 = new JButton("Modifier");
		btnModifier_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String tempo = textFieldNouvDe.getText();
				double valeur = Double.parseDouble(tempo);
				monCompteCo.mise_a_jour(valeur);
			}
		});
		GridBagConstraints gbc_btnModifier_1 = new GridBagConstraints();
		gbc_btnModifier_1.anchor = GridBagConstraints.WEST;
		gbc_btnModifier_1.gridx = 1;
		gbc_btnModifier_1.gridy = 19;
		add(btnModifier_1, gbc_btnModifier_1);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
