import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

@SuppressWarnings("unused")
public class displayAll extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6329073683128968213L;
	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayAll frame = new displayAll();
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
	public displayAll(Acquaintances contactList) {
		setResizable(false);
		setTitle("Your Contact List");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 493);
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 5, 842, 448);
		contentPane.add(tabbedPane);
		JTable relativeTable = new JTable();
		relativeTableModel tableModel = new relativeTableModel(contactList.relativesList);
		relativeTable.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(relativeTable);
		tabbedPane.addTab("Relatives", null, scrollPane, null);
		
		JTable personalTable = new JTable();
		personalTableModel tableModel_1 = new personalTableModel(contactList.personalFriendsList);
		personalTable.setModel(tableModel_1);
		JScrollPane scrollPane_1 = new JScrollPane(personalTable);
		tabbedPane.addTab("Personal Friends", null, scrollPane_1, null);
		
		JTable professionalTable = new JTable();
		professionalTableModel tableModel_2 = new professionalTableModel(contactList.professionalFriendsList);
		professionalTable.setModel(tableModel_2);
		JScrollPane scrollPane_2 = new JScrollPane(professionalTable);
		tabbedPane.addTab("Professsional Friends", null, scrollPane_2, null);
		
		JTable casualTable = new JTable();
		casualTableModel tableModel_3 = new casualTableModel(contactList.casualAcquaintancesList);
		casualTable.setModel(tableModel_3);
		JScrollPane scrollPane_3 = new JScrollPane(casualTable);
		tabbedPane.addTab("Casual Acquaintances", null, scrollPane_3, null);
	}
}
