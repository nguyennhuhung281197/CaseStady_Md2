package main;
import controller.ManageUser;
import java.util.Scanner;
public class Main {
    public static final String ANSI_RESET = "\u001B[0m";

    // Declaring the color
// Custom declaration
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {

        ManageUser manageUser = new ManageUser();
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        while (check) {
            System.out.println(ANSI_YELLOW);
            System.out.println("""
                    +---------------+
                    | 1. Register   |
                    | 2. Log In     |
                    | 3. Exit       |
                    +---------------+""");
            System.out.println("Your choice : ");
            String choice = sc.nextLine();
            System.out.println(ANSI_RESET);
            switch (choice) {
                case "1":
                    manageUser.register();
                    break;
                case "2":
                    manageUser.login();
                    break;
                case "3":
                    System.out.println("""
                            +-------------+
                            | No Return ! |
                            +-------------+""");
                    break;
                case "0":
                    check = false;
                    break;
                default:
                    System.err.println("""
                            +--------------------+
                            | Invalid selection! |
                            +--------------------+""");
                    break;


            }
        }
    }
}
