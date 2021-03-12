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
