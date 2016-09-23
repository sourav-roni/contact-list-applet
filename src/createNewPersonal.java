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

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("unused")
public class createNewPersonal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6445456423543305247L;
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
					createNewPersonal frame = new createNewPersonal();
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
	public createNewPersonal(final Acquaintances contactList) {
		setResizable(false);
		setTitle("Add Personal Friend");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 519);
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
		
		JLabel lblEnterTheName = new JLabel("Enter the Name of Your Personal Friend");
		lblEnterTheName.setBounds(35, 43, 312, 15);
		contentPane.add(lblEnterTheName);
		
		JLabel lblEnterTheMobile = new JLabel("<html>Enter the Mobile number of your Personal Friend<br>(Note Mobile Number should be valid)");
		lblEnterTheMobile.setBounds(35, 77, 352, 33);
		contentPane.add(lblEnterTheMobile);
		
		JLabel lblEnterTheEmail = new JLabel("Enter the E-mail ID of Your Personal Friend");
		lblEnterTheEmail.setBounds(35, 139, 352, 15);
		contentPane.add(lblEnterTheEmail);
		
		JLabel lblEnterTheContext = new JLabel("<html>Enter the Context of Acquaintance with Your Personal Friend <br> (100 characters Max.)");
		lblEnterTheContext.setBounds(35, 180, 447, 46);
		contentPane.add(lblEnterTheContext);
		
		JLabel lblEnterTheDate = new JLabel("<html>Enter the Date of Acquaintance with your Personal Friend<br>(Please Enter Date in (dd/MM/yyyy) format");
		lblEnterTheDate.setBounds(35, 248, 432, 29);
		contentPane.add(lblEnterTheDate);
		
		JLabel lblEnterTheSpecific = new JLabel("<html>Enter the Specific Events<br>(100 characters Max)");
		lblEnterTheSpecific.setBounds(38, 310, 385, 46);
		contentPane.add(lblEnterTheSpecific);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(483, 180, 259, 46);
		contentPane.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(479, 310, 263, 67);
		contentPane.add(scrollPane_1);
		
		final JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(485, 248, 196, 33);
		contentPane.add(dateChooser);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		
		JButton btnSaveContact = new JButton("Save Contact");
		btnSaveContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean done = true;
				SimpleDateFormat datef = new SimpleDateFormat("dd/MM/yyyy");
				PersonalFriends addPersonal = new PersonalFriends();
				addPersonal.personalFriendName = textField.getText();
				addPersonal.personalFriendMobileNumber = textField_1.getText();
				addPersonal.personalFriendEmail = textField_2.getText();
				addPersonal.personalFriendContextOfAcqaintance = textArea.getText();
				addPersonal.personalFriendDateOfAcquaintance = datef.format(dateChooser.getDate());
				addPersonal.personalFriendSpecificEvents = textArea_1.getText();
				
				if(isStringLong(addPersonal.personalFriendMobileNumber)==false){
					done = false;
					textField_1.setText("");
					JOptionPane.showMessageDialog(null, "Invalid Mobile Number. Mobile Number Should contain only digits");
				}
				/*try {
					addPersonal.dateOfAcquaintance.setTime(datef.parse(addPersonal.personalFriendDateOfAcquaintance));
					//System.out.println("OhYes");
					}
			    catch (ParseException e) {
			    	textField_3.setText("");
			    	JOptionPane.showMessageDialog(null, "Invalid Date format");
			    	done = false;
				}*/
				if(addPersonal.personalFriendContextOfAcqaintance.length()>100){
					done = false;
					JOptionPane.showMessageDialog(null, "Too many Characters in the field Context of Acquaintance");
					textArea.setText("");
				}
				if(addPersonal.personalFriendSpecificEvents.length()>100){
					done = false;
					JOptionPane.showMessageDialog(null, "Too many Characters in the field Specific Events");
					textArea_1.setText("");
				}
				if(done){
					contactList.personalFriendsList.add(addPersonal);
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
					JOptionPane.showMessageDialog(null, "One Personal Friend Successfully Added");
					setVisible(false);
				}
			}
		});
		btnSaveContact.setBounds(155, 407, 172, 40);
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
		btnBack.setBounds(463, 405, 158, 44);
		try {
			image = ImageIO.read(getClass().getResource("/back.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnBack.setIcon(new ImageIcon(image));
		contentPane.add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(483, 31, 259, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(483, 77, 259, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(483, 132, 259, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
	}
}
