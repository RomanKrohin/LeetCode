class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOnes = 0;
        int minSwaps = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num == 1) {
                totalOnes++;
            }
        }

        if (totalOnes == 0) {
            return 0;
        }

        int currentZeros = 0;
        for (int i = 0; i < totalOnes; i++) {
            if (nums[i] == 0) {
                currentZeros++;
            }
        }
        
        minSwaps = currentZeros;

        for (int i = totalOnes; i < n + totalOnes; i++) {
            if (nums[i % n] == 0) {
                currentZeros++;
            }
            if (nums[(i - totalOnes) % n] == 0) {
                currentZeros--;
            }
            minSwaps = Math.min(minSwaps, currentZeros);
        }

        return minSwaps;
    }
}
