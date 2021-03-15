package surkovr.arraysAndStrings;

// Task
// Assume you have a method isSubstring which checks if one word is a substring of
//another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
//only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).

import java.util.Arrays;

public class Task8substringRotation {

    public static void main(String[] args) {

        String s1 = "waterbottle";
        String s2 = "ewaterbottl";
        String s3 = "not rotated substring";

        System.out.println("Is s2 a substring of s1: " + isRotatedSubstring(s1, s2));
        System.out.println("Is s3 a substring of s1: " + isRotatedSubstring(s1, s3));

        System.out.println("----------------\nSecond Impl");
        System.out.println("Is s2 a substring of s1: " + isRotatedSubstring_2impl(s1, s2));
        System.out.println("Is s3 a substring of s1: " + isRotatedSubstring_2impl(s1, s3));
    }

    private static boolean isRotatedSubstring(String source, String check) {
        if (source == null || check == null || source.equals("") || check.equals("")
                || source.length() != check.length()) return false;
        if (source.equals(check)) return true;
        char[] srcArr = source.toCharArray();
        char[] checkArr = check.toCharArray();
        int len = check.length();
        char[] modifiedArray = new char[len];
        int start = 0;
        int end = len - 1;
        for (int offset = 1; offset < len; offset++) {
            System.arraycopy(checkArr, offset, modifiedArray, 0, len - offset);
            System.arraycopy(checkArr, 0, modifiedArray, len - offset, offset);
            if (Arrays.equals(srcArr, modifiedArray)) return true;
        }
        return false;
    }

    private static boolean isRotatedSubstring_2impl(String source, String check) {
        if (source == null || check == null || source.equals("") || check.equals("")
                || source.length() != check.length()) return false;
        if (source.equals(check)) return true;
        return (source + source).contains(check);
    }
}
