package controller;

import base.AbstractMethod;
import base.InterfaceAccount;
import fileio.ReadFile;
import fileio.WriteFile;
import modent.Account;

import java.io.*;
import java.util.*;

public class ManageAccount extends AbstractMethod implements InterfaceAccount {

    private List<Account> accountList;

    private ReadFile<Account> readFile;
    private WriteFile<Account>writeFile;

    public ManageAccount() {
        accountList = new ArrayList<>();
        readFile = new ReadFile<>();
        accountList = readFile.readToFile();
        writeFile = new WriteFile<>();
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
    public void removeAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                =====================================================
                |         What do you want to delete?               | 
                |1. Delete an account by account number <=          |    
                |2. Delete all <=                                   |
                =====================================================""");
        String input = sc.nextLine();
        String removeOne = "1";
        String removeAll = "2";
        String yes = "a";
        String no = "b";

        try {
            if (removeOne.equals(input)) {
                boolean check = false;
                System.out.println("Enter the account number you want to delete ");
                int num = sc.nextInt();
                sc.nextLine();
                System.out.println("Do you want to delete? ");
                String agree = sc.nextLine();
                System.out.println("""
                        +----------+
                        |a. Yes    |
                        |b. No     |
                        +----------+""");
                if (agree.equals(yes)) {
                    for (int i = 0; i < accountList.size(); i++) {
                        if (accountList.get(i).getAccountNumber() == num) {
                            accountList.remove(i);
                            check = true;
                            break;
                        } else {
                            check = false;

                        }

                    }
                    if (check) {
                        System.out.println("Successful delete");
                        for (Account account : accountList) {
                            System.out.println(account);
                        }
                    } else {
                        System.out.println("Does not exist");
                    }
                } else if (agree.equals(no)) {
                    for (Account account : accountList) {
                        System.out.println(account);
                    }
                } else {
                    throw new IllegalAccessException("""
                            +-------------+
                            | Not Valid ! |
                            +-------------+""");
                }


            } else if (removeAll.equals(input)) {
                System.out.println("Are you sure you want to delete it?");
                System.out.println("""
                        +----------+
                        | 1. Yes   |
                        | 2. No    |
                        +----------+
                        """);
                String yes2 = "1";
                String no2 = "2";
                String input1 = sc.nextLine();
                if (yes2.equals(input1)) {
                    accountList.clear();
                    for (Account account : accountList) {
                        System.out.println(account);
                    }
                } else if (no2.equals(input1)) {
                    for (Account account : accountList) {
                        System.out.println(account);
                    }
                } else {
                    throw new IllegalAccessException("""
                            +-------------+
                            | Not Valid ! |
                            +-------------+""");
                }

            } else {
                throw new IllegalAccessException("""
                        +-------------+
                        | Not Valid ! |
                        +-------------+""");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
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
        System.out.println("Want to search for an account name or number?");
        System.out.println("""
                ====================================
                |1.Search by account name <=  |
                |2.Search account number <=       |
                ====================================""");
        String tim = sc.nextLine();
        String name = "1";
        String num = "2";
        try {


            if (num.equals(tim)) {
                System.out.println("nhap stk muon tim : ");
                int searchNum = sc.nextInt();
                for (int i = 0; i < accountList.size(); i++) {
                    if (accountList.get(i).getAccountNumber() == searchNum) {
                        System.out.println(accountList.get(i));
                    }
                }
            } else if (name.equals(tim)) {
                System.out.println("Enter the name you want to search : ");
                String searchName = sc.nextLine();
                accountList.stream().filter(doc -> doc.getNameAccount().equalsIgnoreCase(searchName)).forEach(System.out::println);
            } else {
                throw new IllegalAccessException("""
                        +----------+
                        | Illegal !|
                        +----------+""");
            }
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void sortAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Do you want to Sort by name or account number? ");
        System.out.println("""
                ====================================
                |1.Sort By Name <=                 |
                |2.Sort by Account Number <=   |
                |3.Sort by Account Money <= |
                ====================================""");
        String xepSep = sc.nextLine();
        String name = "1";
        String num = "2";
        String numMoney = "3";
        try {
            if (name.equals(xepSep)) {
                accountList.sort(Comparator.comparing(Account::getNameAccount));
                for (Account account : accountList) {
                    System.out.println(account);
                }
            } else if (num.equals(xepSep)) {
                accountList.sort(Comparator.comparing(Account::getAccountNumber));
                for (Account account : accountList) {
                    System.out.println(account);
                }
            } else if (numMoney.equals(xepSep)) {
                accountList.sort(Comparator.comparing(Account::getAccountAmount));
            } else {
                throw new IllegalAccessException("""
                        +----------+
                        | Illegal !|
                        +----------+""");
            }
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());

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
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

}
