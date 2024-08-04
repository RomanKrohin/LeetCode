class Solution {

    private static final int MOD = 1_000_000_007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        int count=0;
        int[] sums = new int[(n*(n+1)/2)];
        int sumFinal =0;

        for (int i=0; i<n; i++){
            int sum = nums[i];
            sums[count]=sum;
            count++;
            for (int j=i+1; j<n; j++){
                sum+=nums[j];
                sums[count]=sum;
                count++;
            }
        }

        Arrays.sort(sums);

         for (int i = left - 1; i < right; i++) {
            sumFinal += sums[i];
            sumFinal %= MOD;
        }

        return sumFinal;
    }
}