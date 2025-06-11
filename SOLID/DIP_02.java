package SOLID;

public class DIP_02 {

    /*
     * TASK:
     * The class Employee violates the DIP (Dependency Inversion Principle).
     * Fix this!
     */

    public static interface Notification {
        void doNotify();
    }

    public static class EmailNotification implements Notification {
        @Override
        public void doNotify() {
            System.out.println("Sending notification via email!");
        }
    }

    public static class SMSNotification implements Notification { // Added for demonstration of flexibility
        @Override
        public void doNotify() {
            System.out.println("Sending notification via SMS!");
        }
    }

    public static class Employee {
        // Employee now depends on the Notification interface, not EmailNotification
        private Notification notification;

        // Dependency Injection via constructor
        // The constructor now accepts an object of type Notification
        public Employee(Notification notification) {
            this.notification = notification;
        }

        public void notifyEmployee() {
            notification.doNotify();
        }
    }

    public static void main(String[] args) {
        // Client code decides which concrete implementation to use
        EmailNotification emailNotification = new EmailNotification();
        Employee employee1 = new Employee(emailNotification);
        employee1.notifyEmployee();

        SMSNotification smsNotification = new SMSNotification();
        Employee employee2 = new Employee(smsNotification);
        employee2.notifyEmployee();
    }
}