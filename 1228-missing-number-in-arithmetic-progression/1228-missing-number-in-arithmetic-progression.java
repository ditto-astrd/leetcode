class Solution {
    public int missingNumber(int[] arr) {
        int arrSize = arr.length;
        int gap = (arr[arrSize - 1] - arr[0]) / arrSize;

        for (int i = 1; i < arrSize; i++) {
            if (arr[i] - arr[i-1] != gap) {
                return arr[i-1] + gap;
            }
        }
        
        // ex : 1 1 1 
        return arr[0];
    }
}
