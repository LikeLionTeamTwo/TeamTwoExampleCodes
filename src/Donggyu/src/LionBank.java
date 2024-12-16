package Donggyu.src;

import Donggyu.src.bankproject.exception.AccountNotFoundException;
import Donggyu.src.bankproject.exception.InvalidTransactionException;

import java.util.Scanner;

public class LionBank {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        boolean power = true;

        System.out.println("=================================");
        System.out.println("==Lion Bank에 오신 것을 환영합니다.==");

        while (power) {
            System.out.println("=================================");
            System.out.println("==메뉴를 선택해주세요.==");
            System.out.println("=== 라이온 은행 시스템 ===");
            System.out.println("1. 고객 등록");
            System.out.println("2. 계좌 생성");
            System.out.println("3. 입금");
            System.out.println("4. 출금");
            System.out.println("5. 잔액 조회");
            System.out.println("6. 종료");
            System.out.print("선택: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("고객등록을 선택하셨습니다. 고객님의 ID를 입력해주세요: ");
                    String customerId = sc.nextLine();
                    System.out.println("고객님의 성함을 입력해주세요: ");
                    String customerName = sc.nextLine();
                    Customer customer = new Customer(customerId, customerName);
                    bank.addCustomer(customer);
                    break;

                case 2:
                    System.out.println("계좌 생성을 선택하셨습니다. 고객 ID를 입력해주세요: ");
                    customerId = sc.nextLine();
                    Customer foundCustomer = bank.findCustomer(customerId);
                    if (foundCustomer != null) {
                        System.out.println("계좌 번호를 입력해주세요: ");
                        String accountNumber = sc.nextLine();
                        Account account = new Account(accountNumber, customerId);
                        foundCustomer.addAccount(account);
                    } else {
                        System.out.println("고객 ID를 찾을 수 없습니다.");
                    }
                    break;

                case 3: // 입금
                    try {
                        System.out.println("입금을 선택하셨습니다. 계좌 번호를 입력해주세요: ");
                        String accountNumber = sc.nextLine(); // 계좌번호 입력
                        System.out.println("입금할 금액을 입력해주세요: ");
                        double depositAmount = sc.nextDouble(); // 입금 금액 입력
                        sc.nextLine(); // 버퍼 정리

                        Account depositAccount = findAccountInBank(bank, accountNumber); // 계좌 검색
                        depositAccount.deposit(depositAmount); // 입금 처리
                        System.out.println("입금이 완료되었습니다.");
                    } catch (AccountNotFoundException | InvalidTransactionException e) {
                        System.out.println("오류: " + e.getMessage());
                    }
                    break;

                case 4: // 출금
                    try {
                        System.out.println("출금을 선택하셨습니다. 계좌 번호를 입력해주세요: ");
                        String accountNumber = sc.nextLine(); // 계좌번호 입력
                        System.out.println("출금할 금액을 입력해주세요: ");
                        double withdrawAmount = sc.nextDouble(); // 출금 금액 입력
                        sc.nextLine(); // 버퍼 정리

                        Account withdrawAccount = findAccountInBank(bank, accountNumber); // 계좌 검색
                        withdrawAccount.withdraw(withdrawAmount); // 출금 처리
                        System.out.println("출금이 완료되었습니다.");
                    } catch (AccountNotFoundException | InvalidTransactionException e) {
                        System.out.println("오류: " + e.getMessage());
                    }
                    break;

                case 5: // 잔액 조회
                    try {
                        System.out.println("잔액 조회를 선택하셨습니다. 계좌 번호를 입력해주세요: ");
                        String accountNumber = sc.nextLine(); // 계좌번호 입력

                        Account balanceAccount = findAccountInBank(bank, accountNumber); // 계좌 검색
                        System.out.println("현재 잔액: " + balanceAccount.getBalance()); // 잔액 출력
                    } catch (AccountNotFoundException e) {
                        System.out.println("오류: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("이용해주셔서 감사합니다. 프로그램을 종료합니다.");
                    power = false;
                    break;

                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }

        sc.close();
    }

    private static Account findAccountInBank(Bank bank, String accountNumber) throws AccountNotFoundException {
        for (Customer customer : bank.getCustomers()) {
            if (customer != null) {
                Account account = customer.findAccount(accountNumber);
                if (account != null) {
                    return account;
                }
            }
        }
        throw new AccountNotFoundException("계좌 번호를 찾을 수 없습니다: " + accountNumber);
    }


}
