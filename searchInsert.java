import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get sorted array input
        System.out.println("Enter sorted integers separated by spaces:");
        String[] input = scanner.nextLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        
        // Get target input
        System.out.println("Enter target number:");
        int target = scanner.nextInt();
        
        // Get and display result
        int result = searchInsert(nums, target);
        System.out.println("Insert position: " + result);
    }
}