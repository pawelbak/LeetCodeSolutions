package leetcode.task23;

import leetcode.utils.ListNode;

public class mergeKSortedLists {
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

    ListNode[] initialLists;
    ListNode resultingList;
    ListNode lastNodePointer;
    public ListNode mergeKLists(ListNode[] lists) {
        this.initialLists = lists;


        int nextListToPick = findLowestElementIndex();
        while(nextListToPick>=0){
            appendNextFromList(nextListToPick);
            removeNodeFromSource(nextListToPick);
            nextListToPick = findLowestElementIndex();
        }
        return resultingList;
    }

    void appendNextFromList(int list){
        ListNode next = new ListNode(this.initialLists[list].val);
        if(this.resultingList == null){
            this.resultingList =next;
        }else{
            this.lastNodePointer.next =next;

        }
        this.lastNodePointer = next;
    }

    void removeNodeFromSource(int list){
        this.initialLists[list] = this.initialLists[list].next;
    }


    int findLowestElementIndex(){
        int lowestVal = 0;
        int lowestValIdx = -1;

        for(int i = 0;i<initialLists.length;i++){
            if(initialLists[i]!=null){
                if(lowestValIdx<0){
                    lowestValIdx = i;
                    lowestVal = initialLists[i].val;
                } else{
                    if(initialLists[i].val<lowestVal){
                        lowestVal = initialLists[i].val;
                        lowestValIdx = i;
                    }
                }
            }
        }

        return lowestValIdx;
    }




}