class Solution {
    public int findComplement(int num) {
        char[] list = Integer.toBinaryString(num).toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char c: list){
            if (c=='0') sb.append("1");
            if (c=='1') sb.append("0");
        }
        
        return Integer.parseInt(sb.toString(),2);
    }
}