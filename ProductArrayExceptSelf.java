package practise;
/*

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation


Input: nums = [1,2,3,4]
Output: [24,12,8,6]


Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

 */
public class ProductArrayExceptSelf {
    public static void main(String[] args) {
            int[] arr = {1,2,3,4};
            print(arr);
            int[] res = productExceptSelf(arr);
            print(res);
    }
    static int[] productExceptSelf(int[] arr) {
        int len = arr.length;
        int res[] = new int[len];

        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i-1] * arr[i-1];
        }

        int lastProduct = 1;

        for (int i = len-2; i >= 0; i--) {
            lastProduct = lastProduct * arr[i+1];
            res[i] *= lastProduct;
        }
        return res;
    }

    static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }



}
