import java.util.List;
import javax.swing.table.AbstractTableModel;

public class professionalTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -549714236536777744L;

	/**
	 * 
	 */
	/**
	 * 
	 */


	/**
	 * 
	 */

	String ColumnName[] = {"Name","Mobile No.","E-mail Address","<html>Specific Common <br>Profesional Interest</html>"};
	
	List<ProfessionalFriends> professionalList = null;
	
	professionalTableModel(List<ProfessionalFriends> list){
		 professionalList = list;
	}

	public int getColumnCount() {
		return ColumnName.length;
	}

	
	public int getRowCount() {
		return  professionalList.size();
	}

	
	public Object getValueAt(int row, int column) {
		ProfessionalFriends professional =  professionalList.get(row);
		switch(column){
		case 0:
			return professional.professionalFriendName;
		case 1:
			return professional.professionalFriendMobileNumber;
		case 2:
			return professional.professionalFriendEmail;
		case 3:
			return professional.professionalFriendSpecificCommonInterest;
		case 5:
			return professional;
		default:
			return professional;
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