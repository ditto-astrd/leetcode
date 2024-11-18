class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int len = books.length;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 0번째 책은 존재하지 않으니 높이가 0

        for (int i = 1; i <= len; i++) {
            int maxWidth = 0;
            int maxHeight = 0;
            for (int j = i; j > 0; j--) {
                maxWidth += books[j-1][0];
                if (maxWidth > shelfWidth) break;
                maxHeight = Math.max(maxHeight, books[j-1][1]);
                dp[i] = Math.min(dp[i], dp[j-1] + maxHeight);
            }
        } 

        return dp[len];
    }
}

/**
- 목표 : 제한된 width에서 모든 책을 수납할 수 있는 최소한의 height을 구하라
- book[i][0] = 두께, book[i][1] = 높이
- 책은 순서대로 배치되어야 함
- dp 활용 (점화식 : dp[i] = min(dp[i], dp[i-1] + currentHeight))
- dp[i]: 첫 번째 책부터 i번째 책까지 배치했을 때의 최소 선반 높이
 */