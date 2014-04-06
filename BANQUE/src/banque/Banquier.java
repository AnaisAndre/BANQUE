package banque;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;

public class Banquier
{
	Scanner saisie = new Scanner(System.in);
	int rep, numC;
	String nomT;
	double soldeBis;
	
	private JFrame frmBanquier;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Banquier window = new Banquier();
					window.frmBanquier.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Banquier() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBanquier = new JFrame();
		frmBanquier.setTitle("Interface banquier");
		frmBanquier.setBounds(100, 100, 450, 300);
		frmBanquier.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBanquier.getContentPane().setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		frmBanquier.getContentPane().add(panel_1);
		
		JLabel lblChoisissezCeQue = new JLabel("Choisissez ce que vous d\u00E9sirez effectuer comme action :");
		panel_1.add(lblChoisissezCeQue);
		lblChoisissezCeQue.setHorizontalTextPosition(SwingConstants.CENTER);
		lblChoisissezCeQue.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblChoisissezCeQue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblChoisissezCeQue.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_2 = new JPanel();
		frmBanquier.getContentPane().add(panel_2);
		
		JButton btnCrerUnNouveau = new JButton("Cr\u00E9er un nouveau compte banquaire");
		btnCrerUnNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Numéro du compte : ");
				numC = saisie.nextInt();
				System.out.println("Nom du titulaire : ");
				nomT = saisie.next();
				System.out.println("Solde de départ : ");
				soldeBis = saisie.nextDouble();
				
				compte unCompte = new compte(numC,nomT,soldeBis);
				
				unCompte.consulte();
			}
		});
		panel_2.add(btnCrerUnNouveau);
		btnCrerUnNouveau.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCrerUnNouveau.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JPanel panel_3 = new JPanel();
		frmBanquier.getContentPane().add(panel_3);
		
		JButton btnConsulterUnCompte = new JButton("Consulter les comptes ayant un solde n\u00E9gatif");
		btnConsulterUnCompte.setHorizontalTextPosition(SwingConstants.CENTER);
		panel_3.add(btnConsulterUnCompte);
		
		JPanel panel_4 = new JPanel();
		frmBanquier.getContentPane().add(panel_4);
		
		JButton btnModifierLeTaux = new JButton("Modifier le taux de r\u00E9mun\u00E9ration des comptes \u00E9pargne");
		btnModifierLeTaux.setHorizontalTextPosition(SwingConstants.CENTER);
		panel_4.add(btnModifierLeTaux);
		
		JPanel panel_5 = new JPanel();
		frmBanquier.getContentPane().add(panel_5);
		
		JButton btnAfficherLaListe = new JButton("Afficher la liste des titulaires d'un compte \u00E9pargne et d'un compte courant");
		btnAfficherLaListe.setHorizontalTextPosition(SwingConstants.CENTER);
		panel_5.add(btnAfficherLaListe);
		
		JPanel panel_6 = new JPanel();
		frmBanquier.getContentPane().add(panel_6);
		
		JButton btnModifierLeMontant = new JButton("Modifier le montant du d\u00E9couvert autoris\u00E9");
		panel_6.add(btnModifierLeMontant);
	}

}
