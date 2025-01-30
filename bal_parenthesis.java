import java.util.Stack;
import java.util.Scanner;
public class bal_parenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string exp to validate");
        String a = sc.next();

        Stack<Character> stk = new Stack<>();
        sc.close();
        for(int i=0;i<a.length();i++){
            char ch = a.charAt(i);
            if(ch == '(' || ch=='[' || ch=='{'){
                stk.push(ch);
            }
            else if(ch==')' || ch==']' || ch=='}' ){
                if(stk.isEmpty()){
                    System.out.println(false);
                    return;
                }
                char last = stk.pop();

                if(!((ch ==')' && last == '(' )||(ch ==']' && last == '[' )||(ch =='}' && last == '{' ))){

                    System.out.println(false);
                    return;
                }

            }

        }
        
        System.out.println(stk.isEmpty());
    }

}
            