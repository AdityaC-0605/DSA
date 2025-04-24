import java.util.Scanner;

public class Solution {
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int first = 1, last = x;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        return last; // This returns the floor of sqrt(x)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find its square root: ");
        int num = scanner.nextInt();
        scanner.close();

        if (num < 0) {
            System.out.println("Square root of negative numbers is not supported.");
        } else {
            int result = mySqrt(num);
            System.out.println("The floor of the square root of " + num + " is: " + result);
        }
    }
}
