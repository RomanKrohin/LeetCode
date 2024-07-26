class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        int minCities = Integer.MAX_VALUE;
        int city =0;


        for (int[] edge: edges){
            ArrayList<int[]> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(new int[]{edge[1], edge[2]});
            map.put(edge[0], list);
            list = map.getOrDefault(edge[1], new ArrayList<>());
            list.add(new int[]{edge[0], edge[2]});
            map.put(edge[1], list);
        }

        for (ArrayList<int[]> list : map.values()){
            Collections.sort(list, Comparator.comparingInt(a -> a[1]));
        }

        for (int node=0; node<n; node++){
            HashMap<Integer, Integer> set = new HashMap<>();
            helper(set, node, 0, distanceThreshold, map);
            if (minCities>=(set.size()-1)){
                city=node;
                minCities=set.size()-1;
            }

        }

        return city;
    }

    public boolean helper(HashMap<Integer, Integer> set, Integer node, Integer path, Integer distinct, HashMap<Integer, ArrayList<int[]>> map){

        if (path>distinct || set.getOrDefault(node, Integer.MAX_VALUE)<path) return false;

        set.put(node, path);

        for (int[] edge: map.getOrDefault(node, new ArrayList<>())){
            helper(set, edge[0], path+edge[1], distinct, map);
        }

        return true;
    }
}