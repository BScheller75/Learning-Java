package com.trainCGI;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BankAccount myBank = new BankAccount("Brendan",
                "Bks5361");
        //Display text asking user what they want to do
        myBank.showMenu();

    }

     static class BankAccount{
        int balance;
        int previousTransaction;
        String customerName;
        String customerId;

        public BankAccount(String name, String cid){
            customerName = name;
            customerId = cid;
        }

         void deposit(int amount){
            if(amount != 0){
                balance = balance + amount;
                previousTransaction = amount;
            }
        }

         void withdraw(int amount){
            if(amount != 0){
                balance = balance - amount;
                previousTransaction = -amount;
            }
        }

         void getPreviousTransaction(){
            if(previousTransaction >0){
                System.out.println("Deposited: " +
                        previousTransaction);
            }
            else if(previousTransaction<0){
                System.out.println("Withdrew: " +
                        Math.abs(previousTransaction));
            }
            else{
                System.out.println("No transaction occurred");
            }
        }

         void showMenu(){
            char option;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome " + customerName);
            System.out.println("Your ID is " + customerId);
            System.out.println();
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Exit");

            do {
                System.out.println();
                System.out.println("Enter an option");
                option = scanner.next().charAt(0);

                switch(option){
                    case 'A':
                        System.out.println("Balance = " + balance);
                        System.out.println();
                        break;
                    case 'B':
                        System.out.println("Enter an amount to deposit");
                        int amount = scanner.nextInt();
                        deposit(amount);
                        System.out.println();
                        break;
                    case 'C':
                        System.out.println("Enter an amount to withdraw");
                        int amount2 = scanner.nextInt();
                        withdraw(amount2);
                        System.out.println();
                        break;
                    case 'D':
                        getPreviousTransaction();
                        System.out.println();
                        break;
                    case 'E':
                        System.out.println("*****************************************");
                        break;
                    default:
                        System.out.println("Invalid option! Please enter again ");
                        System.out.println();
                }
            } while(option != 'E');
            System.out.println("Thank you for using our services");
        }
    }
}
