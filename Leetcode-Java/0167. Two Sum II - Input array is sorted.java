// Using two indexes, initially pointing to the first and last element respectively. Compare the sum of these 
// two elements with target. If the sum is not equal to target, either increase or decrease the index by one
// Return the index + 1.

class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int lo = 0, hi = numbers.length - 1;
    while (lo < hi) {
      int resSum = numbers[lo] + numbers[hi];
      if (resSum == target) {
        return new int[] {
          lo + 1, hi + 1
        };
      } else if (resSum > target) {
        hi--;
      } else {
        lo++;
      }
    }
    throw new IllegalArgumentException("No Solution");
  }
}

Time Complexity: O(n); Each of the n elements is visited at most once.
Space Complexity: O(1); We only use two indexes, initially pointing to the first and last element respectively.
