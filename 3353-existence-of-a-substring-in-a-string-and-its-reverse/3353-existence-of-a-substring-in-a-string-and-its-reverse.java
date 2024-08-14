class Solution {
    public boolean isSubstringPresent(String s) {

        StringBuilder sb = new StringBuilder(s);

        sb.reverse();

        char[] arr = s.toCharArray();
        
        for(int i=1; i<arr.length;i++){
            if (sb.indexOf(String.valueOf(arr[i-1])+String.valueOf(arr[i]))!=-1) return true;
        }


        return false;
    }
}