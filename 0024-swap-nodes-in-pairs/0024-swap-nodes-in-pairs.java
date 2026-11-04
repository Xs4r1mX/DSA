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
    public ListNode swapPairs(ListNode head) {
        
        if(head==null || head.next==null)
        return head;

        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode prev = dummy;
        ListNode first = head;
        while(first!=null && first.next!=null)
        {
            ListNode second = first.next;
            first.next=second.next;
            prev.next=second;
            second.next=first;
            prev=prev.next.next;
            first=first.next;
        }
        return dummy.next;

        
    }
}