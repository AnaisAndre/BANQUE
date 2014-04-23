package banque;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Client extends JPanel
{
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	compte monCompte = new compte();
	compte_epargne monCompteEp = new compte_epargne();
	compte_courant monCompteCo = new compte_courant();
	bddConnect base = new bddConnect();
	
	int numCom;
	int type = 0;
	private JTextField textField_1;
	/**
	 * Create the panel.
	 */
	public Client()
	{
		setBackground(Color.PINK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{150, 150, 0, 150, 150, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblClient = new JLabel("CLIENT");
		lblClient.setFont(new Font("Urdu Typesetting", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_lblClient = new GridBagConstraints();
		gbc_lblClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblClient.gridx = 0;
		gbc_lblClient.gridy = 0;
		add(lblClient, gbc_lblClient);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 2;
		gbc_separator.gridy = 1;
		add(separator, gbc_separator);
		
		JLabel lblConsulterLeSolde = new JLabel("Connexion \u00E0 un compte");
		lblConsulterLeSolde.setFont(new Font("Georgia", Font.PLAIN, 14));
		GridBagConstraints gbc_lblConsulterLeSolde = new GridBagConstraints();
		gbc_lblConsulterLeSolde.insets = new Insets(0, 0, 5, 5);
		gbc_lblConsulterLeSolde.gridx = 0;
		gbc_lblConsulterLeSolde.gridy = 2;
		add(lblConsulterLeSolde, gbc_lblConsulterLeSolde);
		
		JLabel lblManipulerUnCompte = new JLabel("Manipuler un compte");
		lblManipulerUnCompte.setFont(new Font("Georgia", Font.PLAIN, 14));
		GridBagConstraints gbc_lblManipulerUnCompte = new GridBagConstraints();
		gbc_lblManipulerUnCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblManipulerUnCompte.gridx = 3;
		gbc_lblManipulerUnCompte.gridy = 2;
		add(lblManipulerUnCompte, gbc_lblManipulerUnCompte);
		
		JLabel lblNDuCompte = new JLabel("N\u00B0 du compte");
		GridBagConstraints gbc_lblNDuCompte = new GridBagConstraints();
		gbc_lblNDuCompte.anchor = GridBagConstraints.EAST;
		gbc_lblNDuCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblNDuCompte.gridx = 0;
		gbc_lblNDuCompte.gridy = 3;
		add(lblNDuCompte, gbc_lblNDuCompte);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblMontantDposer = new JLabel("Retrait");
		GridBagConstraints gbc_lblMontantDposer = new GridBagConstraints();
		gbc_lblMontantDposer.anchor = GridBagConstraints.EAST;
		gbc_lblMontantDposer.insets = new Insets(0, 0, 5, 5);
		gbc_lblMontantDposer.gridx = 3;
		gbc_lblMontantDposer.gridy = 3;
		add(lblMontantDposer, gbc_lblMontantDposer);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 3;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDpt = new JLabel("D\u00E9p\u00F4t");
		GridBagConstraints gbc_lblDpt = new GridBagConstraints();
		gbc_lblDpt.anchor = GridBagConstraints.EAST;
		gbc_lblDpt.insets = new Insets(0, 0, 5, 5);
		gbc_lblDpt.gridx = 3;
		gbc_lblDpt.gridy = 4;
		add(lblDpt, gbc_lblDpt);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 4;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSoldeDuCompte = new JLabel("Solde du compte");
		GridBagConstraints gbc_lblSoldeDuCompte = new GridBagConstraints();
		gbc_lblSoldeDuCompte.anchor = GridBagConstraints.EAST;
		gbc_lblSoldeDuCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblSoldeDuCompte.gridx = 0;
		gbc_lblSoldeDuCompte.gridy = 5;
		add(lblSoldeDuCompte, gbc_lblSoldeDuCompte);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 5;
		add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTauxDeRmunration = new JLabel("Taux de r\u00E9mun\u00E9ration");
		GridBagConstraints gbc_lblTauxDeRmunration = new GridBagConstraints();
		gbc_lblTauxDeRmunration.anchor = GridBagConstraints.EAST;
		gbc_lblTauxDeRmunration.insets = new Insets(0, 0, 5, 5);
		gbc_lblTauxDeRmunration.gridx = 0;
		gbc_lblTauxDeRmunration.gridy = 6;
		add(lblTauxDeRmunration, gbc_lblTauxDeRmunration);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.WEST;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 6;
		add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNouveauSolde = new JLabel("Nouveau solde");
		GridBagConstraints gbc_lblNouveauSolde = new GridBagConstraints();
		gbc_lblNouveauSolde.anchor = GridBagConstraints.EAST;
		gbc_lblNouveauSolde.insets = new Insets(0, 0, 5, 5);
		gbc_lblNouveauSolde.gridx = 3;
		gbc_lblNouveauSolde.gridy = 6;
		add(lblNouveauSolde, gbc_lblNouveauSolde);
		
		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.anchor = GridBagConstraints.WEST;
		gbc_textField_7.gridx = 4;
		gbc_textField_7.gridy = 6;
		add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		JLabel lblDcouvertAutoris = new JLabel("D\u00E9couvert autoris\u00E9");
		GridBagConstraints gbc_lblDcouvertAutoris = new GridBagConstraints();
		gbc_lblDcouvertAutoris.anchor = GridBagConstraints.EAST;
		gbc_lblDcouvertAutoris.insets = new Insets(0, 0, 0, 5);
		gbc_lblDcouvertAutoris.gridx = 0;
		gbc_lblDcouvertAutoris.gridy = 7;
		add(lblDcouvertAutoris, gbc_lblDcouvertAutoris);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.anchor = GridBagConstraints.WEST;
		gbc_textField_5.insets = new Insets(0, 0, 0, 5);
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 7;
		add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JButton btnAfficherLeSolde = new JButton("Afficher le solde");
		btnAfficherLeSolde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_7.setText("");
				// Récupération des valeurs des textField
				String tempo = textField.getText();
				numCom = Integer.parseInt(tempo);
				double sol = base.consulte(numCom);
				//System.out.println("SOL : " + sol);
				textField_3.setText(String.valueOf(sol));
				//System.out.println("JE SUIS LE NUMERO DE COMPTE : " + numCom);
				
				type = base.recupType(numCom);
				switch (type)
				{
				case 1 :
					break;
				case 2 :
					double tauxActu = base.recupTaux(numCom);
					//System.out.println("TAUX : " + tauxActu);
					textField_4.setText(String.valueOf(tauxActu));
					break;
				case 3 :
					double decouvActu = base.recupDecouvert(numCom);
					//System.out.println("DECOUV : " + decouvActu);
					textField_5.setText(String.valueOf(decouvActu));
					break;
				default:
					textField.setText("ERREUR");
				}
			}
		});
		GridBagConstraints gbc_btnAfficherLeSolde = new GridBagConstraints();
		gbc_btnAfficherLeSolde.gridwidth = 2;
		gbc_btnAfficherLeSolde.anchor = GridBagConstraints.WEST;
		gbc_btnAfficherLeSolde.insets = new Insets(0, 0, 5, 5);
		gbc_btnAfficherLeSolde.gridx = 1;
		gbc_btnAfficherLeSolde.gridy = 4;
		add(btnAfficherLeSolde, gbc_btnAfficherLeSolde);
		
		JButton btnEffectuer = new JButton("Effectuer");
		btnEffectuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				// Récupération des valeurs des textField
				if (textField_2.getText().equals(""))
				{
					textField_2.setText("0");
				}
				String tempo = textField_2.getText();
				double somme = Integer.parseInt(tempo);
				base.retirer(numCom, somme);
				
				if (textField_1.getText().equals(""))
				{
					textField_1.setText("0");
				}
				tempo = textField_1.getText();
				double sommeBis = Integer.parseInt(tempo);
				base.deposer(numCom, sommeBis);
				
				double sol = base.consulte(numCom);
				textField_7.setText(String.valueOf(sol));
				//base.manipuler(numCom, sol);
				//System.out.println("JE SUIS LE NUMERO DE COMPTE : " + numCom);
			}
		});
		GridBagConstraints gbc_btnEffectuer = new GridBagConstraints();
		gbc_btnEffectuer.anchor = GridBagConstraints.WEST;
		gbc_btnEffectuer.insets = new Insets(0, 0, 5, 0);
		gbc_btnEffectuer.gridx = 4;
		gbc_btnEffectuer.gridy = 5;
		add(btnEffectuer, gbc_btnEffectuer);
	}
}
