package com.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 * Абстрактний клас для представлення бібліотечних документів.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Doc {
    @Id
    @Column(name = "inventory_num", unique = true, nullable = false)
    private String inventoryNum; // Інвентарний номер

    @ElementCollection
    @CollectionTable(name = "doc_authors", joinColumns = @JoinColumn(name = "inventory_num"))
    @Column(name = "author")
    private List<String> authors; // Список авторів

    @ElementCollection
    @CollectionTable(name = "doc_themes", joinColumns = @JoinColumn(name = "inventory_num"))
    @Column(name = "theme")
    private List<String> themes; // Теми/рубрики

    @Column(name = "creation_year")
    private Integer creationYear; // Рік створення

    @Column(name = "name")
    private String name; // Назва документа

    @Column(name = "udc_code")
    private String udcCode; // Код УДК

    @Column(name = "location")
    private String location; // Розташування

    public void setAuthors(List<String> authors) {
        this.authors = authors != null ? new ArrayList<>(authors) : new ArrayList<>();
    }

    public void setThemes(List<String> themes) {
        this.themes = themes != null ? new ArrayList<>(themes) : new ArrayList<>();
    }

    public void setCreationYear(Integer year) {
        if (year != null && year >= 0 && year <= Year.now().getValue()) {
            this.creationYear = year;
        } else {
            throw new IllegalArgumentException("Неприпустимий рік створення");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doc doc)) return false;
        return inventoryNum.equals(doc.inventoryNum);
    }

    @Override
    public int hashCode() {
        return inventoryNum.hashCode();
    }
}