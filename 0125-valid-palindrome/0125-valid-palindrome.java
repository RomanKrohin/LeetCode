class Solution {
    public boolean isPalindrome(String s) {
        
        char[] edit_s = s.trim().toLowerCase().toCharArray();

        ArrayList<Character> sList = new ArrayList<>();

        for(int i=0;i<edit_s.length; i++){
            if (((edit_s[i])>=97 && (edit_s[i])<=122) || ((edit_s[i])>=48 && (edit_s[i])<=57)){
                sList.add(edit_s[i]);
            }
        }

        for(int i=0;i<sList.size()/2; i++){
            if (sList.get(i)!=sList.get(sList.size()-i-1)){
                return false;
            }
        }

        return true;
    }

}