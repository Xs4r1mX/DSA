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
    public ListNode reverseList(ListNode head) {
        if(head==null)
        return null;

        ListNode start =null;
        while(head!=null)
        {
            ListNode node = new ListNode(head.val);
            node.next=start;
            start=node;
            head=head.next;
        }
        return start;
    }
}