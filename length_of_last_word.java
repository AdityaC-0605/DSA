import java.util.Scanner;

public class Solution {
    public static int lengthOfLastWord(String s) {
        String ans = "";
        int flag = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && flag == 1) {
                return ans.length();
            }
            else if (s.charAt(i) != ' ') {
                ans += s.charAt(i);
                flag = 1;
            }
        }
        
        return ans.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        
        int result = lengthOfLastWord(input);
        System.out.println("Length of last word: " + result);
    }
}