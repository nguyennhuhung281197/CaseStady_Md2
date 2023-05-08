package controller;

import base.AbstractMethod;
import base.InterfaceAccount;
import fileio.ReadFile;
import fileio.WriteFile;
import model.Account;

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
                +-------------------------------+
                |1.One year package : 300$      |
                |2.Package 30 days : 120$       |
                |3.Package 7 days : 30$         |
                |4.Package 3 days : 15$         |
                |5.DATE OPTION : 5$ 1 days      |
                +-------------------------------+
                """);
        System.out.println("Please Enter : ");
        int input = sc.nextInt();
        sc.nextLine();
        System.out.println("Account number :");
        int search = sc.nextInt();
        for (Account account : accountList) {
            if (account.getAccountNumber() == search) {
                System.out.println(account);
                double sub = 0;
                switch (input) {
                    case 1:
                        if (account.getAccountAmount() <= 300) {
                            System.out.println("""
                                    +------------------------------+
                                    |The amount is too specified ! |
                                    +------------------------------+""");
                        } else {
                            sub += account.getAccountAmount() - 300;
                            account.setAccountAmount(sub);
                            System.out.println("Your account balance is : " + sub + "$");
                            LocalDate startDate = LocalDate.of(2023, 4, 21);
                            LocalDate endDate = startDate.plus(1, ChronoUnit.YEARS);
                            System.out.println("Since : " + startDate + " Expiry date 3G : " + endDate);
                            break;
                        }
                        break;
                    case 2:
                        if (account.getAccountAmount() <= 120) {
                            System.out.println("""
                                    +------------------------------+
                                    |The amount is too specified ! |
                                    +------------------------------+""");
                        } else {
                            sub += account.getAccountAmount() - 120;
                            account.setAccountAmount(sub);
                            System.out.println("Your account balance is : " + sub + "$");
                            LocalDate startDate = LocalDate.of(2023, 4, 21);
                            LocalDate endDate = startDate.plus(30, ChronoUnit.DAYS);
                            System.out.println("Since : " + startDate + " Expiry date 3G : " + endDate);
                            break;
                        }
                        break;
                    case 3:
                        if (account.getAccountAmount() <= 30) {
                            System.out.println("""
                                    +------------------------------+
                                    |The amount is too specified ! |
                                    +------------------------------+""");
                        } else {
                            sub += account.getAccountAmount() - 30;
                            account.setAccountAmount(sub);
                            System.out.println("Your account balance is : " + sub + "$");
                            LocalDate startDate = LocalDate.of(2023, 4, 21);
                            LocalDate endDate = startDate.plus(7, ChronoUnit.DAYS);
                            System.out.println("Since : " + startDate + " Expiry date 3G : " + endDate);
                            break;
                        }
                        break;
                    case 4:
                        if (account.getAccountAmount() <= 15) {
                            System.out.println("""
                                    +------------------------------+
                                    |The amount is too specified ! |
                                    +------------------------------+""");
                        } else {
                            sub += account.getAccountAmount() - 15;
                            account.setAccountAmount(sub);
                            System.out.println("Your account balance is : " + sub + "$");
                            LocalDate startDate = LocalDate.of(2023, 4, 21);
                            LocalDate endDate = startDate.plus(3, ChronoUnit.DAYS);
                            System.out.println("Since : " + startDate + " Expiry date 3G : " + endDate);
                            break;
                        }
                        break;
                    case 5:
                        double mul = 0;
                        System.out.println("Enter the date you want to register : \n" +
                                "* Number of days less than 1 year");
                        int days = sc.nextInt();
                        boolean check = false;
                        mul = days * 5;
                        for (Account account1 : accountList) {
                            if (mul > account1.getAccountAmount() && days >= 365) {
                                check = true;
                                break;
                            }
                        }
                        if (check) {
                            System.out.println("""
                                    +------------+
                                    | ILLEGAL !  |
                                    +------------+""");
                        } else {
                            System.out.println("Customer's Account Multi-loaded successfully: " + mul + "$");
                            sub += account.getAccountAmount() - mul;
                            account.setAccountAmount(sub);
                            System.out.println("Your account balance is : " + sub);
                            LocalDate startDate = LocalDate.of(2023, 4, 21);
                            LocalDate endDate = startDate.plus(days, ChronoUnit.DAYS);
                            System.out.println("Since : " + startDate + " Expiry date 3G : " + endDate);
                        }
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

                double sub = 0;
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
                        if (nap > account.getAccountAmount() || nap > 1000) {
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
                    case 0:
                        System.exit(0);
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
        System.out.println("Enter the number of the person you want to top up : ");
        int nguoiNap = sc.nextInt();
        double sum = 0;
        for (Account account : accountList) {
            if (account.getAccountNumber() == nguoiNap) {
                System.out.println(account);
                if (load >= 0) {
                    sum = load + account.getAccountAmount();
                    account.setAccountAmount(sum);
                } else {
                    System.out.println("""
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
        System.out.println("Number Account of person who wants to withdraw money  : ");
        int rutTien = sc.nextInt();
        System.out.println("Enter The Amount You Want To Withdraw : ");
        double deduction = sc.nextDouble();
        double sub = 0;
        double fee = 5;
        boolean check = false;
        for (Account account : accountList) {
            if (account.getAccountNumber() == rutTien) {
                System.out.println(account);
                sub += account.getAccountAmount() - (deduction + fee);
                System.out.println("Account balance : " + sub);
                account.setAccountAmount(sub);
                if (sub < 0) {
                    System.out.println("""
                            +-----------+
                            | Illegal ! |
                            +-----------+""");
                    break;
                }
                check =true;
                break;

            }
            if (deduction > account.getAccountAmount() || deduction < 0) {
                check = false;
                break;
            }
        }if (check){
            System.out.println("""
                    +------------------+
                    | Successfully...  |
                    +------------------+""");
        }else {
            System.out.println("""
                    +-----------+
                    | Illegal ! | 
                    +-----------+""");
        }

