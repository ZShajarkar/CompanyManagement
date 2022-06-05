package ir.shajarkar.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "Bonus_Employee")
@Entity(name = "Bonus_Employee")
public class BonusEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Timestamp takeTime;
    @ManyToOne()
    private Bonus bonus;
    @ManyToOne()
    private Employee employee;

    public Long getId() {
        return id;
    }

    public BonusEmployee setId(Long id) {
        this.id = id;
        return this;
    }

    public Timestamp getTakeTime() {
        return takeTime;
    }

    public BonusEmployee setTakeTime(Timestamp takeTime) {
        this.takeTime = takeTime;
        return this;
    }

    public Bonus getBonus() {
        return bonus;
    }

    public BonusEmployee setBonus(Bonus bonus) {
        this.bonus = bonus;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public BonusEmployee setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }
}
