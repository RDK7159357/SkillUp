import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
// import java.util.HashMap;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getusername() {
        return username;
    }

    public String getpassword() {
        return password;
    }
}

class Authentication {
    private String currUser = null;
    // private HashMap<String, User> users = new HashMap<>();

    public boolean registerUser(String username, String password) {
        // if (users.containsKey(username)) {
        //     return false;
        // }
        // users.put(username, new User(username, password));
        try (FileWriter Writer = new FileWriter("Users.txt", true)) {
            Writer.write(username + "," + password + "\n");
        } catch (IOException e) {
            System.out.println("Eror occured while writing in to users file");
        }
        return true;
    }

    public boolean login(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Users.txt"))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                String arr[] = line.split(",");

                if (arr[0].equals(username) && arr[1].equals(password)) {
                    // User user = users.get(username);
                    // if (user != null && user.getpassword().equals(password)) {
                        currUser = username;
                        return true;
                    // }
                }
            }
        } catch (IOException e) {
            System.out.println("Error!!");
        }
        return false;
    }

    public boolean Isexists(String username) {
        try(BufferedReader reader = new BufferedReader(new FileReader("Users.txt"))){
            String l ="";
            while((l=reader.readLine()) != null){
                String arr [] = l.split(",");
                if(arr[0].equals(username)){
                    return true;
                }
            }
            return false;
        }
        catch(IOException e){
            System.out.println("Error");
            return false;
        }
        // return users.containsKey(username);
    }

    public void logout() {
        if (currUser != null) {
            System.out.println("Logged out " + currUser + " successfully\n");
            currUser = null;
        } else {
            System.out.println("User not logged in\n");
        }
    }

    public boolean isloggedin() {
        return currUser != null;
    }
}

public class Ollamaoffline {

    public static void main(String[] args) {
        String modelName = "deepseek-r1:8b";
        Scanner sc = new Scanner(System.in);
        Authentication auth = new Authentication();

        while (true) {
            System.out.println("Choices:");
            System.out.print("1: Register User\n2: Login\n3: Logout\n4: Exit\nEnter choice: ");
            int choice = -1;

            try {
                choice = sc.nextInt(); // Read the choice
                sc.nextLine(); // Clear the newline character after nextInt
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.nextLine(); // Clear the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = sc.nextLine();
                    System.out.print("Enter password: ");
                    String password = sc.nextLine();
                    if (auth.Isexists(username)) {
                        System.out.println("User already exists\n");
                    } else {
                        auth.registerUser(username, password);
                        System.out.println("User registered successfully\n");
                    }
                    break;

                case 2:
                    if (auth.isloggedin()) {
                        System.out.println("User already logged in");
                    } else {
                        System.out.print("Enter username: ");
                        String usernam = sc.nextLine();
                        System.out.print("Enter password: ");
                        String pass = sc.nextLine();
                        int count =0 ;
                        if (auth.login(usernam, pass)) {
                            System.out.println("Logged in\n");

                            // Start chatbot interaction  
                       
                            while (true) {
                                if(count>1){
                                          System.out.println("Is there anything more to ask about!!");
                                }else{
                                         System.out.println("Hello, how can I help you?");
                                         
                                }
                                count++;
                          
                                String prompt = sc.nextLine(); // Capture the full input prompt
                                if (prompt.equalsIgnoreCase("exit")) {
                                    System.out.println("Exiting chat...");
                                    break;
                                }

                                try {
                                    ProcessBuilder processBuilder = new ProcessBuilder("ollama", "run", modelName);
                                    processBuilder.redirectErrorStream(true);
                                    Process process = processBuilder.start();
                                    OutputStream processInput = process.getOutputStream();
                                    processInput.write(("--prompt \"" + prompt + "\"\n").getBytes());
                                    processInput.flush();
                                    processInput.close();
                                    
                                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                                    String line;
                                    StringBuilder response = new StringBuilder();
                                    while ((line = reader.readLine()) != null) {
                                        response.append(line).append("\n");
                                    }
                                    reader.close();
                                    process.waitFor();
                                    
                                    // Correctly remove <think> and </think>
                                    String responseText = response.toString().replaceAll("<\\/?think>", "").trim();
                                    
                                    System.out.print("Response from Ollama: ");
                                    System.out.print(responseText);
                                    
                                    
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            System.out.println("Failed to login, user does not exist\n");
                        }
                    }
                    break;

                case 3:
                    auth.logout();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Incorrect choice! Please select a valid option.");
            }
        }
    }
}
