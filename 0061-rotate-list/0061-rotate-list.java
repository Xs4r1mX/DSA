class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // 1. Find the length and locate the tail node
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // 2. If k is a multiple of len, no rotation is needed
        k = k % len;
        if (k == 0) return head;

        // 3. Make it a circular linked list
        tail.next = head;

        // 4. Find the new tail: (len - k) steps from the start
        ListNode newTail = tail;
        for (int i = 0; i < len - k; i++) {
            newTail = newTail.next;
        }

        // 5. Break the circle and set the new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}