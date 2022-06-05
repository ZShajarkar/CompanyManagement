package ir.shajarkar.model.repository;

import ir.shajarkar.common.JPAProvider;
import ir.shajarkar.model.entity.Bonus;
import ir.shajarkar.model.entity.BonusEmployee;
import ir.shajarkar.model.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;

public class BonusEmployeeRepo implements AutoCloseable {

    private BonusEmployeeRepo() {
    }

    private static BonusEmployeeRepo bonusEmployeeRepo = new BonusEmployeeRepo();

    public static BonusEmployeeRepo getInstance() {
        return bonusEmployeeRepo;
    }

    private EntityManager entityManager;

    public void save(Bonus bonus, Employee employee) {
        entityManager = JPAProvider.getEntityManager();
        BonusEmployee bonusEmployee = new BonusEmployee();
        EntityTransaction transaction = entityManager.getTransaction();
        final TypedQuery<Bonus> query = entityManager.createQuery("select b from Bonus b where b.id=:id", Bonus.class);
        query.setParameter("id", bonus.getId());
        final Bonus singleResult = query.getSingleResult();
        transaction.begin();
        singleResult.setNumber(singleResult.getNumber() - 1);
        entityManager.persist(singleResult);
        bonusEmployee.setBonus(singleResult);
        bonusEmployee.setEmployee(employee);
        bonusEmployee.setTakeTime(new Timestamp(System.currentTimeMillis()));
        entityManager.persist(bonusEmployee);
        transaction.commit();
        entityManager.close();
    }

    @Override
    public void close() throws Exception {

    }
}
