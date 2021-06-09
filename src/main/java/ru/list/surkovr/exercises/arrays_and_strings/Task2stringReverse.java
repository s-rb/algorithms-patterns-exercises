package ru.list.surkovr.exercises.arrays_and_strings;

// Task 2
// Write code to reverse a C-Style String. (C-String means that “abcd” is represented as
// five characters, including the null character.)

public class Task2stringReverse {

    public static String reverseCstyleString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char nullChar = '\u0000';
        stringBuilder.append(nullChar);
        for (int i = s.length() - 1; i >= 0; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
