class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap= new HashMap<>();
        int[] result = {0,0};
        for (int i=0; i<nums.length; i++){
            if (hashMap.containsKey(nums[i]) && target==2*nums[i]){
                result[0]=hashMap.get(nums[i]);
                result[1]=i;
                return result;
            }
            else {
                hashMap.put(nums[i], i);
            }
        }

        for (Map.Entry<Integer, Integer> it : hashMap.entrySet()) {
            if (hashMap.containsKey(target - it.getKey())) {
                result[0]=(it.getValue());
                result[1]=hashMap.get(target-it.getKey());
                break;
            }
        }
        return result;
    }
}