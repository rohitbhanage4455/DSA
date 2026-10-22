/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node curr = head;

        // Step 1: Har node ki copy uske baad insert karo
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Random pointers set karo
        curr = head;

        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Original aur copied list ko alag karo
        curr = head;
        Node newHead = head.next;

        while (curr != null) {
            Node copy = curr.next;
            curr.next = copy.next;

            if (copy.next != null) {
                copy.next = copy.next.next;
            }

            curr = curr.next;
        }

        return newHead;
    }
}