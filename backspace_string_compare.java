import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static boolean backspaceCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
    }
    
    private static String buildString(String str) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : str.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter first string with backspaces:");
        String s = scanner.nextLine();
        
        System.out.println("Enter second string with backspaces:");
        String t = scanner.nextLine();
        
        boolean result = backspaceCompare(s, t);
        System.out.println("Strings are equal after backspaces: " + result);
    }
}