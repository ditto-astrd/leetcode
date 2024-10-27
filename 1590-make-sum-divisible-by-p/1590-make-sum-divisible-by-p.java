class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        
        for (int num : nums) {
            sum += num;
        }

        if (sum < p) return - 1;
        if (sum % p == 0) return 0;

        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);

        int ans = nums.length;
        long remain = sum % p;
        sum = 0L;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= p;

            long remainTemp = sum - remain;
            if (remainTemp < 0) {
                remainTemp += p;
            }

            if (map.containsKey(remainTemp)) {
                Integer subArrayStartIndex = map.get(remainTemp);
                ans = Math.min(ans, i - subArrayStartIndex);
            }
            
            map.put(sum, i);
        }

        return ans == nums.length ? -1 : ans;
    }
}

/**
- 배열의 각 인덱스는 모두 양수
- subarray를 지우고 남은 원소들을 p로 나눌수 있는 가장 작은 subarray의 길이를 구하기
  - subarray를 제거하지 않고 p로 나눌수 있으면 0 반환
  - 정답이 불가능하면 -1 반환
- 전체를 배열을 지워서는 안됨
 */

 /**
 1. 전체 합을 구하고 early return이 되는지 파악하기
 2. sum - nums[i] 이 p로 나눠질 수 있는지
    - 나눠진다면 바로 1 반환
    - 못 나눠진다면 map에 remain sum - p가 있는지 확인
  */