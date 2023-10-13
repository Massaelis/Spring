package com.prodius.repository;

import com.prodius.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findByAuthor(String author);

}

//  @Query("SELECT r FROM Robot r ORDER BY r.name DESC")
//Iterable<Robot> findAllWithSort();


