import java.util.List;

public class Firm {
    private String name;
    private Employee director;
    private List<Department> departments;

    public Firm(String name, Employee director, List<Department> departments) {
        this.name = name;
        this.director = director;
        this.departments = departments;
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