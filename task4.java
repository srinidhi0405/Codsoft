import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample exchange rates (base: INR)
        double usdRate = 0.012;
        double eurRate = 0.011;
        double gbpRate = 0.0095;

        System.out.println("=== Currency Converter ===");
        System.out.println("Base Currency: INR");
        System.out.println("Choose target currency:");
        System.out.println("1. USD (US Dollar)");
        System.out.println("2. EUR (Euro)");
        System.out.println("3. GBP (British Pound)");

        System.out.print("Enter choice (1-3): ");
        int choice = scanner.nextInt();

        System.out.print("Enter amount in INR: ");
        double amount = scanner.nextDouble();

        double convertedAmount = 0.0;
        String targetCurrency = "";

        switch (choice) {
            case 1:
                convertedAmount = amount * usdRate;
                targetCurrency = "USD";
                break;
            case 2:
                convertedAmount = amount * eurRate;
                targetCurrency = "EUR";
                break;
            case 3:
                convertedAmount = amount * gbpRate;
                targetCurrency = "GBP";
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        System.out.printf("Converted Amount: %.2f %s\n", convertedAmount, targetCurrency);
    }
}
