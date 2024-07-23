package hu.anzek.vizsga_feladat_spring_1;

import hu.anzek.vizsga_feladat_spring_1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VizsgaFeladatSpring1Application implements CommandLineRunner  {

    @Autowired
    private BookService bookService;
        
    public static void main(String[] args) {
        SpringApplication.run(VizsgaFeladatSpring1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        // a tábla létrehozásakor tesztadatok bevitele (nem volt előírva):
        this.bookService.tesztFelvitel();
        // a másik feladat outputjának a betöltése:
        // D:\java_meghajto\ProgramozasTanitasa\backend176\anzek\vizsgafelkeszito\vizsga1\java_oop\hu.anzek.backend_vizsga_feladat_1_jar_1.0-SNAPSHOT\vizsga_1_a.txt
        this.bookService.loadBooksFromFile("D:\\java_meghajto\\ProgramozasTanitasa\\backend176\\anzek\\vizsgafelkeszito\\vizsga1\\java_oop\\hu.anzek.backend_vizsga_feladat_1_jar_1.0-SNAPSHOT\\vizsga_1_a.txt");
    }
}
