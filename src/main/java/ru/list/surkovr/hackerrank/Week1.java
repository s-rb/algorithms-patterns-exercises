package ru.list.surkovr.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

public class Week1 {

    public static void main(String[] args) {
        Result.plusMinus(List.of(1, 1, 0, -1, -1));
        Result.plusMinus(List.of(-4, 3, -9, 0, 4, 1));
        System.out.println("-----------------------------------------");
        miniMaxSum(List.of(1, 2, 3, 4, 5));
        miniMaxSum(List.of(1, 3, 5, 7, 9));
        miniMaxSum(List.of(256741038, 623958417, 467905213, 714532089, 938071625));
        System.out.println("-----------------------------------------");
        System.out.println("12:00:00AM => " + timeConversion("12:00:00AM"));
        System.out.println("12:00:00PM => " + timeConversion("12:00:00PM"));
        System.out.println("12:01:00PM => " + timeConversion("12:01:00PM"));
        System.out.println("12:01:00AM => " + timeConversion("12:01:00AM"));
        System.out.println("07:05:45PM => " + timeConversion("07:05:45PM"));
        System.out.println("06:40:03AM => " + timeConversion("06:40:03AM"));
        System.out.println("12:45:54PM => " + timeConversion("12:45:54PM"));
        System.out.println("-----------------------------------------");
        System.out.println(breakingRecords(List.of(12, 24, 10, 24)));
        System.out.println("-----------------------------------------");
        Scanner sn = new Scanner(System.in);
        while (sn.hasNext()) {
            String line = sn.nextLine();
            System.out.println("Source" + line);
            printTransformed(line);
        }
        System.out.println("-----------------------------------------");

    }

    private static void printTransformed(String line) {
        String[] parts = line.split(";");
        String method = parts[0];
        String entity = parts[1];

        if ("S".equalsIgnoreCase(method)) {
            processSplit(parts[2]);
        } else {
            processCombine(parts, "C".equalsIgnoreCase(entity), "M".equalsIgnoreCase(entity));
        }
    }

