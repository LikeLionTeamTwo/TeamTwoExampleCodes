package Junho.실습문제.bankProject;


import Junho.실습문제.bankProject.exception.BankException;
import Junho.실습문제.bankProject.exception.BankOperationException;
import Junho.실습문제.bankProject.exception.InvalidTransactionException;

import java.util.Scanner;

public class Main {
    public void start(Bank bank)  {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== " + bank.name + " 은행 시스템 ===");
        int selectedNum = 0;
        while(selectedNum != 6){
            try{
                selectedNum = menu(sc);
                if(selectedNum == 1){
                    addCustomer(sc, bank);
                } else if(selectedNum == 2){
                    inputInfoAccount(sc, bank);
                } else if (selectedNum == 3){
                    Account account = findAccount(sc, bank);
                    deposit(sc,account);
                } else if( selectedNum == 4){
                    Account account = findAccount(sc, bank);
                    withdrawal(sc, account);
                } else if (selectedNum == 5) {
                    Account account = findAccount(sc, bank);
                    printBalance(account);
                }
            } catch (Exception e){
                System.out.println("다시 제대로 입력하세요. ");
                System.out.println();
                sc = new Scanner(System.in);
            }

        }

    }

    public void printBalance(Account account){
        System.out.println("남은 잔액: " + account.balance);
    }
    public void withdrawal(Scanner sc, Account account){
        System.out.print("출금할 금액을 입력하세요. : ");
        int money = sc.nextInt();
        try {
            account.withdrawal(money);
        } catch (InvalidTransactionException e){
            System.out.println(e);
        }
    }
    public void deposit(Scanner sc, Account account){
        System.out.print("입급할 돈을 입력하세요. ");
        int inputMoney = sc.nextInt();
        try {
            account.deposit(inputMoney);
        }  catch (InvalidTransactionException e){
            System.out.println(e);
        }

    }
    //find Account
    public Account findAccount(Scanner sc, Bank bank){
        //고객 id -> 계좌 찾고 -> 입금 하기
        sc.nextLine();
        Account account;
        try {
            System.out.print("고객 id를 입력하세요: ");
            String customerId = sc.nextLine();
            Customer customer = bank.findCustomer(customerId);
            System.out.print("계좌 번호 입력: ");
            int accountNumber = sc.nextInt();
            return account = customer.findAccount(accountNumber);

        } catch (BankException e){
            System.out.println(e);
        }

        return null;
    }
    public void inputInfoAccount(Scanner sc, Bank bank)  {
        sc.nextLine();
        System.out.println("계좌 생성을 시작합니다. !");
        System.out.print("고객 id를 입력하세요: ");
        String id = sc.nextLine();
        try{
            Customer customer = bank.findCustomer(id);
            //계좌 생성하기
            System.out.print("계좌 번호 입력: ");
            int accountNumber = sc.nextInt();
            Account account = new Account(accountNumber, customer.id);
            customer.addAccount(account);
        } catch (BankOperationException e){
            System.out.println(e);
        }


    }
    public Customer inputInfoCustomer(Scanner sc){
        sc.nextLine();
        System.out.println("고객 등록을 시작합니다. !");
        System.out.print("고객 id를 입력하세요: ");
        String id = sc.nextLine();
        System.out.print("name을 입력하세요: ");
        String name = sc.nextLine();
        return new Customer(id, name);
    }
    public void addCustomer(Scanner sc, Bank bank){
        try{
            bank.addCustomer(this.inputInfoCustomer(sc));

        }catch (BankOperationException e){
            System.out.println(e);
        }
    }
    public int menu(Scanner sc){
        System.out.println("1. 고객 등록");
        System.out.println("2. 계좌 생성");
        System.out.println("3. 입금");
        System.out.println("4. 출금");
        System.out.println("5. 잔액 조회");
        System.out.println("6. 종료");
        System.out.print("번호를 선택하세요: ");
        int selectedNum = sc.nextInt();
        System.out.println();
        return selectedNum;
    }


    public static void main(String[] args) {
        Main main = new Main();
        Bank bank = new Bank("라이온");
        main.start(bank);
    }
}
