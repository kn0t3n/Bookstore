package de.gbsschulen.bookstore.book;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "Buch")
public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String ISBN, title, autor;

    public Book() {
    }

    public Book(String ISBN, String title, String autor) {
        this.ISBN = ISBN;
        this.title = title;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(ISBN, book.ISBN) &&
                Objects.equals(title, book.title) &&
                Objects.equals(autor, book.autor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, ISBN, title, autor);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
