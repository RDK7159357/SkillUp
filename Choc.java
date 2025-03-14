import java.util.*;

public class Choc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // String arr [][] = new String[10][10];
        
        // arr[0][0] = "Dairy Milk";     arr[0][1] = "50";
        // arr[1][0] = "KitKat";         arr[1][1] = "40";
        // arr[2][0] = "Snickers";       arr[2][1] = "40";
        // arr[3][0] = "Ferrero Rocher"; arr[3][1] = "30";
        // arr[4][0] = "Galaxy";         arr[4][1] = "10";
        
        // Arrays.sort(arr, Comparator.comparingInt(o-> Integer.parseInt(o[1])));
        
        // System.out.println("Chocolate Prices:");
        // for (String[] chocolate : arr) {
        //     System.out.println(chocolate[0] + " - $" + chocolate[1]);
        // }
        
        
        Map<String, Integer> map = new HashMap<>();
        map.put("cad", 50);
        map.put("kit", 10);
        map.put("milk", 40);
        map.put("perk", 40);
        map.put("silk", 60);
        map.put("mars", 10);
        map.put("gems", 20);
        map.put("man", 5);
        

        // Sort keys based on values
        List<String> keys = new ArrayList<>(map.keySet());
        keys.sort(Comparator.comparingInt(map::get));


        // Or can also implement using treeset for the keys

        // OR
        // keys.sort((key1, key2) -> Integer.compare(map.get(key1), map.get(key2)));


        // Get user input
        System.out.print("Enter number of Chocolates: ");
        int n = sc.nextInt();
        sc.close();

        // Print the first 'n' chocolates based on price
        System.out.println("Chocolates and their prices");
        for (int i = 0; i < n && i < keys.size(); i++) {
            String key = keys.get(i);
            System.out.println("Name: " + key + ", Price: " + map.get(key));
        }
    }
}
