class Solution {
    public boolean canPermutePalindrome(String s) {
        int len = s.length();

        if (len == 1) return true;
        if (len == 2) return s.charAt(0) == s.charAt(1);

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        if (map.size() == 1) return true;

        List<Character> keys = new ArrayList<>(map.keySet());
        boolean ans = true;

        // 짝수인 경우를 위한 판별
        for (Character key : keys) {
            if (len % 2 == 1) {
                if (map.get(key) % 2 == 1) {
                    if (!ans) return false;
                    else ans = false;
                }
            } else {
                if (map.get(key) % 2 == 1) return false;
            }
        }

        return true;
    } 
}

/**
s의 index를 조작해서 회문이 될 수 있는지 판단

- 길이가 홀수일 경우 : 알파벳의 개수가 1개인것이 1개만 존재해야 함
- 길이가 짝수일 경우 : 알파벳의 개수가 무조건 짝수여야 함 


 */