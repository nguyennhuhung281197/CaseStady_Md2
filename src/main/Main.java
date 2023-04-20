package main;

import controller.ManageAccount;
import fileio.ReadFile;
import fileio.WriteFile;
import modent.Account;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ManageAccount manageAccount = new ManageAccount();

        ManageAccount.Used();

        boolean isRun = true;
        while (isRun) {
            Scanner sc = new Scanner(System.in);
            System.out.println("""
                     =======================================
                     | 1.Add User Information              |
                     | 2.Display Information               |
                     | 3.Edit Information                  |
                     | 4.Delete Information                |
                     | 5.Search Name Information           |
                     | 6.Sort By Account Number            |
                     | 7.Deposit Money Into Your Account   |
                     | 8.Withdraw Money                    |
                     | 9.Transfer Money                    |
                     | 10.Ghi file                         |
                     =======================================
                    """);
            System.out.println("PLEASE ENTER : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    manageAccount.addAccount();
                    break;
                case 2:
                    manageAccount.display();

                    break;
                case 3:
                    manageAccount.updateAccount();
                    break;
                case 4:
                    manageAccount.removeAccount();
                    break;
                case 5:
                    manageAccount.searchAccount();
                    break;
                case 6:
                    manageAccount.sortAccount();

                    break;
                case 7:
                    manageAccount.loadMoney();
                    break;
                case 8:
                    manageAccount.withdrawMoney();
                    break;
                case 9:
                    manageAccount.transferMoney();
                    break;
                case 0:
                    isRun = false;
                    break;
            }
        }

    }
}
