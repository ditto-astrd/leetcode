class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, ans = 0;

        while(right < s.length()) {
            if (right - left + 1 > k) {
                while (right - left + 1 > k) {
                    char temp = s.charAt(left);
                    set.remove(temp);
                    left++;
                }
            }

            char c = s.charAt(right);
            
            while (set.contains(c)) {
                char temp = s.charAt(left);
                set.remove(temp);
                left++;
            }

            set.add(c);
            if (right - left + 1 == k) ans++;
            right++;
        }

        return ans;
    }
}

/**
길이가 k이면서 중복된 문자가 없는 문자열의 개수를 반환

- 투 포인터 + Map으로 접근
 */