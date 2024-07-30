import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    private static Map<Integer, Double> memo = new HashMap<>();

    // Recursive method to calculate future value with memoization
    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        // Base case: If no years left, return the current value
        if (years == 0) {
            return currentValue;
        }
        // Check if the result is already computed and stored in the memo map
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
        // Recursive case: Calculate the value for the next year
        double futureValue = calculateFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
        // Store the result in the memo map
        memo.put(years, futureValue);
        return futureValue;
    }

    public static void main(String[] args) {
        double currentValue = 1000.0; // Example current value
        double growthRate = 0.05; // Example annual growth rate (5%)
        int years = 10; // Example number of years into the future

        double futureValue = calculateFutureValue(currentValue, growthRate, years);
        System.out.println("Future value after " + years + " years: $" + futureValue);
    }
}
