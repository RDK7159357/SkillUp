import java.util.Scanner;
import java.util.Stack;
public class History_man_stk {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        Stack<String> backStack = new Stack<>();  
        Stack<String> forwardStack = new Stack<>();
        while (choice != 5) {
            System.out.println("\n1: Go Forward\n2: Search\n3: Go Back\n4: View Your Search List\n5: Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    if(!forwardStack.isEmpty()){
                        backStack.push(forwardStack.pop());
                        System.out.println("Went forward to: "+forwardStack.pop());
                    }else{
                        System.out.println("No history to go forward!!");
                    }
                    // history.forward();
                    break;

                case 2:
                    System.out.print("Enter your search: ");
                    String search = sc.nextLine();
                    // history.addNodeatend(search);
                    backStack.push(search);
                    forwardStack.clear();
                    break;

                case 3:
                    // history.goback();
                    if(!backStack.isEmpty()){
                        forwardStack.push(backStack.pop());
                        System.out.println("Went back to: "+backStack.pop());
                    }
                    else{
                        System.out.println("No history to go back");
                    }
                    break;

                case 4:
                    
                    System.out.println("Search history is: "+backStack);
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Incorrect choice, please try again.");
                    break;
            }
        }
        sc.close();
        
    }
}
