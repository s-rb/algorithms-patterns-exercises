package leetcode.easy;


import java.util.logging.Logger;

public class NewPart1 {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    /*
    Reverse integer
    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value
    to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
    */
    public int reverseInt(int x) {
        int reversed = 0;
        while (x != 0) {
            try {
                reversed = Math.addExact(Math.multiplyExact(reversed, 10), x % 10);
            } catch (ArithmeticException e) {
                return 0;
            }
            x = x / 10;
        }
        return reversed;
    }
}
