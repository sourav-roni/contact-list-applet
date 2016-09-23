import java.util.List;
import javax.swing.table.AbstractTableModel;

public class personalTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4529257339637342686L;

	/**
	 * 
	 */


	/**
	 * 
	 */

	String ColumnName[] = {"Name","Mobile No.","E-mail Address","Context","Date of Acquaintance","Specific Events"};
	
	List<PersonalFriends> personalList = null;
	
	personalTableModel(List<PersonalFriends> list){
		personalList = list;
	}

	public int getColumnCount() {
		return ColumnName.length;
	}

	
	public int getRowCount() {
		return personalList.size();
	}

	
	public Object getValueAt(int row, int column) {
		PersonalFriends personal = personalList.get(row);
		switch(column){
		case 0:
			return personal.personalFriendName;
		case 1:
			return personal.personalFriendMobileNumber;
		case 2:
			return personal.personalFriendEmail;
		case 3:
			return personal.personalFriendContextOfAcqaintance;
		case 4:
			return personal.personalFriendDateOfAcquaintance;
		case 5:
			return personal.personalFriendSpecificEvents;
		default:
			return personal;
		}
	}
	@Override
	public Class<? extends Object> getColumnClass(int col) {
		return getValueAt(0,col).getClass();
	}
	@Override
	public String getColumnName(int col) {
		return ColumnName[col];
	}
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}

}