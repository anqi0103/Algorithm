// Binary Search method:

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length;
        while (lo < hi) {
            int pivot = lo + (hi - lo) / 2;
            if (letters[pivot] > target) {
                hi = pivot;
            } else {
                lo = pivot + 1;
            }
        }
        return letters[lo % letters.length];
    }
}

// Time Complexity: O(logN), where N is the length of letters. We peek only at logN elements in the array.

// Space Complexity: O(1), as we maintain only pointers.

// Linear Scan:
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char c: letters) {
            if (c > target) {
                return c;
            }
        }
        return letters[0];
    }
}

// Time Complexity: O(N), where N is the length of letters. We scan every element of the array.

// Space Complexity: O(1), as we maintain only pointers.
