package org.example.mybookstore.controller;

import org.example.mybookstore.dto.BookDto;
import org.example.mybookstore.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
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

    @GetMapping("/by-author/stream")
    public List<BookDto> getBooksByAuthorName(@RequestParam String authorName) {
        return bookService.getBooksByAuthorName(authorName);
    }

    @GetMapping("/by-author/method")
    public List<BookDto> getBooksByAuthor_Name(@RequestParam String authorName) {
        return bookService.getBooksByAuthor_Name(authorName);
    }

    @GetMapping("/by-author/query")
    public List<BookDto> getBooksByQueryAuthorName(@RequestParam String authorName) {
        return bookService.getBooksByQueryAuthorName(authorName);
    }

}
