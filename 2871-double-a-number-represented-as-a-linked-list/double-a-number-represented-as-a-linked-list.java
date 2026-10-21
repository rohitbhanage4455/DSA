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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode forward = curr.next;

            curr.next = prev;
            prev = curr;
            curr = forward;
        }

        return prev;
    }
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        ListNode temp = head;


        ListNode dummy = new ListNode(1);
        ListNode t = dummy;

        int carry = 0;
        while(temp != null){
            int sum = temp.val + temp.val + carry;

            int digit = sum % 10;
            carry = sum / 10;

            t.next = new ListNode(digit);
            t = t.next; 

            temp = temp.next;
        }

        if(carry != 0){
            t.next = new ListNode(carry);
        }

        return reverse(dummy.next);
    }
}