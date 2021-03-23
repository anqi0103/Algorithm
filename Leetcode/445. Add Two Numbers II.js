/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */

// Reverse List Implementation
// Time Compliexity: O(m + n);
// Space Complexity: O(1);
var reverseList = function(head) {
    let prev = null;
    let curr = head;
    while (curr != null) {
        let next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
} 

var addTwoNumbers = function(l1, l2) {    
    l1 = reverseList(l1);
    l2 = reverseList(l2);
    
    let node = null;
    let carry = 0;
    while (l1 != null || l2 != null || carry) {
        let x1 = l1 != null ? l1.val : 0;
        let x2 = l2 != null ? l2.val : 0;
        let digit = (x1 + x2 + carry) % 10;
        carry = Math.floor((x1 + x2 + carry) / 10);
        
        let curr = new ListNode(digit);
        curr.next = node;
        node = curr;
        
        l1 = l1 != null ? l1.next : null;
        l2 = l2 != null ? l2.next : null;
    }
    
    if (carry != 0) {
        let curr = new ListNode(carry);
        curr.next = node;
        node = curr;
    }
    return node;
};

// Do not reverse List Implementation
// Time Compliexity: O(m + n);
// Space Complexity: O(1);
var addTwoNumbers = function(l1, l2) {
    let s1 = [];
    let s2 = [];
    // Use stack to reverse link list
    while (l1) {
        s1.push(l1.val);
        l1 = l1.next;
    }
    while (l2) {
        s2.push(l2.val);
        l2 = l2.next;
    }
    let list = new ListNode(0);
    let sum = 0;
    while (s1.length !== 0 || s2.length !== 0 || sum > 0) {
        sum = sum + (s1.length === 0 ? 0 : s1.pop());
        sum = sum + (s2.length === 0 ? 0 : s2.pop());
        // update list value
        list.val = sum % 10;
        // add new head node with carry, head.val could be 1 or 0;
        sum = Math.floor(sum / 10);
        let head = new ListNode(sum);
        // connect head to list;
        head.next = list;
        // update list;
        list = head;
    }
    if (list.next === 0) {
        return list.next;
    } else {
        return list;
    }
}
