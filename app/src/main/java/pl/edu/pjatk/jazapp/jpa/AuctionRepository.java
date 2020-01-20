package pl.edu.pjatk.jazapp.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AuctionRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public List<AuctionEntity> findAll() {
        return em.createQuery("from AuctionEntity", AuctionEntity.class).getResultList();
    }

    @Transactional
    public Optional<AuctionEntity> findAuctionById(Long auctionId) {
        var auction = em.find(AuctionEntity.class, auctionId);
        return Optional.ofNullable(auction);
    }

    @Transactional
    public List<AuctionEntity> findByOwner(Long ownerId){
        return em.createQuery("from AuctionEntity where ownerId = :ownerId", AuctionEntity.class).setParameter("ownerId", ownerId).getResultList();
    }
}
