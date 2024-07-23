/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hu.anzek.vizsga_feladat_spring_1.restcontroller;


import hu.anzek.vizsga_feladat_spring_1.model.Book;
import hu.anzek.vizsga_feladat_spring_1.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api/book")
public class BookRestController {
   
    @Autowired
    private BookService bookService;
    
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book createdBook = this.bookService.addBook(book);
        return ResponseEntity.ok(createdBook);
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteBook(@RequestBody Book book) {
        this.bookService.removeBook(book);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/remove")
    public ResponseEntity<Void> removeBook(@RequestBody Book book) {
        this.bookService.removeBook(book);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/search")
    public ResponseEntity<List<Book>> searchBook(@RequestBody Book book) {
        List<Book> books = bookService.searchBook(book.getTitle());
        if (books != null) {
            return ResponseEntity.ok(books);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id , @RequestBody Book book) {
        Book updatedBook = this.bookService.updateBook(id, book);
        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Book>> listBooks() {
        List<Book> books = this.bookService.listBooks();
        return ResponseEntity.ok(books);
    }
}
