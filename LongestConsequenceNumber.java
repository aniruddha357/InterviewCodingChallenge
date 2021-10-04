package codingninjas.languagetools;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestConsequenceNumber {
    public static void main(String[] args) {
        int arr[] = { 9, 1, 8, 6, 3, 4, 2, 7, 10, 15 };
        print(arr);

        int[] longestSubsequence  = find(arr);
        print(longestSubsequence);
    }

    static int[] find(int[] arr) {
        Map<Integer, Boolean> numberMapList = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            numberMapList.put(arr[i], Boolean.FALSE);
        }

        int start = -1;
        int end = -1;
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if(numberMapList.get(num)){
                continue;
            }
            int innerLen = 1;

            int innerStart = num;
            while(numberMapList.containsKey(innerStart-1)){
                innerStart = innerStart -1;
                numberMapList.put(innerStart, Boolean.TRUE);
                innerLen++;
            }
            int innerEnd = num;
            while (numberMapList.containsKey(innerEnd+1)){
                innerEnd = innerEnd + 1;
                numberMapList.put(innerEnd, Boolean.TRUE);
                innerLen++;
            }

            if(innerLen > len){
                start = innerStart;
                end = innerEnd;
                len = innerLen;
            }
        }

        int res[] = new int[len];
        int k = 0;
        for (int i = start; i <= end ; i++) {
            res[k] = i;
            k++;
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
