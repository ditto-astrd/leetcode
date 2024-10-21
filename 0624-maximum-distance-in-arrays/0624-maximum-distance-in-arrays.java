class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        /* 
        1. 가장 큰값, 가장 작은값을 구하기
        2. 단, 큰값과 작은 값은 한 배열에서 한 개씩 밖에 못고름 (ex : 한 개의 배열에서 작은값, 큰값을 동시에 가져갈 수 없음)
        */
        int maximumNum = arrays.get(0).get(0);
        int minimumNum = arrays.get(0).get(arrays.get(0).size()-1);
        int ans = Integer.MIN_VALUE;
        for(List<Integer> list : arrays){
            ans = Math.max(ans, Math.abs(maximumNum-list.get(0)));
            ans = Math.max(ans, Math.abs(list.get(list.size()-1)-minimumNum));
            maximumNum = Math.max(maximumNum, list.get(list.size()-1));
            minimumNum = Math.min(minimumNum, list.get(0));
        }
        return ans;
    }
}