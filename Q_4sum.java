import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

public class Q_4sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (n < 4) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1, l = n - 1;
                while (k < l) {
                    long x = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (x < target) {
                        ++k;
                    } else if (x > target) {
                        --l;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k++], nums[l--]));
                        while (k < l && nums[k] == nums[k - 1]) {
                            ++k;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            --l;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get array input
        System.out.println("Enter integers separated by spaces:");
        String[] input = scanner.nextLine().trim().split(" ");
        List<Integer> numList = new ArrayList<>();
        for (String s : input) {
            if (!s.isEmpty()) {
                try {
                    numList.add(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input detected: '" + s + "' is not an integer. Skipping.");
                }
            }
        }
        if (numList.size() == 0) {
            System.out.println("No valid integers entered. Exiting.");
            scanner.close();
            return;
        }
        int[] nums = numList.stream().mapToInt(Integer::intValue).toArray();
        
        // Get target input
        System.out.println("Enter target sum:");
        int target;
        try {
            target = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid target input. Please enter an integer.");
            scanner.close();
            return;
        }
        
        // Calculate and display results
        List<List<Integer>> result = fourSum(nums, target);
        System.out.println("Unique quadruplets that sum to target:");
        result.forEach(System.out::println);
        
        scanner.close();
    }
}