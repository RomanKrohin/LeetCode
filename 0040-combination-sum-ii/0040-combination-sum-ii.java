class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);
        helper(res, target, candidates, new ArrayList<>(), 0);

        return res;
    }

    public void helper(List<List<Integer>> res , int target, int[] candidates, List<Integer> tmp, int start){

        if (target==0) {
            List<Integer> list  = new ArrayList<>(tmp);
            res.add(list);

        }
        else {
            for(int i =start ; i<candidates.length; i++){

                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }


                if (target-candidates[i]>=0 && candidates[i]>0) {
                    tmp.add(candidates[i]);
                    helper(res, target-candidates[i], candidates, tmp, i+1);
                    tmp.remove(tmp.size()-1);
                }
            }

        }
    }

}