import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;


public class RandomMyHero implements Observer, ActionListener{

	private JFrame frmRandomMyHero;
	private JTextField txtHero;
	private HeroRandomizer rando;
	private JButton btnRandomStrength;
	private JButton btnRandomAgility;
	private JButton btnRandomIntelligence;
	private JButton btnRandomAll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandomMyHero window = new RandomMyHero();
					window.frmRandomMyHero.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RandomMyHero() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.rando = new HeroRandomizer(this);
		frmRandomMyHero = new JFrame();
		frmRandomMyHero.setResizable(false);
		frmRandomMyHero.setTitle("Random My Hero");
		frmRandomMyHero.setBounds(100, 100, 450, 196);
		frmRandomMyHero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRandomMyHero.getContentPane().setLayout(null);
		
		txtHero = new JTextField();
		txtHero.setHorizontalAlignment(SwingConstants.CENTER);
		txtHero.setEditable(false);
		txtHero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtHero.setText("Press a button to random your hero!");
		txtHero.setBounds(10, 10, 414, 25);
		
		frmRandomMyHero.getContentPane().add(txtHero);
		txtHero.setColumns(10);
		
		btnRandomStrength = new JButton("Random Strength");
		btnRandomStrength.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRandomStrength.setBounds(10, 57, 133, 23);
		btnRandomStrength.addActionListener(this);
		frmRandomMyHero.getContentPane().add(btnRandomStrength);
		
		btnRandomAgility = new JButton("Random Agility");
		btnRandomAgility.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRandomAgility.setBounds(150, 57, 133, 23);
		btnRandomAgility.addActionListener(this);
		frmRandomMyHero.getContentPane().add(btnRandomAgility);
		
		btnRandomIntelligence = new JButton("Random Intelligence");
		btnRandomIntelligence.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRandomIntelligence.setBounds(291, 57, 133, 23);
		btnRandomIntelligence.addActionListener(this);
		frmRandomMyHero.getContentPane().add(btnRandomIntelligence);
		
		btnRandomAll = new JButton("Random All");
		btnRandomAll.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRandomAll.setBounds(10, 87, 414, 74);
		btnRandomAll.addActionListener(this);
		btnRandomAll.getInputMap(btnRandomAll.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "randomAll");
		btnRandomAll.getActionMap().put("randomAll", new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			rando.randomHero(0);  // some function
		}
		});
		
		frmRandomMyHero.getContentPane().add(btnRandomAll);
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		txtHero.setText(arg.toString());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRandomAll) {
			rando.randomHero(0);
		}
		if (e.getSource() == btnRandomStrength) {
			rando.randomHero(1);
		}
		if (e.getSource() == btnRandomAgility) {
			rando.randomHero(2);
		}
		if (e.getSource() == btnRandomIntelligence) {
			rando.randomHero(3);
		}
		
	}
}
