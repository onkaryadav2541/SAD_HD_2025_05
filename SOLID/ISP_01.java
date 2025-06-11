package SOLID;

public class ISP_01 {

    /*
     * TASK:
     * This SimplePrinter is not a multi functional printer but a very
     * simple one.
     * Please fix this to obey the ISP (Interface Segregation Principle)!
     */

    // ---
    // New Interfaces for specific capabilities
    // ---

    public static interface Printable {
        void printDocument();
    }

    public static interface Scannable {
        void scanDocument();
    }

    public static interface Faxable {
        void faxDocument();
    }

    // ---
    // SimplePrinter now only implements Printable
    // ---

    public static class SimplePrinter implements Printable {
        @Override
        public void printDocument() {
            System.out.println("Sending document to the printer ...");
        }
    }

    // ---
    // Example of a MultiFunctionPrinter that implements all capabilities
    // ---

    public static class MultiFunctionPrinter implements Printable, Scannable, Faxable {
        @Override
        public void printDocument() {
            System.out.println("Printing document from MultiFunctionPrinter ...");
        }

        @Override
        public void scanDocument() {
            System.out.println("Scanning document with MultiFunctionPrinter ...");
        }

        @Override
        public void faxDocument() {
            System.out.println("Faxing document from MultiFunctionPrinter ...");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Simple Printer Usage ---");
        SimplePrinter simplePrinter = new SimplePrinter();
        simplePrinter.printDocument();
        // simplePrinter.scanDocument(); // This would now cause a compile-time error, as expected
        // simplePrinter.faxDocument();  // This would now cause a compile-time error, as expected

        System.out.println("\n--- Multi-Function Printer Usage ---");
        MultiFunctionPrinter multiPrinter = new MultiFunctionPrinter();
        multiPrinter.printDocument();
        multiPrinter.scanDocument();
        multiPrinter.faxDocument();
    }
}