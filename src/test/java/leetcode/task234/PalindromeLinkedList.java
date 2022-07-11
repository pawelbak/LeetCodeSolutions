package leetcode.task234;

import leetcode.utils.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static leetcode.utils.ListNodeUtils.arrayToListNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeLinkedList {

    @Test
    public void test() {
        assertEquals(true, new Solution().isPalindrome(arrayToListNode(new int[]{1, 2, 2, 1})));
        assertEquals(false, new Solution().isPalindrome(arrayToListNode(new int[]{1, 2})));
        assertEquals(true, new Solution().isPalindrome(arrayToListNode(new int[]{1})));
        assertEquals(false, new Solution().isPalindrome(arrayToListNode(new int[]{1, 2, 3})));
        assertEquals(true, new Solution().isPalindrome(arrayToListNode(new int[]{1, 2, 1})));
    }

}

class Solution {
    public boolean isPalindrome(ListNode head) {
        Solver s = new Solver();
        s.readItems(head);
        int listSize = s.list.size();
        for (int i = 0; i < listSize; i++) {
            if (!s.list.get(i).equals(s.list.get(listSize - 1 - i))) {
                return false;
            }
            if (i > listSize / 2) {
                return true;
            }
        }
        return true;
    }

    static class Solver {
        List<Integer> list = new ArrayList<>();

        void readItems(ListNode listNode) {
            list.add(listNode.val);
            if (listNode.next != null) {
                readItems(listNode.next);
            }
        }
    }

}