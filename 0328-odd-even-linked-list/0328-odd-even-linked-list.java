class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // Save the start of the even list

        // Traverse while there are even nodes and subsequent nodes
        while (even != null && even.next != null) {
            odd.next = even.next;  // Connect odd to next odd
            odd = odd.next;        // Advance odd pointer
            
            even.next = odd.next;  // Connect even to next even
            even = even.next;      // Advance even pointer
        }

        // Attach the head of the even list to the end of the odd list
        odd.next = evenHead;

        return head;
    }
}