import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2 && nums[i] <= 0; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k) {
                int x = nums[i] + nums[j] + nums[k];
                if (x < 0) {
                    ++j;
                } else if (x > 0) {
                    --k;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                    while (j < k && nums[j] == nums[j - 1]) {
                        ++j;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        --k;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get array input
        System.out.println("Enter integers separated by spaces (at least 3 numbers):");
        String input = scanner.nextLine();
        String[] numbers = input.split("\\s+");
        
        // Validate input
        if (numbers.length < 3) {
            System.out.println("Error: At least 3 numbers are required.");
            return;
        }
        
        // Convert to int array
        int[] nums = new int[numbers.length];
        try {
            for (int i = 0; i < numbers.length; i++) {
                nums[i] = Integer.parseInt(numbers[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid integers only.");
            return;
        }
        
        // Find and display triplets
        List<List<Integer>> result = threeSum(nums);
        
        if (result.isEmpty()) {
            System.out.println("No triplet found that sums to zero.");
        } else {
            System.out.println("Unique triplets that sum to zero:");
            for (List<Integer> triplet : result) {
                System.out.println(triplet.stream()
                                      .map(Object::toString)
                                      .collect(Collectors.joining(" ")));
            }
        }
        
        scanner.close();
    }
}