package practise;

/*

Given an array that contains both positive and negative integers,
find the product of the maximum product subarray.
Expected Time complexity is O(n) and only O(1) extra space can be used.


Input: arr[] = {6, -3, -10, 0, 2}
Output:   180  // The subarray is {6, -3, -10}

Input: arr[] = {-1, -3, -10, 0, 60}
Output:   60  // The subarray is {60}

Input: arr[] = {-2, -40, 0, -2, -3}
Output:   80  // The subarray is {-2, -40}

 */
public class MaximumProductArray {

    public static void main(String[] args) {
        int arr[] = {6, -3, -10, 0, 2};
        if(180 == maxProduct(arr)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
    }

    static int maxProduct(int arr[]){
        if(arr.length == 1){
            return arr[0];
        }
        int currProduct = arr[0];
        int globalProduct = currProduct;

        for (int i = 1; i < arr.length; i++) {
            currProduct *= arr[i];
            globalProduct = Math.max(currProduct, globalProduct);
        }
        System.out.println(globalProduct);
        return globalProduct;
    }
}
