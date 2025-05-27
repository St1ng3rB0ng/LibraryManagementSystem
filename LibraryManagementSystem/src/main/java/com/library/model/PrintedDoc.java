package com.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Year;

/**
 * Абстрактний клас для друкованих документів.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class PrintedDoc extends Doc {
    @Column(name = "page_count")
    private int pageCount; // Кількість сторінок

    @Column(name = "publisher")
    private String publisher; // Видавництво

    @Column(name = "publication_year")
    private Integer publicationYear; // Рік публікації

    public void setPageCount(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Кількість сторінок має бути більше 0");
        }
        this.pageCount = number;
    }

    public void setPublicationYear(Integer year) {
        if (year != null && year >= 1400 && year <= Year.now().getValue()) {
            this.publicationYear = year;
        } else {
            throw new IllegalArgumentException("Неприпустимий рік публікації");
        }
    }
}