package codingninjas.languagetools;

/*
Let say we have an array with size N. We have to rotate it by d

I/P
arr = {2, 6, 3, 1, 5, 9, 8}
d = 2

O/P
arr = {3, 1, 5, 9, 8, 2, 6}
*/
public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {2, 6, 3, 1, 5, 9, 8};
        print(arr);
        int d = 2;

        int[] res = rotate(arr, d);
        print(res);
    }

    private static int[] rotate(int[] arr, int d) {
        int rN = arr.length - 1;
        int halfRN = rN/2;
        for (int i = 0; i < halfRN; i++) {
            int temp = arr[i];
            arr[i] = arr[rN];
            arr[rN] = temp;
            rN--;
        }
        rN = arr.length - 1;
        int i = 0;
        int j = rN - d;

        int p = j+1;
        int r = rN;

        while (i<=j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        while (p<=r){
            int temp = arr[p];
            arr[p] = arr[r];
            arr[r] = temp;
            p++;
            r--;
        }


        return arr;
    }

    static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
