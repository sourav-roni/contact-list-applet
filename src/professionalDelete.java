import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class professionalDelete extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1702616186256708919L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					professionalDelete frame = new professionalDelete();
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
	public professionalDelete(final Acquaintances contactList) {
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 503);
		BufferedImage image = null;
		try {
			image = ImageIO.read(getClass().getResource("/contactlist.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setIconImage(image);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTable professionalTable = new JTable();
		professionalTableModel tableModel = new professionalTableModel(contactList.professionalFriendsList);
		professionalTable.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(professionalTable);
		scrollPane.setBounds(12, 12, 662, 393);
		contentPane.add(scrollPane);
		
		JButton btnDeleteContact = new JButton("Delete Contact");
		btnDeleteContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = professionalTable.getSelectedRow();
				contactList.professionalFriendsList.remove(index);
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
				JOptionPane.showMessageDialog(null, "One Professional Friend Successfully Deleted");
				setVisible(false);
			}
		});
		btnDeleteContact.setBounds(129, 417, 175, 25);
		try {
			image = ImageIO.read(getClass().getResource("/delete.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnDeleteContact.setIcon(new ImageIcon(image));
		contentPane.add(btnDeleteContact);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(412, 417, 163, 25);
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
