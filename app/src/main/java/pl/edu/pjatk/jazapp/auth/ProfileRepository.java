package pl.edu.pjatk.jazapp.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class ProfileRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addUser(User user){
        var passwordEncoder = new BCryptPasswordEncoder();
        var profile = new ProfileEntity(user, passwordEncoder.encode(user.getPassword()));

        em.persist(profile);
    }

    @Transactional
    public boolean userExists(User user){
        var foundUSer = em.createQuery("from ProfileEntity where username = :username", ProfileEntity.class)
                .setParameter("username", user.getUsername())
                .getResultList();

        return !foundUSer.isEmpty();
    }

    @Transactional
    public boolean correctCredentials(String username, String password){
        var passwordEncoder = new BCryptPasswordEncoder();
        var queryResult = em.createQuery("from ProfileEntity where username = :username", ProfileEntity.class)
                .setParameter("username", username).getResultList();

        if (queryResult.isEmpty()) return false;

        return passwordEncoder.matches(password, queryResult.get(0).getPassword());
    }
}
