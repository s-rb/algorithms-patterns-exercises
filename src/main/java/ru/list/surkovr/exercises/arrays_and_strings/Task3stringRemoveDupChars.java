package ru.list.surkovr.exercises.arrays_and_strings;

public class Task3stringRemoveDupChars {

    // Task
    //      Design an algorithm and write code to remove the duplicate characters in a string
    //  without using any additional buffer. NOTE: One or two additional variables are fine.
    //  An extra copy of the array is not.
    //      FOLLOW UP
    //      Write the test cases for this method.


    public static void main(String[] args) {

        String sWithDups = "String to remove duplicate characters!";
        System.out.println(removeDupChars(sWithDups));

        // Tests
        String sWithoutDups = "String wIThouDUps!";
        String sAllDups = "ssss";
        String sNull = null;
        System.out.println(removeDupChars_CharArr(sWithDups));
        System.out.println(removeDupChars_CharArr(sWithoutDups));
        System.out.println(removeDupChars_CharArr(sAllDups));
        System.out.println(removeDupChars_CharArr(sNull));
    }

    private static String removeDupChars(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            boolean hasBefore = false;
            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        hasBefore = true;
                        break;
                    }
                }
            }
            if (!hasBefore) sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    // Without buffer
    private static String removeDupChars_CharArr(String s) {
        if (s == null || s.equals("")) return null;
        char[] sArr = s.toCharArray();
        int len = s.length();
        int currIndex = 0;
        int dupsCount = 0;
        for (int i = 0; i < len; i++) {
            boolean hasBefore = false;
            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        hasBefore = true;
                        dupsCount++;
                        break;
                    }
                }
            }
            if (!hasBefore) sArr[currIndex++] = sArr[i];
        }
        if (dupsCount > 0) {
            for (int i = 0; i < dupsCount; i++) {
                sArr[len - 1 - i] = '\u0000';
            }
        }
        return new String(sArr);
    }
}