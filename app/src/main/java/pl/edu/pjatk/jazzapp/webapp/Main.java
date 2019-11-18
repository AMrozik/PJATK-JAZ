package pl.edu.pjatk.jazzapp.webapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

@Transactional
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager em = entityManagerFactory.createEntityManager();

        ProfileEntity pe = new ProfileEntity();
        pe.setName("ziggy");
        pe.setPassword("123");

        em.getTransaction().begin();
        em.persist(em);
        em.getTransaction().commit();

        em.close();
        entityManagerFactory.close();
    }
}
