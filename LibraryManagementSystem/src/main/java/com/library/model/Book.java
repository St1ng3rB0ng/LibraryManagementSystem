package com.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Клас для представлення книги.
 */
@Entity
@Table(name = "books")
@Getter
@Setter
public class Book extends PrintedDoc {
    @Column(name = "isbn", unique = true)
    private String isbn; // ISBN

    @Column(name = "genre")
    private String genre; // Жанр
}