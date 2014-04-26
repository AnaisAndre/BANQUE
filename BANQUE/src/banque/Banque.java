package banque;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Banque
{
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		bddConnect base = new bddConnect();
		base.compteEpAndCo();
		//base.titulaireEnDecouvert();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Banque window = new Banque();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Banque() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 609);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmBanquier = new JMenuItem("Banquier");
		mntmBanquier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//CreationCompte PCreaPanel = new CreationCompte();
				Banquier PCreaPanel = new Banquier();
				frame.setContentPane(PCreaPanel);
				frame.setVisible(true);
			}
		});
		menuBar.add(mntmBanquier);
		
		JMenuItem mntmClient = new JMenuItem("Client");
		mntmClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Client PCreaPanel = new Client();
				frame.setContentPane(PCreaPanel);
				frame.setVisible(true);
			}
		});
		menuBar.add(mntmClient);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		menuBar.add(mntmQuitter);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
	}
}
