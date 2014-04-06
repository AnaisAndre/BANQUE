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

public class test {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
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
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		
		JLabel lblChoisissezCeQue = new JLabel("Choisissez ce que vous d\u00E9sirez effectuer comme action :");
		lblChoisissezCeQue.setHorizontalTextPosition(SwingConstants.CENTER);
		lblChoisissezCeQue.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblChoisissezCeQue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblChoisissezCeQue.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblChoisissezCeQue);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		
		JButton btnCrerUnNouveau = new JButton("Cr\u00E9er un nouveau compte banquaire");
		panel_1.add(btnCrerUnNouveau);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3);
		
		JButton btnConsulterUnCompte = new JButton("Consulter les comptes ayant un solde n\u00E9gatif");
		panel_3.add(btnConsulterUnCompte);
		
		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4);
		
		JButton btnModifierLeTaux = new JButton("Modifier le taux de r\u00E9mun\u00E9ration des comptes \u00E9pargne");
		panel_4.add(btnModifierLeTaux);
		
		JPanel panel_5 = new JPanel();
		frame.getContentPane().add(panel_5);
		
		JPanel panel = new JPanel();
	}

}
