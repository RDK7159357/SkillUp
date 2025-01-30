import java.util.Scanner;
import java.util.regex.*;

public class snakewatergun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rounds: ");
        int rounds = sc.nextInt();
        System.out.println("Enter the exp: ");
        String exp = sc.next();
        int res = snakegame(exp, rounds);


        if (res != -1) {
            System.out.println("Player A won " + res + " rounds");
        }
        sc.close();
    }

    static int snakegame(String exp, int rounds) {
        String pattern = "(snake|water|gun)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(exp);

        // Store results in a fixed-size array
        String[] words = new String[rounds * 2];  
        int index = 0;
        while (m.find() && index < rounds * 2) {
            words[index++] = m.group();
        }

        // Validate input
        if (index != rounds * 2) {
            System.out.println("Error: Expected " + (rounds * 2) + " words, but found " + index);
            return -1;
        }

        @SuppressWarnings("unused")
        int cA = 0, cB = 0;
        for (int i = 0; i < rounds * 2; i += 2) {
            if (words[i].equals("snake") && words[i + 1].equals("water") ||
                words[i].equals("water") && words[i + 1].equals("gun") ||
                words[i].equals("gun") && words[i + 1].equals("snake")) {
                cA++; // Player A wins
            } else if (!words[i].equals(words[i + 1])) {
                cB++; // Player B wins
            }
        }
        return cA;
    }
}
