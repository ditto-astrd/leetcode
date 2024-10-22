class Solution {
    public boolean confusingNumber(int n) {
        int originNumber = n;
        int result = 0;
        int[] mirror = new int[10];
        setMirror(mirror);

        while(n > 0) {
            int number = n % 10;
            n/=10;

            if (mirror[number] == -1) return false;
            result = result * 10 + mirror[number];
        }

        return originNumber != result ? true : false;
    }

    private void setMirror(int[] mirror) {
        Arrays.fill(mirror, -1);

        mirror[0] = 0;
        mirror[1] = 1;
        mirror[6] = 9;
        mirror[8] = 8;
        mirror[9] = 6;
    }
}

/**
1. 1~9까지 숫자들을 180도 돌렸을때의 값을 int[]에 정의
2. 1의 자리 숫자부터 한번씩 확인해서 1번에 해당되지 못하는 경우가 1개라도 존재하면 false
3. 180도 돌린 값과 원본 값을 비교해서 정답 반환
 */