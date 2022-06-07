package ir.shajarkar.model.servcie;

import ir.shajarkar.model.entity.Employee;
import ir.shajarkar.model.repository.EmployeeRepo;

public class EmployeeService {
    private static final EmployeeService EMPLOYEE_SERVICE = new EmployeeService();

    private EmployeeService() {
    }

    public static EmployeeService getInstance() {
        return EMPLOYEE_SERVICE;
    }

    public Employee login(Employee user) throws Exception {
        try (EmployeeRepo userDA = new EmployeeRepo()) {
            return userDA.selectByUsernameAndPassword(user);
        }
    }

    public void register(Employee user) throws Exception {
        try (EmployeeRepo userDA = new EmployeeRepo()) {
            userDA.save(user);
        }
    }
}
