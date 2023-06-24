import java.util.Scanner;


import static java.lang.Math.*;

public class Account {
    //Class Variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //Class Constructor
    Account(String cname, String cid){
        customerName = cname;
        customerID = cid;
    }

    //Function for depositing money
    void deposit(int amount) {
        if (amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    //Function for withdrawing money
    void withdraw(int amount){
        if (amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    //Function for showing the previous transaction
    void getPreviousTransaction(){
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0){
            System.out.println("Withdrawn: " +Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }

    }

    //Function for calculating interest of the current funds after a number of years
    void calculateInterest(int years){
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    //Function showing the main menu
    void showMenu(){
        char option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome. " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                //Case 'A' allows the user to check their account balance
                case 'A' -> {
                    System.out.println("=========================================");
                    System.out.println("Balance = R" + balance);
                    System.out.println("=========================================");
                    System.out.println();
                }
                //Case 'B' allows the user to deposit money into their account using
                case 'B' -> {
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                }
                //Case 'C' allows the user to withdraw money from their account using
                case 'C' -> {
                    System.out.println("Enter the amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                }
                //Case 'D' allows a user to view their most recent transaction using
                case 'D' -> {
                    System.out.println("=========================================");
                    getPreviousTransaction();
                    System.out.println("=========================================");
                    System.out.println();
                }
                //Case 'E' calculates the accrued interest on the account after a selected number of years
                case 'E' -> {
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                }
                //Case 'F' exits the user from the account
                case 'F' -> System.out.println("=========================================");

                //The default case lets the user know that they entered an invalid character
                default -> System.out.println("Error: invalid option. Please enter A, B, C, D, E or F");
            }
        }while (option != 'F');
        System.out.println("Thank you for banking with us!");
    }
}
