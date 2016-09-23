import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

@SuppressWarnings("unused")
public class relativeDisplay extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -27397681713418417L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					relativeDisplay frame = new relativeDisplay();
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
	public relativeDisplay(Acquaintances contactList) {
		setResizable(false);
		setTitle("Contact List of Relatives");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 445);
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
		
		JTable relativeTable = new JTable();
		relativeTableModel tableModel = new relativeTableModel(contactList.relativesList);
		relativeTable.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(relativeTable);
		scrollPane.setBounds(12, 12, 690, 393);
		contentPane.add(scrollPane);
	}
}
