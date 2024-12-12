public class Employee {
    private final String firstName;
    private final String lastName;
    private final double salary;

    public Employee(String firstName, String lastName, double salary) throws InvalidNameException, NullPointerException, IllegalArgumentException {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        if (firstName == null || lastName == null) {
            throw new NullPointerException("First or Last name cannot be null");
        }
        if (firstName.trim().isEmpty() || lastName.trim().isEmpty()) {
            throw new InvalidNameException("First or Last name cannot be empty");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }
}