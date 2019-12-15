package pl.edu.pjatk.jazapp.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AuctionRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public List findAll() {
        return em.createQuery("from AuctionEntity", AuctionEntity.class).getResultList();
    }

    @Transactional
    public AuctionEntity findById(Long id){
        return em.createQuery("from AuctionEntity where id = :id", AuctionEntity.class).setParameter("id", id).getSingleResult();
    }

    @Transactional
    public List<AuctionEntity> findByOwner(Long ownerId){
        return em.createQuery("from AuctionEntity where ownerId = :ownerId", AuctionEntity.class).setParameter("ownerId", ownerId).getResultList();
    }
}
