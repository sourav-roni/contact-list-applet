import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class chooseCreateContact extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3388684712877091633L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chooseCreateContact frame = new chooseCreateContact();
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
	public chooseCreateContact(final Acquaintances contactList) {
		setResizable(false);
		setTitle("Select type of Contact \n");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResource("/contactlist.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setIconImage(image);
		contentPane.setLayout(null);
		
		JLabel lblWhichTypeOf = new JLabel("Which Type of Contact do you want Create ?");
		lblWhichTypeOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhichTypeOf.setBounds(72, 38, 351, 15);
		contentPane.add(lblWhichTypeOf);
		
		JButton btnRelatives = new JButton("Relatives");
		btnRelatives.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createNewRelative addRelative = new createNewRelative(contactList);
				addRelative.setVisible(true);
			}
		});
		btnRelatives.setBounds(138, 78, 233, 25);
		contentPane.add(btnRelatives);
		
		JButton btnPersonalFriends = new JButton("Personal Friends");
		btnPersonalFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createNewPersonal addPersonal = new createNewPersonal(contactList);
				addPersonal.setVisible(true);
			}
		});
		btnPersonalFriends.setBounds(138, 129, 233, 25);
		contentPane.add(btnPersonalFriends);
		
		JButton btnProfessionalFriends = new JButton("Professional Friends");
		btnProfessionalFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createNewProfesssionalFriend addProfessional = new createNewProfesssionalFriend(contactList);
				addProfessional.setVisible(true);
			}
		});
		btnProfessionalFriends.setBounds(138, 182, 233, 25);
		contentPane.add(btnProfessionalFriends);
		
		JButton btnCasualAcquaintances = new JButton("Casual Acquaintances");
		btnCasualAcquaintances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createCasual addCasual = new createCasual(contactList);
				addCasual.setVisible(true);
			}
		});
		btnCasualAcquaintances.setBounds(138, 238, 233, 25);
		contentPane.add(btnCasualAcquaintances);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(368, 313, 117, 25);
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
