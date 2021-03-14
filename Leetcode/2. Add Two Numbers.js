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
 
// LinkedList

var addTwoNumbers = function(l1, l2) {
  let dummy = new ListNode(0);
  let node = dummy;
  let carry = 0;
 
  while (l1 || l2 || carry) {
    if (l1) {
      carry = carry + l1.val;
      l1 = l1.next;
    }
   
    if (l2) {
      carry = carry + l2.val;
      l2 = l2.next;
    }
    node.next = new ListNode(carry % 10);
    carry = Math.floor(carry / 10);
    node = node.next;   
  }
  return dummy.next;
}

var addTwoNumbers = function(l1, l2) {
    let dummy = new ListNode(0);
    let p1 = l1;
    let p2 = l2;
    let current = dummy;
    let carry = 0;
    
    while (p1 != null && p2 != null) {
        let x = p1 != null ? p1.val : 0;
        let y = p2 != null ? p2.val : 0;
        let sum = x + y + carry;
        carry = Math.floor(sum / 10);
        current.next = new ListNode(sum % 10);
        current = current.next;
      
        if (p1 != null) {
            p1 = p1.next;
        }
        if (p2 != null) {
            p2 = p2.next;
        }
    }
    if (carry > 0) {
        current.next = new ListNode(carry);
    }
  
    return dummy.next;
};

var addTwoNumbers = function(l1, l2) {
    
    return addTwo(l1, l2, 0);
    
    function addTwo(l1, l2, carry) {
        if (!l1 && !l2 && carry === 0) {
            return null;
        }
        let x = l1 ? l1.val : 0;
        let y = l2 ? l2.val : 0;
        let nextL1 = l1 ? l1.next : null;
        let nextL2 = l2 ? l2.next : null;
        
        let sum = x + y + carry;
        carry = Math.floor(sum / 10);
        let digit = sum % 10;
        
        return {
            val : digit,
            next : addTwo(nextL1, nextL2, carry)
        }
    }
};
let l1 = new ListNode(2, new ListNode(4, new ListNode(6)));
let l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

let result = addTwoNumbers(l1, l2);
console.log(result);

// Time Complexity: O(max(m,n))
// Space Complexity: O(max(m,n))
