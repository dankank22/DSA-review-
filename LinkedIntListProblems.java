package problems;

import datastructures.LinkedIntList;
// Checkstyle will complain that this is an unused import until you use it in your code.
import datastructures.LinkedIntList.ListNode;

/**
 * See the spec on the website for example behavior.
 *
 * REMEMBER THE FOLLOWING RESTRICTIONS:
 * - do not call any methods on the `LinkedIntList` objects.
 * - do not construct new `ListNode` objects for `reverse3` or `firstToLast`
 *      (though you may have as many `ListNode` variables as you like).
 * - do not construct any external data structures such as arrays, queues, lists, etc.
 * - do not mutate the `data` field of any node; instead, change the list only by modifying
 *      links between nodes.
 */

public class LinkedIntListProblems {

    /**
     * Reverses the 3 elements in the `LinkedIntList` (assume there are exactly 3 elements).
     */
    public static void reverse3(LinkedIntList list) {
        ListNode node1 = list.front;
        ListNode node2 = list.front.next;
        ListNode node3 = list.front.next.next;
        node2.next = null;
        node3.next = node2;
        node1.next = null;
        node2.next = node1;
        list.front = node3;
    }

    /**
     * Moves the first element of the input list to the back of the list.
     */
    public static void firstToLast(LinkedIntList list) {
        ListNode curr = list.front;
        ListNode temp = list.front;
        if (temp != null) {
            if (temp.next != null) {
                while (temp.next != null) {
                    temp = temp.next;
                }
                list.front = curr.next;
                curr.next = null;
                temp.next = curr;
            }
        }
    }

    /**
     * Returns a list consisting of the integers of a followed by the integers
     * of n. Does not modify items of A or B.
     */
    public static LinkedIntList concatenate(LinkedIntList a, LinkedIntList b) {
        if (a.front == null) {
            return new LinkedIntList(b.front);
        }
        if (b.front == null) {
            return new LinkedIntList(a.front);
        }
        ListNode temp = new ListNode(a.front.data);
        ListNode traverse1 = temp;
        ListNode traverse2 = a.front.next;
        while (traverse2 != null) {
            traverse1.next = new ListNode(traverse2.data);
            traverse1 = traverse1.next;
            traverse2 = traverse2.next;
        }
        traverse1.next = b.front;
        return new LinkedIntList(temp);
    }
}
