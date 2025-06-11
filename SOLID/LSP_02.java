package SOLID;

public class LSP_02 {

    /*
     * TASK:
     * The polymorphic function move expect the same behaviour
     * for all birds, but this isn't the case.
     * Fix this to obey the LSP (Liskov Substitution Principle)!
     */

    // Interface for birds that can fly
    public interface Flyable {
        void fly();
    }

    public static class Bird {
        // Common bird behaviors can go here, e.g., eat, sleep, etc.
        public void eat() {
            System.out.println("The bird is eating...");
        }
    }

    public static class Sparrow extends Bird implements Flyable {
        @Override
        public void fly() {
            System.out.println("The sparrow is flying...");
        }
    }

    public static class Penguin extends Bird {
        // Penguins don't implement Flyable because they can't fly
        public void swim() {
            System.out.println("The penguin is swimming...");
        }
    }

    // This method now specifically operates on Flyable birds
    public static void move(Flyable bird) {
        bird.fly();
    }

    // A more general method for any bird
    public static void interactWithBird(Bird bird) {
        bird.eat();
        // We can check the type if we need specific behavior, but avoid 'instanceof' if possible
        // and prefer polymorphic calls or separate interfaces.
        if (bird instanceof Penguin) {
            ((Penguin) bird).swim();
        } else if (bird instanceof Flyable) {
            ((Flyable) bird).fly();
        }
    }


    public static void main(String[] args) {
        // Sparrows can fly, so they can be passed to move
        move(new Sparrow());

        // Penguins cannot fly, so they cannot be passed to move (which expects a Flyable)
        // This line would now cause a compile-time error:
        // move(new Penguin());

        // We can interact with birds generally
        interactWithBird(new Sparrow());
        interactWithBird(new Penguin());
    }
}