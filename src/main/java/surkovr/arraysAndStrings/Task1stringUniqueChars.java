package surkovr.arraysAndStrings;

public class Task1stringUniqueChars {

    // Task:
    // Implement an algorithm to determine if a string has all unique characters. What if you
    // can not use additional data structures?

    // Для упрощения принимаем, что применяется кодировка ASCII (256 кодов)

    public static void main(String[] args) {
        String notUniqString = "Some source string. It contains NOT unique characters";
        String uniqString = "String";

        System.out.println("Not unique string result: " + isContainsUniqueChars(notUniqString));
        System.out.println("Unique string: " + isContainsUniqueChars(uniqString));

        System.out.println("-------- without additional datastructure --------");
        System.out.println("Not unique string result: " + isContainsUniqueChars_withoutAdditionalDataStructure(notUniqString));
        System.out.println("Unique string: " + isContainsUniqueChars_withoutAdditionalDataStructure(uniqString));
    }

    // Сложность O(n)
    private static boolean isContainsUniqueChars(String s) {
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
    private static boolean isContainsUniqueChars_withoutAdditionalDataStructure(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) return false;
            }
        }
        return true;
    }
}
