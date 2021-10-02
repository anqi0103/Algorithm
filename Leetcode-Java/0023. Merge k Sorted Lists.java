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

// Compare one by one using PriorityQueue
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
            (Comparator<ListNode>) (o1, o2) -> o1.val - o2.val
        );
      
        for (ListNode head : lists) {
            if (head != null) {
                heap.offer(head);
            }
        }
      
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
      
        while (!heap.isEmpty()) {
            ListNode curr = heap.poll();
            temp.next = new ListNode(curr.val);
            if (curr.next != null) {
                heap.offer(curr.next);
            }
            temp = temp.next;
        }
        return dummyHead.next;
    }
}
// Time Complexity: O(nlogk)
// Space Complexity: O(n);

// Merge with Divide and Conquer
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 0) {
            return null;
        }
        
        ListNode head = mergeTwoLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;        

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            } else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            temp.next = l2;
        }
        if (l2 == null) {
            temp.next = l1;
        }
        return dummyHead.next;
    }      
}
// Time Complexity: O(nlogk)
// Space Complexity: O(1);
