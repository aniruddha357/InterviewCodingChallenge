package codingninjas.advrecursion;

import java.util.HashMap;
import java.util.Map;

public class PrintKeypadApproach {
    private static Map<Integer,String> keyNumAlphaMap = new HashMap<>();
    static {
        keyNumAlphaMap.put(2,"abc");
        keyNumAlphaMap.put(3,"def");
        keyNumAlphaMap.put(4,"ghi");
        keyNumAlphaMap.put(5,"jkl");
        keyNumAlphaMap.put(6,"mno");
        keyNumAlphaMap.put(7,"pqrs");
        keyNumAlphaMap.put(8,"tuv");
        keyNumAlphaMap.put(9,"wxyz");
        keyNumAlphaMap.put(1,"&");
    }
    public static void main(String[] args) {
        Integer num = 23;
        printKeypadCombination( num,"");
    }

    private static void printKeypadCombination(Integer input,String output) {
        if(input == 0){
            System.out.println(output);
            return;
        }

        int res = input%10;
        String value = keyNumAlphaMap.get(res);
        int newInput = input/10;

        for (int i = 0; i < value.length(); i++) {
            printKeypadCombination(newInput, value.charAt(i)+output);
        }
    }
}
