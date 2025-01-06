class Solution {
    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];
        
        ArrayList<Integer> list= new ArrayList<>();

        for (int i = 0 ; i<answer.length; i++){
            if (boxes.charAt(i)=='1'){
                list.add(i);
            }
        };

        for (int i = 0 ; i<answer.length; i++){

            final int tmp_i = i;

            answer[i] = list.stream()
                            .mapToInt(x -> Math.abs(x - tmp_i))
                            .sum();
        };


        return answer;    
    }

}