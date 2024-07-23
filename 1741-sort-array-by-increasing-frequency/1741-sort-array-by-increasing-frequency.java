class Solution {
    public int[] frequencySort(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num: nums){
            int freq = map.getOrDefault(num, 0);
            freq++;
            map.put(num,freq);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, new EntryComparator());

        int i=0;
        int j=0;
        while (i<nums.length){
            if (list.get(j).getValue()==0){
                j++;
            }

            nums[i]=list.get(j).getKey();
            list.get(j).setValue(list.get(j).getValue()-1);
            i++;
        }

        return nums;
    }
}

class EntryComparator implements Comparator<Map.Entry<Integer, Integer>> {

    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {

        if (o1.getValue()==o2.getValue()){
            return o2.getKey()-o1.getKey();
        }

        return o1.getValue()-o2.getValue();
    }
}