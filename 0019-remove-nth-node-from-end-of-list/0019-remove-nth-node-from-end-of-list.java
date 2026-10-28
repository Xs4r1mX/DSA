class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node pointing to the head to easily handle head-removal edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast n + 1 steps ahead so that slow stops right BEFORE the target node
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both fast and slow until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the target node
        slow.next = slow.next.next;

        return dummy.next;
    }
}