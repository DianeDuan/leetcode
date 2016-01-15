package algorithm.medium;

/**
 * Problem:
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * Analysis:
 *
 * If there is no limit that you cannot use division, you can get a product of all the numbers in the array,
 * and then divide that product by num[i], you will get output[i].
 *
 * Without division, you you can use the product of two products as output[i]
 * (one of the product is the product of all the numbers whose index is lower than i,
 * the other product is the product of all the numbers whose index is higher than i),
 * and there are two solutions based on this thought.
 *
 * Solution1:
 * Use two arrays, leftProduct array and rightProduct array to store the products.
 * leftProduct[i] = nums[0] * nums[1] * ... * nums[i-1]
 * rightProduct[i] = nums[nums.length] * nums[nums.length - 1] * ... * nums[i+1]
 * Then by multiplying leftProduct[i] and rightProduct[i], we can get output[i].
 *
 * Solution2:
 * Solution1's space complexity is O(n), but if we can use output array for leftProduct,
 * and don't use rightProduct array to store products of numbers with higher indexes than each number in nums array,
 * we can reduce the space complexity to O(1).
 * We can use only one variable to store the products of numbers with higher indexes,
 * by doing this from the highest index in nums array.
 * And after multiply this variable and output[i] to get the final output[i],
 * you can continue to multiply the variable and nums[i] for the next final output[i-1].
 */
public class ProductOfArrayExceptSelf_238 {
    //time complexity: O(n), space complexity: O(n)
    public int[] productExceptSelf_solution1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
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
        if (nums == null || nums.length == 0) {
            return nums;
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
