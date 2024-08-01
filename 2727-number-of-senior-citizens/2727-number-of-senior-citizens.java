class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String person: details){
            if ((person.charAt(person.length()-4)=='6' && person.charAt(person.length()-3)>'0') ||
                    (person.charAt(person.length()-4)>'6')){
                count++;
            }
        }
        return count;
    }
}