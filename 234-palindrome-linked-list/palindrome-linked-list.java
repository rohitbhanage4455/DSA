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
    public ListNode  findmid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }
    public ListNode reverse(ListNode head2){
        ListNode previous = null;
        ListNode curr = head2;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }
        return previous;
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        if(head.next == null){
            return true;
        }
        ListNode head2  = findmid(head);
        
        ListNode temp = head;
        while(temp.next != head2){
            temp = temp.next;
        }
        temp.next = null;

        ListNode n = reverse(head2);
        head2 = n;

        while(head != null && head2 != null){
            if(head.val != head2.val){
                return false;
            } else {
                head = head.next;
                head2 = head2.next;
            }
        }
        return true;
    }
}