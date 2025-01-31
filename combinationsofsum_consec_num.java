import java.util.ArrayList;
import java.util.Scanner;
public class combinationsofsum_consec_num {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    sc.close();
    //i is the num of terms in the expansion
    //n is the sum
    for(int i=2;i<n/2;i++){
        int x =((n-(i*(i-1)/2))/(i)) ;   
        
      
        if(x==Math.floor(x) && (n==(i*x) +(i*(i-1)/2)) && x>0 ){ 
             ArrayList<Integer> arr = new ArrayList<>();
            // System.out.println("X is : "+x);
            for(int j=0;j<i;j++){
                arr.add(x);
                x++;

            }  
                al.add(arr); 
                
        }
     

    }
    System.out.println(al);
    }

}
// k=2 
// https://justpaste.it/1zch8