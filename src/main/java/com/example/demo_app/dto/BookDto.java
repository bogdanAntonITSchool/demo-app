package com.example.demo_app.dto;

import java.util.UUID;

public record BookDto(UUID id,
                      String title,
                      String author,
                      String isbn,
                      int pages) {
}
