import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("unused")
public class casualDisplay extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3826338499733141677L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					casualDisplay frame = new casualDisplay();
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
	public casualDisplay(Acquaintances contactList) {
		setResizable(false);
		setTitle("Contact List of Casual Acquaintances");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 502);
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
		
		JTable casualTable = new JTable();
		casualTableModel tableModel = new casualTableModel(contactList.casualAcquaintancesList);
		casualTable.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(casualTable);
		scrollPane.setBounds(12, 0, 641, 462);
		contentPane.add(scrollPane);
	}

}
