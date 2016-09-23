import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class chooseSpecificDispaly extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8203558693350028395L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chooseSpecificDispaly frame = new chooseSpecificDispaly();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public chooseSpecificDispaly(final Acquaintances contactList) {
		setResizable(false);
		setTitle("Choose type of Contact");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResource("/contactlist.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setIconImage(image);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWhichTypeOf = new JLabel("Which Type of Contact do you want to be displayed ?");
		lblWhichTypeOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhichTypeOf.setBounds(85, 12, 466, 15);
		contentPane.add(lblWhichTypeOf);
		
		JButton btnRelatives = new JButton("Relatives");
		btnRelatives.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				relativeDisplay relDisplay = new relativeDisplay(contactList);
				relDisplay.setVisible(true);
			}
		});
		btnRelatives.setBounds(195, 60, 233, 25);
		contentPane.add(btnRelatives);
		
		JButton btnPersonalFriends = new JButton("Personal Friends");
		btnPersonalFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				personalDisplay personDisplay = new personalDisplay(contactList);
				personDisplay.setVisible(true);
			}
		});
		btnPersonalFriends.setBounds(195, 115, 233, 25);
		contentPane.add(btnPersonalFriends);
		
		JButton btnProfessionalFriends = new JButton("Professional Friends");
		btnProfessionalFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				professionalDisplay profDisplay = new professionalDisplay(contactList);
				profDisplay.setVisible(true);
			}
		});
		btnProfessionalFriends.setBounds(195, 178, 233, 25);
		contentPane.add(btnProfessionalFriends);
		
		JButton btnCasualAcquaintances = new JButton("Casual Acquaintances");
		btnCasualAcquaintances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				casualDisplay casDisplay = new casualDisplay(contactList);
				casDisplay.setVisible(true);
			}
		});
		btnCasualAcquaintances.setBounds(195, 232, 233, 25);
		contentPane.add(btnCasualAcquaintances);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(485, 323, 117, 25);
		try {
			image = ImageIO.read(getClass().getResource("/back.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnBack.setIcon(new ImageIcon(image));
		contentPane.add(btnBack);
	}

}
