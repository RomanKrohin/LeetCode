import java.util.PriorityQueue;
import java.util.HashSet;

class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();
        
        pq.offer(1L);
        seen.add(1L);
        
        int[] factors = new int[]{2, 3, 5};
        
        long ugly = 1;
        
        for (int i = 0; i < n; i++) {
            ugly = pq.poll();
            

            for (int factor : factors) {
                long newUgly = ugly * factor;
                if (!seen.contains(newUgly)) {
                    seen.add(newUgly);
                    pq.offer(newUgly);
                }
            }
        }
        
        return (int) ugly;
    }
}
