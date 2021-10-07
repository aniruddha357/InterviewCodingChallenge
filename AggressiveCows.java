package codingninjas.searching;

import java.util.Set;
import java.util.TreeSet;

/*
Aggressive Cows Problem
Send Feedback
Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).
His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other,
FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
Input
t – the number of test cases, then t test cases follows.
* Line 1: Two space-separated integers: N and C
* Lines 2..N+1: Line i+1 contains an integer stall location, xi
Output
For each test case output one integer: the largest minimum distance.
Sample Input :
1
5 3
1
2
8
4
9
Sample Output:
3
Output details:
FJ can put his 3 cows in the stalls at positions 1, 4 and 8,
resulting in a minimum distance of 3.
 */
public class AggressiveCows {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 8, 9};
        int numCow = 3;
        int res = process(arr, numCow);
        System.out.println(res);
    }

    private static int process(int arr[], int numCows) {
        int left = 0;
        int right = arr[arr.length-1]-1;
        int mid = -1;
        while (left <= right){
            mid = (left+right)/2;
            if(checkWhetherCowsFitIn(arr, numCows, mid)){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return mid;
    }

    private static boolean checkWhetherCowsFitIn(int arr[], int numCows, int k){
        numCows--;
        int lastBarn = 0;
        for (int i = 1; i < arr.length; i++) {
            int m = arr[i] - arr[lastBarn];
            if(m >= k){
                numCows--;
                lastBarn = i;
            }
        }
        return numCows<1;
    }
}
