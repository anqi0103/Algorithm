// Resolution artile: https://www.geeksforgeeks.org/reverse-a-linked-list/
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */

// Iterative method:
// Time Complexity: O(n); Space Complexity: O(1);
var reverseList = function(head) {
    // Initialize three pointers
    let prev = null;
    let curr = head;
    let next = null;
    // Iterate through the linked list
    while (curr != null) {
        // Before changing the next of curr, store it first
        let next = curr.next;
        // Reverse happened here
        curr.next = prev;
        // Move prev and curr pointer one step forward
        prev = curr;
        curr = next;
    }
    return prev;
};

// Recursive method:
// Time Complexity: O(n); Space Complexity: O(n);
var reverseList = function(head) {
    if (head == null || head.next == null) {
        return head;
    }
    
    let p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    
    return p;
};
