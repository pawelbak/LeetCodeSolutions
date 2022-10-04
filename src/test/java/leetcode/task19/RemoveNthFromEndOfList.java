package leetcode.task19;

import leetcode.utils.ListNode;

public class RemoveNthFromEndOfList {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return null;
        }
        ListNode first = head;
        ListNode nthNode = findNthNodeFromStart(head, n+1);
        if(nthNode==null){
            return head.next;
        }
        System.out.println("Nth: "+nthNode.val);

        while(nthNode.next!=null){
            nthNode = nthNode.next;
            first = first.next;
        }
        first.next = first.next.next;
        return head;
    }

    ListNode findNthNodeFromStart(ListNode start, int n){
        ListNode x = start;
        for(int i = 2; i<=n;i++){
            x=x.next;
        }
        return x;
    }
}
