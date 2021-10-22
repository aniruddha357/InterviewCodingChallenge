package codingninjas.advrecursion;
/*
replace a particular character of string
 */
public class ReplaceStringCharacter {
    public static void main(String[] args) {
        char c1 = 'b';
        char c2 = 'x';
        String str = "bababbc";
        char chs[] = str.toCharArray();
        System.out.println(str);
        replacement(chs,c1,c2,0);
        for (int i = 0; i < chs.length; i++) {
            System.out.print(chs[i]);
        }
    }

    private static void replacement(char[] chs, char c1, char c2, int i) {
        if(i == chs.length){
            return;
        }

        if(chs[i] == c1){
            chs[i] = c2;
        }
        replacement(chs,c1,c2,i+1);
    }
}
