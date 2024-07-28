class Solution {
    public int[] replaceElements(int[] arr) {
        int max=Integer.MIN_VALUE;
        int prev=0;

        for (int i=arr.length-1; i>-1; i--){
            if (arr[i]>max) prev = arr[i];
            
            arr[i]=max;
            
            max=prev;

        }

        if (arr.length>0) arr[arr.length-1]=-1;

        return arr;
    }
}