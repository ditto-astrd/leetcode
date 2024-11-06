class Solution {
    public int largestUniqueNumber(int[] nums) {
        final int LEN = 2001;
        int[] frequency = new int[LEN];

        for (int num : nums) {
            frequency[num]++;
        }

        for (int i = LEN - 1; i >= 0; i--) {
            if (frequency[i] == 1) return i;
        }

        return -1;
    }
}