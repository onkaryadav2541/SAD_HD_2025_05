package SOLID;

public class SRP_02 {

    /*
     * TASK:
     * Just made this class obeying the SRP (Single Responsibility Principle)!
     * The method bodies are empty by purpose and there is no main provided.
     */

    /**
     * Represents an Employee with core information.
     * Responsibility: Holding employee data.
     */
    public static class Employee {
        private int employeeID;
        private String name;
        private String designation;
        private double salary;

        // Constructor, getters, and setters
        public Employee(int employeeID, String name, String designation, double salary) {
            this.employeeID = employeeID;
            this.name = name;
            this.designation = designation;
            this.salary = salary;
        }

        public int getEmployeeID() {
            return employeeID;
        }

        public String getName() {
            return name;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }
    }

    /**
     * Handles operations related to employee data persistence and retrieval.
     * Responsibility: Managing employee data in a data store (e.g., database).
     */
    public static class EmployeeRepository {
        public Employee getEmployeeDetails(int employeeID) {
            // In a real application, this would fetch employee data from a database
            System.out.println("Fetching employee details for ID: " + employeeID);
            // For demonstration, returning a dummy employee
            return new Employee(employeeID, "John Doe", "Software Engineer", 70000.00);
        }

        public void updateSalary(int employeeID, double newSalary) {
            // In a real application, this would update the employee's salary in a database
            System.out.println("Updating salary for employee ID: " + employeeID + " to " + newSalary);
        }

        public void saveEmployee(Employee employee) {
            // In a real application, this would save a new employee or update an existing one
            System.out.println("Saving employee: " + employee.getName());
        }
    }

    /**
     * Handles sending emails or other notifications.
     * Responsibility: Communication.
     */
    public static class EmailService {
        public void sendMail(String recipient, String subject, String body) {
            // In a real application, this would send an actual email
            System.out.println("Sending email to: " + recipient);
            System.out.println("Subject: " + subject);
            System.out.println("Body: " + body);
            System.out.println("Email sent successfully!");
        }

        public void sendEmployeeNotification(Employee employee, String message) {
            // Example of a more specific notification
            System.out.println("Sending notification to " + employee.getName() + ": " + message);
            sendMail(employee.getName() + "@company.com", "Important Update", message);
        }
    }
}