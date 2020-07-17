package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.models.Book;
import com.bookapp.service.BookService;

@RestController
@RequestMapping("book-restapi")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/greet")
	public ResponseEntity<String> sayHello() {
		String msg = "Welcome to Book App";
		HttpHeaders header = new HttpHeaders();
		header.add("desc","Online Book Application");
		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
	}
	@PostMapping("/books")
	public ResponseEntity<Void> addBook(@RequestBody Book book) {	
		 bookService.addBook(book);
		 HttpHeaders header = new HttpHeaders();
		 header.add("desc","Adding one book");
		 return ResponseEntity.status(HttpStatus.OK).headers(header).build();
//		 return ResponseEntity.ok().build();
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookbyId(@PathVariable("id") int bookid) {
		Book book = bookService.getBookById(bookid);
		HttpHeaders header = new HttpHeaders();
		header.add("desc","Getting book by id");
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(book);
	}

	@GetMapping("/books-by-author/{author}")
	public ResponseEntity<List<Book>> getBookSByAuthor(@PathVariable("author") String author) {
		List<Book> bookList = bookService.getBooksByAuthor(author);
		return ResponseEntity.ok(bookList);
	}

	@GetMapping("/books-by-category")
	public ResponseEntity<List<Book>>  getBookByCategory(@RequestParam("category") String category) {
		HttpHeaders header = new HttpHeaders();
		header.add("desc","List of books by category");
		header.add("type", "book object");
		List<Book> bookList =  bookService.getBooksByCategory(category);
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(bookList);
	}

}
