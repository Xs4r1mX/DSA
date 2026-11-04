/*Definition of singly linked list:
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;

        while (temp != null) {
            // Find the kth node from the current temp
            ListNode kthNode = getKthNode(temp, k);

            // If fewer than k nodes remain, leave them as is and exit
            if (kthNode == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }

            // Store the reference to the node after the kth node
            ListNode nextNode = kthNode.next;
            
            // Disconnect the current k-group so we can reverse it independently
            kthNode.next = null;

            // Reverse the current k-group
            reverse(temp);

            // If this is the first group, update the main head
            if (temp == head) {
                head = kthNode;
            } else {
                // Connect the previous group's tail to the new head of this group (kthNode)
                prevLast.next = kthNode;
            }

            // Update prevLast to the tail of the current reversed group (which is now temp)
            prevLast = temp;
            
            // Move to the next group
            temp = nextNode;
        }

        return head;
    }

    // Helper function to find the kth node
    private ListNode getKthNode(ListNode temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    // Helper function to reverse a linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}