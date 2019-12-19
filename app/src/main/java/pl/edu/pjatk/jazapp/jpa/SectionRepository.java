package pl.edu.pjatk.jazapp.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class SectionRepository {
        @PersistenceContext
        EntityManager em;

        public Optional<SectionEntity> findSectionById(Long sectionId) {
            var section = em.find(SectionEntity.class, sectionId);
            return Optional.ofNullable(section);
        }

        @Transactional
        public void save(SectionEntity section) {
            if (section.getId() == null) {
                em.persist(section);
            } else {
                em.merge(section);
            }
        }

        public List<SectionEntity> findAll() {
            return em.createQuery("from SectionEntity ", SectionEntity.class).getResultList();
        }

        @Transactional
        public List findSectionByName(String name){
            return em.createQuery("from SectionEntity where name = :name", SectionEntity.class).setParameter("name", name).getResultList();
        }

//        @Transactional
//        public void addSection(Section section){
//            var addsSection = new SectionEntity(section);
//
//            em.persist(addsSection);
//        }
}
