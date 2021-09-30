package codingninjas.languagetools;

import java.util.stream.IntStream;

/*

Let say we have an array with size n and contains numbers which ranges between from 0 to n-2. Find out the duplicate number

n = 6
{ 2, 1, 0, 4, 3, 1}
 */
public class DuplicateInArray {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 0, 4, 3, 2};
        int duplicate = findDuplicate2(arr);
        System.out.println(duplicate);
    }

    public static int findDuplicate(int[] arr){
        int duplicateNumber = -1;
        for (int i = 0; i < arr.length; i++) {
            int k = Math.abs(arr[i]);
            if(arr[i] == arr.length){
                k = 0;
            }
            int num = arr[k];
            if(num < 0){
                return k;
            }else if(num == 0) {
                arr[k] = arr.length;
            }else if(num == arr.length) {
                return k;
            }else {
                arr[k] = arr[k] * -1;
            }
        }

        return duplicateNumber;
    }

    public static int findDuplicate2(int[] arr){
        int sum = IntStream.of(arr).sum();
        int idealSum = (arr.length - 2) * (arr.length - 1) / 2;
        return sum - idealSum;
    }
}
