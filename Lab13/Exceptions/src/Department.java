import java.util.List;

public class Department {
    private final String name;
    private final Employee head;
    private final List<Employee> employees;

    public Department(String name, Employee head, List<Employee> employees) throws InvalidNameException, NullPointerException {
        if (name == null) {
            throw new NullPointerException("Department name cannot be null");
        }
        if (name.trim().isEmpty()) {
            throw new InvalidNameException("Department name cannot be empty");
        }
        for (Employee employee : employees) {
            if (employee == null) {
                throw new NullPointerException("Employee cannot be null");
            }
        }
        if (head == null) {
            throw new NullPointerException("Head of department cannot be null");
        }
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