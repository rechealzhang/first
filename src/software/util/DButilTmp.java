/*package software.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DButilTmp {
	public static void main(String[] args) throws Exception {
		//0.准备连接数据库的资源
		//连接数据库的URL
		String url = "jdbc:mysql://localhost:3306/smart";
		
		//连接数据库的用户名
		String username = "root";
		
		//密码
		String password = "1234";
		
		//1.加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.获取连接
		Connection conn = DriverManager.getConnection(url, username, password);
		
		
		//3.创建Statement对象(用来向数据库发送SQL语句)
		Statement st = conn.createStatement();
		//System.out.println("BookID: " );
		
		//4.创建SQL语句
		String sql = "select * from book";
		
		
		//5.执行SQL语句(通过Statement向数据库发送SQL语句)，
		//  并获取返回的结果集ResultSet
		ResultSet rs = st.executeQuery(sql);
		
		//6.遍历结果集
		while (rs.next()) {
			System.out.println("BookID: " + rs.getObject(1));
			System.out.println("BookName: " + rs.getObject("bookname"));
			System.out.println("BookPrice: " + rs.getObject("price"));
		}
		
		//7.关闭连接，释放资源
	rs.close();
	st.close();
	conn.close();
	}
}
*/