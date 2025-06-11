package SOLID;

public class LSP_01 {

    // Interface for shapes that have an area
    public interface Shape {
        int getArea();
    }

    public static class Rectangle implements Shape {
        protected int width;
        protected int height;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public int getArea() {
            return width * height;
        }
    }

    public static class Square implements Shape {
        protected int side;

        public Square(int side) {
            this.side = side;
        }

        public void setSide(int side) {
            this.side = side;
        }

        public int getSide() {
            return side;
        }

        @Override
        public int getArea() {
            return side * side;
        }
    }

    public static void main(String[] args) {
        // Test Rectangle
        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println("Rectangle (5x10) Area: " + rectangle.getArea()); // Expected: 50

        // Test Square
        Square square = new Square(5);
        System.out.println("Square (5x5) Area: " + square.getArea()); // Expected: 25

        // Demonstrate LSP with a common interface (if needed)
        // For example, a method that calculates area for any shape:
        calculateAndPrintArea(rectangle);
        calculateAndPrintArea(square);
    }

    public static void calculateAndPrintArea(Shape shape) {
        System.out.println("Shape Area: " + shape.getArea());
    }
}