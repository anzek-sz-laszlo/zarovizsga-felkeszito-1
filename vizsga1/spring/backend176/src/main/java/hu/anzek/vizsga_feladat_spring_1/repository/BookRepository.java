/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hu.anzek.vizsga_feladat_spring_1.repository;


import hu.anzek.vizsga_feladat_spring_1.model.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author User
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public Optional<List<Book>> findByTitle(String title);    
}
