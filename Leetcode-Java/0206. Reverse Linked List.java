// Iterative Approach:
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = null;
        ListNode temp = head;
        
        while (temp != null) {
            ListNode curr = temp.next;
            temp.next = prev;
            dummyHead = temp;
            temp = curr;
        }
        return dummyHead;
    }
}
// Time Complexity: O(n);
// Space Complexity: O(1);

// Recursive Approach:
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
// Time Complexity: O(n);
// Space Complexity: O(n);
