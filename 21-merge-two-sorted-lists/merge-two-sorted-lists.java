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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(1);
        ListNode newhead = dummy;
        ListNode newtail = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                newtail.next = list1;
                newtail = list1;
                list1 = list1.next;
            } else {
                newtail.next = list2;
                newtail = list2;
                list2 = list2.next;
            }
        }
        if(list1 != null){
            newtail.next = list1;
        } else {
            newtail.next = list2;
        }
        newhead = newhead.next;
        dummy.next = null;
        return newhead;
    }
}