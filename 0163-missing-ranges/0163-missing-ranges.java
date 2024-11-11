class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        if (nums.length == 0) {
            return new ArrayList<>(List.of(List.of(lower, upper)));
        }

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        if (nums.length > 0 && nums[0] > lower) {
            ans.add(List.of(lower, nums[0] - 1));
        }
    
        for (int i = 0; i < nums.length - 1; i++) {
            int cur = nums[i] + 1;
            int next = nums[i+1] - 1;

            if (cur <= next) {
                // cur >= lower && next <= upper
                if (next < lower) continue;
                else if (cur > upper) continue;
                else ans.add(List.of(cur, next));
            }
        }

        if (nums.length > 0 && nums[nums.length - 1] < upper) {
            ans.add(List.of(nums[nums.length - 1] + 1, upper));
        }

        return ans;
    }
}

/**
- 숫자 x가 lower ~ upper 사이에 있지만 nums에 없으면 missing
- 모든 missing numbers를 커버하는 가장 짧은 sorted list 반환

1. nums 오름차순 정렬
2. nums의 각각의 숫자마자 간격을 확인해서 List에 저장
 */