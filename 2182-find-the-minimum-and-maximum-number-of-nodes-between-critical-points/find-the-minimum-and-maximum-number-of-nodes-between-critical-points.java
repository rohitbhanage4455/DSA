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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode forward = head.next.next;

        int pos = 1;

        while (forward != null) {

            if (curr.val > prev.val && curr.val > forward.val) {
                list.add(pos);
            }

            if (curr.val < prev.val && curr.val < forward.val) {
                list.add(pos);
            }

            prev = curr;
            curr = forward;
            forward = forward.next;
            pos++;
        }

        if (list.size() < 2) {
            return new int[]{-1, -1};
        }

        int max = list.get(list.size() - 1) - list.get(0);
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1);

            if (diff < min) {
                min = diff;
            }
        }

        return new int[]{min, max};
    }
}