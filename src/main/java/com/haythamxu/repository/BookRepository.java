package com.haythamxu.repository;

import com.haythamxu.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAll();
    Book findByIsbn(String isbn);

}
