/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package hu.anzek.backend.vizsga_feladat_1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Vizsga_feladat_1 {
    
    class Book {
        private String title;
        private String author;
        private int year;
        private String isbn;

        public Book(String title, String author, int year, String isbn) {
            this.title = title;
            this.author = author;
            this.year = year;
            this.isbn = isbn;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        @Override
        public String toString() {
            return "Konyvcim: '" + title + "' iro: '" + author + "' kiadas eve: '" + year + "'"; 
        }
        
        public void toConsol(String s){
            System.out.println(s + " { " + this.toString() + " }");
        }
    }

    class Library {
        private ArrayList<Book> books = new ArrayList<>();

        public void addBook(Book book) {
            this.books.add(book);
        }

        public void removeBook(String title) {
            this.books.removeIf(e -> e.getTitle().equalsIgnoreCase(title));            
        }

        public Book searchBook(String title) {         
            for (Book e : this.books) {
                if (e.getTitle().equalsIgnoreCase(title)) {
                    return e;
                }
            }
            return null;
        }

        public List<Book> listBooks() {
            for (Book book : this.books) {
                book.toConsol("Library : ");
            }
            return Collections.unmodifiableList(this.books);
        }
    }
    
    class BookService {
        private Library library;
        private Scanner scanner;
        
        public BookService() {
            this.library = new Library();
            this.scanner = new Scanner(System.in);
        }

        public void showMenu() {
            while (true) {
                System.out.println("\n--- Library Menu ---");
                System.out.println("1. Uj konyv felvetele");
                System.out.println("2. Konyv eltavolitasa");
                System.out.println("3. Konyv keresese");
                System.out.println("4. konyvek listazasa");
                System.out.println("5. Konyvek mentese fajlba");
                System.out.println("6. Konyvek betoltese fajlbol");
                System.out.println("7. Kilep");
                System.out.print("Valasszon a lehetosegek kozul (1..7): ");
                
                int choice = scanner.nextInt();            
                this.scanner.nextLine(); 
                switch (choice) {
                    case 1:
                        this.addBook();
                        break;
                    case 2:
                        this.removeBook();
                        break;
                    case 3:
                        this.searchBook();
                        break;
                    case 4:
                        this.listBooks();
                        break;
                    case 5:{
                            List<Book> books = this.library.listBooks();
                            this.saveBooksToFile(books, "vizsga_1_a.txt");
                            break;
                        }
                    case 6:
                        this.loadBooksFromFile("vizsga_1_a.txt");
                        break;                        
                    case 7:
                        System.out.println("Kileptetes...");
                        return;
                    default:
                        System.out.println("ervenytelen valasztas, probalja meg ujra.");
                }
            }
        }

        private void addBook() {
            System.out.print("Kerem a konyv cimet (title): ");
            String title = this.scanner.nextLine();
            System.out.print("Kerem a szerzot(author): ");
            String author = this.scanner.nextLine();
            System.out.print("Kerem a kiadas evet (year): ");
            int year = this.scanner.nextInt();
            this.scanner.nextLine();  
            System.out.print("Kerem az ISBN-t : ");
            String isbn = this.scanner.nextLine();

            Book book = new Book(title, author, year, isbn);
            this.library.addBook(book);
            System.out.println("A konyv sikeresen hozzaadva.");
        }

        private void removeBook() {
            System.out.print("Kerem a cimet a konyv eltavolitasahoz: ");
            String title = this.scanner.nextLine();
            this.library.removeBook(title);
            System.out.println("Vegrehajtva!");
        }

        private void searchBook() {
            System.out.print("Kerem a cimet a konyv keresesehez: ");
            String title = this.scanner.nextLine();
            Book book = this.library.searchBook(title);
            if (book != null) {
                System.out.println("A konvy: " + book);
            } else {
                System.out.println("A konyv nem talalhato.");
            }
        }
        
        public void saveBooksToFile(List<Book> books, String filename) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (Book book : books) {
                    writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getYear() + "," + book.getIsbn());
                    writer.newLine();
                }
                System.out.println("Sikeres fajlmentes.");
            } catch (IOException e) {
                System.out.println("Nem sikerult a fajlmentes: " + e.getMessage());
            }
        }

        @SuppressWarnings("null")
        public List<Book> loadBooksFromFile(String filename) {
            List<Book> books = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 4) {
                        books.add(new Book(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]));
                    }
                }
                if(books != null){
                    System.out.println("A konyveket sikeresen beolvastuk, ime a lista:");
                    for (Book book : books) {
                        System.out.println("  - " + book);
                    }                
                }else{
                    System.out.println("nincs kiolvasható adat!");
                }
            } catch (IOException e) {
                System.out.println("Problema adodott a konyvek beolvasasakor: " + e.getMessage());
            }
            
            return books;
        }
        
        private List<Book> listBooks() {
            System.out.println("Az osszes konyv listazasa:");
            return this.library.listBooks();
        }
        
        public void libraryIni() {
            this.library = new Library();
            this.library.addBook(new Book("Java Programozas", "Csicseri Borso", 2022, "123456789"));
            this.library.addBook(new Book("Spring Boot Kezikonyv", "Kicsi Csillag", 2024, "987654321"));
            this.library.addBook(new Book("Java backend programozas", "Anzek Informatika", 2024, "1243126546"));
            this.library.listBooks();
        }    
    }

    public static void main(String[] args) {
        System.out.println("Hello World!\nEz itt egy egyszeru konyvtar kezelo alkalpamzas!");
        // Mivel a BookService() osztály nem statikus belső osztály, ezért nem példányosítható közvetlenül a main metódusból, 
        // a main() ugyanis statikus. 
        // Két megoldás lehet: 
        // 1, hogy statikus belső osztállyá tesszük a BookService-t, 
        // 2, példányosítjuk a külső osztályt (Vizsga_feladat_1), majd ezen példányon keresztül érjük el a belső osztályt.
        // a második megoldást fogom használni, mert az első számos további változtatást (statikussá tételt) igényelne!
        Vizsga_feladat_1 vizsgaFeladat_1_A = new Vizsga_feladat_1();
        // a példányosításnak ezt a változatát eddig még sehol sem használtuk:
        BookService bookService = vizsgaFeladat_1_A.new BookService();
        // most már hívható:
        bookService.libraryIni();
        bookService.showMenu();              
    }
}
