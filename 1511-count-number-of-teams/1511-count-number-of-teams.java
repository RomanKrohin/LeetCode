class Solution {
    public int numTeams(int[] rating) {

        HashMap<Integer, ArrayList<Integer>> map_pravo = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> map_levo = new HashMap<>();
        int count =0;

        for (int i=0; i < rating.length; i++){
            ArrayList<Integer> list_pravo = map_pravo.getOrDefault(rating[i], new ArrayList<>());
            ArrayList<Integer> list_levo = map_levo.getOrDefault(rating[i], new ArrayList<>());
            for (int j=i+1; j < rating.length; j++){
                if (rating[j]<rating[i]) list_pravo.add(rating[j]);
            }

            for (int k=i-1; k>-1; k--){
                if (rating[k]<rating[i]) list_levo.add(rating[k]);
            }
            map_pravo.put(rating[i], list_pravo);
            map_levo.put(rating[i], list_levo);
        }
        
        for (int key: map_pravo.keySet()){
            if (map_pravo.get(key).size()>0){
                for (int tmp: map_pravo.get(key)){
                    if (map_pravo.get(tmp).size()>0) count+= map_pravo.get(tmp).size();
                }
            }
        }

        for (int key: map_pravo.keySet()){
            if (map_levo.get(key).size()>0){
                for (int tmp: map_levo.get(key)){
                    if (map_levo.get(tmp).size()>0) count+= map_levo.get(tmp).size();
                }
            }
        }

        return count;
    }
}

