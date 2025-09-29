package org.example.mybookstore.controller;

import org.example.mybookstore.BookDto;
import org.example.mybookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vi/books")
public class MyBooksController {

    private final BookService bookService;
    MyBooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    ResponseEntity<List<BookDto>> getAllBooks()
    {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
}
