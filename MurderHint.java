package codingninjas.languagetools;

/*
10810. Its a Murder!
Problem code: DCEPC206
Once detective Saikat was solving a murder case. While going to the crime scene he took the stairs and saw that a number is written on every stair.
He found it suspicious and decides to remember all the numbers that he has seen till now.
While remembering the numbers he found that he can find some pattern in those numbers.
So he decides that for each number on the stairs he will note down the sum of all the numbers previously seen on the stairs which are smaller than the present number.
Calculate the sum of all the numbers written on his notes diary.
Input
First line gives T, number of test cases.
2T lines follow.
First line gives you the number of stairs N
Next line gives you N numbers written on the stairs.
Output
For each test case output one line giving the final sum for each test case.
Constraints
T<=10
1<=N<=10^5
All numbers will be between 0 and 10^6.
Example
Input:
1
5
1 5 3 6 4
Output:
15
*/

import java.util.*;

public class MurderHint {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 3, 6, 4 };
        print(arr);
        int res = process(arr);
        System.out.println(res);
    }

    static int process(int[] arr){
        int sum = 0;
        NavigableSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            Set<Integer> innerSet = set.headSet(num);
            set.add(num);
            if(innerSet.isEmpty()){
                continue;
            }
            int innerSum = innerSet.stream().reduce(Integer::sum).get();
            sum += innerSum;
        }
        return sum;
    }

    static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
