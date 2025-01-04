class Solution {
    public int maximalSquare(char[][] matrix) {
        final char SQUARE = '1';
        int h = matrix.length;
        int w = matrix[0].length;
        int[][] dp = new int[h+1][w+1];
        int maxEdge = 0;
        
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if (matrix[i-1][j-1] == SQUARE) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    maxEdge = Math.max(maxEdge, dp[i][j]);
                }
            }
        }

        return maxEdge * maxEdge;
    }
}
/**
- dp 배열에 [0][0]부터 해당 인덱스까지 1인 구역 중 최대 모서리의 길이를 저장

점화식 : dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
 */