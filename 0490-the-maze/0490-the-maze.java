class Solution {

    boolean[][] visited = new boolean[100][100];
    int[] my = {0,1,0,-1}, mx = {1,0,-1,0};
    int ny, nx, lenY, lenX, targetY, targetX;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        lenY = maze.length; lenX = maze[0].length; targetY = destination[0]; targetX = destination[1];

        return goMaze(maze, start[0], start[1]);
    }

    public boolean goMaze(int[][] maze, int y, int x) {
        if (visited[y][x])
            return false;
        if (y == targetY && x == targetX)
            return true;
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            ny = y;
            nx = x;
            while (ny + my[i] >= 0 && ny + my[i] < lenY && nx + mx[i] >= 0 && nx + mx[i] < lenX && maze[ny+my[i]][nx+mx[i]] == 0) {
                ny += my[i];
                nx += mx[i];
            }
            if (goMaze(maze, ny, nx)) return true;
        }
        return false;
    }

}