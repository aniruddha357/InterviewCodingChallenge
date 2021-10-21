package codingninjas.advrecursion;

/*
Remove zero from array

 */
public class RemoveXFromString {
    public static void main(String[] args) {
        String str = "xxxxabcxd";
        System.out.println(str);
        char charArr[] = str.toCharArray();
        remove(charArr, 0, 1);
        for (int i = 0; i < charArr.length; i++) {
            if(charArr[i]=='x'){
                break;
            }
            System.out.print(charArr[i]);
        }
    }

    private static void remove(char[] arr, int i, int j) {

        if(i == j){
            return;
        }
        if(j >= arr.length){
            return;
        }

        if (arr[i] == 'x' && arr[j] != 'x') {
            arr[i] = arr[j];
            arr[j] = 'x';
            i++;
        }

        if(j < arr.length){
            j++;
        }
        remove(arr,i,j);
    }


}
