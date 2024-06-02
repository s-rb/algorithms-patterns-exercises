package ru.list.surkovr.data_structures.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Queue {

    /**
     * 1700. Number of Students Unable to Eat Lunch
     * Easy
     * Topics
     * Companies
     * Hint
     * The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.
     *
     * The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:
     *
     * If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
     * Otherwise, they will leave it and go to the queue's end.
     * This continues until none of the queue students want to take the top sandwich and are thus unable to eat.
     *
     * You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the i​​​​​​th sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the j​​​​​​th student in the initial queue (j = 0 is the front of the queue). Return the number of students that are unable to eat.
     *
     *
     *
     * Example 1:
     *
     * Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
     * Output: 0
     * Explanation:
     * - Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
     * - Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
     * - Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
     * - Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
     * - Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
     * - Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
     * - Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
     * - Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
     * Hence all students are able to eat.
     * Example 2:
     *
     * Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
     * Output: 3
     */
    public static int countStudents(int[] students, int[] sandwiches) {
        java.util.Queue<Integer> studentsQueue = Arrays.stream(students).boxed().collect(Collectors.toCollection(LinkedList::new));
        java.util.Queue<Integer> sandwichesQueue = Arrays.stream(sandwiches).boxed().collect(Collectors.toCollection(LinkedList::new));

        int offered = 0;
        while (!studentsQueue.isEmpty() && !sandwichesQueue.isEmpty() && offered < studentsQueue.size()) {
            Integer student = studentsQueue.poll();
            if (sandwichesQueue.peek().equals(student)) {
                sandwichesQueue.remove();
                offered = 0;
            } else {
                studentsQueue.add(student);
                offered++;
            }
        }

        return studentsQueue.size();
    }

    public static int countStudentsSecondImpl(int[] students, int[] sandwiches) {
        int[] countStudents = new int[2]; // count 1s and 0s
        for (int student : students) ++countStudents[student]; // increment student count

        for (int i = 0; i < sandwiches.length; i++) {
            int sandwich = sandwiches[i];
            if (countStudents[sandwich] == 0) return sandwiches.length - i; // if all student ate such sandwiches - the rest remain
            --countStudents[sandwich]; // decrement student who ate
        }
        return 0; // all students ate
    }


    /**
     * 1823. Find the Winner of the Circular Game
     * Medium
     * Topics
     * Companies
     * Hint
     * There are n friends that are playing a game. The friends are sitting in a circle and are numbered from 1 to n in clockwise order. More formally, moving clockwise from the ith friend brings you to the (i+1)th friend for 1 <= i < n, and moving clockwise from the nth friend brings you to the 1st friend.
     *
     * The rules of the game are as follows:
     *
     * Start at the 1st friend.
     * Count the next k friends in the clockwise direction including the friend you started at. The counting wraps around the circle and may count some friends more than once.
     * The last friend you counted leaves the circle and loses the game.
     * If there is still more than one friend in the circle, go back to step 2 starting from the friend immediately clockwise of the friend who just lost and repeat.
     * Else, the last friend in the circle wins the game.
     * Given the number of friends, n, and an integer k, return the winner of the game.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: n = 5, k = 2
     * Output: 3
     * Explanation: Here are the steps of the game:
     * 1) Start at friend 1.
     * 2) Count 2 friends clockwise, which are friends 1 and 2.
     * 3) Friend 2 leaves the circle. Next start is friend 3.
     * 4) Count 2 friends clockwise, which are friends 3 and 4.
     * 5) Friend 4 leaves the circle. Next start is friend 5.
     * 6) Count 2 friends clockwise, which are friends 5 and 1.
     * 7) Friend 1 leaves the circle. Next start is friend 3.
     * 8) Count 2 friends clockwise, which are friends 3 and 5.
     * 9) Friend 5 leaves the circle. Only friend 3 is left, so they are the winner.
     * Example 2:
     *
     * Input: n = 6, k = 5
     * Output: 1
     * Explanation: The friends leave in this order: 5, 4, 6, 2, 3. The winner is friend 1.
     *
     *
     * Constraints:
     *
     * 1 <= k <= n <= 500
     *
     *
     * Follow up:
     *
     * Could you solve this problem in linear time with constant space?
     */
    public static int findTheWinner(int n, int k) {
        LinkedList<Integer> friends = IntStream.range(1, n+1).boxed().collect(Collectors.toCollection(LinkedList::new));
        while (friends.size() > 1) {
            for (int i = 1; i < k; i++) {
                friends.add(friends.poll());
            }
            friends.remove();
        }
        return friends.poll();
    }
}
