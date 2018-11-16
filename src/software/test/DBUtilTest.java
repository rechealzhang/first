package software.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import software.util.DBUtil;

public class DBUtilTest {
	public static void main(String[] args) throws Exception {
		
		
		System.out.println(DBUtil.getConnection());

		
		}
}
	