    private static void processCombine(String[] parts, boolean isClass, boolean isMethod) {
        String words = parts[2];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length(); i++) {
            char charAt = words.charAt(i);
            if (Character.isSpaceChar(charAt)) {
                charAt = words.charAt(++i);
                sb.append(Character.toUpperCase(charAt));
            } else {
                if (isClass && i == 0) charAt = Character.toUpperCase(charAt);
                sb.append(charAt);
            }
        }
        if (isMethod) sb.append("()");
        System.out.println(sb.toString());
    }

    //         String[] words = words.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])"); через регекс
    private static void processSplit(String words) {
        words = words.replaceAll("[()]", "");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length(); i++) {
            char charAt = words.charAt(i);
            if (Character.isUpperCase(charAt)) {
                if (i != 0) sb.append(" ");
                sb.append(Character.toLowerCase(charAt));
            } else sb.append(charAt);
        }
        System.out.println(sb.toString());
    }

    /**
     * Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero.
     * Print the decimal value of each fraction on a new line with  places after the decimal.
     * <p>
     * Note: This challenge introduces precision problems. The test cases are scaled to six decimal places,
     * though answers with absolute error of up to  are acceptable.
     * <p>
     * Example
     * <p>
     * There are  elements, two positive, two negative and one zero. Their ratios are ,  and . Results are printed as:
     * <p>
     * 0.400000
     * 0.400000
     * 0.200000
     * Function Description
     * <p>
     * Complete the plusMinus function in the editor below.
     * <p>
     * plusMinus has the following parameter(s):
     * <p>
     * int arr[n]: an array of integers
     * Print
     * Print the ratios of positive, negative and zero values in the array. Each value should be printed on a separate
     * line with  digits after the decimal. The function should not return a value.
     * <p>
     * Input Format
     * <p>
     * The first line contains an integer, , the size of the array.
     * The second line contains  space-separated integers that describe .
     * <p>
     * Constraints
     * <p>
     * <p>
     * <p>
     * Output Format
     * <p>
     * Print the following  lines, each to  decimals:
     * <p>
     * proportion of positive values
     * proportion of negative values
     * proportion of zeros
     * Sample Input
     * <p>
     * STDIN           Function
     * -----           --------
     * 6               arr[] size n = 6
     * -4 3 -9 0 4 1   arr = [-4, 3, -9, 0, 4, 1]
     * Sample Output
     * <p>
     * 0.500000
     * 0.333333
     * 0.166667
     * Explanation
     * <p>
     * There are  positive numbers,  negative numbers, and  zero in the array.
     * The proportions of occurrence are positive: , negative:  and zeros: .
     */
    public static class Result {

        /*
         * Complete the 'plusMinus' function below.
         *
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static void plusMinus(List<Integer> arr) {
            // Write your code here
            BigDecimal size = BigDecimal.valueOf(arr.size());
            int pos = 0;
            int neg = 0;
            int zer = 0;
            for (Integer num : arr) {
                if (num == 0) {
                    zer++;
                } else if (num > 0) {
                    pos++;
                } else neg++;
            }
            System.out.println(BigDecimal.valueOf(pos).divide(size, new MathContext(6, RoundingMode.HALF_UP)));
            System.out.println(BigDecimal.valueOf(neg).divide(size, new MathContext(6, RoundingMode.HALF_UP)));
            System.out.println(BigDecimal.valueOf(zer).divide(size, new MathContext(6, RoundingMode.HALF_UP)));
        }

    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            Result.plusMinus(arr);

            bufferedReader.close();
        }
    }

    ///////

    /**
     * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly
     * four of the five integers. Then print the respective minimum and maximum values as a single line of two
     * space-separated long integers.
     * <p>
     * Example
     * <p>
     * The minimum sum is  and the maximum sum is . The function prints
     * <p>
     * 16 24
     * Function Description
     * <p>
     * Complete the miniMaxSum function in the editor below.
     * <p>
     * miniMaxSum has the following parameter(s):
     * <p>
     * arr: an array of  integers
     * Print
     * <p>
     * Print two space-separated integers on one line: the minimum sum and the maximum sum of  of  elements.
     * <p>
     * Input Format
     * <p>
     * A single line of five space-separated integers.
     * <p>
     * Constraints
     * <p>
     * <p>
     * Output Format
     * <p>
     * Print two space-separated long integers denoting the respective minimum and maximum values that can be
     * calculated by summing exactly four of the five integers. (The output can be greater than a 32 bit integer.)
     * <p>
     * Sample Input
     * <p>
     * 1 2 3 4 5
     * Sample Output
     * <p>
     * 10 14
     * Explanation
     * <p>
     * The numbers are , , , , and . Calculate the following sums using four of the five integers:
     * <p>
     * Sum everything except , the sum is .
     * Sum everything except , the sum is .
     * Sum everything except , the sum is .
     * Sum everything except , the sum is .
     * Sum everything except , the sum is .
     * Hints: Beware of integer overflow! Use 64-bit Integer.
     * <p>
     * Need help to get started? Try the Solve Me First problem
     */
    /*
     1 2 3 4
     2 3 4 5
     3 4 5 1
     4 5 1 2
     5 1 2 3
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long[] result = new long[5];

        for (int i = 0; i < 5; i++) {
            for (int j = i; j < i + 4; j++) {
                result[j % 5] = result[j % 5] + arr.get(i);
            }
        }

        long min = result[0];
        long max = result[0];
        for (int i = 1; i < result.length; i++) {
            long num = result[i];
            if (num < min) min = num;
            if (num > max) max = num;
        }

        System.out.println(min + " " + max);
    }

    /**
     * Given a time in -hour AM/PM format, convert it to military (24-hour) time.
     * <p>
     * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
     * - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
     * <p>
     * Example
     * <p>
     * <p>
     * Return '12:01:00'.
     * <p>
     * <p>
     * Return '00:01:00'.
     * <p>
     * Function Description
     * <p>
     * Complete the timeConversion function in the editor below. It should return a new string representing the input time in 24 hour format.
     * <p>
     * timeConversion has the following parameter(s):
     * <p>
     * string s: a time in  hour format
     * Returns
     * <p>
     * string: the time in  hour format
     * Input Format
     * <p>
     * A single string  that represents a time in -hour clock format (i.e.:  or ).
     * <p>
     * Constraints
     * <p>
     * All input times are valid
     * Sample Input
     * <p>
     * 07:05:45PM
     * Sample Output
     * <p>
     * 19:05:45
     */
    public static String timeConversion(String s) {
        // Write your code here
        String minsSeconds = s.substring(2, s.length() - 2);
        int hour = Integer.parseInt(s.substring(0, 2));
        String res;
        if (s.toUpperCase().endsWith("AM")) {
            res = (hour == 12 ? "00" : hour) + minsSeconds;
        } else {
            res = (hour == 12 ? "12" : (hour + 12)) + minsSeconds;
        }
        return res.length() < 8 ? "0" + res : res;
    }

    /**
     * Maria plays college basketball and wants to go pro. Each season she maintains a record of her play.
     * She tabulates the number of times she breaks her season record for most points and least points in a game.
     * Points scored in the first game establish her record for the season, and she begins counting from there.
     * <p>
     * Example
     * <p>
     * Scores are in the same order as the games played. She tabulates her results as follows:
     * <p>
     * Count
     * Game  Score  Minimum  Maximum   Min Max
     * 0      12     12       12       0   0
     * 1      24     12       24       0   1
     * 2      10     10       24       1   1
     * 3      24     10       24       1   1
     * Given the scores for a season, determine the number of times Maria breaks her records for most and least points scored during the season.
     * <p>
     * Function Description
     * <p>
     * Complete the breakingRecords function in the editor below.
     * <p>
     * breakingRecords has the following parameter(s):
     * <p>
     * int scores[n]: points scored per game
     * Returns
     * <p>
     * int[2]: An array with the numbers of times she broke her records. Index  is for breaking most points records, and index  is for breaking least points records.
     * Input Format
     * <p>
     * The first line contains an integer , the number of games.
     * The second line contains  space-separated integers describing the respective values of .
     * <p>
     * Constraints
     */
    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        List<Integer> res = Arrays.asList(0, 0);
        int min = scores.get(0);
        int max = scores.get(0);
        for (Integer score : scores) {
            if (score < min) {
                min = score;
                res.set(1, res.get(1) + 1);
            }
            if (score > max) {
                max = score;
                res.set(0, res.get(0) + 1);
            }
        }
        return res;
    }

    /**
     * Camel Case is a naming style common in many programming languages. In Java, method and variable names typically start with a lowercase letter, with all subsequent words starting with a capital letter (example: startThread). Names of classes follow the same pattern, except that they start with a capital letter (example: BlueCar).
     *
     * Your task is to write a program that creates or splits Camel Case variable, method, and class names.
     *
     * Input Format
     *
     * Each line of the input file will begin with an operation (S or C) followed by a semi-colon followed by M, C, or V followed by a semi-colon followed by the words you'll need to operate on.
     * The operation will either be S (split) or C (combine)
     * M indicates method, C indicates class, and V indicates variable
     * In the case of a split operation, the words will be a camel case method, class or variable name that you need to split into a space-delimited list of words starting with a lowercase letter.
     * In the case of a combine operation, the words will be a space-delimited list of words starting with lowercase letters that you need to combine into the appropriate camel case String. Methods should end with an empty set of parentheses to differentiate them from variable names.
     * Output Format
     *
     * For each input line, your program should print either the space-delimited list of words (in the case of a split operation) or the appropriate camel case string (in the case of a combine operation).
     * Sample Input
     *
     * S;M;plasticCup()
     *
     * C;V;mobile phone
     *
     * C;C;coffee machine
     *
     * S;C;LargeSoftwareBook
     *
     * C;M;white sheet of paper
     *
     * S;V;pictureFrame
     *
     * Sample Output
     *
     * plastic cup
     *
     * mobilePhone
     *
     * CoffeeMachine
     *
     * large software book
     *
     * whiteSheetOfPaper()
     *
     * picture frame
     *
     * Explanation
     *
     * Use Scanner to read in all information as if it were coming from the keyboard.
     *
     * Print all information to the console using standard output (System.out.print() or System.out.println()).
     *
     * Outputs must be exact (exact spaces and casing).
     */

}
