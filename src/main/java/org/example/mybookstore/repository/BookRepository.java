package org.example.mybookstore.repository;

import org.example.mybookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findByAuthor_Name(String name);

    @Query(value = "SELECT b.* FROM Books b LEFT JOIN Authors a ON b.author_id = a.id WHERE a.name = :name", nativeQuery = true)
    List<Book> queryBooksByAuthorName(String name);
}
