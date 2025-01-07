class Solution {
    public List<String> stringMatching(String[] words) {
        
        List<String> list= new ArrayList<>();
        

        for (int i=0; i<words.length;i++){
            for (int j=0; j<words.length;j++){
                if (i==j || words[j].length()>words[i].length()){
                    continue;
                }

                if (words[i].contains(words[j]) && !list.contains(words[j])) list.add(words[j]);
            }
        }

        return list;
    }
}