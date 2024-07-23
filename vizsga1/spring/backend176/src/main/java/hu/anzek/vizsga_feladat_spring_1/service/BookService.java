/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hu.anzek.vizsga_feladat_spring_1.service;


import hu.anzek.vizsga_feladat_spring_1.model.Book;
import hu.anzek.vizsga_feladat_spring_1.repository.BookRepository;
import jakarta.transaction.Transactional;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;


/**
 *
 * @author User
 */
@Service
public class BookService {
    
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    
    // könyv hozzáadása
    @Transactional
    public Book addBook(Book book) {
        return this.bookRepository.save(book);
    }
    
    // könyv eltávolítása
    @Transactional
    public void removeBook(Book book) {
        this.bookRepository.delete(book);
    }
    
    // könyv lekérdezése
    @Transactional
    public List<Book> searchBook(String title) {
        return this.bookRepository.findByTitle(title).orElse(null);
    }
    
    // ezek nem voltak specifikálva:
    // könyv frissítése:
    @Transactional
    public Book updateBook(Long id, Book book) {
        Book updating = this.bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Nincs ilyen konyv a konyvtarlistaban!"));        
        updating.setTitle(book.getTitle());
        updating.setAuthor(book.getAuthor());
        updating.setYear(book.getYear());
        updating.setIsbn(book.getIsbn());
        return bookRepository.save(updating);      
    }
    
    // könyvek lekérdezése
    @Transactional
    public List<Book> listBooks() {
        return this.bookRepository.findAll();
    }
    
    // egy "önkényes" beviteli teszt (előkészítő)
    @Transactional
    public void tesztFelvitel(){
        // csak egyszer akarom, hogy ha még üres a tábla tegyen bele rekordot:
        if( ! this.bookRepository.findByTitle("A nagy tesztkonyv").isPresent()){
            this.bookRepository.save(new Book(null, "A nagy tesztkonyv", "Anzek It kft", 2024, "987654321"));
            this.bookRepository.save(new Book(null, "A kis tesztkonyv", "Anzek Informatika Kft", 2024, "1928736250"));

            this.bookRepository.findAll().forEach(book -> book.toConsole("Indulasi tesztadatok:"));        
        }        
    }
    
    // kiolvassa a konzolalkalmazás oputputját
    // és az SQL -be átírja azt:
    @Transactional
    @SuppressWarnings("NestedAssignment")
    public void loadBooksFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    this.bookRepository.save(new Book(null, parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("Problema adodott a konyvek beolvasasakor: " + e.getMessage());
        }
    }    
}
