class Solution {
    private int[][] directions = {{1,2}, {2,1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
    private final int BOUNDARY = 305;
    private boolean[][] visited = new boolean[BOUNDARY][BOUNDARY];

    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>(); 
        int result = 0;

        q.add(new int[]{0,0});
        
        while(!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                if (cur[0] == x && cur[1] == y) {
                    return result;
                }

                for (int[] direction : directions) {
                    int newX = cur[0] + direction[0];
                    int newY = cur[1] + direction[1];

                    if (newX >= -2 && newX <= BOUNDARY && newY >= -2 && newY <= BOUNDARY && !visited[newX + 2][newY + 2]) {
                        visited[newX + 2][newY + 2] = true;
                        q.add(new int[]{newX, newY});
                    } 
                }
            }

            result++;
        }

        return -1;
    }
}

/**
[0, 0]에서 [x, y]에 도달하는 최단 회수를 구하기
- BFS로 풀이
 */