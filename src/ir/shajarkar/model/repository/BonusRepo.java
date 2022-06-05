package ir.shajarkar.model.repository;

import ir.shajarkar.common.JPAProvider;
import ir.shajarkar.model.entity.Bonus;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BonusRepo implements AutoCloseable {

    private BonusRepo() {
    }

    private static BonusRepo bonusRepo = new BonusRepo();

    public static BonusRepo getInstance() {
        return bonusRepo;
    }

    private EntityManager entityManager;

    public void save(Bonus bonus) {
        entityManager = JPAProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(bonus);
        transaction.commit();
    }

    public void update(Bonus bonus) {
        entityManager = JPAProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        final Bonus updatedBonus = entityManager.createQuery("select b from Bonus b where b.id=:id", Bonus.class).setParameter("id", bonus.getId()).getSingleResult();
        updatedBonus.setNumber(bonus.getNumber()).setPrice(bonus.getPrice()).setName(bonus.getName());
        entityManager.persist(updatedBonus);
        transaction.commit();
    }

    public List<Bonus> findMoreThanZeroCapacity() {
        entityManager = JPAProvider.getEntityManager();
        final List<Bonus> notReservedBonuses = entityManager.createNamedQuery("Bonus.findAllUnordered").setParameter("capacityOfBonus", 0L).getResultList();
        return notReservedBonuses;
    }

    public List<Bonus> findAll() {
        entityManager = JPAProvider.getEntityManager();
        final List<Bonus> foundBonuses = entityManager.createQuery("select b from Bonus b", Bonus.class).getResultList();
        return foundBonuses;
    }

    public void close() {

        entityManager.close();
        System.err.println(">>>>>>>>     CLOSE ENTITY MANAGER" +
                "" +
                "MerC koli azatun :))))))))");
    }

}
