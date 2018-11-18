package software.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DBUtil {
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	
	static {
		InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取driver
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		
		//加载驱动
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(url, username, password);
	}
	
	public static void relase(Connection conn, PreparedStatement pst, ResultSet rs) throws Exception {
		if (conn != null) {
			conn.close();
		}
		if (pst != null) {
			pst.close();
		}
		if (rs != null) {
			rs.close();
		}
	}
}
