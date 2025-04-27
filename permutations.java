import java.util.*;
import java.util.stream.Collectors;

public class permutations {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    private boolean[] vis;
    private int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        vis = new boolean[nums.length];
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        for (int j = 0; j < nums.length; ++j) {
            if (!vis[j]) {
                vis[j] = true;
                t.add(nums[j]);
                dfs(i + 1);
                t.remove(t.size() - 1);
                vis[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        
        System.out.println("Enter integers separated by spaces:");
        String input = scanner.nextLine();
        
        // Parse input into integer array
        int[] nums;
        try {
            nums = Arrays.stream(input.split("\\s+"))
                       .mapToInt(Integer::parseInt)
                       .toArray();
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid integers only.");
            return;
        }
        
        // Generate permutations
        List<List<Integer>> permutations = solution.permute(nums);
        
        // Display results
        System.out.println("All possible permutations:");
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation.stream()
                                      .map(Object::toString)
                                      .collect(Collectors.joining(" ")));
        }
        
        System.out.println("Total permutations: " + permutations.size());
        scanner.close();
    }
}