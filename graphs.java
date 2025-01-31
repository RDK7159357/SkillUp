import java.util.*;

public class graphs{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline

        HashMap<Integer, ArrayList<Integer>> al = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue; // Skip empty lines

            String[] parts = line.split(" ");
            int key = Integer.parseInt(parts[0]);

            // Ensure the key exists in the adjacency list
            al.putIfAbsent(key, new ArrayList<>());

            for (int j = 1; j < parts.length; j++) {
                al.get(key).add(Integer.parseInt(parts[j]));
            }
        }
        sc.close();

        // Print adjacency list
        for (int key : al.keySet()) {
            System.out.print(key + " -> ");
            System.out.println(String.join(", ", al.get(key).toString().replaceAll("[\\[\\]]", "")));
        }
    }
}
