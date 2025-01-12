class Solution {
    private final int INF = 2147483647;
    private boolean[][] visited = new boolean[250][250];
    private int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    private int w = 0;
    private int h = 0;

    public void wallsAndGates(int[][] rooms) {
        w = rooms.length;
        h = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        int distance = 0;

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()) {
            distance++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                for (int[] direction : directions) {
                    int x = cur[0] + direction[0];
                    int y = cur[1] + direction[1];

                    if (x >= 0 && x < w && y >= 0 && y < h && rooms[x][y] == INF) {
                        rooms[x][y] = distance;
                        q.add(new int[]{x,y});
                    }
                }
            }
        }
    }
}

/**
1. gate의 모든 위치를 저장
2. gate로 bfs 돌리기
 */