package main;

import controller.ManageAccount;
import controller.ManageUser;
import model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ManageUser manageUser = new ManageUser();
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        while (check) {
            System.out.println("1. Register");
            System.out.println("2.Log In");
            System.out.println("3. Exit");
            System.out.println("Your choice : ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    manageUser.register();
                    break;
                case 2:
                    manageUser.login();
                    break;
                case 3:
                    System.exit(0);
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
