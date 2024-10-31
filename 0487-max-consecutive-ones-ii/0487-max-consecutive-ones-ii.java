class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0, ans = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                while (set.size() > 0) {
                    if (nums[left] == 0) {
                        set.remove(0);
                    }
                    left++;
                }
                set.add(0);
            }
            
            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;
    }
}

/**
최대 1개의 숫자만 1로 변경 가능
- 1로만 구성된 가장 긴 sub array의 길이 구하기
 */