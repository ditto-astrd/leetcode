class Solution {
    public int[] sameEndSubstringCount(String s, int[][] queries) {
        int LOWER_ALPHABET_LEN = 26;
        int n = s.length();
        int[][] preSum = new int[n][LOWER_ALPHABET_LEN];
        int[] ans = new int[queries.length];

        // 1. 0번째 문자열의 preSum 1로 셋팅
        preSum[0][s.charAt(0) - 'a']++;
        for (int i = 1; i < n; i++) {
            // 1번째 길이 부터는 바로 직전의 preSum 복붙
            preSum[i] = Arrays.copyOf(preSum[i-1], LOWER_ALPHABET_LEN);
            // 최종적으로 0번째부터 i번째 인덱스까지의 preSum이 만들어짐
            preSum[i][s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0], end = queries[i][1];
            int sum = 0;
            for (int j = 0; j < LOWER_ALPHABET_LEN; j++) {
                int cnt = preSum[end][j] - (start > 0 ? preSum[start - 1][j] : 0);
                sum += (cnt * (cnt + 1)) / 2;
            }
            ans[i] = sum;
        }

        return ans;
    }
}
/**
목표 : 각 quries의 인덱스 별로 처음과 끝이 같은 substring(부분 문자열)의 개수를 구하기
주의 : aa -> a, a, aa 총 3개 -> (n * (n+1)) / 2
누적합 활용
 */