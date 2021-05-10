package surkovr.arraysAndStrings;

public class Task4anagrams {

    // Task
    // Write a method to decide if two strings are anagrams or not.

    // Для упрощения принимаем, что применяется кодировка ASCII (256 кодов)

    public static void main(String[] args) {
        String anagramString1 = "some anagram string";
        String anagramString2 = "emos granama gnistr";
        String notAnagramString2 = "It's NOT anagram string";

        System.out.println("Check anagram strings: " + isStringsAnagrams(anagramString1, anagramString2));
        System.out.println("Check NOT anagram strings: " + isStringsAnagrams(anagramString1, notAnagramString2));
    }

    // Не учитывая возможное разное количество пробелов и знаков препинания
    private static boolean isStringsAnagrams(String s1, String s2) {
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
