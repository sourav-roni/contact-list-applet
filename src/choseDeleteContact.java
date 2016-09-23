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
public class choseDeleteContact extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4581458052650972638L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					choseDeleteContact frame = new choseDeleteContact();
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
	public choseDeleteContact(final Acquaintances contactList) {
		setResizable(false);
		setTitle("Select Type of Contact");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 425);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 153));
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
		
		JLabel lblWhichTypeOf = new JLabel("Which Type of Contact do you want Delete ?");
		lblWhichTypeOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhichTypeOf.setBounds(140, 12, 351, 15);
		contentPane.add(lblWhichTypeOf);
		
		JButton btnRelatives = new JButton("Relatives");
		btnRelatives.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				relativeDelete relDel = new relativeDelete(contactList);
				relDel.setVisible(true);
			}
		});
		btnRelatives.setBounds(189, 69, 233, 25);
		contentPane.add(btnRelatives);
		
		JButton btnPersonalFriends = new JButton("Personal Friends");
		btnPersonalFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				personalDelete personDel = new personalDelete(contactList);
				personDel.setVisible(true);
			}
		});
		btnPersonalFriends.setBounds(189, 130, 233, 25);
		contentPane.add(btnPersonalFriends);
		
		JButton btnProfessionalFriends = new JButton("Professional Friends");
		btnProfessionalFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				professionalDelete professionalDel = new professionalDelete(contactList);
				professionalDel.setVisible(true);
			}
		});
		btnProfessionalFriends.setBounds(189, 187, 233, 25);
		contentPane.add(btnProfessionalFriends);
		
		JButton btnCasualAcquaintances = new JButton("Casual Acquaintances");
		btnCasualAcquaintances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				casualDelete casDel = new casualDelete(contactList);
				casDel.setVisible(true);
			}
		});
		btnCasualAcquaintances.setBounds(189, 251, 233, 25);
		contentPane.add(btnCasualAcquaintances);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(487, 310, 112, 55);
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
