package ru.easyjava.data.jpa.hibernate.entity;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class UserTest {
    private EntityManagerFactory entityManagerFactory;

    @Before
    public void setUp() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
    }

    @Test(expected = PersistenceException.class)
    public void testNeedId() {
        User u = new User();
        u.setEmail("test@example.com");
        u.setPassword("secret");

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();
    }
}