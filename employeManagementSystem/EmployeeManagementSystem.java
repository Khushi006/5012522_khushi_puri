class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: $" + salary;
    }
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count] = employee;
            count++;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    // Search for an employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse and display all employees
    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by ID
    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[count - 1] = null;
            count--;
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        // Adding employees
        ems.addEmployee(new Employee(1, "Alice", "Manager", 80000));
        ems.addEmployee(new Employee(2, "Bob", "Developer", 60000));
        ems.addEmployee(new Employee(3, "Charlie", "Designer", 50000));

        // Traverse and display all employees
        System.out.println("All employees:");
        ems.traverseEmployees();

        // Search for an employee
        int searchId = 2;
        Employee foundEmployee = ems.searchEmployee(searchId);
        if (foundEmployee != null) {
            System.out.println("Employee found: " + foundEmployee);
        } else {
            System.out.println("Employee not found.");
        }

        // Delete an employee
        int deleteId = 3;
        ems.deleteEmployee(deleteId);
        System.out.println("Employee with ID " + deleteId + " deleted.");

        // Traverse and display all employees after deletion
        System.out.println("All employees after deletion:");
        ems.traverseEmployees();
    }
}
