package software.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sofeware.dao.IBookDao;
import software.dao.impl.BookDaoImpl;
import software.model.Book;

/**
 * Servlet implementation class BookUpdateServlet
 */
@WebServlet("/BookUpdateServlet")
public class BookUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Book book = new Book();
		
		String bookId = request.getParameter("book_id");
		String bookName = request.getParameter("book_name");
		String bookPrice = request.getParameter("book_price");
		
		book.setBookId(Integer.parseInt(bookId));
		book.setBookName(bookName);
		book.setBookPrice(Double.parseDouble(bookPrice));
		
		IBookDao bookDao = new BookDaoImpl();
		bookDao.UpdateBook(book);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}