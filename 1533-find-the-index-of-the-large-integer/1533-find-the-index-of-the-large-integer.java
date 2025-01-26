/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int left = 0, right = reader.length() - 1, mid = 0, sumResult = 0;
        
        while (left <= right) {
            mid = (left + right) / 2;
            sumResult = ((right - left) % 2) == 1 ? reader.compareSub(left, mid, mid + 1, right) : reader.compareSub(left, mid, mid, right);

            if (sumResult == 1) {
                right = mid;
            } else if (sumResult == 0) {
                return mid;
            } else {
                left = mid + 1;
            }
        }

        return 0;
    }
}

/**
- arr의 딱 한 개의 인덱스만 제외한 나머지 인덱스는 모두 같은 값
- 해당 인덱스를 찾아서 반환

0. left = 0, right = arr.length로 셋팅
1. 이진 탐색으로 Large Integer 찾아보기
 */