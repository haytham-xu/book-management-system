package com.haythamxu.service;

import com.haythamxu.entity.Book;
import com.haythamxu.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void addBook(Book book) {
        this.bookRepository.save(book);
    }

    public Book getBookByIsbn(String isbn) {
        return this.bookRepository.findByIsbn(isbn);
    }

    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

}
