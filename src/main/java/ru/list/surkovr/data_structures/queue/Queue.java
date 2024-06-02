package ru.list.surkovr.data_structures.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
}
