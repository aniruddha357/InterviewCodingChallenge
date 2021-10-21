package codingninjas.advrecursion;

/*
Find string length using recursion
 */
public class StringLength {
    public static void main(String[] args) {
        String str = "abcdefg";
        int len = length(str,0);
        System.out.println(len);
    }
    private static int length(String str, int i) {

        try {
            str.charAt(i);
            int small = length(str,i+1);
            return small + 1;
        }catch (Exception e){
            return 0;
        }

    }
}
