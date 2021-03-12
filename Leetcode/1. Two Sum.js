/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

// Array && HashTable
// Map object holds key-value pair
// Map.has();
// Map.get();
// Map.set();

var twoSum = (nums, target) => {
    const dict = new Map();
    for (let i = 0; i < nums.length; i++) {
        let complement = target- nums[i];
        if (dict.has(complement)) {
            return [dict.get(complement), i];
        }
        dict.set(nums[i], i);
    }
};

// Traverse over the array containing n element only once, Time Complexity is O(n);
// Space Complexity is O(n);
