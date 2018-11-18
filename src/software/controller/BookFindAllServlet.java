package software.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sofeware.dao.IBookDao;
import software.dao.impl.BookDaoImpl;
import software.model.Book;

/**
 * Servlet implementation class BookFindAll
 */
@WebServlet("/BookFindAllServlet")
public class BookFindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		List<Book> bookList = new ArrayList<Book>();
		
//		String bookName = request.getParameter("book_name");
//		String bookPrice = request.getParameter("book_price");
//		
//		book.setBookName(bookName);
//		book.setBookPrice(Double.parseDouble(bookPrice));
		
		IBookDao bookDao = new BookDaoImpl();
		bookList = bookDao.findall();
		
		PrintWriter out = response.getWriter();
		out.println("<table border='1' cellspacing='0'>");
			out.println("<tr>");
				out.println("<th>");
					out.println("图书ID");
				out.println("</th>");
				out.println("<th>");
					out.println("图书名称");
				out.println("</th>");
				out.println("<th>");
					out.println("图书价格");
				out.println("</th>");
			out.println("</tr>");
			for (Book book : bookList) {
				out.println("<tr>");
					out.println("<td>");
						out.println(book.getBookId());
					out.println("</td>");
					out.println("<td>");
						out.println(book.getBookName());
					out.println("</td>");
					out.println("<td>");
						out.println(book.getBookPrice());
					out.println("</td>");
				out.println("</tr>");
			}
		out.println("</table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}