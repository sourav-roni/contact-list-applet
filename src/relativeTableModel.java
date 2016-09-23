import java.util.List;
import javax.swing.table.AbstractTableModel;

public class relativeTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4441653745908057119L;

	/**
	 * 
	 */

	String ColumnName[] = {"Name","Mobile No.","E-mail Address","Birthday","Date of Last Meeting"};
	
	List<Relatives> relationList = null;
	
	relativeTableModel(List<Relatives> list){
		relationList = list;
	}

	public int getColumnCount() {
		return ColumnName.length;
	}

	
	public int getRowCount() {
		return relationList.size();
	}

	
	public Object getValueAt(int row, int column) {
		Relatives relative = relationList.get(row);
		switch(column){
		case 0:
			return relative.relativeName;
		case 1:
			return relative.relativeMobileNumber;
		case 2:
			return relative.relativeEmail;
		case 3:
			return relative.relativeBirthday;
		case 4:
			return relative.relativeDateOfLastMeeting;
		case 5:
			return relative;
		default:
			return relative;
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