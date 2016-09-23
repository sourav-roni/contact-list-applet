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
public class personalDisplay extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7517043590064042597L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					personalDisplay frame = new personalDisplay();
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
	public personalDisplay(Acquaintances contactList) {
		setResizable(false);
		setTitle("Contact List of Personal Friends");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 873, 492);
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
		
		JTable personalTable = new JTable();
		personalTableModel tableModel = new personalTableModel(contactList.personalFriendsList);
		personalTable.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(personalTable);
		scrollPane.setBounds(12, 12, 849, 440);
		contentPane.add(scrollPane);
	}

}
