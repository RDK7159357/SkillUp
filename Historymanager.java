import java.util.Scanner;

class Node {
    String data;
    Node next;
    Node prev;

    Node(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class Dll {
    Node head;
    Node ptr;

    void addNodeatend(String data) {
        Node newNode = new Node(data);
        if (head == null) { // First node
            head = newNode;
            ptr = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) { // Traverse to the end of the list
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        ptr = newNode; // Update ptr to the newly added node
        System.out.println("Added search: " + data);
    }

    void goback() {
        if (ptr != null && ptr.prev != null) {
            ptr = ptr.prev;
            System.out.println("You are currently at: " + ptr.data);
        } else {
            System.out.println("You are on the homepage, cannot go back further.");
        }
    }

    void forward() {
        if (ptr != null && ptr.next != null) {
            ptr = ptr.next;
            System.out.println("You are currently at: " + ptr.data);
        } else if (ptr != null) {
            System.out.println("You have reached the end of the history.");
        } else {
            System.out.println("Error: History is empty or invalid pointer.");
        }
    }

    void viewll() {
        if (head == null) {
            System.out.println("No searches in history.");
            return;
        }
        Node temp = head;
        System.out.print("Search history: ");
        while (temp != null) {
            System.out.print(temp.data);
            
            if(temp.next==null){
                System.out.print("");
            }
            else{
                System.out.print("->");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Historymanager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dll history = new Dll();

        int choice = 0;
        while (choice != 5) {
            System.out.println("\n1: Go Forward\n2: Search\n3: Go Back\n4: View Your Search List\n5: Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    history.forward();
                    break;

                case 2:
                    System.out.print("Enter your search: ");
                    String search = sc.nextLine();
                    history.addNodeatend(search);
                    break;

                case 3:
                    history.goback();
                    break;

                case 4:
                    history.viewll();
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Incorrect choice, please try again.");
                    break;
            }
        }
        sc.close();
    }
}
