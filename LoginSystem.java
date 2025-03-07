import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


class User{
    private String username;
    private String password;
    
    User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getusername(){
        return username;
    }
    public String getpassword(){
        return password;
    }
}

class Authentication{
    private String currUser = null;
    private HashMap<String, User> users = new HashMap<>();

    public boolean registerUser(String username, String password){
        if(users.containsKey(username)){
            return false;
        }
        users.put(username, new User(username, password));
        try
            (FileWriter Writer = new FileWriter("Users.txt",true)){
                Writer.write(username+","+password+"\n");
            }
        catch(IOException e){
            System.out.println("Eror occured while writing in to users file");

        }
        return true;
    }
    public boolean login(String username, String password){
   
        try(BufferedReader reader = new BufferedReader(new FileReader("Users.txt"))){
            String line="";
            while((line = reader.readLine())!=null){   
                String arr[] = line.split(",");
            
                if(arr[0].equals(username) && arr[1].equals(password)){  
                    User user = users.get(username);
                    if(user!=null && user.getpassword().equals(password)){
                        currUser = username;
                        return true;
                    }

                }
            }
        }
        catch(IOException e){
            System.out.println("Error!!");
        }
        return false;
    }
    public boolean Isexists(String username){
        if(users.containsKey(username)){
            return true;
        }
        return false;
    }
    public void logout(){
        if(currUser!=null){
            System.out.println("Logged out "+currUser+" successfully\n");
            currUser = null;
        }
        else{
            System.out.println("User not logged in\n");
        }
    }
    public boolean isloggedin(){
        return currUser!=null;
    }
}
public class LoginSystem {

    public static void main(String[] args) {
        Authentication auth = new Authentication();
        Scanner sc = new Scanner(System.in);
        while(true){
              System.out.println("Choices");
              System.out.print("1: Register User\n2: login\n3: logout\n4: Exit\nEnter choice: \n");
              int choice = sc.nextInt();
              switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = sc.next();
                    System.out.print("Enter password: ");
                    String password = sc.next();
                    if(auth.Isexists(username)){
                        System.out.println("User already exists\n");
                    }
                    else{
                        auth.registerUser(username, password);
                        System.out.println("User registered successfully\n");
                    }                  
                    break;
                case 2:
                    if(auth.isloggedin()){
                        System.out.println("User already logged in");
                    }
                    else{

                        System.out.print("Enter username: ");
                        String usernam = sc.next();
                        System.out.print("Enter password: ");
                        String pass = sc.next();
                        if(auth.login(usernam, pass)){
                            System.out.println("Logged in\n");
                        }
                        else{
                            System.out.println("Failed to login ie user does not exist\n");
                        }
                    }
                    break;

                case 3:

                    auth.logout();
                    break;
                case 4:
                    System.out.println("Exiting !!!");

                    sc.close();
                    System.exit(0);
                    
              
                default:
                    System.out.println("Incorrect choice");
                    break;
              }
        }
        
      
       
    }
}