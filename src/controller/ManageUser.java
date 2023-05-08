package controller;

import model.EmailExample;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageUser {
    private List<User> users;

    public ManageUser() {
        users = new ArrayList<>();
    }

    public ManageUser(List<User> users) {
        this.users = users;
    }

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("* Instructions : xxx@gmail.com\n" +
                "x : is a number or letter without special characters !");
        System.out.print("User name :");
        String username = sc.nextLine();
        System.out.print("Password :");
        String password = sc.nextLine();
        EmailExample emailExample = new EmailExample();
        boolean isValid = emailExample.validate(username);

        if (isValid) {
            User user = new User(username, password);
            users.add(user);
            System.out.println("""
                    +-----------------+
                    | Sign Up Success |
                    +-----------------+""");
        } else {
            System.out.println("""
                    +------------+
                    | Illegal !  |
                    +------------+""");
        }
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("User name :");
        String name = sc.nextLine();
        System.out.print("Password :");
        String pass = sc.nextLine();

        boolean check = false;
        for (User user : users) {
            if (user.getUsername().equals(name) && user.getPassword().equals(pass)) {
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("""
                    +-------------------------+
                    |  Logged in successfully |
                    +-------------------------+""");
            ManageMenu.getMenu();

        } else {
            System.out.println("""
                    +-----------------------------+
                    | Wrong username or password! |
                    +-----------------------------+""");


        }
    }

}
