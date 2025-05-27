package com.library.controller;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    // Отримати всі книги
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Отримати книгу за inventoryNum
    @GetMapping("/{inventoryNum}")
    public ResponseEntity<Book> getBookById(@PathVariable String inventoryNum) {
        Optional<Book> book = bookRepository.findById(inventoryNum);
        return book.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Додати нову книгу
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Оновити книгу
    @PutMapping("/{inventoryNum}")
    public ResponseEntity<Book> updateBook(@PathVariable String inventoryNum, @RequestBody Book bookDetails) {
        Optional<Book> book = bookRepository.findById(inventoryNum);
        if (book.isPresent()) {
            Book updatedBook = book.get();
            updatedBook.setName(bookDetails.getName());
            updatedBook.setAuthors(bookDetails.getAuthors());
            updatedBook.setThemes(bookDetails.getThemes());
            updatedBook.setCreationYear(bookDetails.getCreationYear());
            updatedBook.setUdcCode(bookDetails.getUdcCode());
            updatedBook.setLocation(bookDetails.getLocation());
            updatedBook.setPageCount(bookDetails.getPageCount());
            updatedBook.setPublisher(bookDetails.getPublisher());
            updatedBook.setPublicationYear(bookDetails.getPublicationYear());
            updatedBook.setIsbn(bookDetails.getIsbn());
            updatedBook.setGenre(bookDetails.getGenre());
            return ResponseEntity.ok(bookRepository.save(updatedBook));
        }
        return ResponseEntity.notFound().build();
    }

    // Видалити книгу
    @DeleteMapping("/{inventoryNum}")
    public ResponseEntity<Void> deleteBook(@PathVariable String inventoryNum) {
        if (bookRepository.existsById(inventoryNum)) {
            bookRepository.deleteById(inventoryNum);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}