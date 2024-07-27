
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        final int INF = (int) 1e9;
        int ALPHABET_SIZE = 26;
        
        int[][] minCost = new int[ALPHABET_SIZE][ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            Arrays.fill(minCost[i], INF);
            minCost[i][i] = 0;
        }
        
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            minCost[from][to] = Math.min(minCost[from][to], cost[i]);
        }
        
        for (int k = 0; k < ALPHABET_SIZE; k++) {
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                for (int j = 0; j < ALPHABET_SIZE; j++) {
                    if (minCost[i][k] < INF && minCost[k][j] < INF) {
                        minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                    }
                }
            }
        }
        
        long totalCost = 0;
        for (int i = 0; i < n; i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            if (minCost[from][to] == INF) {
                return -1;
            }
            totalCost += minCost[from][to];
        }
        
        return totalCost;
    }
}