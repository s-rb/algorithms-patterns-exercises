package ru.list.surkovr.hackerrank;

import java.util.*;

public class Week6 {

    public static int month[];

    public static void main(String[] args) {
        System.out.println(counterGame(2));
        System.out.println(counterGame(1900082075));
        System.out.println(counterGame(1073741824));
        System.out.println(counterGame(1877182773));
    }

    public static void updateLeapYear(int year) {
        if(year % 400 == 0) {
            month[2] = 29;
        } else if(year % 100 == 0) {
            month[2] = 28;
        } else if(year % 4 == 0) {
            month[2] = 29;
        } else {
            month[2] = 28;
        }
    }

    public static void storeMonth() {
        month[1] = 31;
        month[2] = 28;
        month[3] = 31;
        month[4] = 30;
        month[5] = 31;
        month[6] = 30;
        month[7] = 31;
        month[8] = 31;
        month[9] = 30;
        month[10] = 31;
        month[11] = 30;
        month[12] = 31;
    }

    public static int findPrimeDates(int d1, int m1, int y1, int d2, int m2, int y2) {
        storeMonth();

        int result = 0;

        while(true) {
            int x = d1;
            x = x * 100 + m1;
            x = x * 10000 + y1;
            if(x % 4 == 0 || x % 7 == 0) {
                result = result + 1;
            }
            if(d1 == d2 && m1 == m2 && y1 == y2) {
                break;
            }
            updateLeapYear(y1);
            d1 = d1 + 1;
            if(d1 > month[m1]) {
                m1 = m1 + 1;
                d1 = 1;
                if(m1 > 12) {
                    y1 =  y1 + 1;
                    m1 = 1;
                }
            }
        }
        return result;
    }

    public static int formingMagicSquare(List<List<Integer>> s) {
        int magicConst = 15; // 15
        int minCost = Integer.MAX_VALUE;

        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < s.size(); i++) {
            arr.add(new ArrayList<>());
            for (int j = 0; j < s.get(0).size(); j++) {
                arr.get(i).add(0);
            }
        }
        int[] asdss = new int[]{1, 2, 3};


        for (int m = 0; m < s.size() * s.get(0).size() * 10; m++) {

        }


        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.get(0).size(); j++) {
                for (int k = 0; k < 10; k++) {
                    arr.get(i).set(j, k);
                    if (isMagic(arr, magicConst)) {
                        int cost = getCost(s, arr);
                        minCost = cost < minCost ? cost : minCost;
                    }
                }
            }
        }
        return minCost;
    }

    private static boolean isMagic(List<List<Integer>> arr, int magicConst) {
        for (int row = 0; row < arr.size(); row++) {
            int sum = 0;
            for (int column = 0; column < arr.get(0).size(); column++) {
                sum += arr.get(row).get(column);
            }
            if (sum != magicConst) return false;
        }
        for (int col = 0; col < arr.get(0).size(); col++) {
            int sum = 0;
            for (int row = 0; row < arr.size(); row++) {
                sum += arr.get(row).get(col);
            }
            if (sum != magicConst) return false;
        }
        return true;
    }

    private static int getCost(List<List<Integer>> arr1, List<List<Integer>> arr2) {
        int cost = 0;
        for (int row = 0; row < arr1.size(); row++) {
            for (int col = 0; col < arr1.get(0).size(); col++) {
                cost += Math.abs(arr1.get(row).get(col) - arr2.get(row).get(col));
            }
        }
        return cost;
    }

    public static String counterGame(long n) {
        int turn = 0;
        while (n > 1) {
            int log2 = (int) (Math.log10(n) / Math.log10(2));
            long pow = (long) Math.pow(2, log2);
            if (pow == n) {
                n >>= 1;
            } else {
                n = n - pow;
            }

            if (n == 1) break;
            turn++;
        }
        return turn % 2 == 0 ? "Louise" : "Richard";

    }

    public static long sumXor(long n) {
        if (n == 0) return 1;
        String bin = Long.toBinaryString(n);
        int zeros = (int) bin.chars().boxed().filter(o -> o.equals((int) '0')).count();
        return (long) Math.pow(2, zeros);
    }
}
