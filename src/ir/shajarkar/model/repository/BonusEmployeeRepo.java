package ir.shajarkar.model.repository;

import ir.shajarkar.common.JPAProvider;
import ir.shajarkar.model.entity.Bonus;
import ir.shajarkar.model.entity.BonusEmployee;
import ir.shajarkar.model.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.List;

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

    public List<BonusEmployee> findAll() {
        entityManager = JPAProvider.getEntityManager();
        final List<BonusEmployee> bonusEmployees = entityManager.createQuery("select be from Bonus_Employee be left join fetch Bonus b on b.id=be.bonus.id left join fetch Employee e on e.id=be.employee.id ", BonusEmployee.class).getResultList();
        return bonusEmployees;
    }

    @Override
    public void close() throws Exception {

    }


}
