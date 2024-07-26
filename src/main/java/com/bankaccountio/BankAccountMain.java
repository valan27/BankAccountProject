package com.bankaccountio;

import com.bankaccountdto.BankAccount;
import com.bankaccountservice.BankService;
import com.bankaccountservice.BankServiceImpl;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Scanner;

public class BankAccountMain {
    public static void main(String[] args) {
    //create();
    //remove();
    //update();
    //read();
        //byId();
        //byName();
       byBid();
         //groupby();



    }
    public static void create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter customer name: ");
        String customerName = sc.nextLine();
        System.out.println("Enter account balance: ");
        double accountBalance = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter city: ");
        String city = sc.nextLine();

        System.out.println("Enter branch code: ");
        int branchCode = sc.nextInt();
        BankAccount bankAccount1 = new BankAccount(accountNumber, customerName, accountBalance, city, branchCode);
        BankService bankService = new BankServiceImpl();
        bankService.create(bankAccount1);
        System.out.println("Bank account created");

    }
    public static void remove(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();
        BankAccount bankAccount1 = new BankAccount(accountNumber);
        BankService bankService = new BankServiceImpl();
        bankService.remove(bankAccount1);
        System.out.println("Bank account removed");
    }
    public static void update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter customer name: ");
        String customerName = sc.nextLine();
        System.out.println("Enter account balance: ");
        double accountBalance = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter city: ");
        String city = sc.nextLine();

        System.out.println("Enter branch code: ");
        int branchCode = sc.nextInt();
        BankAccount bankAccount3 = new BankAccount(accountNumber, customerName, accountBalance, city, branchCode);
        BankService bankService = new BankServiceImpl();
        bankService.update(bankAccount3);
        System.out.println("Bank account updated");

    }
    public static void read(){
        BankService bankService = new BankServiceImpl();
        List<BankAccount> bank = bankService.read();
        bank.forEach(System.out::println);
    }
    public static void byId(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Acc id:");
        int accnum = sc.nextInt();
        sc.nextLine();
        BankService bankService = new BankServiceImpl();
        List<BankAccount> l = bankService.byId(accnum);
        System.out.println("Details by Id");
        l.forEach(System.out::println);

    }
    public static void byName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Cust Name:");
        String custname = sc.nextLine();
        BankService bankService = new BankServiceImpl();
        List<BankAccount> l = bankService.byCustName(custname);
        System.out.println("Details by Name");
        l.forEach(System.out::println);

    }
    public static void byBid(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter branchcode id:");
        int bid = sc.nextInt();
        sc.nextLine();
        BankService bankService = new BankServiceImpl();
        List<BankAccount> l = bankService.byId(bid);
        System.out.println("Details by Branchcode");
        l.forEach(System.out::println);

    }
    public static void groupby(){
        BankService bankService = new BankServiceImpl();

        List<Object[]> bankAccGroupByCity =  bankService.getAllBankAccGroupByCity();
        System.out.println("Bank Account group by:");
        for (Object[] obj : bankAccGroupByCity) {
            System.out.println("City: " + obj[0] +
                    ", Branch Code: " + obj[1]);
         }
    }


}
