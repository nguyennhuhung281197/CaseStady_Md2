package modent;

import java.io.Serializable;

public class Account implements Serializable {
    private int accountNumber;
    private String nameAccount;
    private double accountAmount;

    public Account() {
    }

    public Account(int accountNumber, String nameAccount, double accountAmount) {
        this.accountNumber = accountNumber;
        this.nameAccount = nameAccount;
        this.accountAmount = accountAmount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public double getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(double accountAmount) {
        this.accountAmount = accountAmount;
    }

    @Override
    public String toString() {
        return "" + '\t'+'\t'+'\t' + accountNumber + '\t'+'\t'+'\t' + nameAccount + '\t'+'\t'+'\t' + accountAmount + "$";
    }


}
