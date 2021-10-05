package codingninjas.languagetools;

import java.util.stream.IntStream;

/*
Distribute Candies
Send Feedback
Shaky has N (1<=N<=50000) candy boxes each of them contains a non-zero number of candies (between 1 and 1000000000). Shaky want to distibute these candies among his K (1<=K<=1000000000) IIIT-Delhi students. He want to distibute them in a way such that:
1. All students get equal number of candies.
2. All the candies which a student get must be from a single box only.
As he want to make all of them happy so he want to give as many candies as possible. Help Shaky in finding out what is the maximum number of candies which a student can get.
Input
First line contains 1<=T<=20 the number of test cases. Then T test cases follow. First line of each test case contains N and K. Next line contains N integers, ith of which is the number of candies in ith box.
Output
For each test case print the required answer in a seperate line.
Sample Input:
5
3 2 3 9
Sample Output:
3

 */
public class DistributionOfCandies {
    public static void main(String[] args) {
        int arr[] = { 3, 2, 3, 9 };
        int k = 5;
        int res = process(arr, k);
        System.out.println(res);
    }

    static int process(int arr[], int k){
        int maxElem = IntStream.of(arr).max().getAsInt();
        int left = 0;
        int right = maxElem;
        int mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            if(checkTheFit(arr, mid, k)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return mid;
    }

    static boolean checkTheFit(int arr[], int num, int k){
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i]/num;
            if(j == 0){
                continue;
            }
            k = k-j;
            if(k<=0){
                return true;
            }
        }
        return false;
    }
}
