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

// Iteration
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode dummyNode = new ListNode(-1);
      ListNode curr = dummyNode;
      
      while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
          curr.next = l1;
          l1 = l1.next;
        } else {
          curr.next = l2;
          l2 = l2.next;
        }
        curr = curr.next;
      }
      curr.next = l1 == null ? l2 : l1;
      
      return dummyNode.next;
    }
}

// Time Complexity: O(m + n);
// Space Complexity: O(1); Only allocates each of the nodes, so it is constant;

// Recursive method
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) {
        return l2;
      }
      if (l2 == null) {
        return l1;
      }
      if (l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
      } else {
        l2.next = mergeTwoLists(l2.next, l1);
        return l2;
      }
    }
}

// Time Complexity: O(m + n);
// Space Complexity: O(m + n); because the recursive function mergeTwoLists won't return until the end, so m + n stacks consume m + n space
