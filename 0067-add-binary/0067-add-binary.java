import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {

        BigInteger ai = new BigInteger(a,2);
        BigInteger bi = new BigInteger(b,2);
        BigInteger sum = ai.add(bi);
        return sum.toString(2);
    }
}
