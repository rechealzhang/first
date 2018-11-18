package sofeware.dao;

import java.util.List;

import software.model.Book;

public interface IBookDao {
  
	
	//增
	public void addBook(Book book);
   
   
   //删
	public Book deleteBook(int bookId);
	
	
	//改
	public void UpdateBook(Book book);
	
	
	//查一本
	public Book selectBook(int BookId);
	
	//查所有
	public List<Book> findall();
   
}
