package com.example.demo_app.controller;

import com.example.demo_app.dto.BookDto;
import com.example.demo_app.mapper.ObjectMapper;
import com.example.demo_app.persistence.entity.Book;
import com.example.demo_app.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final ObjectMapper<BookDto, Book> bookMapper;

    public BookController(BookService bookService,
                          ObjectMapper<BookDto, Book> bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getBooks() {
        List<Book> books = bookService.getBooks();

        return ResponseEntity.ok(
                books.stream()
                        .map(bookMapper::mapEntityToDto)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable UUID id) {
        Book bookById = bookService.getBookById(id);

        return ResponseEntity.ok(bookMapper.mapEntityToDto(bookById));
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        Book mappedBook = bookMapper.mapDtoToEntity(bookDto);
        Book createdBook = bookService.createBook(mappedBook);

        return new ResponseEntity<>(
                bookMapper.mapEntityToDto(createdBook),
                HttpStatus.CREATED
        );
    }

}
