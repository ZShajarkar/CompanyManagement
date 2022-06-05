package ir.shajarkar.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@NamedQuery(
        name = "Bonus.findAllUnordered",
        query = "SELECT b FROM Bonus b where b.number>:capacityOfBonus")
@Entity
@Table(name = "Bonus")
public class Bonus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 20)
    private String name;
    @Column(name = "price")
    private long price;
    @Version
    private long recordVersion;
    @Column(name = "number_")
    private long number;

    public long getId() {
        return id;
    }

    public Bonus setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Bonus setName(String name) {
        this.name = name;
        return this;
    }

    public long getPrice() {
        return price;
    }

    public Bonus setPrice(long price) {
        this.price = price;
        return this;
    }

    public long getNumber() {
        return number;
    }

    public Bonus setNumber(long number) {
        this.number = number;
        return this;
    }

    public Bonus setId(Long id) {
        this.id = id;
        return this;
    }

    public long getRecordVersion() {
        return recordVersion;
    }

    public Bonus setRecordVersion(long recordVersion) {
        this.recordVersion = recordVersion;
        return this;
    }
}
