import java.util.Arrays;
import java.util.Scanner;

public class MinTwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int minDifference = findMinDifference(arr, n);
        System.out.println(minDifference);
        
        sc.close();
    }
    
    static int findMinDifference(int[] arr, int n) {
        int totalSum = Arrays.stream(arr).sum();  
        boolean[] dp = new boolean[totalSum / 2 + 1];
        dp[0] = true;  
        
        for (int num : arr) {
            for (int j = dp.length - 1; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }
        
        int maxSubsetSum = 0;
        for (int i = 0; i <= totalSum / 2; i++) {
            if (dp[i]) {
                maxSubsetSum = i;
            }
        }
        
        return totalSum - 2 * maxSubsetSum;
    }
}
