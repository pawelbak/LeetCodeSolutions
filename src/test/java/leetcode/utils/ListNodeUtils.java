package leetcode.utils;

public class ListNodeUtils {

    public static ListNode arrayToListNode(int[] arr) {
        ListNode first = null;
        ListNode current = null;
        for (int item : arr) {
            ListNode node = new ListNode(item);
            if (first == null) {
                first = node;
            }
            if (current == null) {
                current = node;
            } else {
                current.next = node;
                current = node;
            }
        }
        return first;
    }
}
