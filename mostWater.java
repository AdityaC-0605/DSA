import java.util.Scanner;

public class MostWater {
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int ans = 0;
        while (i < j) {
            int t = Math.min(height[i], height[j]) * (j - i);
            ans = Math.max(ans, t);
            if (height[i] < height[j]) {
                ++i;
            } else {
                --j;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the heights of vertical lines (space-separated integers):");
        String input = scanner.nextLine();
        
        // Parse input into integer array
        int[] heights;
        try {
            String[] parts = input.split("\\s+");
            heights = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                heights[i] = Integer.parseInt(parts[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid integers only.");
            return;
        }
        
        // Validate input size
        if (heights.length < 2) {
            System.out.println("Error: At least two heights are required.");
            return;
        }
        
        // Calculate and display result
        int maxWater = maxArea(heights);
        System.out.println("The maximum amount of water the container can hold is: " + maxWater);
        
        scanner.close();
    }
}