import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class supermarket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the weight of products :");
        int weight = sc.nextInt();
        int orgPrice = weight * 100;
        if(weight == 5){
            System.out.println("Discounted price: "+orgPrice*0.1);
        }
        else if(weight == 10){
            System.out.println("Discounted price: "+orgPrice*0.15);
        }
        else if(weight == 15){
            System.out.println("Discounted price: "+orgPrice*0.2);
        }
        else{
            int temp = weight;
            List<Integer> arr = new ArrayList<>();
            while(temp>0){
                if(temp>=15){
                    temp -= 15;
                    arr.add(15);
                }
                else if(temp>=10){
                    temp-=10;
                    arr.add(10);
                }
                else if(temp>=5){
                    temp-=5;
                    arr.add(5);
                }

            }
            System.out.println(arr);
            sc.close();
        }
    }
    
}
