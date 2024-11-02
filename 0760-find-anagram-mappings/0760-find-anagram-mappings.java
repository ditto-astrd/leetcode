class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }

        return nums1;
    }
}

/**
- nums2는 nums1의 애너그램
- 중복된 값도 존재할 수 있음

1. nums1의 각각의 값이 존재하는 nums2의 인덱스를 반환
2. 중복된 값으로 정답이 여러개가 될 수 있으면 어떤걸 반환해도 상관 없음
 */