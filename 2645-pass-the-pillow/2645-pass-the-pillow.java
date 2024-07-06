class Solution {
    public int passThePillow(int n, int time) {
        int tmp = time/(n-1);
        if (tmp%2==0){
            return time%(n-1)+1;
        }
        else {
            return n-(time%(n-1));
        }
    }
}