import java.util.Scanner;

public class Minbadness {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();
        sc.close();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 & arr[i] == 'W') {
                int j = 1;
                while (j < arr.length) {
                    if (arr[j] != 'W') {

                        arr[i] = arr[j];
                        break;
                    }
                    j += 1;
                }

            } else if (arr[i] == 'W') {
                arr[i] = arr[i - 1];

            }
        }
        int badness = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[i + 1]) {
                badness += 1;
            }
        }
        System.out.println(badness);
    }

}
