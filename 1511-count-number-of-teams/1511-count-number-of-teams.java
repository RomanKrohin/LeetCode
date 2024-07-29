class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int[] lessFromLeft = new int[n];
        int[] lessFromRight = new int[n];
        int[] greaterFromLeft = new int[n];
        int[] greaterFromRight = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    lessFromLeft[i]++;
                } else if (rating[j] > rating[i]) {
                    greaterFromLeft[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rating[j] < rating[i]) {
                    lessFromRight[i]++;
                } else if (rating[j] > rating[i]) {
                    greaterFromRight[i]++;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += lessFromLeft[i] * greaterFromRight[i] + greaterFromLeft[i] * lessFromRight[i];
        }

        return count;
    }
}
