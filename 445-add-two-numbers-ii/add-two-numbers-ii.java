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
    public ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode forward = curr.next;
            curr.next = previous;
            previous = curr;
            curr = forward;
        }

        return previous;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        ListNode curr1 = l1;
        ListNode curr2 = l2;

        int carry = 0;

        while (curr1 != null || curr2 != null) {
            int sum = carry;

            if (curr1 != null) {
                sum += curr1.val;
                curr1 = curr1.next;
            }

            if (curr2 != null) {
                sum += curr2.val;
                curr2 = curr2.next;
            }

            carry = sum / 10;

            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }

        if (carry != 0) {
            temp.next = new ListNode(carry);
        }

        return reverse(dummy.next);  // yaha reverse wapas karna zaroori hai
    }
}