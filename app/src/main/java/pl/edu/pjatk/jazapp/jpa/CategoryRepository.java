package pl.edu.pjatk.jazapp.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CategoryRepository {

    @PersistenceContext
    EntityManager em;

    public Optional<CategoryEntity> findCategoryById(Long categoryId) {
        var category = em.find(CategoryEntity.class, categoryId);
        return Optional.ofNullable(category);
    }

    @Transactional
    public void save(CategoryEntity category) {
        if (category.getId() == null) {
            em.persist(category);
        } else {
            em.merge(category);
        }
    }

    public List<CategoryEntity> findAll() {
        return em.createQuery("from CategoryEntity ", CategoryEntity.class).getResultList();
    }

    @Transactional
    public List<CategoryEntity> findCategoryByName(String name){
        return em.createQuery("from CategoryEntity where name = :name", CategoryEntity.class).setParameter("name", name).getResultList();
    }

//        @Transactional
//        public void addSection(Section section){
//            var addsSection = new SectionEntity(section);
//
//            em.persist(addsSection);
//        }

}
