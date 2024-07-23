/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package hu.anzek.vizsga_feladat_spring_1;


import hu.anzek.vizsga_feladat_spring_1.model.Book;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;


/**
 *
 * @author User
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class BookRestControllerIntegrationTest {
    

    public BookRestControllerIntegrationTest() {
    }
    
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl;

    @BeforeEach
    public void setUp() {
        baseUrl = "http://localhost:" + port + "/api/book";
    }

    @Test
    public void testAddAndGetBook() {
        // adjunk hozzá egy könyvet:
        Book book = new Book(null, "Spring Boot Tesztek kiskonyve", "Javajani Nagymester", 2021, "123456789");
        ResponseEntity<Book> responseEntity = restTemplate.postForEntity(baseUrl + "/api/add", book, Book.class);

        // Assert that the book was added successfully
        assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
        Book addedBook = responseEntity.getBody();
        assertThat(addedBook).isNotNull();
        assertThat(addedBook.getTitle()).isEqualTo("Spring Boot Tesztek kiskonyve");

        // Get the list of books
        ResponseEntity<Book[]> responseEntityList = restTemplate.getForEntity(baseUrl + "/api/list", Book[].class);
        Book[] books = responseEntityList.getBody();

        // Assert that the book list contains the added book
        assertThat(books).isNotNull();
        assertThat(books.length).isGreaterThan(0);
        assertThat(books[0].getTitle()).isEqualTo("Spring Boot Tesztek kiskonyve");
    }

    @Test
    public void testSearchBook() {
        // Add a new book
        Book book = new Book(null, "Spring Boot Tesztek kiskonyve", "Javajani Nagymester", 2021, "123456789");
        restTemplate.postForEntity(baseUrl + "/api/add", book, Book.class);

        // Search for the book by title
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<Book> requestEntity = new HttpEntity<>(book, headers);
        ResponseEntity<Book[]> responseEntity = restTemplate.exchange(baseUrl + "/api/search", HttpMethod.POST, requestEntity, Book[].class);
        Book[] foundBooks = responseEntity.getBody();

        // Assert that the search returns the correct book
        assertThat(foundBooks).isNotNull();
        assertThat(foundBooks.length).isGreaterThan(0);
        assertThat(foundBooks[0].getTitle()).isEqualTo("Spring Boot Tesztek kiskonyve");
    }
}
