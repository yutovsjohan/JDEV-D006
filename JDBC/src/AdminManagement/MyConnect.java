package AdminManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {
	String servername;
	String port;
	String db_name;
	String db_user;
	String db_pass;

	public MyConnect(String servername, String port, String db_name, String db_user, String db_pass) {
		super();
		this.servername = servername;
		this.port = port;
		this.db_name = db_name;
		this.db_user = db_user;
		this.db_pass = db_pass;
	}

	public MyConnect() {
		super();
		this.servername = "127.0.0.1";
		this.port = "3306";
		this.db_name = "test";
		this.db_user = "root";
		this.db_pass = "";
	}

	public Connection getcn() {
		Connection cn = null;
		try {
			String db_url = "jdbc:mysql://" + servername + ":" + port + "/" + db_name;
			//System.out.println(db_url);
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(db_url, db_user, db_pass);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}

}