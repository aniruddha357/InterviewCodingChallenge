package codingninjas.advrecursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReturnKeypadApproach {

    private static Map<Integer,String>  keyNumAlphaMap = new HashMap<>();
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
        keyNumAlphaMap.put(0,"+");
    }

    public static void main(String[] args) {
        int num = 234;
        List<String> combination = new ArrayList<>();
        combination( num, combination);
        System.out.println(combination);
    }

    private static void combination(int num, List<String> combination) {
        int n = num % 10;

        String s = keyNumAlphaMap.get(n);
        List<String> newCombination = new ArrayList<>();

        for (char ch:s.toCharArray()) {
            if(combination.isEmpty()){
                newCombination.add(ch+"");
                continue;
            }
            for (String str:combination) {
                newCombination.add(ch+""+str);
            }
        }
        combination.addAll(newCombination);
        if(num <10){
            return;
        }
        num /= 10;
        combination(num,combination);
    }
}
