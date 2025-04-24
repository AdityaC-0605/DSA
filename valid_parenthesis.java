import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
    public static boolean isValid(String s) {
        Deque<Character> stk = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stk.push(c);
            } else if (stk.isEmpty() || !match(stk.pop(), c)) {
                return false;
            }
        }
        return stk.isEmpty();
    }

    private static boolean match(char l, char r) {
        return (l == '(' && r == ')') || (l == '{' && r == '}') || (l == '[' && r == ']');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a string containing parentheses (only '(){}[]' allowed):");
        String input = scanner.nextLine();
        
        // Validate input contains only allowed characters
        if (!input.matches("^[\\[\\](){}]*$")) {
            System.out.println("Error: Input contains invalid characters. Only '(){}[]' are allowed.");
            return;
        }
        
        boolean result = isValid(input);
        System.out.println("The parentheses are " + (result ? "valid" : "invalid"));
        
        scanner.close();
    }
}