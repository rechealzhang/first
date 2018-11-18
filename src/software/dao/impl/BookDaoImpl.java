package software.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sofeware.dao.IBookDao;
import software.model.Book;
import software.util.DBUtil;

public class BookDaoImpl implements IBookDao {
	public void addBook(Book book){
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		//获取数据库链接
		try {
			//获取数据库连接
			conn = DBUtil.getConnection();
			
			//准备SQL指令，SQL指令中的参数使用?作为占位符
			String sql = "insert into book(bookId,bookName,price) values(?,?,?)";
			
			//获取PreparedStatement对象
			pst = conn.prepareStatement(sql);
			
			//对SQL指令中的参数进行赋值
			pst.setInt(1, book.getBookId());

			pst.setString(2, book.getBookName());
			pst.setDouble(3, book.getBookPrice());
			
			//执行SQL指令
			int num = pst.executeUpdate();
			
			if (num > 0) {
				System.out.println("插入成功！");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtil.relase(conn, pst, rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


@Override
public Book deleteBook(int bookId) {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	Book book = new Book();
	
	try {
		//获取数据库连接
		conn = DBUtil.getConnection();
		
		//准备SQL指令，SQL指令中的参数使用?作为占位符
		String sql = "select * from book where bookid=?";
		
		//获取PreparedStatement对象
		pst = conn.prepareStatement(sql);
		
		//对SQL指令中的参数进行赋值
		pst.setInt(1, bookId);
		
		//执行SQL指令
		rs = pst.executeQuery();
		
		if (rs.next()) {
			book.setBookId(rs.getInt("bookid"));
			book.setBookName(rs.getString("bookname"));
			book.setBookPrice(rs.getDouble("price"));
			
			sql = "delete from book where bookid=?";
			
			//获取PreparedStatement对象
			pst = conn.prepareStatement(sql);
			
			//对SQL指令中的参数进行赋值
			pst.setInt(1, bookId);
			
			int num = pst.executeUpdate();
			if (num > 0) {
				System.out.println("删除成功");
			}
		}else {
			System.out.println("该条记录不存在，请重新查询！");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			DBUtil.relase(conn, pst, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return book;
}

@Override
public void UpdateBook(Book book) {
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	try {
		//获取数据库连接
		conn = DBUtil.getConnection();
		
		//准备SQL指令，SQL指令中的参数使用?作为占位符
		String sql = "update book set bookname=?,price=? where bookid=?";
		
		//获取PreparedStatement对象
		pst = conn.prepareStatement(sql);
		
		//对SQL指令中的参数进行赋值
		pst.setString(1, book.getBookName());
		pst.setDouble(2, book.getBookPrice());
		pst.setInt(3, book.getBookId());
		
		//执行SQL指令
		int num = pst.executeUpdate();
		
		if (num > 0) {
			System.out.println("更新成功！");
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			DBUtil.relase(conn, pst, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


@Override
public List<Book> findall() {
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	List<Book> bookList = new ArrayList<Book>();
	
	try {
		//获取数据库连接
		conn = DBUtil.getConnection();
		
		//准备SQL指令，SQL指令中的参数使用?作为占位符
		String sql = "select * from book";
		
		//获取PreparedStatement对象
		pst = conn.prepareStatement(sql);
		
		//对SQL指令中的参数进行赋值
		//pst.setString(1, book.getBookName());
		//pst.setDouble(2, book.getBookPrice());
		
		//执行SQL指令
		rs = pst.executeQuery();
		
		while (rs.next()) {
			Book book = new Book();
			
			book.setBookId(rs.getInt("bookid"));
			book.setBookName(rs.getString("bookname"));
			book.setBookPrice(rs.getDouble("price"));
			
			bookList.add(book);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			DBUtil.relase(conn, pst, rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return bookList;
}

@Override
public Book selectBook(int BookId)
 {
	 Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Book book = new Book();
		
		try {
			//获取数据库连接
			conn = DBUtil.getConnection();
			
			//准备SQL指令，SQL指令中的参数使用?作为占位符
			String sql = "select * from book where bookid=?";
			
			//获取PreparedStatement对象
			pst = conn.prepareStatement(sql);
			
			//对SQL指令中的参数进行赋值
			pst.setInt(1, BookId);
			//pst.setDouble(2, book.getBookPrice());
			
			//执行SQL指令
			rs = pst.executeQuery();
			
			rs.next();
			book.setBookId(rs.getInt("bookid"));
			book.setBookName(rs.getString("bookname"));
			book.setBookPrice(rs.getDouble("price"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtil.relase(conn, pst, rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return book;
	}

}







