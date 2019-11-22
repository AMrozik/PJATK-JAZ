package pl.edu.pjatk.jazapp.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@ApplicationScoped
public class ProfileRepository {
    @PersistenceContext
    private EntityManager em;

    private final Map<String, User> userMap = new HashMap<>();

    //    TODO: naprawić do gówno3

    // startTx()
    @Transactional
    public void sampleCodeWithPC(User user) {
        var passwordEncoder = new BCryptPasswordEncoder();
        var profile = new ProfileEntity(user);

        em.persist(profile);

        final ProfileEntity profileEntity = em.find(ProfileEntity.class, 7L);
        var foundUSer = em.createQuery("from ProfileEntity where username = :username", ProfileEntity.class)
                .setParameter("username", user.getUsername())
                .getSingleResult();



        final String rawPassword = "xGdXi7Qb5EK4";

        System.out.println("hashed password try 1: " + passwordEncoder.encode(rawPassword));
        final String hashedPassword = passwordEncoder.encode(rawPassword);
        System.out.println("hashed password try 2: " + hashedPassword);

        System.out.println("Does password match?: " + passwordEncoder.matches(rawPassword, hashedPassword));

        System.out.println("user exists" + (foundUSer != null));
    }
    // commitTx()

    @Transactional
    public void register(User user){
        var passwordEncoder = new BCryptPasswordEncoder();
        var profile = new ProfileEntity(user);

        em.persist(profile);
    }

    @Transactional
    public boolean userExists(User user){
        var foundUSer = em.createQuery("from ProfileEntity where username = :username", ProfileEntity.class)
                .setParameter("username", user.getUsername())
                .getSingleResult();

        return foundUSer != null;
    }

//    public User requireUser(String username) {
//        if (!userMap.containsKey(username)) {
//            throw new IllegalStateException("Required user does not exist.");
//        }
//        return userMap.get(username);
//    }
//
//    public Optional<User> findUserByUsername(String username) {
//        if (userMap.containsKey(username)) {
//            return Optional.of(userMap.get(username));
//        }
//        return Optional.empty();
//    }
//
//    @Transactional
//    public void addUser(User user) {
//        if (userMap.containsKey(user.getUsername())) {
////            throw new IllegalStateException(String.format("User %s already exists.", user.getUsername()));
//            System.out.println("user exists");
//        }
//        else {
//            userMap.put(user.getUsername(), user); //TODO: po co to?
//
//            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//            em.persist(new ProfileEntity(user.getUsername(), passwordEncoder.encode(user.getPassword())));
//        }
//    }
}
