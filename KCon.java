package practise;

import java.util.Scanner;

/*
You are given an array A with size N (indexed from 0) and an integer K. Let's define another array B with size N · K as the array that's formed by concatenating K copies of array A.

For example, if A = {1, 2} and K = 3, then B = {1, 2, 1, 2, 1, 2}.

You have to find the maximum subarray sum of the array B. Fomally, you should compute the maximum value of Bi + Bi+1 + Bi+2 + ... + Bj


Input
   1) The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
   2) The first line of each test case contains two space-separated integers N and K.
   3) The second line contains N space-separated integers A0, A1, ..., AN-1.

Output
For each test case, print a single line containing the maximum subarray sum of B.

Constraints
1 ≤ T ≤ 10
1 ≤ N ≤ 105
1 ≤ K ≤ 105
-106 ≤ Ai ≤ 106 for each valid i

Sample Input 1
2
2 3
1 2
3 2
1 -2 1

Sample Output 1
9
2

{1, 2, 1, 2, 1, 2} and the subarray with maximum sum is the whole {1, 2, 1, 2, 1, 2}. Hence, the answer is 9.

{1, -2, 1, 1, -2, 1} and the subarray with maximum sum is {1, 1}. Hence, the answer is 2.

*/
public class KCon {
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int arr[] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            System.out.println(kcon(arr,n,k));

        }

    }

    static long kcon(int arr[], int n, int k){
        long kadane = kadane(arr,n);

        if(k == 1) {
            return kadane;
        }

        long currentPrefixSum = 0, currentSuffixSum = 0;
        long maxPrefixSum = Long.MIN_VALUE, maxSuffixSum = Long.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            currentPrefixSum += arr[i];
            maxPrefixSum = Math.max(currentPrefixSum,maxPrefixSum);
        }

        long totalSum = currentPrefixSum;
        for (int i = n-1; i >=0; i--) {
            currentSuffixSum += arr[i];
            maxSuffixSum = Math.max(currentSuffixSum, maxSuffixSum);
        }

        if(totalSum < 0){
            return Math.max(maxPrefixSum+maxSuffixSum, kadane);
        }
        return Math.max( maxPrefixSum+maxSuffixSum+(totalSum*(k-2)), kadane);
    }

    static long kadane(int arr[], int n){
        long currSum = 0;
        long globalSum = Long.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            globalSum = Math.max(currSum, globalSum);
            currSum = Math.max(0, currSum);
        }
        return globalSum;
    }
}
