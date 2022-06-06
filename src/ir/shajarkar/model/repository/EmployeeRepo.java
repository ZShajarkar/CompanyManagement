package ir.shajarkar.model.repository;

import ir.shajarkar.common.JPAProvider;
import ir.shajarkar.model.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EmployeeRepo implements AutoCloseable {

    private EntityManager entityManager;

    public Employee selectByUsernameAndPassword(Employee user) throws Exception {
        entityManager = JPAProvider.getEntityManager();
        final TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.username=:username and e.password=:password", Employee.class);
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        final Employee employee = query.getSingleResult();
        return employee;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
