// import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
// import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;;

class Farmer{
    String f_name;
    // double yield;
     HashMap<String , ArrayList<ArrayList<String>>> details;

    Farmer(String f_name){
        this.f_name = f_name;
        this.details = new HashMap<>();
    }
    void add_details(String name , ArrayList<String> crop_d, ArrayList<String> irr_m,ArrayList<String> fertilizer, ArrayList<String> yield){
        ArrayList<ArrayList<String>> farmerdata = new ArrayList<>();
    
        farmerdata.add(crop_d);
        farmerdata.add(irr_m);
        farmerdata.add(fertilizer);   
        farmerdata.add(yield);
        details.put(name, farmerdata);

        addToFile( "farmer_database.csv");
    }

    void addToFile(String file_name)
    {
        try(BufferedWriter writer=new BufferedWriter(new FileWriter (file_name,true)))
        {
            writer.write(String.format("| %-13s | %-15s | %-20s | %-16s | %-12s |\n",
            "Farmer Name", "Crops Grown", "Irrigation Methods", "Fertilizers Used", "Yield"));

            for(String i:details.keySet())
            {
                ArrayList<ArrayList<String>> f_data=details.get(i);
                int max_r=Math.max(f_data.get(0).size(),Math.max(f_data.get(1).size(),f_data.get(2).size()));
                for (int j=0;j<max_r;j++)
                {
                    String crop=j<f_data.get(0).size()?f_data.get(0).get(j):"";
                    String irrigation=j<f_data.get(1).size()?f_data.get(1).get(j):"";
                    String fertilizer=j<f_data.get(2).size()?f_data.get(2).get(j):"";
                    String f_yield=j<f_data.get(3).size()?f_data.get(3).get(j):"";
                    writer.write(String.format("| %-13s | %-15s | %-20s | %-16s | %-12s |\n",
                    (j == 0 ? i : ""), crop, irrigation, fertilizer, f_yield));

                }

  
            }
        }
        catch (Exception e) {
            System.out.println("Error");
        }

    }
    void display_details(String name){
        if(details.containsKey(name)){
            ArrayList<ArrayList<String>> data=details.get(name);
            ArrayList<String> crops=data.get(0);
            ArrayList<String> irrigation_m=data.get(1);
            ArrayList<String> fertilizers=data.get(2);
            ArrayList<String> yield=data.get(2);
            System.out.println("Name: "+ name);
            System.out.println("Crops grown: "+crops);
            System.out.println("Irrigation methods used: "+irrigation_m);
            System.out.println("Fertilizers used: "+fertilizers);
            System.out.println("Yield: "+yield);

        }
    }


    
}
public class JPMC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        Farmer farmer = new Farmer(name);

        System.out.println("Enter crops grown: ");
        String []crop_details = sc.nextLine().trim().split(","); 

        System.out.println("Enter irrigation methods used: ");
        String [] irr_m = sc.nextLine().trim().split(","); 

        System.out.println("Enter fertilizers used: ");
        String []fertilizers = sc.nextLine().trim().split(","); 

        System.out.println("Yield: ");
        String[] yield = sc.nextLine().trim().split(",");

        farmer.add_details(name, addintoArrlist(crop_details), addintoArrlist(irr_m), addintoArrlist(fertilizers),addintoArrlist(yield));
        farmer.display_details(name);
        sc.close();

    }

    static ArrayList<String> addintoArrlist(String arr[]){
        ArrayList<String> arr_list = new ArrayList<>();
        for(String s: arr){
            arr_list.add(s);
        }
        return arr_list;

    }
    
}