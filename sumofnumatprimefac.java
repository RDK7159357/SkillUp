import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class sumofnumatprimefac{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lp = new ArrayList<>();
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        // while(n%2==0){
        //     lp.add(2);
        //     n/=2;
  
        // }
        for(int i=2;i<=Math.sqrt(n);i+=2){ // or i*i<= n
            while(n%i==0){
                lp.add(i);
                n/=i;
            }
        }
        if(n>2){
            lp.add(n);
        }
        Collections.sort(lp);        
        int res=0;
        for(int i=0;i<lp.size();i++){
            if(i>0 && lp.get(i).equals(lp.get(i-1))) continue;
            int factor = lp.get(i);
            res += Count(lp, lp.get(i)) * (factor<arr.length ? arr[factor] : 0);
        }
        System.out.println(res);
    }
    static int Count(ArrayList<Integer> lp,int key){
        int count =0;
        for(int i=0;i<lp.size();i++){
            if(lp.get(i)==key){
                count++;
            }
        }
        return count;
    }

}