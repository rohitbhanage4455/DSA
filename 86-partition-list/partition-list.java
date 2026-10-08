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
    public ListNode partition(ListNode head, int x) {

        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);

        ListNode small = smallDummy;
        ListNode large = largeDummy;

        ListNode temp = head;

        while(temp != null) {

            ListNode newNode = new ListNode(temp.val);

            if(temp.val < x) {
                small.next = newNode;
                small = small.next;
            }
            else {
                large.next = newNode;
                large = large.next;
            }

            temp = temp.next;
        }

        small.next = largeDummy.next;

        return smallDummy.next;
    }
}