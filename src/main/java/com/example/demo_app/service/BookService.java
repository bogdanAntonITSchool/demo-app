package com.example.demo_app.service;

import com.example.demo_app.persistence.entity.Book;
import com.example.demo_app.persistence.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBookById(UUID id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

}
