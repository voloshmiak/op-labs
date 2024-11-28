import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Comparator;

public class Firm {
    private String name;
    private Employee director;
    private Set<Department> departments;
    private Map<String, Department> departmentMap;

    public Firm(String name, Employee director, Set<Department> departments) {
        this.name = name;
        this.director = director;
        this.departments = new TreeSet<>(Comparator.comparing(Department::getName));
        this.departments.addAll(departments);
        this.departmentMap = new TreeMap<>();
        for (Department department : departments) {
            this.departmentMap.put(department.getName(), department);
        }
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

    public Department getDepartmentByName(String name) {
        return departmentMap.get(name);
    }
}