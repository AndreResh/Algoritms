package alg.ace_inteviev_1;

import java.util.Stack;

public class FourteenthDay {
    public static void main(String[] args) {
//        System.out.println(new FourteenthDay().decodeString("100[leetcode]"));
        System.out.println("100".matches("\\d+"));
    }
    public String decodeString(String s) {
        StringBuilder result  = new StringBuilder();
       Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))){
                StringBuilder number = new StringBuilder();
                while (Character.isDigit(s.charAt(i))){

                    number.append(s.charAt(i));
                    i++;
                }

                stack.add(number.toString());
            } else if (Character.isAlphabetic(s.charAt(i))) {
                if(stack.isEmpty()){
                    result.append(s.charAt(i));
                } else {
                    stack.add(String.valueOf(s.charAt(i)));
                }
            } else if (s.charAt(i)==']') {
                StringBuilder current = new StringBuilder();
                int number;
                while (true){
                    String a = stack.pop();
                    if(a.matches("\\d+")){
                        number = Integer.parseInt(a);
                        break;
                    } else {
                        current.append(a);
                    }
                }
                current.reverse();
                StringBuilder newSb = new StringBuilder();
                for (int j = 0; j < number; j++) {
                    newSb.append(current);
                }
                if(stack.isEmpty()){
                    result.append(newSb.reverse());
                } else {
                    stack.add(newSb.toString());
                }
            }
//            System.out.println(stack);

        }
        return result.toString();
    }
}
