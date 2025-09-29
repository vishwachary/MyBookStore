package org.example.mybookstore.service;

import org.example.mybookstore.BookDto;
import org.example.mybookstore.entity.Book;
import org.example.mybookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository=bookRepository;
    }

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    private BookDto convertToDto(Book book) {

        return BookDto.builder().id(book.getId())
                .title(book.getTitle())
                .summary(book.getSummary())
                .authorName(book.getAuthor().getName())
                .catalogName(book.getCatalog().getName()).build();

    }
}
