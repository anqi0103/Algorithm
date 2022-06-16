// Using HashSet to solve the issue

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<> (nums.length);
        for (int x : nums) {
            if (set.contains(x) {
                return true;
            }
            set.add(x);
        }
        return false;
    }
}

// Time Complexity: O(n);
// Space Complexity: O(1);
