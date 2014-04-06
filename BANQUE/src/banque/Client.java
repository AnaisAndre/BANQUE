package banque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Client {

	private JFrame frmInterfaceClient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.frmInterfaceClient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInterfaceClient = new JFrame();
		frmInterfaceClient.setTitle("Interface client");
		frmInterfaceClient.setBounds(100, 100, 450, 300);
		frmInterfaceClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInterfaceClient.getContentPane().setLayout(new GridLayout(7, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frmInterfaceClient.getContentPane().add(panel);
		
		JLabel lblChoisissezUneAction = new JLabel("Choisissez une action \u00E0 effectuer :");
		panel.add(lblChoisissezUneAction);
		
		JPanel panel_1 = new JPanel();
		frmInterfaceClient.getContentPane().add(panel_1);
		
		JButton btnConsulterLeSolde = new JButton("Consulter le solde de votre compte");
		panel_1.add(btnConsulterLeSolde);
		
		JPanel panel_2 = new JPanel();
		frmInterfaceClient.getContentPane().add(panel_2);
		
		JButton btnFaireUnRetrait = new JButton("Faire un retrait sur votre compte");
		panel_2.add(btnFaireUnRetrait);
		
		JPanel panel_3 = new JPanel();
		frmInterfaceClient.getContentPane().add(panel_3);
		
		JButton btnFaireUnDpt = new JButton("Faire un d\u00E9p\u00F4t sur votre compte");
		panel_3.add(btnFaireUnDpt);
		
		JPanel panel_4 = new JPanel();
		frmInterfaceClient.getContentPane().add(panel_4);
		
		JButton btnConnatreLeMontant = new JButton("Conna\u00EEtre le montant du d\u00E9couvert autoris\u00E9 sur votre compte courant");
		panel_4.add(btnConnatreLeMontant);
		
		JPanel panel_5 = new JPanel();
		frmInterfaceClient.getContentPane().add(panel_5);
		
		JButton btnConnatreLaTaux = new JButton("Conna\u00EEtre la taux de r\u00E9mun\u00E9ration de votre compte \u00E9pargne");
		panel_5.add(btnConnatreLaTaux);
		
		JPanel panel_6 = new JPanel();
		frmInterfaceClient.getContentPane().add(panel_6);
		
		JButton btnConsulterLaListe = new JButton("Consulter la liste des op\u00E9rations que vous avez effectu\u00E9es");
		panel_6.add(btnConsulterLaListe);
	}

}
