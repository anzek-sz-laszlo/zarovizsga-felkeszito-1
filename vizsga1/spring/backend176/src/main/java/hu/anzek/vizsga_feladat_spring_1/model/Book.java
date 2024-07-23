/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package hu.anzek.vizsga_feladat_spring_1.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author User
 */
@Entity
public class Book {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    Long id;
    String title;
    String author;
    int year;
    String isbn;
    
    public Book() {        
    }

    public Book(Long id,
                String title,
                String author,
                int year,
                String isbn) {
        this.id = id;
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
    
    // További metódusok adhatóak hozzá:
    @Override
    public String toString() {
        return "Konyv{ cim: " + title + " szerzo: " + author + " kiadva :" + year + " }";
    }    

    public void toConsole(String s){
        System.out.println(s + " " + this.toString());
    }
}
