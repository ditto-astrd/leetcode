class Solution {
    public int[][] candyCrush(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int score = 1;

        while(score > 0) {
            boolean[][] check = new boolean[n][m];
            for(boolean[] temp : check) Arrays.fill(temp, false);
            score = 0;
            
            // 오른쪽
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(board[i][j] != 0 && j+2 < m) {
                        if(board[i][j] == board[i][j+1] && board[i][j] == board[i][j+2]) {
                            int temp = board[i][j];
                            check[i][j] = true;
                            for(int k = j+1; k < m; k++) {
                                if(board[i][k] == temp) check[i][k] = true;
                                else break;
                            }
                        }
                    }
                }
            }

            // 아래쪽
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(board[i][j] != 0 && i+2 < n) {
                        if(board[i][j] == board[i+1][j] && board[i][j] == board[i+2][j]) {
                            int temp = board[i][j];
                            check[i][j] = true;
                            for(int k = i+1; k < n; k++) {
                                if(board[k][j] == temp) check[k][j] = true;
                                else break;
                            }
                        }
                    }
                }
            }

            // 빈공간으로 만들어주기
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(check[i][j]) board[i][j] = 0;
                }
            }

            // 움직이기
            for(int i = n-1; i >= 0; i--) {
                for(int j = 0; j < m; j++) {
                    if(board[i][j] == 0) {
                        for(int k = i-1; k >= 0; k--) {
                            if(board[k][j] != 0) {
                                board[i][j] = board[k][j];
                                board[k][j] = 0;
                                score++;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return board;
    }
}

// 3개 이상 되어야 제거 가능
/*
1. 제거가능한게 있다면
2. 해당 column 맨 위에서 해당 위치까지 자리 바꿔주기
3. 
*/