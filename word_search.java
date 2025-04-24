import java.util.Scanner;

public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int r, int c, String word, int count) {
        if (count == word.length()) {
            return true;
        }
        
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || 
            board[r][c] != word.charAt(count)) {
            return false;
        }
        
        // Mark as visited
        char temp = board[r][c];
        board[r][c] = '#';
        
        // Explore neighbors
        boolean found = dfs(board, r + 1, c, word, count + 1) ||
                        dfs(board, r - 1, c, word, count + 1) ||
                        dfs(board, r, c + 1, word, count + 1) ||
                        dfs(board, r, c - 1, word, count + 1);
        
        // Backtrack
        board[r][c] = temp;
        
        return found;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        
        // Get board dimensions
        System.out.println("Enter number of rows and columns (space separated):");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        // Get board data
        char[][] board = new char[rows][cols];
        System.out.println("Enter board (each row on a new line):");
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            board[i] = line.toCharArray();
        }
        
        // Get word to search
        System.out.println("Enter word to search:");
        String word = scanner.nextLine();
        
        // Check if word exists
        boolean result = solution.exist(board, word);
        System.out.println("Word exists: " + result);
    }
}