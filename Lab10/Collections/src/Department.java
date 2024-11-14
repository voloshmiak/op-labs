import java.util.List;

public class Department {
    private String name;
    private Employee head;
    private List<Employee> employees;

    public Department(String name, Employee head, List<Employee> employees) {
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

    public List<Employee> getEmployees() {
        return employees;
    }
}