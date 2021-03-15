package leetcode.easy;

public class NewPart1 {
    /*
    Reverse integer
    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value
    to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
    */
    public int reverseInt(int x) {
        final String s = Integer.toString(x);
        char[] rev = new char[s.length()];
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            if (i == 0 && s.charAt(i) == '-') {
                rev[0] = '-';
                j++;
                continue;
            }
            rev[j] = s.charAt(i);
        }
        final String revStr = new String(rev);
        try {
            return Integer.parseInt(revStr);
        } catch (Exception e) {
            return 0;
        }
    }
}
