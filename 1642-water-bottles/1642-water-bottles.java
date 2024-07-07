class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum =numBottles;
        while (numBottles/numExchange>0) {
            sum+=(numBottles/numExchange);
            numBottles=(numBottles/numExchange)+(numBottles%numExchange);
        }
        return sum;
    }
}