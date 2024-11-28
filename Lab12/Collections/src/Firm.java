import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class Firm {
    private String name;
    private Employee director;
    private Set<Department> departments;
    private Map<String, Department> departmentMap;

    public Firm(String name, Employee director, Set<Department> departments) {
        this.name = name;
        this.director = director;
        this.departments = departments;
        this.departmentMap = new HashMap<>();
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