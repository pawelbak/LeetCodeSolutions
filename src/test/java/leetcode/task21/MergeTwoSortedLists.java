package leetcode.task21;

import leetcode.utils.ListNode;

public class MergeTwoSortedLists {
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode result = null;
    ListNode endPointer = null;

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        while(list1!=null || list2 !=null){
            if(list1==null){
                push(list2);
                list2 = list2.next;
            }else if(list2==null){
                push(list1);
                list1 = list1.next;
            }else if(list1.val<list2.val){
                push(list1);
                list1 = list1.next;
            }else{
                push(list2);
                list2 = list2.next;
            }
        }
        return result;
    }

    private void push(ListNode elem){
        if(result == null){
            result = elem;
            endPointer = elem;
        } else{
            endPointer.next = elem;
            endPointer = elem;
        }
    }

}