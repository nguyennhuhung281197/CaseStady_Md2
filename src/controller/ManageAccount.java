package controller;

import base.AbstractMethod;
import base.InterfaceAccount;
import fileio.ReadFile;
import fileio.WriteFile;
import model.Account;
import model.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ManageAccount extends AbstractMethod implements InterfaceAccount {

    private List<Account> accountList;
    private ReadFile<Account> readFile;
    private WriteFile<Account> writeFile;

    public ManageAccount() {
        accountList = new ArrayList<>();
        readFile = new ReadFile<>();
        accountList = readFile.readToFile();
        writeFile = new WriteFile<>();
    }

    public ManageAccount(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public void register3G() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                +-----------------+
                |1.goi 1 nam      |
                |2.goi 30 ngay    |
                |3.goi 7 ngay     |
                |4.goi 3 ngay     |
                |0.Exit           |
                +-----------------+
                """);
        System.out.println("Please Enter : ");
        int input = sc.nextInt();
        sc.nextLine();
        System.out.println("tim stk  ");
        int search = sc.nextInt();
        for (Account account : accountList) {
            if (account.getAccountNumber() == search) {
                System.out.println(account);
                switch (input) {
                    case 1:
                        LocalDate startDate = LocalDate.of(2023, 4, 21);
                        LocalDate endDate = startDate.plus(1, ChronoUnit.YEARS);
                        System.out.println("Tu ngay : " + startDate + " Hạn sử dụng 3G : " + endDate);
                        break;
                    case 2:
                        LocalDate startDate1 = LocalDate.of(2023, 4, 21);
                        LocalDate endDate1 = startDate1.plus(30, ChronoUnit.DAYS);
                        System.out.println("Tu ngay : " + startDate1 + " Hạn sử dụng 3G : " + endDate1);
                        break;
                    case 3:
                        LocalDate startDate2 = LocalDate.of(2023, 4, 21);
                        LocalDate endDate2 = startDate2.plus(7, ChronoUnit.DAYS);
                        System.out.println("Tu ngay" + startDate2 + "Hạn sử dụng 3G: " + endDate2);
                        break;
                    case 4:
                        LocalDate startDate3 = LocalDate.of(2023, 4, 21);
                        LocalDate endDate3 = startDate3.plus(3, ChronoUnit.DAYS);
                        System.out.println("Tu ngay" + startDate3 + "Hạn sử dụng 3G: " + endDate3);
                        break;
                    case 0:
                        break;
                    default:
                        System.err.println("""
                                +-----------+
                                | Invalid ! |
                                +-----------+""");
                        break;

                }
            }
        }

    }


    @Override
    public void rechargeCard() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter the account number to top up the card : ");
        int search = sc.nextInt();
        sc.nextLine();
        System.out.println("""
                +-------------------------+
                |1.Load Card 20$          |
                |2.LOAD Card 50$          |
                |3.LOAD Card 100$         |
                |4.LOAD Card 200$         |
                |5.LOAD Card 500$         |
                |6.LOAD AS REQUIRED       |
                +-------------------------+
                """);
        System.out.println("Please Enter Number : ");
        int input = sc.nextInt();
        for (Account account : accountList) {
            if (account.getAccountNumber() == search) {
                System.out.println(account);


                int sub = 0;
                switch (input) {
                    case 1:
                        if (account.getAccountAmount() <= 20) {
                            System.out.println("""
                                    +------------------------------+
                                    |The amount is too specified ! |
                                    +------------------------------+""");
                        } else {
                            sub += account.getAccountAmount() - 20;
                            account.setAccountAmount(sub);
                            System.out.println("Customer's Account Multi-loaded successfully: " + sub + "$");
                            break;
                        }
                        break;

                    case 2:
                        if (account.getAccountAmount() <= 50) {
                            System.out.println("""
                                    +------------------------------+
                                    |The amount is too specified ! |
                                    +------------------------------+""");
                        } else {
                            sub += account.getAccountAmount() - 50;
                            account.setAccountAmount(sub);
                            System.out.println("Customer's Account Multi-loaded successfully: " + sub + "$");
                            break;
                        }
                        break;
                    case 3:
                        if (account.getAccountAmount() <= 100) {
                            System.out.println("""
                                    +------------------------------+
                                    |The amount is too specified ! |
                                    +------------------------------+""");
                        } else {
                            sub += account.getAccountAmount() - 100;
                            account.setAccountAmount(sub);
                            System.out.println("Customer's Account Multi-loaded successfully: " + sub + "$");
                            break;
                        }
                        break;
                    case 4:
                        if (account.getAccountAmount() <= 200) {
                            System.out.println("""
                                    +------------------------------+
                                    |The amount is too specified ! |
                                    +------------------------------+""");
                        } else {
                            sub += account.getAccountAmount() - 200;
                            account.setAccountAmount(sub);
                            System.out.println("Customer's Account Multi-loaded successfully: " + sub + "$");
                            break;
                        }
                        break;
                    case 5:
                        if (account.getAccountAmount() <= 500) {
                            System.out.println("""
                                    +------------------------------+
                                    |The amount is too specified ! |
                                    +------------------------------+""");
                        } else {
                            sub += account.getAccountAmount() - 500;
                            account.setAccountAmount(sub);
                            System.out.println("Customer's Account Multi-loaded successfully: " + sub + "$");
                            break;
                        }
                        break;
                    case 6:
                        System.out.println("Enter the amount you want to deposit : ");
                        int nap = sc.nextInt();
                        if (nap > account.getAccountAmount()) {
                            System.out.println("""
                                    +------------------------------+
                                    |The amount is too specified ! |
                                    +------------------------------+""");
                        } else {
                            sub += account.getAccountAmount() - nap;
                            account.setAccountAmount(sub);
                            System.out.println("Customer's Account Multi-loaded successfully : " + sub + "$");
                            break;
                        }
                        break;
                    default:
                        System.out.println("""
                                +-----------+
                                | Invalid ! |
                                +-----------+""");
                        break;

                }
            }
        }
        writeFile.writeToFile(accountList);

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
        writeFile.writeToFile(accountList);
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
        writeFile.writeToFile(accountList);
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
        writeFile.writeToFile(accountList);
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
        try {
            if (amount < 0) {
                throw new IllegalAccessException("Invalid amount! Amount must be greater than or equal to 0.");

            }
            boolean check = false;
            for (Account account : accountList) {
                if (account.getAccountNumber() == number) {
                    check = true;
                    break;
                }

            }
            if (check) {
                throw new IllegalAccessException("""
                        +------------------------+
                        | Number Already Exist ! |
                        +------------------------+""");
            } else {
                Account account = new Account(number, name, amount);
                accountList.add(account);

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


        writeFile.writeToFile(accountList);
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
                System.out.println("""
                        +----------+
                        |a. Yes    |
                        |b. No     |
                        +----------+""");
                String agree = sc.nextLine();
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
        writeFile.writeToFile(accountList);
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
        writeFile.writeToFile(accountList);
    }

    @Override
    public void searchAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Want to search for an account name or number?");
        System.out.println("""
                ====================================
                |1.Search by account name <=      |
                |2.Search account number <=       |
                ====================================""");
        String tim = sc.nextLine();
        String name = "1";
        String num = "2";
        try {


            if (num.equals(tim)) {
                System.out.println("Enter the account number you want to find : ");
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
            System.err.println(e.getMessage());
        }
        writeFile.writeToFile(accountList);
    }


    @Override
    public void sortAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Do you want to Sort by name or account number? ");
        System.out.println("""
                ====================================
                |1.Sort By Name <=                 |
                |2.Sort by Account Number <=       |
                |3.Sort by Account Money <=        |
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
        writeFile.writeToFile(accountList);
    }



}
