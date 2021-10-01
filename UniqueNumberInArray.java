package codingninjas.languagetools;

/*
There are 2N duplicate number in array except one unique number find the unique number.
arr: { 6, 1, 6, 4, 3, 1, 3}

output: 4
*/


public class UniqueNumberInArray {
    public static void main(String[] args) {
        int arr[] = { 6, 1, 6, 4, 3, 1, 3};
        int res = uniqueNum(arr);
        System.out.println(res);
    }

    private static int uniqueNum(int[] arr) {
        int unique = arr[0];
        for (int i = 1; i < arr.length; i++) {
            unique ^= arr[i];
        }

        return unique;
    }

}
