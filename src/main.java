import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database database = new Database();
		String SQL = "select * from listview";
		ResultSet rs = null;
		try {
			database.getConn();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		rs = database.getSQL(SQL);
		List list1 = new ArrayList();
		List list2 = new ArrayList();
		try {
			while(rs.next()){
				System.out.println(rs.getString(1));
				list1.add(rs.getString(1));
				System.out.println(rs.getString(2));
				list2.add(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
