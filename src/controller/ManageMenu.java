package controller;

import java.util.Scanner;

public class ManageMenu {

    public static void getMenu(){
        ManageAccount manageAccount = new ManageAccount();
        Scanner sc = new Scanner(System.in);
        boolean isRun = true;
        while(isRun){

            System.out.println("""
                 =======================================
                 | 1.Add User Information              |
                 | 2.Display Information               |
                 | 3.Edit Information                  |
                 | 4.Delete Information                |
                 | 5.Search Name Information           |
                 | 6.Sort By Account Number            |
                 | 7.Load Money                        |
                 | 8.Withdraw Money                    |
                 | 9.Transfer Money                    |
                 | 10.nap the                          |
                 | 11.dki 3g                           |
                 | 12.check
                 | 0.Exit
                 =======================================
                """);
            System.out.println("PLEASE ENTER : ");
            int choice1 = sc.nextInt();
            sc.nextLine();

            switch (choice1) {
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
                case 10:
                    manageAccount.rechargeCard();
                    break;
                case 11:
                    manageAccount.register3G();
                    break;
                case 0:
                    System.exit(0);
                    isRun = false;
                    break;
                default:
                    System.out.println("""
                        +----------+
                        | Illegal !|
                        +----------+""");
            }

        }
    }

}
