package ru.list.surkovr.exercises.arrays_and_strings;

// Task
// Assume you have a method isSubstring which checks if one word is a substring of
//another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
//only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).

import java.util.Arrays;

public class Task8substringRotation {

    public static boolean isRotatedSubstring(String source, String check) {
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

    public static boolean isRotatedSubstring_2impl(String source, String check) {
        if (source == null || check == null || source.equals("") || check.equals("")
                || source.length() != check.length()) return false;
        if (source.equals(check)) return true;
        return (source + source).contains(check);
    }
}
