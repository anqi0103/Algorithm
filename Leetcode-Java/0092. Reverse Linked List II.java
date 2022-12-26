// Recursion Solution

class Solution {
    ListNode successor = null;
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
        }
        return head;
        
        ListNode last = reverseN(next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        returen head;
    }
}

// Time Complexity: O(n);
// Space Complexity: O(n);

// Iterative Solution

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Empty List
        if (head == null) {
            return null;
        }
        // Move the two pointers until they reach the proper starting point in the list
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }
        
        // The two pointers that will fix the final connections
        ListNode con = prev, tail = cur;
        
        //Iteratively reverse the nodes until n becomes 0
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        tail.next = cur;
        return head;
    }
}
// Time Complexity: O(n);
// Space Complexity: O(1);
