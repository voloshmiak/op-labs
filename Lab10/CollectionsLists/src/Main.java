import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee john = new Employee("John", "Smith", 50000);
        Employee jane = new Employee("Jane", "Smith", 60000);
        Employee jack = new Employee("Jack", "Smith", 55000);
        Employee jessie = new Employee("Jessie", "Smith", 70000);
        Employee jessica = new Employee("Jessica", "Smith", 80000);
        Employee alina = new Employee("Alina", "Smith", 100000);


        Department hr = new Department("Human Resources", john, List.of(jane, jack));
        Department engineering = new Department("Engineering", jessie, List.of(jessica));


        Firm firm = new Firm("ABC", alina, List.of(hr, engineering));


        printMaxSalaryEmployee(firm);
        printDepartmentsWithHigherPaidEmployees(firm);
        printAllEmployees(firm);
    }
    public static Employee findMaxSalary(Firm firm) {
        Employee maxSalaryEmployee = firm.getDirector();
        Iterator departmentIterator = firm.getDepartments().iterator();
        while (departmentIterator.hasNext()) {
            Department department = (Department) departmentIterator.next();
            if (department.getHead().getSalary() > maxSalaryEmployee.getSalary()) {
                maxSalaryEmployee = department.getHead();
            }
            Iterator employeeIterator = department.getEmployees().iterator();
            while (employeeIterator.hasNext()) {
                Employee employee = (Employee) employeeIterator.next();
                if (employee.getSalary() > maxSalaryEmployee.getSalary()) {
                    maxSalaryEmployee = employee;
                }
            }
        }
        return maxSalaryEmployee;
}
    public static List<Department> findDepartmentsWithHigherPaidEmployees(Firm firm) {
        List<Department> result = new ArrayList<>();
        Iterator<Department> departmentIterator = firm.getDepartments().iterator();
        while (departmentIterator.hasNext()) {
            Department department = departmentIterator.next();
            double headSalary = department.getHead().getSalary();
            Iterator<Employee> employeeIterator = department.getEmployees().iterator();
            while (employeeIterator.hasNext()) {
                Employee employee = employeeIterator.next();
                if (employee.getSalary() > headSalary) {
                    result.add(department);
                    break;
                }
            }
        }
        return result;
}
    public static List<Employee> getAllEmployees(Firm firm) {
        List<Employee> allEmployees = new ArrayList<>();
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
        List<Department> departmentsWithHigherPaidEmployees = findDepartmentsWithHigherPaidEmployees(firm);
        for (Department department : departmentsWithHigherPaidEmployees) {
            System.out.print("'" + department.getName() + "' ");
        }
        System.out.println();
    }

    static void printAllEmployees(Firm firm) {
        List<Employee> allEmployees = getAllEmployees(firm);
        for (Employee employee : allEmployees) {
            System.out.print("'" + employee.getFirstName() + " " + employee.getLastName() + "' ");
        }
    }
}