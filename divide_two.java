import java.util.Scanner;

public class Solution {
    public static int divide(int dividend, int divisor) {
        // Handle division by zero
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }
        
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Convert to long to handle overflow cases
        long longDividend = (long) dividend;
        long longDivisor = (long) divisor;
        
        // Determine the sign of the result
        boolean negative = (longDividend < 0) ^ (longDivisor < 0);
        
        // Work with absolute values
        longDividend = Math.abs(longDividend);
        longDivisor = Math.abs(longDivisor);
        
        long quotient = 0;
        
        // Perform division using subtraction
        while (longDividend >= longDivisor) {
            long tempDivisor = longDivisor;
            long multiple = 1;
            while (longDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }
            longDividend -= tempDivisor;
            quotient += multiple;
        }
        
        // Apply the sign
        quotient = negative ? -quotient : quotient;
        
        // Handle overflow
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int) quotient;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter dividend: ");
        int dividend = scanner.nextInt();
        
        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();
        
        try {
            int result = divide(dividend, divisor);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}