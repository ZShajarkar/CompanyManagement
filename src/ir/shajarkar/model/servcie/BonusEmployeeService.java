package ir.shajarkar.model.servcie;

import ir.shajarkar.model.entity.Bonus;
import ir.shajarkar.model.entity.BonusEmployee;
import ir.shajarkar.model.entity.Employee;
import ir.shajarkar.model.repository.BonusEmployeeRepo;

import java.util.List;

public class BonusEmployeeService {
    private BonusEmployeeService() {
    }

    private final static BonusEmployeeService BONUS_EMPLOYEE_SERVICE = new BonusEmployeeService();

    public static BonusEmployeeService getInstance() {
        return BONUS_EMPLOYEE_SERVICE;
    }

    public void purchaseBonus(Employee employee, Bonus bonus) throws Exception {
        try (BonusEmployeeRepo instance = BonusEmployeeRepo.getInstance()) { //try-with-resource
            instance.save(bonus, employee);
        }
    }

    public List<BonusEmployee> getAll() throws Exception {
        try (BonusEmployeeRepo instance = BonusEmployeeRepo.getInstance()) { //try-with-resource
            final List<BonusEmployee> bonusesPurchasers = instance.findAll();
            return bonusesPurchasers;
        }
    }
}
