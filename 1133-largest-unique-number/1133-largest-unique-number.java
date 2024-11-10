class Solution {
    public int largestUniqueNumber(int[] nums) {
        final int MAX = 1001;
        int[] frequency = new int[MAX];

        for (int num : nums) {
            frequency[num]++;
        }

        for (int i = MAX - 1; i >= 0; i--) {
            if (frequency[i] == 1) return i;
        }

        return -1;
    }
}