class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int jump = 0;
        int cur = 0, far = 0;

        for (int i = 0; i < len - 1; i++) {
            far = Math.max(far, i + nums[i]);

            if (cur == i) {
                jump++;
                cur = far;
            }
        }

        return jump;
    }
}
/**
    public int jump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (j >= len) break;
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }

        return dp[len - 1];
    }
 */