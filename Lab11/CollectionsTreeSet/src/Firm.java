import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Firm {
    private String name;
    private Employee director;
    private Set<Department> departments;

    public Firm(String name, Employee director, Set<Department> departments) {
        this.name = name;
        this.director = director;
        this.departments = new TreeSet<>(Comparator.comparing(Department::getName));
        this.departments.addAll(departments);
    }

    public String getName() {
        return name;
    }

    public Employee getDirector() {
        return director;
    }

    public Set<Department> getDepartments() {
        return departments;
    }
}