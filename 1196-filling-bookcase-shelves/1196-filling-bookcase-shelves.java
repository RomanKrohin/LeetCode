class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int width = books[i - 1][0];
            int height = books[i - 1][1];
            dp[i] = dp[i - 1] + height;

            for (int j = i - 1; j > 0 && width + books[j - 1][0] <= shelfWidth; j--) {
                width += books[j - 1][0];
                height = Math.max(height, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }

        return dp[n];
    }
}
