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
public class relativeDelete extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8352637763423477090L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					relativeDelete frame = new relativeDelete();
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
	public relativeDelete(final Acquaintances contactList) {
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 491);
		contentPane = new JPanel();
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
		
		final JTable relativeTable = new JTable();
		relativeTableModel tableModel = new relativeTableModel(contactList.relativesList);
		relativeTable.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(relativeTable);
		scrollPane.setBounds(12, 0, 685, 383);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Delete Contact\n");
		try {
			image = ImageIO.read(getClass().getResource("/delete.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnNewButton.setIcon(new ImageIcon(image));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = relativeTable.getSelectedRow();
				contactList.relativesList.remove(index);
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
				JOptionPane.showMessageDialog(null, "One Relative Successfully Deleted");
				setVisible(false);
			}
		});
		btnNewButton.setBounds(124, 408, 194, 25);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnBack.setBounds(458, 408, 158, 25);
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
