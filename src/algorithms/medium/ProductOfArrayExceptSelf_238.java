package algorithms.medium;

/**
 * Problem:
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Analysis:
 * If there is no limit that you cannot use division, you can get a product of all the numbers in the array,
 * and then divide that product by num[i], you will get output[i].
 * Without division,
 */
public class ProductOfArrayExceptSelf_238 {
    //time complexity: O(n), space complexity: O(n)
    public int[] productExceptSelf_solution1(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            return new int[0];
        }

        int[] leftProduct = new int[nums.length];
        leftProduct[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }

        int[] rightProduct = new int[nums.length];
        rightProduct[nums.length - 1] = 1;
        for (int i = (nums.length-2); i > -1; i--) {
            rightProduct[i] = rightProduct[i+1] * nums[i+1];
        }

        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = leftProduct[i] * rightProduct[i];
        }
        return output;
    }

    //time complexity: O(n), space complexity: O(1)
    public int[] productExceptSelf_solution2(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            return new int[0];
        }

        int[] output = new int[nums.length];
        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i-1] * nums[i-1];
        }
        int tmpProduct = 1;
        for (int i = (nums.length - 1); i > -1; i--) {
            output[i] *= tmpProduct;
            tmpProduct *= nums[i];
        }
        return output;
    }
}
