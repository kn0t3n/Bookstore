package de.gbsschulen.bookstore.book;

import de.gbsschulen.bookstore.login.LoginService;
import de.gbsschulen.bookstore.login.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public BookService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("bookstore");
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }

    public void save(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    public List<Book> readAllBooks() {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b from Book b", Book.class);
        return query.getResultList();
    }

    public List<Book> readBooksFrom(String author) {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b from Book b WHERE b.author ='" + author + "'", Book.class);
        return query.getResultList();
    }

    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hallo Welt");
        User user = new User("hallo", "welt");
        LoginService loginService = new LoginService();
        loginService.saveLogin(user);

        Book book = new Book("234", "Effective Java", "Joshua Bloch");
        Book book1 = new Book("345", "Java für Anfänger", "Andreas Maier");
        Book book2 = new Book("456", "Java für Fortgeschrittene", "Andreas Maier");

        BookService bookService = new BookService();
        bookService.save(book);
        bookService.save(book1);
        bookService.save(book2);
        List<Book> list = bookService.readAllBooks();
        for (Book book3 : list) {
            System.out.println(book3);
        }

        for (Book maier : bookService.readBooksFrom("Maier")) {
            System.out.println(maier);
        }

        bookService.readAllBooks();

        bookService.close();

    }
}
