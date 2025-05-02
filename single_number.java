import java.util.Scanner;

public class single_number{
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int v : nums) {
            ans ^= v;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter integers separated by spaces (all appear twice except one):");
        String input = scanner.nextLine();
        
        // Parse input into integer array
        int[] nums;
        try {
            String[] parts = input.split("\\s+");
            nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid integers only.");
            return;
        }
        
        // Validate input size (should be odd length)
        if (nums.length % 2 == 0) {
            System.out.println("Warning: Expected odd number of elements. There should be exactly one unique number.");
        }
        
        // Calculate and display result
        int uniqueNumber = singleNumber(nums);
        System.out.println("The single number is: " + uniqueNumber);
        
        scanner.close();
    }
}