package codingninjas.advrecursion;

import java.util.ArrayList;
import java.util.List;

public class PossibleSubsequenceOfString {
    public static void main(String[] args) {
        String str = "abc";
        List<String> output = new ArrayList<>();
        subs(str, output);
        output.add("");
        output.forEach(System.out::println);
    }

    private static void subs(String str, List<String> output) {
        if(str.length() == 2){
            output.add("");
            output.add(str.charAt(0)+"");
            output.add(str.charAt(1)+"");
            output.add(""+str.charAt(0)+str.charAt(1));
            return;
        }

        char ch =str.charAt(0);
        String newStr = str.substring(1);
        subs(newStr,output);
        List<String> outputList = new ArrayList<>();
        for (String m:output) {
            outputList.add(ch+m);
        }
        output.addAll(outputList);
    }


}
