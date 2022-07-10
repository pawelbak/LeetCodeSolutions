package leetcode.task876;

import leetcode.utils.ListNode;
import org.junit.jupiter.api.Test;

import static leetcode.utils.ListNodeUtils.arrayToListNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiddleLinkedList {

    @Test
    public void test() {
        ListNode list1 = arrayToListNode(new int[]{1, 2, 3, 4, 5});
        ListNode list2 = arrayToListNode(new int[]{1});
        ListNode list3 = arrayToListNode(new int[]{1, 2});
        ListNode list4 = arrayToListNode(new int[]{1, 2, 3, 4});
        assertEquals(3, new Solution().middleNode(list1).val);
        assertEquals(1, new Solution().middleNode(list2).val);
        assertEquals(2, new Solution().middleNode(list3).val);
        assertEquals(3, new Solution().middleNode(list4).val);
    }
}

class Solution {

    class Finder {
        ListNode current;
        ListNode middle;

        public ListNode findMiddle(ListNode head) {
            current = head;
            middle = head;
            findMiddleNode(1);
            return middle;
        }

        private void findMiddleNode(int currentCount) {
            if (currentCount % 2 == 0) {
                middle = middle.next;
            }
            if (current.next == null) {
                return;
            }
            current = current.next;
            findMiddleNode(++currentCount);
        }
    }

    public ListNode middleNode(ListNode head) {
        Finder finder = new Finder();
        return finder.findMiddle(head);
    }

}