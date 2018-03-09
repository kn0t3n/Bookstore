package de.gbsschulen.bookstore.login;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class LoginService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public LoginService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("bookstore");
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }

    public void saveLogin(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }


    public boolean checkPassword(String username, String password) {
        if (username != null && username.length() == 0) {
            return false;
        }
        TypedQuery<User> query = entityManager.createQuery("SELECT l from User l where l.loginname = :username", User.class);
        query.setParameter("username", username);
        List<User> resultList = query.getResultList();
        System.out.println(resultList.size());
        for (User user : resultList) {
            if (user.getLoginname().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
