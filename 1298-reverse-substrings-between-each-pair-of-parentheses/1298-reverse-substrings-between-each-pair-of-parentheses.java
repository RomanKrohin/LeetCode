import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public String reverseParentheses(String s) {
        String regex = "\\([^()]*\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            String tmp = matcher.group();
            String reversed = new StringBuilder(tmp).reverse().toString().replace("(", "").replace(")", "");
            s = s.replace(tmp, reversed);
            matcher = pattern.matcher(s);
        }
        return s;
    }
}