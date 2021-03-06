// One-pass Hash Table approach

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                // return an int array using {}
                return new int[] {
                  map.get(complement), i
                };
            }
            map.put(nums[i], i);
        }
        // return int[0];
        // throw will cause the program crushed and log "No Two Sum Solution"
        throw new IllegalArgumentException("No Two Sum Solution");
    }
}

Time Complexity: O(n); // We traverse the list containing n elements only once. Each look up in the table costs only O(1) time.
Space Complexity: O(n); // The extra space required depends on the number of items stored in hash table, which stores at most n elements.
