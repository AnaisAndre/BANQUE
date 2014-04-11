package banque;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.JScrollBar;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Banquier extends JPanel 
{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public Banquier() {
		setBackground(Color.PINK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {255, 150, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNumroDeCompte = new JLabel("Num\u00E9ro de compte");
		GridBagConstraints gbc_lblNumroDeCompte = new GridBagConstraints();
		gbc_lblNumroDeCompte.anchor = GridBagConstraints.EAST;
		gbc_lblNumroDeCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumroDeCompte.gridx = 0;
		gbc_lblNumroDeCompte.gridy = 2;
		add(lblNumroDeCompte, gbc_lblNumroDeCompte);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSoldeInitial = new JLabel("Solde initial");
		GridBagConstraints gbc_lblSoldeInitial = new GridBagConstraints();
		gbc_lblSoldeInitial.anchor = GridBagConstraints.EAST;
		gbc_lblSoldeInitial.insets = new Insets(0, 0, 5, 5);
		gbc_lblSoldeInitial.gridx = 0;
		gbc_lblSoldeInitial.gridy = 3;
		add(lblSoldeInitial, gbc_lblSoldeInitial);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.WEST;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JButton btnCrer = new JButton("Cr\u00E9er");
		btnCrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				String name = textField.getText();
				System.out.println("JE SUIS LE NAME : " + name);
			}
		});
		GridBagConstraints gbc_btnCrer = new GridBagConstraints();
		gbc_btnCrer.anchor = GridBagConstraints.WEST;
		gbc_btnCrer.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrer.gridx = 1;
		gbc_btnCrer.gridy = 4;
		add(btnCrer, gbc_btnCrer);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 2;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 5;
		add(separator, gbc_separator);
		
		JLabel lblModifierLeTaux = new JLabel("Modifier le taux de r\u00E9mun\u00E9ration");
		lblModifierLeTaux.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblModifierLeTaux = new GridBagConstraints();
		gbc_lblModifierLeTaux.anchor = GridBagConstraints.WEST;
		gbc_lblModifierLeTaux.insets = new Insets(0, 0, 5, 5);
		gbc_lblModifierLeTaux.gridx = 0;
		gbc_lblModifierLeTaux.gridy = 6;
		add(lblModifierLeTaux, gbc_lblModifierLeTaux);
		
		JLabel lblNDuCompte = new JLabel("N\u00B0 du compte");
		GridBagConstraints gbc_lblNDuCompte = new GridBagConstraints();
		gbc_lblNDuCompte.anchor = GridBagConstraints.EAST;
		gbc_lblNDuCompte.insets = new Insets(0, 0, 5, 5);
		gbc_lblNDuCompte.gridx = 0;
		gbc_lblNDuCompte.gridy = 7;
		add(lblNDuCompte, gbc_lblNDuCompte);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.WEST;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 7;
		add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNouveauTauxDe = new JLabel("Nouveau taux de r\u00E9mun\u00E9ration");
		GridBagConstraints gbc_lblNouveauTauxDe = new GridBagConstraints();
		gbc_lblNouveauTauxDe.anchor = GridBagConstraints.EAST;
		gbc_lblNouveauTauxDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblNouveauTauxDe.gridx = 0;
		gbc_lblNouveauTauxDe.gridy = 8;
		add(lblNouveauTauxDe, gbc_lblNouveauTauxDe);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.WEST;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 8;
		add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JButton btnModifier = new JButton("Modifier");
		GridBagConstraints gbc_btnModifier = new GridBagConstraints();
		gbc_btnModifier.anchor = GridBagConstraints.WEST;
		gbc_btnModifier.insets = new Insets(0, 0, 5, 0);
		gbc_btnModifier.gridx = 1;
		gbc_btnModifier.gridy = 9;
		add(btnModifier, gbc_btnModifier);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.gridwidth = 2;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 0;
		gbc_separator_1.gridy = 10;
		add(separator_1, gbc_separator_1);
		
		JLabel lblModifier = new JLabel("Modifier le montant du d\u00E9couvert autoris\u00E9");
		lblModifier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblModifier = new GridBagConstraints();
		gbc_lblModifier.anchor = GridBagConstraints.WEST;
		gbc_lblModifier.insets = new Insets(0, 0, 5, 5);
		gbc_lblModifier.gridx = 0;
		gbc_lblModifier.gridy = 11;
		add(lblModifier, gbc_lblModifier);
		
		JLabel lblNDuCompte_1 = new JLabel("N\u00B0 du compte");
		GridBagConstraints gbc_lblNDuCompte_1 = new GridBagConstraints();
		gbc_lblNDuCompte_1.anchor = GridBagConstraints.EAST;
		gbc_lblNDuCompte_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNDuCompte_1.gridx = 0;
		gbc_lblNDuCompte_1.gridy = 12;
		add(lblNDuCompte_1, gbc_lblNDuCompte_1);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.anchor = GridBagConstraints.WEST;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 12;
		add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNouveauDcouvert = new JLabel("Nouveau d\u00E9couvert");
		GridBagConstraints gbc_lblNouveauDcouvert = new GridBagConstraints();
		gbc_lblNouveauDcouvert.anchor = GridBagConstraints.EAST;
		gbc_lblNouveauDcouvert.insets = new Insets(0, 0, 5, 5);
		gbc_lblNouveauDcouvert.gridx = 0;
		gbc_lblNouveauDcouvert.gridy = 13;
		add(lblNouveauDcouvert, gbc_lblNouveauDcouvert);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.anchor = GridBagConstraints.WEST;
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 13;
		add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		JButton btnModifier_1 = new JButton("Modifier");
		GridBagConstraints gbc_btnModifier_1 = new GridBagConstraints();
		gbc_btnModifier_1.anchor = GridBagConstraints.WEST;
		gbc_btnModifier_1.gridx = 1;
		gbc_btnModifier_1.gridy = 14;
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
