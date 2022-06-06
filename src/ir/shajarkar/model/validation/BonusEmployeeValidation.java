package ir.shajarkar.model.validation;

import ir.shajarkar.common.JPAProvider;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.xml.bind.ValidationException;

public class BonusEmployeeValidation {
    private final static BonusEmployeeValidation BONUS_EMPLOYEE_VALIDATION = new BonusEmployeeValidation();
    private EntityManager entityManager;

    private BonusEmployeeValidation() {
    }

    public static BonusEmployeeValidation getInstance() {
        return BONUS_EMPLOYEE_VALIDATION;
    }

    public void hasBoughtLessThanThreeItems(Long employeeId) throws ValidationException {
        final Long numberOfPurchasedItem = countPurchasedItemsByEmployeeId(employeeId);
        if (numberOfPurchasedItem>=3)
            throw new ValidationException("بیش تر 3  آیتم نمی توانید بخرید");
    }

    private Long countPurchasedItemsByEmployeeId(Long employeeId) {
        entityManager = JPAProvider.getEntityManager();
        final Query query = entityManager.createQuery("select count(be.employee) from Bonus_Employee be where be.employee.id=:employeeId");
        query.setParameter("employeeId", employeeId);
        Long numberOfPurchasedItemByEmployeeId = (Long) query.getSingleResult();
        return numberOfPurchasedItemByEmployeeId;
    }
}
