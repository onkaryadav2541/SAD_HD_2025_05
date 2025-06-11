package SOLID;

public class OCP_02 {

    /*
     * TASK:
     * How to add other shapes without violating the OCP (Open/Closed Principle)?
     * The interface/class/method bodies are empty by purpose, and there is no main provided.
     */
    
    // An abstract class 'Shape' is open for extension. New shapes can extend it.
    public static abstract class Shape {
        // The 'getArea' method is abstract, forcing subclasses to implement their specific area calculation.
        public abstract double getArea();
    }

    // 'Square' extends 'Shape' and provides its specific area calculation.
    public static class Square extends Shape {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        @Override
        public double getArea() {
            return side * side;
        }
    }

    // 'Circle' extends 'Shape' and provides its specific area calculation.
    public static class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }
    }

    // You can now easily add a 'Triangle' without changing 'AreaCalculator'.
    public static class Triangle extends Shape {
        private double base;
        private double height;

        public Triangle(double base, double height) {
            this.base = base;
            this.height = height;
        }

        @Override
        public double getArea() {
            return 0.5 * base * height;
        }
    }

    // The 'AreaCalculator' class is closed for modification. 
    // It doesn't need to change when new shapes are added.
    public static class AreaCalculator {
        // It now simply calls the 'getArea' method on the 'Shape' object.
        // Due to polymorphism, the correct 'getArea' implementation (Square's, Circle's, Triangle's, etc.)
        // will be called at runtime.
        public double calculateShapeArea(Shape shape) {
            return shape.getArea();
        }
    }
}