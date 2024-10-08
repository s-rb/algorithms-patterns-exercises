package ru.list.surkovr.exercises.hackerrank;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;


public class Week1 {

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
     * Print all information to the console using standard output (print() or println()).
     *
     * Outputs must be exact (exact spaces and casing).
     */

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
        out.println(sb.toString());
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
        out.println(sb.toString());
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

        public static String plusMinus(List<Integer> arr) {
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

            var a = BigDecimal.valueOf(pos).divide(size, new MathContext(6, RoundingMode.HALF_UP));
            var b = BigDecimal.valueOf(neg).divide(size, new MathContext(6, RoundingMode.HALF_UP));
            var c = BigDecimal.valueOf(zer).divide(size, new MathContext(6, RoundingMode.HALF_UP));
            return a + "\n" + b + "\n" + c;
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
    public static String miniMaxSum(List<Integer> arr) {
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

        return min + " " + max;
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
     * Given an array of integers and a positive integer , determine the number of  pairs where  and  +  is divisible by .
     *
     * Example
     *
     *
     *
     * Three pairs meet the criteria:  and .
     *
     * Function Description
     *
     * Complete the divisibleSumPairs function in the editor below.
     *
     * divisibleSumPairs has the following parameter(s):
     *
     * int n: the length of array
     * int ar[n]: an array of integers
     * int k: the integer divisor
     * Returns
     * - int: the number of pairs
     *
     * Input Format
     *
     * The first line contains  space-separated integers,  and .
     * The second line contains  space-separated integers, each a value of .
     *
     * Constraints
     *
     * Sample Input
     *
     * STDIN           Function
     * -----           --------
     * 6 3             n = 6, k = 3
     * 1 3 2 6 1 2     ar = [1, 3, 2, 6, 1, 2]
     * Sample Output
     *
     *  5
     * Explanation
     *
     * Here are the  valid pairs when :
     */

     public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((ar.get(i) + ar.get(j)) % k == 0) res++;
            }
        }
        return res;
     }
    /**
     * BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
     *         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
     *
     *         String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
     *
     *         int n = Integer.parseInt(firstMultipleInput[0]);
     *
     *         int k = Integer.parseInt(firstMultipleInput[1]);
     *
     *         String[] arTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
     *
     *         List<Integer> ar = new ArrayList<>();
     *
     *         for (int i = 0; i < n; i++) {
     *             int arItem = Integer.parseInt(arTemp[i]);
     *             ar.add(arItem);
     *         }
     *
     *         int result = Result.divisibleSumPairs(n, k, ar);
     *
     *         bufferedWriter.write(String.valueOf(result));
     *         bufferedWriter.newLine();
     *
     *         bufferedReader.close();
     *         bufferedWriter.close();
     */
    /**
     * There is a collection of input strings and a collection of query strings. For each query string, determine how many times it occurs in the list of input strings. Return an array of the results.
     *
     * Example
     *
     *
     *
     * There are  instances of ',  of '' and  of ''. For each query, add an element to the return array, .
     *
     * Function Description
     *
     * Complete the function matchingStrings in the editor below. The function must return an array of integers representing the frequency of occurrence of each query string in strings.
     *
     * matchingStrings has the following parameters:
     *
     * string strings[n] - an array of strings to search
     * string queries[q] - an array of query strings
     * Returns
     *
     * int[q]: an array of results for each query
     * Input Format
     *
     * The first line contains and integer , the size of .
     * Each of the next  lines contains a string .
     * The next line contains , the size of .
     * Each of the next  lines contains a string .
     *
     * Constraints
     *
     *
     *
     *  .
     */
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> result = Arrays.stream(new int[queries.size()]).boxed().collect(Collectors.toList());
        for (int i = 0; i < queries.size(); i++) {
            List<Integer> lst = new ArrayList<>();
            lst.sort(Comparator.naturalOrder());
            String query = queries.get(i);
            for (int j = 0; j < strings.size(); j++) {
                if (strings.get(j).equals(query)) {
                    result.set(i, result.get(i) + 1);
                }
            }
        }
        return result;
    }

    public static long flippingBits(int n) {
        long parseLong = Long.parseLong(Integer.toBinaryString((int) ~n), 2);
        out.println(parseLong);
        return parseLong;
    }

    public static String pangrams(String s) {
        Set<Character> set = new HashSet();
        char[] chars = s.toUpperCase().replace(" ", "").toCharArray();
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }
        return set.size() == 26 ? "pangram" : "not pangram";
    }

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        A.sort(Comparator.naturalOrder());
        B.sort(Comparator.reverseOrder());
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) + B.get(i) < k) return "NO";
        }
        return "YES";
    }

    public static void xOrString() {
        Scanner sc = new Scanner(System.in);
        char[] line1 = sc.nextLine().toCharArray();
        char[] line2 = sc.nextLine().toCharArray();
        sc.close();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line1.length; i++) {
            sb.append(line1[i] ^ line2[i]);
        }
        out.println(sb.toString());
    }

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        long perimiter = 0L;
        List<Integer> sides = new ArrayList<>();

        for (int i = 0; i < sticks.size() - 2; i++) {
            int side1 = sticks.get(i);
            for (int j = i + 1; j < sticks.size() - 1; j++) {
                int side2 = sticks.get(j);
                for (int k = j + 1; k < sticks.size(); k++) {
                    int side3 = sticks.get(k);
                    boolean isDegenerate = (side1 >= side2 + side3) || (side2 >= side1 + side3) || (side3 >= side1 + side2);
                    if (!isDegenerate) {
                        long tempPerim = side1 + side2 + side3;
                        if (tempPerim > perimiter) {
                            perimiter = tempPerim;
                            sides.clear();
                            sides.addAll(Arrays.asList(side1, side2, side3));
                        }
                    }
                }
            }
        }

        if (perimiter == 0) {
            sides.add(-1);
        }

        return sides;
    }

    public static void main2zigZag() {
    Scanner kb = new Scanner(System.in);
    int test_cases = kb.nextInt();
        for(int cs = 1; cs <= test_cases; cs++){
        int n = kb.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = kb.nextInt();
        }
        findZigZagSequence(a, n);
    }
}

    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a);
        int mid = (n + 1)/2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 1;
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed + 1;
        }
        for(int i = 0; i < n; i++){
            if(i > 0) out.print(" ");
            out.print(a[i]);
        }
        out.println();
    }

    public static int pickingNumbers(List<Integer> a) {
        a.sort(Comparator.naturalOrder());
        int result = 0;

        int firstNum = 0;
        int secondNum = 0;
        int maxNums = 0;

        for (Integer i : a) {
            if (firstNum == 0) {
                firstNum = i;
                maxNums++;
            } else if (secondNum == 0 && Math.abs(i - firstNum) <= 1) {
                secondNum = i;
                maxNums++;
            } else if ((firstNum == secondNum && Math.abs(i - firstNum) <= 1) || (firstNum == i || secondNum == i)) {
                maxNums++;
            } else {
                result = Math.max(maxNums, result);
                firstNum = i;
                secondNum = 0;
                maxNums = 1;
            }
        }

        return Math.max(maxNums, result);
    }

    public static String separateNumbers(String s) {
        if (s.length() <= 1) {
            return "NO";
        }

        LinkedList<Long> list = new LinkedList<>();
        boolean isBeautiful = true;
        int length = 1;
        for (int i = 0; i < s.length() / 2; i++) {
            list.clear();
            String s1 = s.substring(0, length);
            Long val = Long.parseLong(s1);
            list.add(val);

            int tempLength = length;
            for (int j = i + 1; j < s.length(); j = j + tempLength) {
                if (s.length() - j < tempLength) {
                    isBeautiful = false;
                    break;
                }
                boolean isNextZero = false;
                if (s.length() >= (j + tempLength + 1)) {
                    String s0 = s.substring(j + tempLength, j + tempLength + 1);
                    Long zero = Long.parseLong(s0);
                    isNextZero = zero == 0;
                }
                if (isNextZero) tempLength++;

                String s2 = s.substring(j, j + tempLength);
                Long num = Long.parseLong(s2);
                if (num - list.getLast() == 1) {
                    list.add(num);
                    isBeautiful = true;
                } else {
                    isBeautiful = false;
                    break;
                }
            }

            if (isBeautiful) {
                isBeautiful = true;
                break;
            }
            if (Long.MAX_VALUE / 10 <= val) break;
            length++;
        }

        return isBeautiful ? ("YES " + list.getFirst()) : "NO";
    }

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int minLength = 6;
        String digitsRegex = ".*[0-9].*";
        String lowerRegex = ".*[a-z].*";
        String upperRegex = ".*[A-Z].*";
        String symbolsRegex = ".*[!@#$%^&*()\\-+ ].*";

        int result = 0;
        int length = minLength - password.length();
        result = length > 0 ? result + length : result;

        int validatedSymbols = 0;
        if (!password.matches(digitsRegex)) validatedSymbols++;
        if (!password.matches(lowerRegex)) validatedSymbols++;
        if (!password.matches(upperRegex)) validatedSymbols++;
        if (!password.matches(symbolsRegex)) validatedSymbols++;

        return validatedSymbols > result ? validatedSymbols : result;
    }

    public static int sansaXor(List<Integer> arr) {
        Integer result = null;

        for (int nums = 1; nums <= arr.size(); nums++) {
            for (int start = 0; start <= arr.size() - nums; start++) {
                Integer temp = null;
                for (int j = start; j < start + nums; j++) {
                    if (temp == null) {
                        temp = arr.get(j);
                    } else {
                        temp = temp ^ arr.get(j);
                    }
                }
                if (result == null) {
                    result = temp;
                } else {
                    result = (result ^ temp);
                }
            }
        }

        return result;
    }

    public static int sansaXor2(List<Integer> arr) {
        return Optional.of(arr).filter(o -> o.size() % 2 == 0).map(o -> 0)
                .orElse(IntStream.range(0, arr.size()).boxed()
                        .filter(o -> o % 2 == 0)
                        .sorted((o1, o2) -> {return o1 - o2;})
                        .map(i -> arr.get(i))
                        .reduce((o1, o2) -> o1 ^ o2).get());
    }

    public static void countSort(List<List<String>> arr) {
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            ints.add(Integer.parseInt(arr.get(i).get(0)));
        }

        List<String> lst = IntStream.range(0, arr.size()).boxed()
                .sorted((i1, i2) -> {
                    int temp = ints.get(i1) - ints.get(i2);
                    return temp != 0 ? temp : (i1 - i2);
                })
                .map(i -> i < arr.size() / 2 ? "-" : arr.get(i).get(1))
                .collect(Collectors.toList());
        out.println(String.join(" ", lst));
    }
    public static void countSort2(List<List<String>> arr) {
        List<String>[] buckets = new List[100];
        int n = 0;
        for (int i=0; i<100; i++)
            buckets[i] = new ArrayList<String>();
        for (List<String> entry: arr)
            buckets[Integer.parseInt(entry.get(0))]
                    .add((n++ < arr.size()/2) ? "-" : entry.get(1));
        for (List<String> bucket: buckets)
            bucket.forEach(s-> out.print(s+" "));
    }
    public static void countSort3(List<List<String>> arr) {
        for (int i = 0; i < arr.size() / 2; i++) arr.get(i).set(1, "-");
        for (int marker = 1; marker < arr.size(); marker++) {
            List<String> temp = arr.get(marker); // Запоминаем помеченный элемент
            int current = marker;
            while (current > 0 && Integer.parseInt(arr.get(current - 1).get(0)) >= Integer.parseInt(temp.get(0))) {
                arr.set(current, arr.get(current - 1));
                --current;
            }
            arr.set(current, temp);
        }
        for (int i = 0; i < arr.size(); i++) {
            out.print(arr.get(i).get(1) + " ");
        }
    }
    public static void countSort4(List<List<String>> arr) {
        List<Map.Entry<Integer, String>> lst = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            List<String> current = arr.get(i);
            if (i < arr.size() / 2) {
                lst.add(Map.entry(Integer.parseInt(current.get(0)), "-"));
            } else {
                lst.add(Map.entry(Integer.parseInt(current.get(0)), current.get(1)));
            }
        }
        String res = lst.stream().sorted(((o1, o2) -> o1.getKey() - o2.getKey())).map(Map.Entry::getValue)
                .collect(Collectors.joining(" "));
        out.println(res);

        for (int i = 0; i < arr.size() / 2; i++) arr.get(i).set(1, "-");
        for (int marker = 1; marker < arr.size(); marker++) {
            List<String> temp = arr.get(marker); // Запоминаем помеченный элемент
            int current = marker;
            while (current > 0 && Integer.parseInt(arr.get(current - 1).get(0)) >= Integer.parseInt(temp.get(0))) {
                arr.set(current, arr.get(current - 1));
                --current;
            }
            arr.set(current, temp);
        }
        for (int i = 0; i < arr.size(); i++) {
            out.print(arr.get(i).get(1) + " ");
        }
    }

    public static void countSort5(List<List<String>> arr) {
        IntStream.range(0, arr.size()).boxed()
                .map(i -> Map.entry(Integer.parseInt(arr.get(i).get(0)), i < arr.size() / 2 ? "-" : arr.get(i).get(1)))
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .map(o -> new StringJoiner(" ").add(o))
                .reduce(StringJoiner::merge)
                .ifPresent(out::println);

        List<Map.Entry<Integer, String>> lst = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            List<String> current = arr.get(i);
            if (i < arr.size() / 2) {
                lst.add(Map.entry(Integer.parseInt(current.get(0)), "-"));
            } else {
                lst.add(Map.entry(Integer.parseInt(current.get(0)), current.get(1)));
            }
        }
        String res = lst.stream().sorted(((o1, o2) -> o1.getKey() - o2.getKey())).map(Map.Entry::getValue)
                .collect(Collectors.joining(" "));
        out.println(res);
    }

    public static int[] sortEvenOdd(int[] nums) {
        if (nums.length < 3) return nums;
        int half = nums.length;
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int i = 0, evenIdx = 0, oddIdx = 0; i < nums.length; i++) {
            if (i % 2 == 0) even.add(nums[i]);
            else odd.add(nums[i]);
        }
        even.sort(Comparator.naturalOrder());
        odd.sort(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i % 2 == 0 ? even.get(i / 2) : odd.get(i / 2);
        }
        return nums;
    }
}
