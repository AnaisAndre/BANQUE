package banque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;

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
	}

}
