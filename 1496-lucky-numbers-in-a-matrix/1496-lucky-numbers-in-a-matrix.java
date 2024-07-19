class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i < matrix.length; i++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int index=0;

            for (int k=0; k<matrix[i].length; k++){
                if (min>matrix[i][k]){
                    index = k;
                    min = matrix[i][k];
                }
            }

            for (int j=0; j < matrix.length; j++){
                if (max<matrix[j][index]) max=matrix[j][index];
            };


            if (max==min){
                list.add(max);
            }

        }

        return list;
    }
}