package org.example.mybookstore.service;

import org.example.mybookstore.dto.BookDto;
import org.example.mybookstore.entity.Book;
import org.example.mybookstore.repository.AuthorRepository;
import org.example.mybookstore.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository=bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<BookDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    public List<BookDto> getBooksByAuthorName(String authorName)
    {   long startTime = System.currentTimeMillis();
        List<BookDto> booksByAuthor = bookRepository
                .findAll().stream()
                .filter(book -> book.getAuthor().getName().equals(authorName))
                .map(this::convertToDto)
            .toList();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Method getBooksByAuthorName execution time " + "   " + totalTime);
        return booksByAuthor;
    }

    public List<BookDto> getBooksByAuthor_Name(String authorName)
    {  long startTime = System.currentTimeMillis();
        List<BookDto> booksByAuthor = bookRepository.findByAuthor_Name(authorName)
                .stream().map(this::convertToDto)
                .toList();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Method getBooksByAuthor_Name execution time " + "   " + totalTime);
        return booksByAuthor;
    }

    public List<BookDto> getBooksByQueryAuthorName(String authorName)
    {  long startTime = System.currentTimeMillis();
        List<BookDto> booksByAuthor = bookRepository.queryBooksByAuthorName(authorName)
                .stream().map(this::convertToDto)
                .toList();
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Method getBooksByQueryAuthorName execution time " + "   " + totalTime);
        return booksByAuthor;
    }

    private BookDto convertToDto(Book book) {

        return BookDto.builder().id(book.getId())
                .title(book.getTitle())
                .summary(book.getSummary())
                .authorName(book.getAuthor().getName())
                .catalogName(book.getCatalog().getName()).build();

    }
}
