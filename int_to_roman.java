import java.util.*;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class int_to_roman{
    public static String intToRoman(int num) {
        // Validate input range
        if (num < 1 || num > 3999) {
            throw new IllegalArgumentException("Input must be between 1 and 3999");
        }

        List<String> cs = List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
        List<Integer> vs = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
        StringBuilder ans = new StringBuilder();
        
        for (int i = 0; i < cs.size(); ++i) {
            while (num >= vs.get(i)) {
                num -= vs.get(i);
                ans.append(cs.get(i));
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter an integer (1-3999) to convert to Roman numeral:");
        
        try {
            int number = scanner.nextInt();
            String roman = intToRoman(number);
            System.out.printf("%d in Roman numerals is: %s%n", number, roman);
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid integer.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}