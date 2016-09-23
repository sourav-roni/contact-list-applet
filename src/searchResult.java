import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

@SuppressWarnings("unused")
public class searchResult extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6038487891669451058L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchResult frame = new searchResult();
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
	public searchResult(final Acquaintances contactList,String name) {
		setTitle("Search Results");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 12, 613, 445);
		contentPane.add(tabbedPane);
		
		ArrayList<Relatives> relativesList = new ArrayList<Relatives>();
		ArrayList<PersonalFriends> personalFriendsList = new ArrayList<PersonalFriends>();
		ArrayList<ProfessionalFriends> professionalFriendsList = new ArrayList<ProfessionalFriends>();
		ArrayList<CasualAcquaintances> casualAcquaintancesList = new ArrayList<CasualAcquaintances>();
		
		int i=0;
		for(i=0;i<contactList.relativesList.size();i++){
			if(contactList.relativesList.get(i).relativeName.equalsIgnoreCase(name)){
				Relatives relAdd = contactList.relativesList.get(i);
				relativesList.add(relAdd);
			}
		}
		for(i=0;i<contactList.personalFriendsList.size();i++){
			if(contactList.personalFriendsList.get(i).personalFriendName.equalsIgnoreCase(name)){
				PersonalFriends perAdd = contactList.personalFriendsList.get(i);
				personalFriendsList.add(perAdd);
			}
		}
		for(i=0;i<contactList.professionalFriendsList.size();i++){
			if(contactList.professionalFriendsList.get(i).professionalFriendName.equalsIgnoreCase(name)){
				ProfessionalFriends profAdd = contactList.professionalFriendsList.get(i);
				professionalFriendsList.add(profAdd);
			}
		}
		for(i=0;i<contactList.casualAcquaintancesList.size();i++){
			if(contactList.casualAcquaintancesList.get(i).casualAcquaintanceName.equalsIgnoreCase(name)){
				CasualAcquaintances casualAdd = contactList.casualAcquaintancesList.get(i);
				casualAcquaintancesList.add(casualAdd);
			}
		}
		
		JTable relativeTable = new JTable();
		relativeTableModel tableModel = new relativeTableModel(relativesList);
		relativeTable.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(relativeTable);
		tabbedPane.addTab("Relatives", null, scrollPane, null);
		
		JTable personalTable = new JTable();
		personalTableModel tableModel_1 = new personalTableModel(personalFriendsList);
		personalTable.setModel(tableModel_1);
		JScrollPane scrollPane_1 = new JScrollPane(personalTable);
		tabbedPane.addTab("Personal Friends", null, scrollPane_1, null);
		
		JTable professionalTable = new JTable();
		professionalTableModel tableModel_2 = new professionalTableModel(professionalFriendsList);
		professionalTable.setModel(tableModel_2);
		JScrollPane scrollPane_2 = new JScrollPane(professionalTable);
		tabbedPane.addTab("Professional Friends", null, scrollPane_2, null);
		
		JTable casualTable = new JTable();
		casualTableModel tableModel_3 = new casualTableModel(casualAcquaintancesList);
		casualTable.setModel(tableModel_3);
		JScrollPane scrollPane_3 = new JScrollPane(casualTable);
		tabbedPane.addTab("Casual Acquaintances", null, scrollPane_3, null);
	}
}
