package com.bookapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.models.Book;
   
@Service
public class BookServiceImpl implements BookService {
	
	@Override
	public void addBook(Book book) {  
		System.out.println(book);
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		List<Book> bookList =  getBookList() 
				.stream()
				.filter((book)->book.getAuthor().equals(author))
				.collect(Collectors.toList());
		if(bookList.isEmpty()) {
			throw new BookNotFoundException("Book with this author not found");
		}
	return bookList;
	} 
	@Override  
	public Book getBookById(int bookId) { 
		if(bookId<=0) {
			throw new RuntimeException("other type of exception");
		}
		return getBookList()
				.stream()
				.filter((book)->book.getBookid()==bookId)
				.findAny()
				.orElseThrow(()-> new IdNotFoundException("Invalid Id"));
//		if(opt.isPresent()) {
//			return opt.get();
//		}else {
//			throw new IdNotFoundException("Invalid id");
//		}
	} 
	@Override
	public List<Book> getBooksByCategory(String category) {
		List<Book> bookList = getBookList()
				.stream()
				.filter((book)->book.getCategory().equals(category))
				.collect(Collectors.toList());
		if(bookList.isEmpty()) {
			throw new BookNotFoundException("Book with this category not found");
		}
	return bookList;
	}
 
	private List<Book> getBookList(){
		return Arrays.asList(new Book("Java","Kathy","Tech",10),
				new Book("Spring","Rod","Tech",11),
				new Book("Miracle","Robin","Fiction",12),
				new Book("Ferrari","Robin","Fiction",13),
				new Book("Captain","Hal","Comic",14),
				new Book("Morning Misty","Hal","Horror",15));
		
	}


				
				
	

}
