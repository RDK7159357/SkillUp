import java.util.Scanner;

public class Convert_to_one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no: ");
        sc.close();
        int n = sc.nextInt();
        
        if(n>=4 ){
            if(n%2==0){

                System.out.println(2);
            }
            else{
                System.out.println(3);
            }

        }
        else{
            System.out.println(n-1);
        }

    }

}
