import java.util.Set;

public class Department {
    private String name;
    private Employee head;
    private Set<Employee> employees;

    public Department(String name, Employee head, Set<Employee> employees) {
        this.name = name;
        this.head = head;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public Employee getHead() {
        return head;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }
}