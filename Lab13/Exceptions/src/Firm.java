import java.util.List;

public class Firm {
    private final String name;
    private final Employee director;
    private final List<Department> departments;

    public Firm(String name, Employee director, List<Department> departments) throws InvalidNameException, NullPointerException {
        if (name == null) {
            throw new NullPointerException("Firm name cannot be null");
        }
        if (name.trim().isEmpty()) {
            throw new InvalidNameException("Firm name cannot be empty");
        }
        if (director == null) {
            throw new NullPointerException("Director of firm cannot be null");
        }
        for (Department department : departments) {
            if (department == null) {
                throw new NullPointerException("Department cannot be null");
            }
        }
        this.name = name;
        this.director = director;
        this.departments = departments;
    }

    public void addDepartment(Department department) throws InvalidNameException {
        if (department.getName() == null || department.getName().trim().isEmpty()) {
            throw new InvalidNameException("Department name cannot be empty");
        }
        departments.add(department);
    }

    public String getName() {
        return name;
    }

    public Employee getDirector() {
        return director;
    }

    public List<Department> getDepartments() {
        return departments;
    }
}