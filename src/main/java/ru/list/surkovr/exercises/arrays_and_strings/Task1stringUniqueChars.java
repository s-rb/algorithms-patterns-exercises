package ru.list.surkovr.exercises.arrays_and_strings;

public class Task1stringUniqueChars {

    // Task:
    // Implement an algorithm to determine if a string has all unique characters. What if you
    // can not use additional data structures?

    // Для упрощения принимаем, что применяется кодировка ASCII (256 кодов)

    // Сложность O(n)
    public static boolean isContainsUniqueChars(String s) {
        // Set<Character> chars = new HashSet<>(); - общий случай, если не знаем кодировку.
        boolean[] res = new boolean[256];
        for (char c : s.toCharArray()) {
            int index = c;
            if (res[index]) return false;
            res[index] = true;
        }
        return true;
    }

    // Без доп структур - сложность O(n^2)
    public static boolean isContainsUniqueCharsNoAddDataStruct(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) return false;
            }
        }
        return true;
    }
}
