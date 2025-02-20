package com.example.demo_app.persistence.repository;

import com.example.demo_app.persistence.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
}
