package com.haythamxu.controller;

import com.haythamxu.dto.BookDTO;
import com.haythamxu.entity.Book;
import com.haythamxu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<String> addBook(@RequestBody BookDTO bookDTO) {
        Book existingBook = bookService.getBookByIsbn(bookDTO.getIsbn());
        if(existingBook == null) {
            Book newBook = new Book();
            newBook.setAuthor(bookDTO.getAuthor());
            newBook.setIsbn(bookDTO.getIsbn());
            newBook.setPublisher(bookDTO.getPublisher());
            newBook.setPublicationDate(bookDTO.getPublicationDate());
            newBook.setCategory(bookDTO.getCategory());
            newBook.setTitle(bookDTO.getTitle());
            newBook.setQuantityInStock(1);
            this.bookService.addBook(newBook);
            return ResponseEntity.ok("New Book added.");
        }
        existingBook.quantityIncrease();
        this.bookService.addBook(existingBook);
        return ResponseEntity.ok("Book added successfully.");
    }

    @GetMapping("/search/{isbn}")
    public ResponseEntity<Book> searchBooks(@PathVariable String isbn) {
        Book book = bookService.getBookByIsbn(isbn);
        if(book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(book);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }
}
