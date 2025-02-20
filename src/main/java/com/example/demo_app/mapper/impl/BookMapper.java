package com.example.demo_app.mapper.impl;

import com.example.demo_app.dto.BookDto;
import com.example.demo_app.mapper.ObjectMapper;
import com.example.demo_app.persistence.entity.Book;
import org.springframework.stereotype.Component;


@Component
public class BookMapper implements ObjectMapper<BookDto, Book> {

    @Override
    public Book mapDtoToEntity(BookDto dto) {
        Book book = new Book();

        book.setIsbn(dto.isbn());
        book.setAuthor(dto.author());
        book.setTitle(dto.title());
        book.setPages(dto.pages());

        return book;
    }

    @Override
    public BookDto mapEntityToDto(Book entity) {
        return new BookDto(
                entity.getId(),
                entity.getIsbn(),
                entity.getAuthor(),
                entity.getTitle(),
                entity.getPages()
        );
    }

}
