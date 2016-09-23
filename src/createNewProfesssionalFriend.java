import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;

@SuppressWarnings("unused")
public class createNewProfesssionalFriend extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6892441009024482721L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createNewProfesssionalFriend frame = new createNewProfesssionalFriend();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public boolean isStringLong(String s)
	{
	    try
	    {
	        Long.parseLong(s);
	        return true;
	    } catch (NumberFormatException ex)
	    {
	        return false;
	    }
	}

	/**
	 * Create the frame.
	 */
	public createNewProfesssionalFriend(final Acquaintances contactList) {
		setResizable(false);
		setTitle("Add New Professional Friend");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 498);
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
		
		JLabel lblEnterTheName = new JLabel("Enter the Name of Your Professional Friend");
		lblEnterTheName.setBounds(28, 12, 376, 26);
		contentPane.add(lblEnterTheName);
		
		JLabel lblEnterTheMobile = new JLabel("Enter the Mobile Number of Your Professional Friend");
		lblEnterTheMobile.setBounds(28, 71, 376, 26);
		contentPane.add(lblEnterTheMobile);
		
		JLabel lblEnterTheEmail = new JLabel("Enter the E-mail  ID of Your Professional Friend");
		lblEnterTheEmail.setBounds(28, 137, 376, 26);
		contentPane.add(lblEnterTheEmail);
		
		JLabel lblEnterTheSpecific = new JLabel("<html>Enter the Specific common Interests<br> (100 characters Max.)");
		lblEnterTheSpecific.setBounds(38, 246, 339, 26);
		contentPane.add(lblEnterTheSpecific);
		
		textField = new JTextField();
		textField.setBounds(422, 13, 306, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(422, 72, 306, 26);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(422, 137, 306, 26);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(422, 212, 306, 94);
		contentPane.add(scrollPane);
		
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnSaveContact = new JButton("Save Contact");
		btnSaveContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean done = true;
				ProfessionalFriends addProfessional = new ProfessionalFriends();
				addProfessional.professionalFriendName = textField.getText();
				//boolean mobileNumber = true;
				addProfessional.professionalFriendMobileNumber = textField_1.getText();
				if(isStringLong(addProfessional.professionalFriendMobileNumber)==true){
					done = true;
				}
				else{
					done = false;
					textField_1.setText("");
					JOptionPane.showMessageDialog(null, "Invalid Mobile Number. Mobile Number Should contain only digits");
				}
				
				
				addProfessional.professionalFriendEmail = textField_2.getText();
				
				//boolean check = true;
				
				addProfessional.professionalFriendSpecificCommonInterest = textArea.getText();
				if(addProfessional.professionalFriendSpecificCommonInterest.length()<=100){
				}
				else{
					done = false;
					JOptionPane.showMessageDialog(null, "Too many Characters in the field Specific Common Interest");
					textArea.setText("");
				}
				if(done){
					contactList.professionalFriendsList.add(addProfessional);
					try
				      {
				         FileOutputStream fileOut = new FileOutputStream("contactlist");
				         ObjectOutputStream out = new ObjectOutputStream(fileOut);
				         out.writeObject(contactList);
				         out.flush();
				         out.close();
				         fileOut.close();
				         //System.out.println("\nAll Changes have been Saved Succcessfully!!");
				         //System.out.println("Thank You");
				      }catch(IOException exe)
				      {
				          exe.printStackTrace();
				      }
					JOptionPane.showMessageDialog(null, "One Professional Friend Successfully Added");
					setVisible(false);
				}
			}
		});
		btnSaveContact.setBounds(75, 374, 260, 61);
		try {
			image = ImageIO.read(getClass().getResource("/save.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnSaveContact.setIcon(new ImageIcon(image));
		contentPane.add(btnSaveContact);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(440, 374, 227, 57);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		try {
			image = ImageIO.read(getClass().getResource("/back.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnNewButton.setIcon(new ImageIcon(image));
		contentPane.add(btnNewButton);
		
	}

}
