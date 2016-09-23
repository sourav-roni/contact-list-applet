import java.util.List;
import javax.swing.table.AbstractTableModel;

public class casualTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1427439550373775016L;

	/**
	 * 
	 */


	/**
	 * 
	 */


	/**
	 * 
	 */

	String ColumnName[] = {"Name","Mobile No.","E-mail Address","When & Where","Circumstances","Information"};
	
	List<CasualAcquaintances> casualList = null;
	
	casualTableModel(List<CasualAcquaintances> list){
		casualList = list;
	}

	public int getColumnCount() {
		return ColumnName.length;
	}

	
	public int getRowCount() {
		return casualList.size();
	}

	
	public Object getValueAt(int row, int column) {
		CasualAcquaintances casual = casualList.get(row);
		switch(column){
		case 0:
			return casual.casualAcquaintanceName;
		case 1:
			return casual.casualAcquaintanceMobileNumber;
		case 2:
			return casual.casualAcquaintanceEmail;
		case 3:
			return casual.casualAcquaintanceWhenAndWhere;
		case 4:
			return casual.casualAcquaintanceCircumstances;
		case 5:
			return casual.casualAcquaintanceSpecificInformation;
		default:
			return casual;
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