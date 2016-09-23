import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("unused")
public class createNewRelative extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2644244724360264106L;
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
					createNewRelative frame = new createNewRelative();
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
	public createNewRelative(final Acquaintances contactList) {
		setResizable(false);
		setTitle("Add New Relative");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 500);
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
		
		JLabel lblEnterTheName = new JLabel("Enter the Name of Your Relative");
		lblEnterTheName.setBounds(35, 36, 281, 31);
		contentPane.add(lblEnterTheName);
		
		JLabel lblEnterTheMobile = new JLabel("Enter the Mobile Number of Your Relative");
		lblEnterTheMobile.setBounds(35, 86, 318, 36);
		contentPane.add(lblEnterTheMobile);
		
		JLabel lblEnterTheEmail = new JLabel("Enter the E-mail ID of your Relative");
		lblEnterTheEmail.setBounds(35, 149, 304, 31);
		contentPane.add(lblEnterTheEmail);
		
		JLabel lblEnterTheDate = new JLabel("<html>Enter the Date of Birth of Your Relative<br>(In dd/mm/yyyy format)");
		lblEnterTheDate.setBounds(35, 217, 298, 30);
		contentPane.add(lblEnterTheDate);
		
		JLabel lblEnterTheDate_1 = new JLabel("<html>Enter the date of Last meeting with Your Relative<br>(In dd/mm/yyyy format)");
		lblEnterTheDate_1.setBounds(31, 275, 373, 25);
		contentPane.add(lblEnterTheDate_1);
		
		textField = new JTextField();
		textField.setBounds(384, 36, 267, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(384, 92, 267, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(384, 155, 267, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(385, 211, 165, 25);
		contentPane.add(dateChooser);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		
		final JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(384, 269, 166, 25);
		contentPane.add(dateChooser_1);
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		
		JButton btnSaveContact = new JButton("Save Contact");
		btnSaveContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Relatives addRelative = new Relatives();
				boolean done = true;
				addRelative.relativeName = textField.getText();
				addRelative.relativeMobileNumber = textField_1.getText();
				if(isStringLong(addRelative.relativeMobileNumber)==false){
					done = false;
					textField_1.setText("");
					JOptionPane.showMessageDialog(null, "Invalid Mobile Number. Mobile Number Should contain only digits");
				}
				
				addRelative.relativeEmail = textField_2.getText();
				SimpleDateFormat datef = new SimpleDateFormat("dd/MM/yyyy");
				addRelative.relativeBirthday = datef.format(dateChooser.getDate());
				/*try {
					addRelative.dateOfBirth.setTime(datef.parse(addRelative.relativeBirthday));
					//System.out.println("OhYes");
					}
			    catch (ParseException e) {
			    	dateChooser.setT("");
			    	JOptionPane.showMessageDialog(null, "Invalid Date format");
			    	done = false;
				}*/
				addRelative.relativeDateOfLastMeeting = datef.format(dateChooser_1.getDate());
				/*try {
					addRelative.dateOfLastMeet.setTime(datef.parse(addRelative.relativeDateOfLastMeeting));
					}
			    catch (ParseException e) {
			    	textField_4.setText("");
			    	JOptionPane.showMessageDialog(null, "Invalid Date format");
			    	done = false;
				}*/
				if(done){
					contactList.relativesList.add(addRelative);
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
					JOptionPane.showMessageDialog(null, "One Relative Successfully Added");
					setVisible(false);
				}
			}
		});
		btnSaveContact.setBounds(123, 355, 172, 43);
		try {
			image = ImageIO.read(getClass().getResource("/save.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnSaveContact.setIcon(new ImageIcon(image));
		contentPane.add(btnSaveContact);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(442, 355, 182, 43);
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
