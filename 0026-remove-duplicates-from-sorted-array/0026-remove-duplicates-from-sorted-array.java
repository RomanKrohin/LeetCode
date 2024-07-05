class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set= new HashSet<>();
        // Поместите все уникальные элементы в множество
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        set= (Set<Integer>) set.stream().sorted().collect(Collectors.toSet());
        
        List<Integer> list = set.stream().collect(Collectors.toList());
        Collections.sort(list);
        int count = 0;
        int[] uniqueNums = new int[set.size()];
        for (int num : list) {
            uniqueNums[count++] = num;
        }
        
        // Скопируйте уникальные элементы обратно в массив nums
        System.arraycopy(uniqueNums, 0, nums, 0, count);
        
        // Верните количество уникальных элементов
        return count;
    }
}