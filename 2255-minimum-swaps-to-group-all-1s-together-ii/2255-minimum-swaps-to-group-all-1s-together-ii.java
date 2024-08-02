class Solution {
    public int minSwaps(int[] nums) {
        int count =Integer.MAX_VALUE;
        int total =0;
        int tmp=0;
        int[] circleNums = new int[(nums.length*2)];

        System.arraycopy(nums, 0, circleNums, 0, nums.length);
        System.arraycopy(nums, 0, circleNums, nums.length, nums.length);

        for (int number: nums){
            if (number==1) total++;
        }

        for (int i=0; i<total; i++){
            if (nums[i]==0) tmp++;
        }

        for (int i=total; i<circleNums.length-1;i++){
            if (circleNums[i]==0)  tmp++;
            if  (circleNums[i-total]==0) tmp--;

            if (tmp<count){
                count=tmp;
            }
        }
        
        if (count==Integer.MAX_VALUE) count=0;
        return count;
    }
}