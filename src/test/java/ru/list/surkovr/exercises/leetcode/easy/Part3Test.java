package ru.list.surkovr.exercises.leetcode.easy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class Part3Test {

    @Test
    public void isPalindrome() {
        int x = 19891;
        boolean result;
        if (x < 0) result = false;
        int y = 0;
        int temp = x;

        for (int i = 0; temp > 0; i++) {
            int remain = temp % 10;
            y = (y * 10) + remain;
            temp = temp / 10;
        }

        result = x == y;
        assertThat(result).isTrue();
    }

    // [8,0,7,1,7,7,9,7,5,2,9,1,7,3,7,0,6,5,1,7,7,9,3,8,1,5,7,7,8,4,0,9,3,7,3,4,5,7,4,8,8,5,8,9,8,5,8,8,4,7,5,4,3,7,3,9,0,4,8,7,7,5,1,8,3,9,7,7,1,5,6,0,7,3,7,1,9,2,5,7,9,7,7,1,7,0,8]
    @Test
    public void isPalindromeList() {
        ListNode0 head = new ListNode0(new int[]{8, 0, 7, 1, 7, 7, 9, 7, 5, 2, 9, 1, 7, 3, 7, 0, 6, 5, 1, 7, 7, 9, 3, 8, 1, 5, 7, 7, 8, 4, 0, 9, 3, 7, 3, 4, 5, 7, 4, 8, 8, 5, 8, 9, 8, 5, 8, 8, 4, 7, 5, 4, 3, 7, 3, 9, 0, 4, 8, 7, 7, 5, 1, 8, 3, 9, 7, 7, 1, 5, 6, 0, 7, 3, 7, 1, 9, 2, 5, 7, 9, 7, 7, 1, 7, 0, 8});
        boolean result;
        if (head.next == null) result = true;
        int x = 0;
        ListNode0 node = head;
        while (node != null) {
            x = (10 * x) + node.val;
            node = node.next;
        }

        int y = 0;
        int temp = x;

        for (int i = 0; temp > 0; i++) {
            int remain = temp % 10;
            y = (y * 10) + remain;
            temp = temp / 10;
        }

        result = x == y;
        assertThat(result).isTrue();
    }

    // [8,0,7,1,7,7,9,7,5,2,9,1,7,3,7,0,6,5,1,7,7,9,3,8,1,5,7,7,8,4,0,9,3,7,3,4,5,7,4,8,8,5,8,9,8,5,8,8,4,7,5,4,3,7,3,9,0,4,8,7,7,5,1,8,3,9,7,7,1,5,6,0,7,3,7,1,9,2,5,7,9,7,7,1,7,0,8]
    @Test
    public void isPalindromeList2() {
        ListNode0 head = new ListNode0(new int[]{8, 0, 7, 1, 7, 7, 9, 7, 5, 2, 9, 1, 7, 3, 7, 0, 6, 5, 1, 7, 7, 9, 3, 8, 1, 5, 7, 7, 8, 4, 0, 9, 3, 7, 3, 4, 5, 7, 4, 8, 8, 5, 8, 9, 8, 5, 8, 8, 4, 7, 5, 4, 3, 7, 3, 9, 0, 4, 8, 7, 7, 5, 1, 8, 3, 9, 7, 7, 1, 5, 6, 0, 7, 3, 7, 1, 9, 2, 5, 7, 9, 7, 7, 1, 7, 0, 8});
        Boolean result = null;
        if (head.next == null) result = true;
        ListNode0 node = head;
        ListNode0 revHead = null;
        while (node != null) {
            revHead = new ListNode0(node.val, revHead);
            node = node.next;
        }

        node = head;
        ListNode0 revNode = revHead;
        while (node != null) {
            if (node.val != revNode.val) {
                result = false;
                break;
            }
            node = node.next;
            revNode = revNode.next;
        }

        result = !Boolean.FALSE.equals(result);
        assertThat(result).isTrue();
    }

    public class ListNode0 {
        int val;
        ListNode0 next;

        ListNode0() {
        }

        ListNode0(int val) {
            this.val = val;
        }

        ListNode0(int val, ListNode0 next) {
            this.val = val;
            this.next = next;
        }

        ListNode0(int[] vals) {
            this.val = vals[0];
            ListNode0 node = new ListNode0();
            this.next = node;
            node.val = vals[1];
            for (int i = 2; i < vals.length; i++) {
                node.next = new ListNode0(vals[i]);
                node = node.next;
            }
        }
    }

    @Test
    public void mergeTwoLists() {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode res = null;
        ListNode currentNd = res;
        while (list1 != null || list2 != null) {
            if (res == null) {
                res = new ListNode();
                currentNd = res;
            } else {
                currentNd.next = new ListNode();
                currentNd = currentNd.next;
            }

            if (list1 == null) {
                currentNd.val = list2.val;
                list2 = list2.next;
            } else if (list2 == null) {
                currentNd.val = list1.val;
                list1 = list1.next;
            } else if (list1.val < list2.val) {
                currentNd.val = list1.val;
                list1 = list1.next;
            } else {
                currentNd.val = list2.val;
                list2 = list2.next;
            }
        }

        ListNode expected = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4))))));
        log.info("result: {}", res);
        log.info("expected: {}", expected);
        assertThat(res).isNotNull();
        assertThat(res.toString()).isEqualTo(expected.toString());
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            List<Integer> lst = new ArrayList<>();
            lst.add(val);
            ListNode nxt = this.next;
            while (nxt != null) {
                lst.add(nxt.val);
                nxt = nxt.next;
            }

            return "ListNode[" +
                    lst.toString() +
                    "]";
        }
    }

    /**
     * Given a balanced parentheses string s, return the score of the string.
     * <p>
     * The score of a balanced parentheses string is based on the following rule:
     * <p>
     * "()" has score 1.
     * AB has score A + B, where A and B are balanced parentheses strings.
     * (A) has score 2 * A, where A is a balanced parentheses string.
     */
    public int scoreOfParentheses(String s) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (stack.empty()) {
                stack.push(c);
                continue;
            }
            if (stack.peek().equals(c)) {
                stack.push(c);
            } else {
                stack.pop();
                res++;
            }
        }
        return res;
    }

    @Test
    void scoreOfParenthesesTest() {
        String s = "(())";
        assertThat(scoreOfParentheses(s)).isEqualTo(2);

        String s2 = "()";
        assertThat(scoreOfParentheses(s2)).isEqualTo(1);

        String s3 = "()()";
        assertThat(scoreOfParentheses(s3)).isEqualTo(2);

        String s4 = "(()(()))";
        assertThat(scoreOfParentheses(s4)).isEqualTo(6); // todo wrong
    }

    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if (idx < 1) return word;
        char[] chars = word.toCharArray();
        for (int i = 0; i < (idx + 1) / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[idx - i];
            chars[idx - i] = temp;
        }
        return new String(chars);
    }

    @Test
    void reversePrefix() {
        assertThat(reversePrefix("abcdefd", 'd')).isEqualTo("dcbaefd");
    }

    public String toGoatLatin(String sentence) {
        final String ma = "ma";
        final String space = " ";
        Set<String> vowels = Set.of("a", "e", "i", "o", "u");
        String[] words = sentence.split("\\s+");
        String result = null;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String firstLetter = word.substring(0, 1);
            if (!vowels.contains(firstLetter.toLowerCase())) {
                word = word.substring(1) + firstLetter;
            }
            result = result == null ? word : result + space + word;
            result = result + ma + "a".repeat(i + 1);
        }

        return result;
    }

    @Test
    void testGoatLatin() {
        assertThat(toGoatLatin("I speak Goat Latin")).isEqualTo("Imaa peaksmaaa oatGmaaaa atinLmaaaaa");
        assertThat(toGoatLatin("Each word consists of lowercase and uppercase letters only"))
                .isEqualTo("Eachmaa ordwmaaa onsistscmaaaa ofmaaaaa owercaselmaaaaaa andmaaaaaaa uppercasemaaaaaaaa etterslmaaaaaaaaa onlymaaaaaaaaaa");
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[][] scores = new int[words.length][licensePlate.length()];
        char[] licenceChars = licensePlate.toLowerCase().toCharArray();
        for (int i = 0; i < words.length; i++) {
            char[] wordChars = words[i].toCharArray();
            for (int j = 0; j < wordChars.length; j++) {
                char ch = wordChars[j];
                for (int k = 0; k < licenceChars.length; k++) {
                    if (scores[i][k] == 1) continue;
                    if (licenceChars[k] == ch) {
                        scores[i][k] = 1;
                        break;
                    }
                }
            }
        }

        int highestScore = 0;
        int highestScoreIdx = 0;
        for (int i = 0; i < words.length; i++) {
            int sum = 0;
            for (int k = 0; k < scores[i].length; k++) {
                sum += scores[i][k];
            }
            if (sum < highestScore) continue;

            if (sum == highestScore && words[highestScoreIdx].length() <= words[i].length()) continue;

            highestScore = sum;
            highestScoreIdx = i;
        }

        return words[highestScoreIdx];
    }

    @Test
    void testShortestCompletingWord() {
        assertThat(shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}))
                .isEqualTo("steps");
        assertThat(shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}))
                .isEqualTo("pest");
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int idx = (end + start) / 2;
            int val = nums[idx];
            if (val == target) return idx;
            if (val < target) {
                start = ++idx;
            } else {
                end = --idx;
            }
        }
        return -1;
    }

    @Test
    void doBinarySearchTest() {
        assertThat(search(new int[]{-1, 0, 3, 5, 9, 12}, 9)).isEqualTo(4);
        assertThat(search(new int[]{-1, 0, 3, 5, 9, 12}, 2)).isEqualTo(-1);
        assertThat(search(new int[]{2, 5}, 5)).isEqualTo(1);
    }

    int[] monthDays = getMonthDays();

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysFrom1900(date1) - daysFrom1900(date2));
    }

    public int daysFrom1900(String date) {
        String[] split = date.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);

        int years = year - 1900 - 1;

        return (years * 365 + years / 4)
                + (monthDays[month - 1] + (month > 2 && isLeap(year) ? 1 : 0))
                + day;
    }

    private int[] getMonthDays() {
        int[] monthDays = new int[13];
        monthDays[0] = 0;
        monthDays[1] = 31;
        monthDays[2] = monthDays[1] + 28;
        monthDays[3] = monthDays[2] + 31;
        monthDays[4] = monthDays[3] + 30;
        monthDays[5] = monthDays[4] + 31;
        monthDays[6] = monthDays[5] + 30;
        monthDays[7] = monthDays[6] + 31;
        monthDays[8] = monthDays[7] + 31;
        monthDays[9] = monthDays[8] + 30;
        monthDays[10] = monthDays[9] + 31;
        monthDays[11] = monthDays[10] + 30;
        monthDays[12] = monthDays[11] + 31;
        return monthDays;
    }

    private boolean isLeap(int year) {
        return (year % 100 != 0 && year % 4 == 0) || (year % 100 == 0 && year % 400 == 0);
    }

    @Test
    void testDaysBetweenDates() {
        assertThat(daysBetweenDates("2019-06-29", "2019-06-30")).isEqualTo(1);
        assertThat(daysBetweenDates("2020-01-15", "2019-12-31")).isEqualTo(15);
        assertThat(daysBetweenDates("2074-09-12", "1983-01-08")).isEqualTo(33485);
    }
}
