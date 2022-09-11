package com.company;

public class Atms {
    private int numberOf1000;
    private int numberOf500;
    private int numberOf100;
    private int balance;
    private int withdrawCalculate;
    private int bankNoteRequired;

    public Atms(int numberOf1000, int numberOf500, int numberOf100, int balance) {
        this.numberOf1000 = numberOf1000;
        this.numberOf500 = numberOf500;
        this.numberOf100 = numberOf100;
        this.balance = balance;
    }

    public void deposit(int numberOf1000, int numberOf500, int numberOf100, int balance) {
        this.numberOf1000 = this.numberOf1000 + numberOf1000;
        this.numberOf500 = this.numberOf500 + numberOf500;
        this.numberOf100 = this.numberOf100 + numberOf100;
        this.balance = this.balance + balance;
    }

    public int getNumberOf1000() {
        return numberOf1000;
    }

    public int getNumberOf500() {
        return numberOf500;
    }

    public int getNumberOf100() {
        return numberOf100;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Atms{" +
                "numberOf1000=" + numberOf1000 +
                ", numberOf500=" + numberOf500 +
                ", numberOf100=" + numberOf100 +
                ", balance=" + balance +
                '}';
    }

    public void increaseNumberOfBankNote(int numberOf1000, int numberOf500, int numberOf100) {
        this.numberOf1000 = this.numberOf1000 + numberOf1000;
        this.numberOf500 = this.numberOf500 + numberOf500;
        this.numberOf100 = this.numberOf100 + numberOf100;
    }

    public int withdraw(int amount) {
        if (amount > balance) {
            return -1;
        }
        if (amount % 100 != 0) {
            return -2;
        }
        this.withdrawCalculate = amount;
        if (withdrawCalculate >= 1000) {
            this.bankNoteRequired = withdrawCalculate / 1000;
            if (this.numberOf1000 < this.bankNoteRequired) {
                this.withdrawCalculate = this.withdrawCalculate - (this.numberOf1000 * 1000);
                this.numberOf1000 = 0;
            } else {
                this.withdrawCalculate = this.withdrawCalculate - (this.bankNoteRequired * 1000);
                this.numberOf1000 = this.numberOf1000 - this.bankNoteRequired;
            }
        }
        if (withdrawCalculate >= 500) {
            this.bankNoteRequired = withdrawCalculate / 500;
            if (this.numberOf500 < this.bankNoteRequired) {
                this.withdrawCalculate = this.withdrawCalculate - (this.numberOf500 * 500);
                this.numberOf500 = 0;
            } else {
                this.withdrawCalculate = this.withdrawCalculate - (this.bankNoteRequired * 500);
                this.numberOf500 = this.numberOf500 - this.bankNoteRequired;
            }
        }
        if (withdrawCalculate >= 100) {
            this.bankNoteRequired = withdrawCalculate / 100;
            if (this.numberOf100 < this.bankNoteRequired) {
                this.withdrawCalculate = this.withdrawCalculate - (this.numberOf100 * 100);
                this.numberOf100 = 0;
            } else {
                this.withdrawCalculate = this.withdrawCalculate - (this.bankNoteRequired * 100);
                this.numberOf100 = this.numberOf100 - this.bankNoteRequired;
            }
        }
        if (withdrawCalculate != 0) {
            return 0;
        }
        this.balance = this.balance - amount;
        return amount;
    }
}
