class Solution {
    public int findLonelyPixel(char[][] picture) {
        int ans = 0;
        int[] row = new int[picture.length];
        int[] col = new int[picture[0].length];

        for(int i = 0; i < picture.length; i++) {
            for(int j = 0; j < picture[i].length; j++) {
                if(picture[i][j] == 'W') {
                    row[i] += 1;
                    col[j] += 1;
                }
            }
        }

        for(int i = 0; i < picture.length; i++) {
            for(int j = 0; j < picture[i].length; j++) {
                if(picture[i][j] == 'B' && row[i] == picture[0].length-1 && col[j] == picture.length-1) ans++; 
            }
        }
        
        return ans;
    }
}