import java.util.Scanner;

public class snakewatergun_noregex {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rounds: ");
        int rounds = sc.nextInt();
        System.out.println("Enter the exp: ");
        String exp = sc.next();
        String words[] = mov(exp, rounds); 
        sc.close();
        // System.out.println(Arrays.toString(mov(exp, rounds)));
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
        System.out.println("A has won" + cA + "rounds");
    }
    static String [] mov(String exp,int rounds){
        int i=0;int j=0;
        String arr[] = new String[rounds*2];
        while(j<=exp.length() && i<arr.length){
            if(exp.charAt(j)=='s'){
                arr[i] = "snake";
                 i+=1;
                 j+=5;
            }
            else if(exp.charAt(j)=='w'){
                arr[i] = "water";
                i+=1;
                j+=5;

            }
            else if(exp.charAt(j)=='g'){
                arr[i] ="gun";
                i+=1;
                j+=3;
            }
        }
        return arr;
    }
}
