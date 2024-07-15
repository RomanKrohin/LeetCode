class Solution {
    public int maximumLength(int[] nums) {
        int count=1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(Integer number : nums) {
            int freq = map.getOrDefault(number, 0);
            map.put(number, freq+1);
        }

        for (int n: map.keySet()){
            int pow=1;
            if (n!=1){
                int next = n;
                int nnext = (int) Math.pow(next, 2);
                while(map.get(next)>1 && map.containsKey(nnext) && map.get(nnext)>1){
                    pow+=2;
                    next=(int) Math.pow(next, 2);
                    nnext = (int) Math.pow(next, 2);
                }
                int nnnext = (int) Math.pow(next, 2);
                if (map.get(next)>1 && map.containsKey(nnnext) && map.get(nnnext)>=1){
                    pow+=2;
                }
                count=Math.max(count, pow);
            }
        }

        if (map.containsKey(1)){
            if (map.get(1)%2==0){
                map.put(1, map.get(1)-1);
            }
            count=Math.max(count, map.get(1));
        }
        return count;
    }
}