//        boolean check = false;
//        for (Account account : accountList) {
//            if (deduction < account.getAccountAmount()) {
//                sub = account.getAccountAmount() - (deduction + fee);
//                check = true;
//
//            }
//            if (account.getAccountNumber() == rutTien) {
//                System.out.println(account);
//                System.out.println("Account Balance : " + sub + "$");
//                account.setAccountAmount(sub);
//                check = true;
//                break;
//            }
//        }
//        if (check) {
//            System.out.println("Successful transaction....");
//        } else {
//            System.out.println("""
//                    +----------------+
//                    |Invalid account! |
//                    +----------------+""");
//        }

        writeFile.writeToFile(accountList);

    }

    public void transferMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Remitter's number : ");
        int tenChuyen = sc.nextInt();
        System.out.println("Amount you want to transfer : ");
        double tienChuyen = sc.nextDouble();
        sc.nextLine();
        System.out.println("Recipient's number : ");
        int nguoiNhan = sc.nextInt();
        for (Account account : accountList) {
            if (account.getAccountNumber() == tenChuyen) {
                System.out.println(account);
                if (tienChuyen < account.getAccountAmount()) {
                    System.out.println("Successful transfer : " + tienChuyen + "$");
                    double soDU;
                    soDU = account.getAccountAmount() - tienChuyen;
                    System.out.println("Account balance : " + soDU + "$");
                    account.setAccountAmount(soDU);

                    for (Account account1 : accountList) {
                        if (account1.getAccountNumber() == nguoiNhan) {
                            System.out.println(account1);
                            double nhanTien;
                            nhanTien = account1.getAccountAmount() + tienChuyen;
                            System.out.println("Successfully received money..... ");
                            System.out.println("The balance in the recipient's account :  " + nhanTien + "$");
                            account1.setAccountAmount(nhanTien);
                        }
                    }

                } else {
                    System.out.println("""
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
                System.out.println(account);
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
                boolean check = false;
                for (Account account : accountList) {
                    if (account.getNameAccount().equalsIgnoreCase(searchName)) {
                        System.out.println(account);
                        check = true;
                    }
                }
                if (check) {
                    System.out.println("successful search...");
                } else {
                    throw new IllegalAccessException("""
                            +------------+
                            | Illegal !  |
                            +------------+""");
                }

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
                accountList.sort(Comparator.comparing(account1 -> account1.getNameAccount()));
                for (Account account : accountList) {
                    System.out.println(account);
                }
            } else if (num.equals(xepSep)) {
                accountList.sort(Comparator.comparing(account1 -> account1.getAccountNumber()));
                for (Account account : accountList) {
                    System.out.println(account);
                }
            } else if (numMoney.equals(xepSep)) {
                accountList.sort(Comparator.comparing(account1 -> account1.getAccountAmount()));
                for (Account account : accountList) {
                    System.out.println(account);
                }
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
