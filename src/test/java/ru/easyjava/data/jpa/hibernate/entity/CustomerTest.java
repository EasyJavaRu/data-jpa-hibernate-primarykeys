package ru.easyjava.data.jpa.hibernate.entity;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CustomerTest {
    private EntityManagerFactory entityManagerFactory;

    @Before
    public void setUp() throws Exception {
        Customer c = new Customer();
        c.setPassportSeries("AA");
        c.setPassportSNo("0123456789");
        c.setName("Test von Testoff");

        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void testGreeter() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("from Customer", Customer.class)
                .getResultList()
                .forEach(System.out::println);
        em.getTransaction().commit();
        em.close();
    }

}