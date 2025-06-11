package SOLID;

public class OCP_01 {

    // 1. Create an interface for discount strategies
    public interface DiscountStrategy {
        double calculateDiscount(double amount);
    }

    // 2. Implement concrete discount strategies
    public static class RegularDiscount implements DiscountStrategy {
        @Override
        public double calculateDiscount(double amount) {
            return amount * 0.1;
        }
    }

    public static class PremiumDiscount implements DiscountStrategy {
        @Override
        public double calculateDiscount(double amount) { // Corrected: removed the extra 'double'
            return amount * 0.2;
        }
    }

    // You can now easily add new discount types without modifying existing classes:
    public static class GoldDiscount implements DiscountStrategy {
        @Override
        public double calculateDiscount(double amount) {
            return amount * 0.3; // New discount type
        }
    }

    // 3. Modify DiscountCalculator to use the interface
    public static class DiscountCalculator {
        public double calculateDiscount(DiscountStrategy discountStrategy, double amount) {
            return discountStrategy.calculateDiscount(amount);
        }
    }

    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();

        // Using different discount strategies
        DiscountStrategy regular = new RegularDiscount();
        DiscountStrategy premium = new PremiumDiscount();
        DiscountStrategy gold = new GoldDiscount(); // New discount type

        double regularDiscount = calculator.calculateDiscount(regular, 100.0);
        double premiumDiscount = calculator.calculateDiscount(premium, 100.0);
        double goldDiscount = calculator.calculateDiscount(gold, 100.0);

        System.out.println("Regular Discount: " + regularDiscount);
        System.out.println("Premium Discount: " + premiumDiscount);
        System.out.println("Gold Discount: " + goldDiscount);
    }
}