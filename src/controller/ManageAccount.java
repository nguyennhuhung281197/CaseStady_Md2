package controller;

import base.AbstractMethod;
import base.InterfaceAccount;
import fileio.WriteFile;
import modent.Account;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ManageAccount extends AbstractMethod implements InterfaceAccount {

    private List<Account> accountList = new ArrayList<>();


    public ManageAccount() {
        accountList.add(new Account(123, "Hung", 50));
        accountList.add(new Account(1253, "Nam", 60));
        accountList.add(new Account(1211, "Dung", 60));
        accountList.add(new Account(163, "Hai", 70));
    }

    public ManageAccount(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void loadMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to deposit : ");
        double load = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter the name of the person you want to top up : ");
        String nguoiNap = sc.nextLine();
        double sum = 0;
        for (Account account : accountList) {
            if (account.getNameAccount().toLowerCase().equals(nguoiNap.toLowerCase())) {
                if (load >= 0) {
                    sum = load + account.getAccountAmount();
                    account.setAccountAmount(sum);
                } else {
                    System.err.println("""
                            -------------------+
                            | Invalid amount ! |
                            +------------------+ """);
                }
                System.out.println("Successfully Loaded : " + sum + "$");
                break;
            }

        }

    }

    public void withdrawMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Amount You Want To Withdraw : ");
        double deduction = sc.nextDouble();
        sc.nextLine();
        System.out.println("Name of person who wants to withdraw money  : ");
        String rutTien = sc.nextLine();
        double sub = 0;
        double fee = 5;
        for (Account account : accountList) {
            if (deduction <= (account.getAccountAmount() - fee)) {
                sub = account.getAccountAmount() - (deduction + fee);
            } else {
                System.out.println("""
                        +----------------+
                        |Invalid amount !|
                        +----------------+""");
            }
            if (account.getNameAccount().toLowerCase().equals(rutTien.toLowerCase())) {
                System.out.println("Successfully Loaded : " + sub + "$");
                account.setAccountAmount(sub);
                break;
            }
        }
    }

    public void transferMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Remitter's name : ");
        String tenChuyen = sc.nextLine();
        System.out.println("Amount you want to transfer : ");
        double tienChuyen = sc.nextDouble();
        sc.nextLine();
        System.out.println("Recipient's name : ");
        String nguoiNhan = sc.nextLine();
        for (Account account : accountList) {
            if (account.getNameAccount().toLowerCase().equals(tenChuyen.toLowerCase())) {
                if (tienChuyen < account.getAccountAmount()) {
                    System.out.println("Successful transfer : " + tienChuyen + "$");
                    double soDU;
                    soDU = account.getAccountAmount() - tienChuyen;
                    System.out.println("Account balance : " + soDU + "$");
                    account.setAccountAmount(soDU);

                    for (Account account1 : accountList) {
                        if (account1.getNameAccount().toLowerCase().equals(nguoiNhan.toLowerCase())) {
                            double nhanTien;
                            nhanTien = account1.getAccountAmount() + tienChuyen;
                            System.out.println("Successfully received money..... ");
                            System.out.println("The balance in the recipient's account :  " + nhanTien + "$");
                            account1.setAccountAmount(nhanTien);
                        }
                    }

                } else {
                    System.err.println("""
                            +-------------+ 
                            | Not Valid ! |
                            +-------------+
                            """);
                }
            }
        }
    }


    @Override
    public void display() {
        System.out.printf("%-10s %-20s %-20s\n", "Number Account ", '\t' + "Name Account", "Account Amount");
        for (Account account : accountList) {
            System.out.println(account);

        }
    }

    @Override
    public void addAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number Account : ");
        int number = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Name Account : ");
        String name = sc.nextLine();

        System.out.println("Enter Account Amount : ");
        double amount = sc.nextDouble();
        boolean check = false;
        for (Account account : accountList) {
            if (account.getAccountNumber() == number) {
                check = true;
                break;
            }
        }
        if (check) {
            System.err.println("""
                    +------------------------+
                    | Number Already Exist ! |
                    +------------------------+""");
        } else {
            Account account = new Account(number, name, amount);
            accountList.add(account);

        }

    }

    @Override
    public boolean removeAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name you want to delete : ");
        String xoaTen = sc.nextLine();
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getNameAccount().toLowerCase().equals(xoaTen.toLowerCase())) {
                accountList.remove(accountList.get(i));
                return true;
            }
        }

        System.err.println("""
                +-------------+
                | Not Valid ! |
                +-------------+""");
        return false;
    }

    @Override
    public void updateAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the account number to edit : ");
        int soTk = Integer.parseInt(sc.nextLine());
        System.out.println("Enter edit name : ");
        String nameEdit = sc.nextLine();
        for (Account account : accountList) {
            if (account.getAccountNumber() == soTk) {
                account.setNameAccount(nameEdit);
                break;
            }
        }
    }

    @Override
    public void searchAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name you want to search : ");
        String searchName = sc.nextLine();
//        for (int i = 0; i < accountList.size(); i++) {
//            if (accountList.get(i).getNameAccount().toLowerCase().contains(searchName.toLowerCase()));
//            System.out.println(accountList.get(i));
//
//        }
        accountList.stream().filter(doc -> doc.getNameAccount().equalsIgnoreCase(searchName)).forEach(System.out::println);

    }

    @Override
    public void sortAccount() {
        accountList.sort(Comparator.comparing(Account::getAccountNumber));
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    public static void Used() {
        String tk = "1";
        String mk = "1";
        Scanner sc = new Scanner(System.in);
        System.out.println(" User Name : ");
        String name = sc.nextLine();
        System.out.println(" Password  : ");
        String pass = sc.nextLine();
        boolean check = false;
        try {
            if (tk.equals(name) || mk.equals(pass)) {
                check = true;
            }

            if (check) {
                System.out.println("""
                        +-------------------------+
                        | Logged in successfully  |
                        +-------------------------+""");
            } else {
               throw new IllegalAccessException("""
                       +-----------------------------+
                       | Wrong Account And Password !|
                       +-----------------------------+""");
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    }
