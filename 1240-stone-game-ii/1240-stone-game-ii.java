import java.util.Arrays;

class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1]; // dp[i][M] - max stones can be collected from piles[i:] with current M
        int[] suffixSum = new int[n];
        
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        
        return helper(0, 1, piles, dp, suffixSum);
    }
    
    private int helper(int i, int M, int[] piles, int[][] dp, int[] suffixSum) {
        if (i == piles.length) return 0;
        if (dp[i][M] != 0) return dp[i][M];
        
        int maxStones = 0;
        for (int x = 1; x <= 2 * M && i + x <= piles.length; x++) {
            maxStones = Math.max(maxStones, suffixSum[i] - helper(i + x, Math.max(M, x), piles, dp, suffixSum));
        }
        
        dp[i][M] = maxStones;
        return maxStones;
    }
}
