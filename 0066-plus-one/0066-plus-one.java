class Solution {
    public int[] plusOne(int[] digits) {
        boolean flag = false;
        if (digits.length>0) {
            digits[digits.length-1]++;
        }
        else {
            return digits;
        }

        for (int i=digits.length-1; i>-1; i--){
            if (flag) digits[i]++;

            if (digits[i]==10){
                digits[i]=0;
                flag=true;
            }
            else {
                flag=false;
            }
        }

        if (flag){
            int[] mergedArray = new int[digits.length+1];
            mergedArray[0]=1;
            System.arraycopy(digits, 0, mergedArray, 1, digits.length);
            return mergedArray;
        }
        return  digits;
    }
}