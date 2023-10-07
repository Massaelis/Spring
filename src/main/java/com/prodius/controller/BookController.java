package com.prodius.controller;

import com.prodius.model.Book;
import com.prodius.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(final BookService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Book book) {
        if (book.getName() == null) {
            book.setName("Default name");
            book.setAuthor("Default author");
        }
        return service.save(book);
    }

    @PutMapping
    public String updateGreeter(@RequestBody Book book) {
        if (book.getId() == null) {
            throw new IllegalArgumentException();
        }
        return service.update(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping
    public Iterable<Book> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/{author}")
    public Book findByAuthor(@PathVariable String author) {
        return service.findByAuthor(author);
    }
}
