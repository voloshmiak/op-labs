import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Employee john = new Employee("John", "Smith", 50000);
        Employee jane = new Employee("Jane", "Smith", 60000);
        Employee jack = new Employee("Jack", "Smith", 55000);
        Employee jessie = new Employee("Jessie", "Smith", 70000);
        Employee jessica = new Employee("Jessica", "Smith", 80000);
        Employee alina = new Employee("Alina", "Smith", 100000);

        Set<Employee> hrEmployees = new HashSet<>(Set.of(jane, jack));
        Set<Employee> engineeringEmployees = new HashSet<>(Set.of(jessica));

        Department hr = new Department("Human Resources", john, hrEmployees);
        Department engineering = new Department("Engineering", jessie, engineeringEmployees);

        Set<Department> departments = new HashSet<>(Set.of(hr, engineering));
        Firm firm = new Firm("ABC", alina, departments);

        printMaxSalaryEmployee(firm);
        printDepartmentsWithHigherPaidEmployees(firm);
        printAllEmployees(firm);
    }

    public static Employee findMaxSalary(Firm firm) {
        Employee maxSalaryEmployee = firm.getDirector();
        for (Department department : firm.getDepartments()) {
            if (department.getHead().getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = department.getHead();
            }
            for (Employee employee : department.getEmployees()) {
                if (employee.getSalary() > maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employee;
                }
            }
        }
        return maxSalaryEmployee;
    }

    public static Set<Department> findDepartmentsWithHigherPaidEmployees(Firm firm) {
        Set<Department> result = new HashSet<>();
        for (Department department : firm.getDepartments()) {
            double headSalary = department.getHead().getSalary();
            for (Employee employee : department.getEmployees()) {
                if (employee.getSalary() > headSalary) {
                    result.add(department);
                    break;
                }
            }
        }
        return result;
    }

    public static Set<Employee> getAllEmployees(Firm firm) {
        Set<Employee> allEmployees = new HashSet<>();
        allEmployees.add(firm.getDirector());
        for (Department department : firm.getDepartments()) {
            allEmployees.add(department.getHead());
            allEmployees.addAll(department.getEmployees());
        }
        return allEmployees;
    }

    static void printMaxSalaryEmployee(Firm firm) {
        Employee maxSalaryEmployee = findMaxSalary(firm);
        System.out.println(maxSalaryEmployee.getFirstName() + " " + maxSalaryEmployee.getLastName() + " with salary: " + maxSalaryEmployee.getSalary());
    }

    static void printDepartmentsWithHigherPaidEmployees(Firm firm) {
        Set<Department> departmentsWithHigherPaidEmployees = findDepartmentsWithHigherPaidEmployees(firm);
        for (Department department : departmentsWithHigherPaidEmployees) {
            System.out.print("'" + department.getName() + "' ");
        }
        System.out.println();
    }

    static void printAllEmployees(Firm firm) {
        Set<Employee> allEmployees = getAllEmployees(firm);
        for (Employee employee : allEmployees) {
            System.out.print("'" + employee.getFirstName() + " " + employee.getLastName() + "' ");
        }
    }
}