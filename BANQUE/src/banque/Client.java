package banque;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
/**
 * Fen�tre permetteant au client de manipul� ses comptes
 * @author Ana�s, Bruno
 *
 */
public class Client extends JPanel
{
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_1;
	private JTextArea textArea;
	
	bddConnect base = new bddConnect();
	
	double decouvActu = 0;
	double sol = 0;
	int numCom;
	int type = 0;
	
	/**
	 * Create the panel.
	 */
	public Client()
	{
		setBackground(Color.PINK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{150, 150, 0, 150, 150, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 165, 25};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0};
		setLayout(gridBagLayout);
		
		// Un label
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
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.gridwidth = 5;
		gbc_separator_1.insets = new Insets(0, 0, 5, 0);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 9;
		add(separator_1, gbc_separator_1);
		
		
		// Un label CONNEXION A UN COMPTE
		JLabel lblConsulterLeSolde = new JLabel("Connexion \u00E0 un compte");
		lblConsulterLeSolde.setFont(new Font("Georgia", Font.PLAIN, 14));
		GridBagConstraints gbc_lblConsulterLeSolde = new GridBagConstraints();
		gbc_lblConsulterLeSolde.insets = new Insets(0, 0, 5, 5);
		gbc_lblConsulterLeSolde.gridx = 0;
		gbc_lblConsulterLeSolde.gridy = 2;
		add(lblConsulterLeSolde, gbc_lblConsulterLeSolde);
		
		
		// Un label
		JLabel lblNDuCompte = new JLabel("N\u00B0 du compte");
		GridBagConstraints gbc_lblNDuCompte = new GridBagConstraints();
		gbc_lblNDuCompte.anchor = GridBagConstraints.EAST;
		gbc_lblNDuCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblNDuCompte.gridx = 0;
		gbc_lblNDuCompte.gridy = 3;
		add(lblNDuCompte, gbc_lblNDuCompte);
		
		// textField permettant la r�cup�ration du num�ro de compte auquel se connecter
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		
		// Un label
		JLabel lblSoldeDuCompte = new JLabel("Solde du compte");
		GridBagConstraints gbc_lblSoldeDuCompte = new GridBagConstraints();
		gbc_lblSoldeDuCompte.anchor = GridBagConstraints.EAST;
		gbc_lblSoldeDuCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblSoldeDuCompte.gridx = 0;
		gbc_lblSoldeDuCompte.gridy = 5;
		add(lblSoldeDuCompte, gbc_lblSoldeDuCompte);
		
		// textField permettant l'affichage du solde du compte en cours
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 5;
		add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		textField_3.setEditable(false);
		
		
		// Un label
		JLabel lblTauxDeRmunration = new JLabel("Taux de r\u00E9mun\u00E9ration");
		GridBagConstraints gbc_lblTauxDeRmunration = new GridBagConstraints();
		gbc_lblTauxDeRmunration.anchor = GridBagConstraints.EAST;
		gbc_lblTauxDeRmunration.insets = new Insets(0, 0, 5, 5);
		gbc_lblTauxDeRmunration.gridx = 0;
		gbc_lblTauxDeRmunration.gridy = 6;
		add(lblTauxDeRmunration, gbc_lblTauxDeRmunration);
		
		// textField permettant l'affichage du taux de r�mun�ration SI le compte en cours est un compte EPARGNE
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.WEST;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 6;
		add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		textField_4.setEditable(false);
		
		
		// Un label
		JLabel lblDcouvertAutoris = new JLabel("D\u00E9couvert autoris\u00E9");
		GridBagConstraints gbc_lblDcouvertAutoris = new GridBagConstraints();
		gbc_lblDcouvertAutoris.anchor = GridBagConstraints.EAST;
		gbc_lblDcouvertAutoris.insets = new Insets(0, 0, 5, 5);
		gbc_lblDcouvertAutoris.gridx = 0;
		gbc_lblDcouvertAutoris.gridy = 7;
		add(lblDcouvertAutoris, gbc_lblDcouvertAutoris);
		
		// textField permettant l'affichage du d�couvert SI le compte en cours est un compte COURANT
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.anchor = GridBagConstraints.WEST;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 7;
		add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		textField_5.setEditable(false);
		
		
		
		// Un label MANIPULER UN COMPTE
		JLabel lblManipulerUnCompte = new JLabel("Manipuler un compte");
		lblManipulerUnCompte.setFont(new Font("Georgia", Font.PLAIN, 14));
		GridBagConstraints gbc_lblManipulerUnCompte = new GridBagConstraints();
		gbc_lblManipulerUnCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblManipulerUnCompte.gridx = 3;
		gbc_lblManipulerUnCompte.gridy = 2;
		add(lblManipulerUnCompte, gbc_lblManipulerUnCompte);
		
		
		// Un label
		JLabel lblMontantDposer = new JLabel("Retrait");
		GridBagConstraints gbc_lblMontantDposer = new GridBagConstraints();
		gbc_lblMontantDposer.anchor = GridBagConstraints.EAST;
		gbc_lblMontantDposer.insets = new Insets(0, 0, 5, 5);
		gbc_lblMontantDposer.gridx = 3;
		gbc_lblMontantDposer.gridy = 3;
		add(lblMontantDposer, gbc_lblMontantDposer);
		
		// textField permettant de r�cup�rer le montant du RETRAIT � effectuer
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 3;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		
		// Un label
		JLabel lblDpt = new JLabel("D\u00E9p\u00F4t");
		GridBagConstraints gbc_lblDpt = new GridBagConstraints();
		gbc_lblDpt.anchor = GridBagConstraints.EAST;
		gbc_lblDpt.insets = new Insets(0, 0, 5, 5);
		gbc_lblDpt.gridx = 3;
		gbc_lblDpt.gridy = 4;
		add(lblDpt, gbc_lblDpt);
		
		// textField permettant de r�cup�rer le montant du DEPOT � effecter
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 4;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		
		// Un label
		JLabel lblNouveauSolde = new JLabel("Nouveau solde");
		GridBagConstraints gbc_lblNouveauSolde = new GridBagConstraints();
		gbc_lblNouveauSolde.anchor = GridBagConstraints.EAST;
		gbc_lblNouveauSolde.insets = new Insets(0, 0, 5, 5);
		gbc_lblNouveauSolde.gridx = 3;
		gbc_lblNouveauSolde.gridy = 6;
		add(lblNouveauSolde, gbc_lblNouveauSolde);
		
		// textField permettant d'afficher le nouveau solde apr�s avoir d�pos�/retir� de l'argent
		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.anchor = GridBagConstraints.WEST;
		gbc_textField_7.gridx = 4;
		gbc_textField_7.gridy = 6;
		add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		textField_7.setEditable(false);
		
		
		
		// Un label
		JLabel lblListeDesOprations = new JLabel("Liste des op\u00E9rations effectu\u00E9es");
		GridBagConstraints gbc_lblListeDesOprations = new GridBagConstraints();
		gbc_lblListeDesOprations.anchor = GridBagConstraints.EAST;
		gbc_lblListeDesOprations.insets = new Insets(0, 0, 5, 5);
		gbc_lblListeDesOprations.gridx = 0;
		gbc_lblListeDesOprations.gridy = 10;
		add(lblListeDesOprations, gbc_lblListeDesOprations);
		
		// textArea permettant d'afficher la table consultations pour le compte en cours.
		// Table consultation --> affiche les op�rations effectu�es sur un compte.
		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 4;
		gbc_textArea.gridy = 10;
		add(textArea, gbc_textArea);
		textArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 10;
		add(scrollPane, gbc_scrollPane);
		
		
		
		
		// CONNEXION A UN COMPTE
		JButton btnAfficherLeSolde = new JButton("Connexion au compte");
		btnAfficherLeSolde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				// Mise � z�ro des textField
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_7.setText("");
				textArea.setText("");
				
				// R�cup�ration des valeurs des textField
				// R�cup�ration du num�ro de compte auquel se connecter
				String tempo = textField.getText();
				numCom = Integer.parseInt(tempo);
				
				// Appel � la fonction permettant d'afficher le solde du compte + Affichage
				sol = base.consulte(numCom);
				textField_3.setText(String.valueOf(sol));
				
				// R�cup�ration de la table consultations
				String consultations = base.afficheConsulations(numCom); // Appel � la fonction permettant de r�cup�rer ce qui se trouve dans
																		// la table consulation pour le compte en cours.
				textArea.setText(consultations); // Affichage de l'historique des manipulations de compte.
				
				// R�cup�ration du type de compte auquel on se connecte pour savoir si l'on r�cup�re dans la base le taux, le d�couvert ou rien.
				type = base.recupType(numCom);
				switch (type)
				{
				// Cas compte classique
				case 1 :
					break;
					// Cas compte �pargne
					// On ne r�cup�re ni le taux ni le d�couvert.
				case 2 :
					// Appel � la fonction de r�cup�ration du taux des comptes �pargne + Affichage
					double tauxActu = base.recupTaux(numCom);
					textField_4.setText(String.valueOf(tauxActu));
					break;
					// Cas compte courant
				case 3 :
					// Appel � la fonction de r�cup�ration du d�couvert autoris� + Affichage
					decouvActu = base.recupDecouvert(numCom);
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
		
		
		
		// EFFECTUER UN RETRAIT ET/OU UN DEPOT
		JButton btnEffectuer = new JButton("Effectuer");
		btnEffectuer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				// R�cup�ration des valeurs des textField
				
				// Si le champ "D�p�t" est vide, on lui donne la valeur 0
				if (textField_1.getText().equals(""))
				{
					textField_1.setText("0");
				}
				// R�cup�ration du contenu du textField "D�p�t"
				String tempo = textField_1.getText();
				double sommeBis = Double.parseDouble(tempo);
				
				// Si le montant du d�p�t est n�gatif, le d�p�t ne s'effectue pas.
				if (sommeBis <0)
				{
					textField_1.setText("D�p�t invalide");
				}
				else
				{
					base.deposer(numCom, sommeBis); // Appel � la fonction effectuant le d�p�t
				}
				
				// R�cup�ration du nouveau solde apr�s un d�p�t.
				// R�cup�ration indispensable pour pouvoir faire en m�me temps un d�p�t et un retrait.
				sol = base.consulte(numCom);
				
				// Si le champ "Retrait" est vide, on lui donne la valeur 0
				if (textField_2.getText().equals(""))
				{
					textField_2.setText("0");
				}
				// R�cup�ration du contenu du textField "Retrait"
				tempo = textField_2.getText();
				double somme = Double.parseDouble(tempo);
				
				// V�rification que le retrait peut �tre effectu� sans d�passer le d�couvert.
				if ((decouvActu + sol) < somme)
				{
					// cr�ation de la frame d'erreur
					JFrame frame = null;
					//fenetre d'erreur
					JOptionPane.showMessageDialog(frame,
					    "Op�ration Impossible : D�couvert autoris� d�pass�",
					    "D�couvert",
					    JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					base.retirer(numCom, somme); // Appel � la fonction effectuant le retrait.
				}
				
				// On r�cup�re le nouveau solde apr�s un retrait.
				sol = base.consulte(numCom);
				// Affichage du nouveau solde dans les deux textField affichant le solde 
				textField_7.setText(String.valueOf(sol));
				textField_3.setText(String.valueOf(sol));
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
