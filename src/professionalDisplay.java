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
public class professionalDisplay extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8206748390665143691L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					professionalDisplay frame = new professionalDisplay();
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
	public professionalDisplay(Acquaintances contactList) {
		setResizable(false);
		setTitle("Contact List of Professional Friends");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1003, 502);
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
		
		JTable professionalTable = new JTable();
		professionalTableModel tableModel = new professionalTableModel(contactList.professionalFriendsList);
		professionalTable.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(professionalTable);
		scrollPane.setBounds(12, 12, 979, 450);
		contentPane.add(scrollPane);
	}

}
