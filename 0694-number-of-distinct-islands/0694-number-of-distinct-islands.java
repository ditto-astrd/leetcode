class Solution {
    private int height = 0;
    private int width = 0;
    
    public int numDistinctIslands(int[][] grid) {
        boolean[][] visited;
        StringBuffer sb;
        Set<String> islands = new HashSet<>();

        height = grid.length;
        width = grid[0].length;

        visited = new boolean[height][width];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    sb = new StringBuffer();
                    dfs(i, j, grid, visited, islands, sb, '0');
                    islands.add(sb.toString());
                }
            }
        }

        return islands.size();
    }

    private void dfs(int y, int x, int[][] grid, boolean[][] visited, Set<String> islands, StringBuffer sb, char cur) {
        if (y >= height || y < 0 || x >= width || x < 0) return;
        if (visited[y][x]) return;
        if (grid[y][x] == 0) return;

        visited[y][x] = true;
        sb.append(cur);

        dfs(y+1, x, grid, visited, islands, sb, 'D');
        dfs(y-1, x, grid, visited, islands, sb, 'U');
        dfs(y, x+1, grid, visited, islands, sb, 'R');
        dfs(y, x-1, grid, visited, islands, sb, 'L');

        sb.append('B');
    }
}

/**
섬의 모양이 동일하면 같은 섬으로 취급됨 (회전, 반전은 허용 X)
관건은 섬의 모양을 어떻게 저장하느냐이며, 이는 문자열 (U D L R)로 판별하기
또한 회전이나 반전된 모양은 같은 섬이 아니므로, 이에 대한 별도의 백트래킹 마킹이 필요됨

1. DFS로 섬의 position을 SET에 저장
2. SET의 개수를 반환
 */