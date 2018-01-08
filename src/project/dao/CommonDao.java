package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CommonDao  implements AutoCloseable{
//	private static CommonDao commonDaoObject;
	private static Connection con;
	private CommonDao(){}

	/*static {
		try {
			con = makeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/*public static CommonDao getInstance() {
		synchronized (CommonDao.class) {
			if (commonDaoObject == null) {
				commonDaoObject = new CommonDao();
			}
		}
		return commonDaoObject;
	}*/

	private static Connection makeConnection() throws ClassNotFoundException, SQLException{
		ResourceBundle rb = ResourceBundle.getBundle("db");
		
		Class.forName(rb.getString("mysqldrivername"));
		
		String dburl = rb.getString("authtesturl");
		String user = rb.getString("userid");
		String password = rb.getString("password");
		
		Connection con = DriverManager.getConnection(dburl, user, password);
		
		return con;
	}
	
	public static Connection getConnection(){
		synchronized (CommonDao.class) {
			if (con == null) {
				try {
					con = makeConnection();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return con;
		}
		
	}

	@Override
	public void close() throws Exception {
		con.close();
	}
}