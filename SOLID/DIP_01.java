package SOLID;

public class DIP_01 {

    /*
     * TASK:
     * The Switch is violating the DIP (Dependency Inversion Principle).
     * Please fix this!
     */
    
    // 1. Create an interface for the switchable device
    public interface Switchable {
        void turnOn();
        void turnOff();
    }

    // 2. Make LightBulb implement the Switchable interface
    public static class LightBulb implements Switchable {
        @Override
        public void turnOn() {
            System.out.println("Light is ON!");
        }
        @Override
        public void turnOff() {
            System.out.println("Light is OFF!");
        }
    }

    public static class Switch {
        // 3. Depend on the abstraction (Switchable interface) instead of the concrete class
        private Switchable device;

        // this is "Dependency Injection" (composition style)
        public Switch(Switchable device) {
            this.device = device;
        }

        public void operate() {
            // For demonstration, let's toggle the state or just turn it on/off
            // A real switch would likely have internal state to know if it's on or off
            device.turnOn(); // Or device.turnOff(); based on desired behavior
        }
    }

    public static void main(String[] args) {
        // Now, Switch depends on Switchable, and LightBulb implements Switchable.
        // This adheres to DIP: high-level module (Switch) and low-level module (LightBulb)
        // both depend on abstractions (Switchable).
        Switchable lightBulb = new LightBulb(); // Can use the interface type
        Switch lightSwitch = new Switch(lightBulb);
        lightSwitch.operate();
    }
}