import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;

@SuppressWarnings("unused")
public class createCasual extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8346688980814577415L;
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
					createCasual frame = new createCasual();
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
	public createCasual(final Acquaintances contactList) {
		setResizable(false);
		setTitle("Add casual Acquaintances");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 516);
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
		
		JLabel lblEnterTheName = new JLabel("Enter the Name of Your Casual Acquaintance");
		lblEnterTheName.setBounds(31, 12, 340, 31);
		contentPane.add(lblEnterTheName);
		
		JLabel lblEnterTheMobile = new JLabel("Enter the Mobile Number of Your Casual Acquaintance");
		lblEnterTheMobile.setBounds(31, 50, 390, 31);
		contentPane.add(lblEnterTheMobile);
		
		JLabel lblEnterTheEmail = new JLabel("Enter the E-mail ID of Your Casual Acquaintance");
		lblEnterTheEmail.setBounds(31, 88, 340, 31);
		contentPane.add(lblEnterTheEmail);
		
		JLabel lblwhereAndWhen = new JLabel("<html>Where and When did you meet the  Casual Acquaintance.<br>(100 characters Max.)");
		lblwhereAndWhen.setBounds(31, 156, 413, 31);
		contentPane.add(lblwhereAndWhen);
		
		JLabel lblunderWhatCircumstances = new JLabel("<html>Under what circumstances did you meet the Casual Acquaintance.<br>(100 characters Max.)");
		lblunderWhatCircumstances.setBounds(31, 241, 413, 59);
		contentPane.add(lblunderWhatCircumstances);
		
		JLabel lblotherUsefulInformation = new JLabel("<html>Other Useful Information.<br> (100 characters Max.)");
		lblotherUsefulInformation.setBounds(31, 342, 362, 31);
		contentPane.add(lblotherUsefulInformation);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(441, 141, 253, 68);
		contentPane.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(445, 232, 249, 68);
		contentPane.add(scrollPane_1);
		
		final JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(441, 326, 253, 68);
		contentPane.add(scrollPane_2);
		
		final JTextArea textArea_2 = new JTextArea();
		scrollPane_2.setViewportView(textArea_2);
		
		JButton btnSaveContact = new JButton("Save Contact");
		btnSaveContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean done = true;
				CasualAcquaintances addCasual = new CasualAcquaintances();
				addCasual.casualAcquaintanceName = textField.getText();
				addCasual.casualAcquaintanceMobileNumber = textField_1.getText();
				addCasual.casualAcquaintanceEmail = textField_2.getText();
				addCasual.casualAcquaintanceWhenAndWhere  = textArea.getText();
				addCasual.casualAcquaintanceCircumstances  = textArea_1.getText();
				addCasual.casualAcquaintanceSpecificInformation  = textArea_2.getText();
				if(isStringLong(addCasual.casualAcquaintanceMobileNumber)==false){
					done = false;
					textField_1.setText("");
					JOptionPane.showMessageDialog(null, "Invalid Mobile Number. Mobile Number Should contain only digits");
				}
				if(addCasual.casualAcquaintanceWhenAndWhere.length()>100){
					done = false;
					JOptionPane.showMessageDialog(null, "Too many Characters in the field When and Where");
					textArea.setText("");
				}
				if(addCasual.casualAcquaintanceCircumstances.length()>100){
					done = false;
					JOptionPane.showMessageDialog(null, "Too many Characters in the field Circumstances");
					textArea_1.setText("");
				}
				if(addCasual.casualAcquaintanceSpecificInformation.length()>100){
					done = false;
					JOptionPane.showMessageDialog(null, "Too many Characters in the field Specific Informations");
					textArea_2.setText("");
				}
				if(done){
					contactList.casualAcquaintancesList.add(addCasual);
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
					JOptionPane.showMessageDialog(null, "One Casual Acquaintance Successfully Added");
					setVisible(false);
				}
			}
		});
		btnSaveContact.setBounds(133, 432, 191, 38);
		try {
			image = ImageIO.read(getClass().getResource("/save.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnSaveContact.setIcon(new ImageIcon(image));
		contentPane.add(btnSaveContact);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(418, 432, 176, 38);
		btnBack.addActionListener(new ActionListener() {
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
		btnBack.setIcon(new ImageIcon(image));
		contentPane.add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(445, 12, 249, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(445, 50, 249, 25);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(445, 88, 249, 25);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
	}

}
