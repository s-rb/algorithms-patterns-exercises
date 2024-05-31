package ru.list.surkovr.data_structures.single_linked_list;

public class LinkedList {

    /**
     * 1290. Convert Binary Number in a Linked List to Integer
     * Easy
     * Topics
     * Companies
     * Hint
     * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
     *
     * Return the decimal value of the number in the linked list.
     *
     * The most significant bit is at the head of the linked list.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: head = [1,0,1]
     * Output: 5
     * Explanation: (101) in base 2 = (5) in base 10
     * Example 2:
     *
     * Input: head = [0]
     * Output: 0
     *
     *
     * Constraints:
     *
     * The Linked List is not empty.
     * Number of nodes will not exceed 30.
     * Each node's value is either 0 or 1.
     */
    public static int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (head == null) break;
            sb.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    /**
     * 2807. Insert Greatest Common Divisors in Linked List
     * Medium
     * Topics
     * Companies
     * Given the head of a linked list head, in which each node contains an integer value.
     *
     * Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.
     *
     * Return the linked list after insertion.
     *
     * The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: head = [18,6,10,3]
     * Output: [18,6,6,2,10,1,3]
     * Explanation: The 1st diagram denotes the initial linked list and the 2nd diagram denotes the linked list after inserting the new nodes (nodes in blue are the inserted nodes).
     * - We insert the greatest common divisor of 18 and 6 = 6 between the 1st and the 2nd nodes.
     * - We insert the greatest common divisor of 6 and 10 = 2 between the 2nd and the 3rd nodes.
     * - We insert the greatest common divisor of 10 and 3 = 1 between the 3rd and the 4th nodes.
     * There are no more adjacent nodes, so we return the linked list.
     * Example 2:
     *
     *
     * Input: head = [7]
     * Output: [7]
     * Explanation: The 1st diagram denotes the initial linked list and the 2nd diagram denotes the linked list after inserting the new nodes.
     * There are no pairs of adjacent nodes, so we return the initial linked list.
     *
     *
     * Constraints:
     *
     * The number of nodes in the list is in the range [1, 5000].
     * 1 <= Node.val <= 1000
     */
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) return head;
        var first = head;
        while (head.next != null) {
            var current = head;
            var next = head.next;
            var middle = new ListNode(getDivision(current.val, next.val));
            current.next = middle;
            middle.next = next;
            head = next;
        }
        return first;
    }

    private int getDivision(int x, int y) {
        return y == 0 ? x : getDivision(y, x % y);
    }
}
