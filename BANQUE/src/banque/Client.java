package banque;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JSeparator;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Client extends JPanel
{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	compte monCompte = new compte();
	compte_epargne monCompteEp = new compte_epargne();
	compte_courant monCompteCo = new compte_courant();
	/**
	 * Create the panel.
	 */
	public Client()
	{
		setBackground(Color.PINK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{255, 150, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblConsulterLeSolde = new JLabel("Consulter le solde d'un compte");
		lblConsulterLeSolde.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblConsulterLeSolde = new GridBagConstraints();
		gbc_lblConsulterLeSolde.insets = new Insets(0, 0, 5, 5);
		gbc_lblConsulterLeSolde.anchor = GridBagConstraints.WEST;
		gbc_lblConsulterLeSolde.gridx = 0;
		gbc_lblConsulterLeSolde.gridy = 0;
		add(lblConsulterLeSolde, gbc_lblConsulterLeSolde);
		
		JLabel lblNDuCompte = new JLabel("N\u00B0 du compte");
		GridBagConstraints gbc_lblNDuCompte = new GridBagConstraints();
		gbc_lblNDuCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblNDuCompte.anchor = GridBagConstraints.EAST;
		gbc_lblNDuCompte.gridx = 0;
		gbc_lblNDuCompte.gridy = 1;
		add(lblNDuCompte, gbc_lblNDuCompte);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnAfficherLeSolde = new JButton("Afficher le solde");
		btnAfficherLeSolde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
			}
		});
		GridBagConstraints gbc_btnAfficherLeSolde = new GridBagConstraints();
		gbc_btnAfficherLeSolde.anchor = GridBagConstraints.WEST;
		gbc_btnAfficherLeSolde.insets = new Insets(0, 0, 5, 0);
		gbc_btnAfficherLeSolde.gridx = 1;
		gbc_btnAfficherLeSolde.gridy = 2;
		add(btnAfficherLeSolde, gbc_btnAfficherLeSolde);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 2;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 3;
		add(separator, gbc_separator);
		
		JLabel lblSoldeDuCompte = new JLabel("Solde du compte");
		GridBagConstraints gbc_lblSoldeDuCompte = new GridBagConstraints();
		gbc_lblSoldeDuCompte.anchor = GridBagConstraints.EAST;
		gbc_lblSoldeDuCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblSoldeDuCompte.gridx = 0;
		gbc_lblSoldeDuCompte.gridy = 4;
		add(lblSoldeDuCompte, gbc_lblSoldeDuCompte);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 4;
		add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTauxDeRmunration = new JLabel("Taux de r\u00E9mun\u00E9ration");
		GridBagConstraints gbc_lblTauxDeRmunration = new GridBagConstraints();
		gbc_lblTauxDeRmunration.anchor = GridBagConstraints.EAST;
		gbc_lblTauxDeRmunration.insets = new Insets(0, 0, 5, 5);
		gbc_lblTauxDeRmunration.gridx = 0;
		gbc_lblTauxDeRmunration.gridy = 5;
		add(lblTauxDeRmunration, gbc_lblTauxDeRmunration);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.WEST;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 5;
		add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDcouvertAutoris = new JLabel("D\u00E9couvert autoris\u00E9");
		GridBagConstraints gbc_lblDcouvertAutoris = new GridBagConstraints();
		gbc_lblDcouvertAutoris.anchor = GridBagConstraints.EAST;
		gbc_lblDcouvertAutoris.insets = new Insets(0, 0, 5, 5);
		gbc_lblDcouvertAutoris.gridx = 0;
		gbc_lblDcouvertAutoris.gridy = 6;
		add(lblDcouvertAutoris, gbc_lblDcouvertAutoris);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.anchor = GridBagConstraints.WEST;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 6;
		add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.gridwidth = 2;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 7;
		add(separator_1, gbc_separator_1);
		
		JLabel lblManipulerUnCompte = new JLabel("Manipuler un compte");
		lblManipulerUnCompte.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblManipulerUnCompte = new GridBagConstraints();
		gbc_lblManipulerUnCompte.anchor = GridBagConstraints.WEST;
		gbc_lblManipulerUnCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblManipulerUnCompte.gridx = 0;
		gbc_lblManipulerUnCompte.gridy = 8;
		add(lblManipulerUnCompte, gbc_lblManipulerUnCompte);
		
		JLabel lblNDuCompte_1 = new JLabel("N\u00B0 du compte");
		GridBagConstraints gbc_lblNDuCompte_1 = new GridBagConstraints();
		gbc_lblNDuCompte_1.anchor = GridBagConstraints.EAST;
		gbc_lblNDuCompte_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNDuCompte_1.gridx = 0;
		gbc_lblNDuCompte_1.gridy = 9;
		add(lblNDuCompte_1, gbc_lblNDuCompte_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 9;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMontantDposer = new JLabel("Montant \u00E0 d\u00E9poser ou retirer");
		GridBagConstraints gbc_lblMontantDposer = new GridBagConstraints();
		gbc_lblMontantDposer.anchor = GridBagConstraints.EAST;
		gbc_lblMontantDposer.insets = new Insets(0, 0, 5, 5);
		gbc_lblMontantDposer.gridx = 0;
		gbc_lblMontantDposer.gridy = 10;
		add(lblMontantDposer, gbc_lblMontantDposer);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 10;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JButton btnEffectuer = new JButton("Effectuer");
		GridBagConstraints gbc_btnEffectuer = new GridBagConstraints();
		gbc_btnEffectuer.anchor = GridBagConstraints.WEST;
		gbc_btnEffectuer.insets = new Insets(0, 0, 5, 0);
		gbc_btnEffectuer.gridx = 1;
		gbc_btnEffectuer.gridy = 11;
		add(btnEffectuer, gbc_btnEffectuer);
		
		JSeparator separator_2 = new JSeparator();
		GridBagConstraints gbc_separator_2 = new GridBagConstraints();
		gbc_separator_2.gridwidth = 2;
		gbc_separator_2.insets = new Insets(0, 0, 5, 0);
		gbc_separator_2.gridx = 0;
		gbc_separator_2.gridy = 12;
		add(separator_2, gbc_separator_2);
		
		JLabel lblSoldeDeDpart = new JLabel("Solde de d\u00E9part");
		GridBagConstraints gbc_lblSoldeDeDpart = new GridBagConstraints();
		gbc_lblSoldeDeDpart.anchor = GridBagConstraints.EAST;
		gbc_lblSoldeDeDpart.insets = new Insets(0, 0, 5, 5);
		gbc_lblSoldeDeDpart.gridx = 0;
		gbc_lblSoldeDeDpart.gridy = 13;
		add(lblSoldeDeDpart, gbc_lblSoldeDeDpart);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.anchor = GridBagConstraints.WEST;
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 13;
		add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNouveauSolde = new JLabel("Nouveau solde");
		GridBagConstraints gbc_lblNouveauSolde = new GridBagConstraints();
		gbc_lblNouveauSolde.anchor = GridBagConstraints.EAST;
		gbc_lblNouveauSolde.insets = new Insets(0, 0, 5, 5);
		gbc_lblNouveauSolde.gridx = 0;
		gbc_lblNouveauSolde.gridy = 14;
		add(lblNouveauSolde, gbc_lblNouveauSolde);
		
		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.anchor = GridBagConstraints.WEST;
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 14;
		add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
	}
}
