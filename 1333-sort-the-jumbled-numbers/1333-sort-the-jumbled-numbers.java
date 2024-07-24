class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<nums.length; i++){
            int tmp = nums[i];
            int buf=0;
            int divider=10;

            list.add(nums[i]);

            while (tmp>0){
                buf+=(mapping[tmp%10])*(divider/10);
                tmp/=10;
                divider*=10;
            }



            if (nums[i]==0){
                map.put(nums[i], mapping[0]);
            }
            else {
                map.put(nums[i], buf);
            }

        }

        Collections.sort(list, (a, b) ->{
            int buf_a = map.get(a);
            int buf_b = map.get(b);

            return  Integer.compare(buf_a, buf_b);
        });

        for (int i=0; i<nums.length; i++){
            nums[i]=list.get(i);
        }

        return nums;
    }
}