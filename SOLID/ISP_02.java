package SOLID;

public class ISP_02 {

    /*
     * TASK:
     * Again, some classes are more simple than other.
     * Fix this without violating the ISP (Interface Segregation Principle)!
     */

    // Interface for entities that can perform work
    public static interface Workable {
        void work();
    }

    // Interface for entities that can rest
    public static interface Restable {
        void rest();
    }

    // A human worker can both work and rest
    public static class Developer implements Workable, Restable {
        @Override
        public void work() {
            System.out.println("Developer is coding ...");
        }

        @Override
        public void rest() {
            System.out.println("Developer is making a break!");
        }
    }

    // A robot only needs to work, it doesn't rest
    public static class Robot implements Workable {
        @Override
        public void work() {
            System.out.println("Robot is working hard ...");
        }
    }

    // Method for entities that can only work
    public static void performWork(Workable worker) {
        worker.work();
    }

    // Method for entities that can work and rest (e.g., human workers)
    public static void workingCycle(Workable worker, Restable rester) {
        worker.work();
        rester.rest();
    }
    
    // Overloaded method to handle cases where only work is performed (like a robot)
    public static void workingCycle(Workable worker) {
        worker.work();
    }


    public static void main(String[] args) {
        Developer developer = new Developer();
        Robot robot = new Robot();

        // Developer can participate in a full working cycle
        workingCycle(developer, developer);

        // Robot only performs work
        workingCycle(robot);
    }
}