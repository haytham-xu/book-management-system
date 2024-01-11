package com.haythamxu.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private LocalDate publicationDate;
    private String category;
    private int quantityInStock;

    public void quantityIncrease() {
        this.quantityInStock += 1;
    }

}
