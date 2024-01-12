package com.fzyue;

import java.util.Arrays;

public class Solution4 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,3};
        int[] res = twoSum(nums, 6);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] indexArr = new int[2];
        int sum = 0;
        for (int i = 0; i< nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                if (sum == target) {
                    indexArr[0] = i;
                    indexArr[1] = j;
                    return indexArr;
                }
            }
        }
        return indexArr;
    }
}
