class Solution {
    public int missingElement(int[] nums, int k) {
        int numsSize = nums.length;

        for (int i = 1; i < numsSize; i++) {
            int gap = nums[i] - nums[i-1];
            if (gap > k) {
                return nums[i] - (nums[i] - nums[i-1] - k);
            }
            if (gap != 1) {
                k -= gap;
                k++;
            }
        }

        return nums[numsSize - 1] + k;
    }
}
