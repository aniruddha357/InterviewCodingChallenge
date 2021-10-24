package codingninjas.advrecursion;
/*
Remove Consecutive Duplicate Numbers
 */
public class RemoveConsecutiveDuplicates {
    public static void main(String[] args) {
        String str = "aabbcccdda";
        char[] chars = str.toCharArray();
        int i = 0;
        int j = 1;
        int len = process(chars,i,j);
        for (int k = 0; k <= len; k++) {
            System.out.print(chars[k]);
        }
    }
    static int process(char[] chars, int i, int j){
        try {
            char currentCh = chars[i];
            char nextCh = chars[j];
            if(currentCh != nextCh) {
                i+=1;
                chars[i] = nextCh;
            }
            j++;
            return process(chars,i,j);
        }catch (Exception e){

        }
        return i;
    }
}
