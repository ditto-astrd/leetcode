class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, ans = 0;

        while (right < s.length()) {
            char rightC = s.charAt(right);
            map.put(rightC, map.getOrDefault(rightC, 0) + 1);

            if (map.size() > k) {
                while (map.size() > k) {
                    char leftC = s.charAt(left);
                    map.put(leftC, map.getOrDefault(leftC, 0) - 1);

                    if (map.get(leftC) == 0)
                        map.remove(leftC);
                    
                    left++;
                }
            }

            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;
    }
}

/**
최대 k개의 distnct 문자를 가진 substring의 최대 길이를 반환

1. 투 포인터를 left, right 모두 0부터 시작
  - right을 한 칸씩 움직이면서 while문 진행
2. Map에 현재 right 인덱스의 문자와 빈도수를 저장
  - 저장할때마다 현재 substring의 최대 길이를 max 값으로 갱신
3. 만약 현재 map의 사이즈가 k를 초과할 경우
  - 현재 map의 사이즈가 k 이하가 될때까지 left의 포지션을 +1 && left 인덱스의 문자열 빈도수를 -1
4. 정답 반환
 */