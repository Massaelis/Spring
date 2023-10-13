package com.prodius.service;

import com.prodius.model.Book;
import com.prodius.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
//Создать веб приложение которое будет работать с Книгами (ид, название, автор).
//
//Реализовать следующие эндпоинты:

//Создание книги
//Обновление книги
//Удаление книги
//Получить все книги
//Получить книгу по ид (часть урл)
//Получить книги по автору (параметр урл)
    private final BookRepository repository;

    @Autowired
    public BookService(final BookRepository repository) {
        this.repository = repository;
    }

    public String save(final Book book) {
        return repository.save(book).getId();
    }

    public String update(final Book book) {
        final Book oldBook = repository.findById(book.getId()).orElseThrow();
        oldBook.setName(book.getName());
        oldBook.setAuthor(book.getAuthor());
        return save(oldBook);
    }

    public void delete(final String id) {
        repository.deleteById(id);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findById(final String id) {
        return repository.findById(id).orElseThrow();
    }

    public Book findByAuthor(final String author) {
        return repository.findByAuthor(author).orElseThrow();
    }

}
