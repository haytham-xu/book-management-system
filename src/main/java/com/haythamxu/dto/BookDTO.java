package com.haythamxu.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDTO {
    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private LocalDate publicationDate;
    private String category;
}
