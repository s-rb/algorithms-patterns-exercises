package ru.list.surkovr.exercises.arrays_and_strings;

public class Task4anagrams {

    // Task
    // Write a method to decide if two strings are anagrams or not.

    // Для упрощения принимаем, что применяется кодировка ASCII (256 кодов)

    // Не учитывая возможное разное количество пробелов и знаков препинания
    public static boolean isStringsAnagrams(String s1, String s2) {
        if (s1 == null || s2 == null || s1.equals("") || s2.equals("")
                || (s1.length() != s2.length())) return false;
        char[] s1arr = s1.toCharArray();
        char[] s2arr = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            boolean hasSame = false;
            for (int j = 0; j < s2.length(); j++) {
                if (s1arr[i] != '\u0000' && s2arr[j] != '\u0000' && (s1arr[i] == s2arr[j])) {
                    hasSame = true;
                    s2arr[j] = '\u0000';
                    break;
                }
            }
            if (!hasSame) return false;
        }
        return true;
    }
}
