package tw.paintingparty.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {
	public Connection Jdbc_connection() {
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databasename=paintingparty";
		String user="sa";
		String password="123456789";
		Connection con=null;
		try {
			con = DriverManager.getConnection(connectionUrl,user,password);
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
