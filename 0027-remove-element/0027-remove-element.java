class Solution {
    public int removeElement(int[] nums, int val) {
        ArrayList<Integer> list= new ArrayList<>();
        Arrays.stream(nums).forEach(it->{
            if (it!=val) list.add(it);
        });

        int count = 0;
        int[] uniqueNums = new int[list.size()];
        for (int num : list) {
            uniqueNums[count++] = num;
        }

        System.arraycopy(uniqueNums, 0, nums, 0, count);
        return count;
    }
}