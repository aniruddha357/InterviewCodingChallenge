package practise;

public class CostOfTravelInArray {
    //Consider an array, let say { 0, 1, 0, 1} find the cost to travel every one to each index.
    //So the output will be { 4, 2, 2, 2}

    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 1};
        print(arr);
        int res[] =costOfArray(arr);
        print(res);
    }

    static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int[] costOfArray(int[] arr){
        int len = arr.length;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = 0;
        int frequencyOne = arr[0];

        for (int i = 1; i < len; i++) {
            left[i] = left[i-1] + frequencyOne;
            if(arr[i] == 1){
                frequencyOne++;
            }
        }

        right[len-1] = 0;
        frequencyOne = arr[len-1];

        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i+1] + frequencyOne;
            if(arr[i] == 1){
                frequencyOne++;
            }
        }


        print(left);
        print(right);

        int res[] = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left[i] + right[i];
        }
        return  res;
    }





}
