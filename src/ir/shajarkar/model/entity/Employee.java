package ir.shajarkar.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 20)
    private String firstName;
    @Column(length = 20)
    private String lastName;
    @Column()
    private String code;
    @Column(length = 20)
    private String username;
    @Column(length = 20)
    private String password;
    @Column(length = 20)
    private String role;

    public Long getId() {
        return id;
    }

    public Employee setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Employee setCode(String code) {
        this.code = code;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Employee setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Employee setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public Employee setRole(String role) {
        this.role = role;
        return this;
    }
}
