package ru.list.surkovr.exercises.arrays_and_strings;

// Task
// Write a method to replace all spaces in a string with ‘%20’.

public class Task5replaceSpaces {

    // Предполагаем, что максимальное количество пробелов == длине строки
    //  Значит при замене символа пробела - тремя символами %20, получим результат не болле х3 от исх.строки
    public static String replaceAllSpaces(String s) {
        if (s == null || s.equals("")) return null;
        char[] res = new char[3 * s.length()];
        int resIndex = 0;
        for (char c : s.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                res[resIndex++] = '%';
                res[resIndex++] = '2';
                res[resIndex++] = '0';
            } else {
                res[resIndex++] = c;
            }
        }
        return new String(res, 0, resIndex);
    }
}
