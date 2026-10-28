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
    public ListNode deleteMiddle(ListNode head) {
        
        if(head==null || head.next==null)
        return null;

        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode fast=head;
        ListNode slow=dummy;
        
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode middle=slow.next;
        slow.next=middle.next;
        middle.next=null;
        

        return head;
    }
}