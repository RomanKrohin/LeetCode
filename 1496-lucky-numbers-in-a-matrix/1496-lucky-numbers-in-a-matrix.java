class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i < matrix.length; i++){

            List<Integer> mins = Arrays.stream(matrix[i]).boxed().toList();
            int min = Collections.min(mins);
            int max = Integer.MIN_VALUE;
            int index = mins.indexOf(min);

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