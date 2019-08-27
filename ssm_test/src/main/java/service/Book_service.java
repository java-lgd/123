package service;

import java.util.List;

import model.Book;
import model.Type;

public interface Book_service {

	public List<Book> select(String txt);
	
	public void insert(Book b);
	
	public void update(Book b);
	
	public void delete(int id);

	public Book selectById(int id);
}
