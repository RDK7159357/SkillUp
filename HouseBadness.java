import java.util.Scanner;

public class HouseBadness {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the house colors (R, B, W): ");
        String houses = sc.next();
        sc.close();

        int minBadness = minimizeBadness(houses);
        System.out.println("Minimum Badness: " + minBadness);
    }

    static int minimizeBadness(String houses) {
        return findMinBadness(houses.toCharArray(), 0);
    }

    static int findMinBadness(char[] houses, int index) {
        if (index == houses.length) {
            return calculateBadness(houses);
        }

        if (houses[index] == 'W') {
            // Try replacing 'W' with 'R' and 'B'
            houses[index] = 'R';
            int badnessR = findMinBadness(houses, index + 1);
            houses[index] = 'B';
            int badnessB = findMinBadness(houses, index + 1);
            houses[index] = 'W'; // Backtrack

            return Math.min(badnessR, badnessB);
        }

        return findMinBadness(houses, index + 1);
    }

    static int calculateBadness(char[] houses) {
        int badness = 0;
        for (int i = 1; i < houses.length; i++) {
            if (houses[i] != houses[i - 1]) {
                badness++;
            }
        }
        return badness;
    }
}
