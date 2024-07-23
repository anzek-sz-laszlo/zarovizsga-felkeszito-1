/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package hu.anzek.vizsga_feladat_spring_1;


import com.fasterxml.jackson.databind.ObjectMapper;
import hu.anzek.vizsga_feladat_spring_1.model.Book;
import hu.anzek.vizsga_feladat_spring_1.restcontroller.BookRestController;
import hu.anzek.vizsga_feladat_spring_1.service.BookService;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *
 * @author User
 */
@WebMvcTest(BookRestController.class)
public class BookServiceAndRestControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    private Book book;
    
    public BookServiceAndRestControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    void setUp() {
        this.book = new Book(0L, "A kozepesen nagy tesztkonyv", "Laszlo Szobonya", 2024, "5432109876");
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddBook() throws Exception {
        given(this.bookService.addBook(any(Book.class))).willReturn( this.book);
        this.mockMvc.perform(post("/api/book/add")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(this.objectMapper.writeValueAsString(this.book))
                    )
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.title").value(this.book.getTitle()));
    }

    @Test
    public void testRemoveBook() throws Exception {
        doNothing().when(this.bookService).removeBook(any(Book.class));
        this.mockMvc.perform(delete("/api/book/delete")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(this.objectMapper.writeValueAsString(this.book))
                    )
                    .andExpect(status().isNoContent());
    }

    @Test
    public void testSearchBook() throws Exception {
        // hozzunk létre egy user-objektum tömbből egy Lista<T> generikus listakollekciót:
        List<Book> books = Arrays.asList(this.book);
        // A mokító tesztek alapbeállító metódusa a given()
        // ezeket kb olvassuk így: when given( search books by any string) will return (the) books collecton.        
        given(this.bookService.searchBook(anyString())).willReturn(books);
        // a "mockMvc" objektumot használjuk egy HTTP-POST kérés szimulálására az "/api/book/search" erőforrásvégpontra
        this.mockMvc.perform(post("/api/book/search")
                            // itt beállítjuk a kérés body (vagyis a tartalom) típusát JSON-re
                            .contentType(MediaType.APPLICATION_JSON)
                            // most beadjuk a kérelem törzsébe a valódi tartalmat (content)
                            // azaz a "book" objektumnak a JSon reprezentációját (ez konvertálja JSon -re),
                            // Hiszen már ezek előtt is említettem, az "objectMapper" egy Jackson könyvtárból származó osztály, 
                            // - amely Java objektumokat JSON formátumra alakít - és vissza.
                            .content(this.objectMapper.writeValueAsString(this.book))
                    )
                    // elvárjuk, hogy 200 OK legyen a szerver válasza:
                    .andExpect(status().isOk())
                    // elvárjuk, hogy JSon listát tartalmazzon a válasz body -ja és 1 elemmel rendelkezzen
                    .andExpect(jsonPath("$", hasSize(1)))
                    // elvárjuk, hogy ennek a JSon listának az első (vagyis a nulladik) eleme a megyegyezzena bokk.getTitle() értékünkkel!
                    .andExpect(jsonPath("$[0].title").value(this.book.getTitle()));
                    // Egyéb jelölések és használatuk:
                    // "$": az egész dokumentum.
                    // "$[0]": az első elem a listában (mivel ez most egy lista okollekció JSon formában).
                    // "$[0].title": az első elem title mezője.
                    // "$.books": a dokumentum books nevű mezője (de most nincs is más benne...).
                    // "$.books[0].author": a books lista első elemének author mezője.
                    // "$.books[*].title": a books lista összes elemének title mezője.
                    // -  mostani esetben például a: "$.books[0].author" azonos lesz "$[0].author" -al, 
                    // - - miután a JSon body-ban most csak egy List<Book> JSon szerializációja szerepel!
                    // egy JSon szerializáció (eredetiben persze ez sortörések és felesleges szóközök nélkül van):
                    //  [
                    //   {
                    //        "title": "Egy konyv",
                    //        "author": "Egy szerzo"
                    //   },
                    //       "title": "Masik konyv",
                    //        "author": "Masik szerzo"
                    //      },
                    //        "title": "Harmadik konyv",
                    //        "author": "Harmadik szerzo"
                    //      }
                    //  ]                    
                    
    }

    @Test
    public void testListBooks() throws Exception {
        List<Book> books = Arrays.asList(this.book);
        given(this.bookService.listBooks()).willReturn(books);
        this.mockMvc.perform(get("/api/book/list").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(1)))
                    .andExpect(jsonPath("$[0].title").value(this.book.getTitle()));
    }

}
