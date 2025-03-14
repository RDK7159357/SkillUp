import java.util.Scanner;

// JPMC PYQ

public class fib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = fibo(n);
        sc.close();
        System.out.println(dectobin(temp));
        
    }
    public static int fibo(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }

        else{

            int a=0,b=1,fib=0;

            for(int i=2;i<=n;i++){
                fib = a+b;
                a=b;
                b=fib;
            }
            return fib;
        }
    }
    // public static int dectobin(int n){
    //    StringBuilder s = new StringBuilder();
    //     while(n>0){
    //         int bit = n%2;
    //         s.append(bit);
    //         n/=2; 
    //     }
    //     s.reverse();
    //     return Integer.parseInt(s.toString());
    // }
    public static String dectobin(int n) {
        return Integer.toBinaryString(n);
    }
    
}
