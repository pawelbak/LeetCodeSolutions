package leetcode.task2;

import leetcode.utils.ListNode;
import org.junit.jupiter.api.Test;

import static leetcode.utils.ListNodeUtils.arrayToListNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTwoNumbers {

    @Test
    public void test() {
        ListNode node1 = arrayToListNode(new int[]{2, 4, 3});
        ListNode node2 = arrayToListNode(new int[]{5, 6, 4});
        ListNode result = new Solution().addTwoNumbers(node1, node2);
        assertEquals(7, result.val);
        assertEquals(0, result.next.val);
        assertEquals(8, result.next.next.val);
    }

}

class Solution {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addThreeNodes(l1, l2, 0);
    }

    private ListNode addThreeNodes(ListNode l1, ListNode l2, int over) {
        int sum = l1.val + l2.val + over;
        int newOver = sum > 9 ? 1 : 0;
        int newSumDigit = sum > 9 ? sum - 10 : sum;
        ListNode current = new ListNode(newSumDigit);
        if (l1.next == null && l2.next == null) {
            if (newOver > 0) {
                current.next = new ListNode(1);
            }
            return current;
        }
        if (l1.next != null && l2.next != null) {
            current.next = addThreeNodes(l1.next, l2.next, newOver);
            return current;
        }
        if (l1.next == null) {
            current.next = addThreeNodes(new ListNode(0), l2.next, newOver);
            return current;
        }
        current.next = addThreeNodes(l1.next, new ListNode(0), newOver);
        return current;
    }
}