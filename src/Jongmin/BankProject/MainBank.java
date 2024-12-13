package BankProject;
import java.util.Scanner;

public class MainBank {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=== 라이온 은행 시스템 ===");
            System.out.println("1. 고객 등록");
            System.out.println("2. 계좌 생성");
            System.out.println("3. 입금");
            System.out.println("4. 출금");
            System.out.println("5. 잔액 조회");
            System.out.println("6. 종료");
            System.out.print("선택: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("고객 ID: ");
                        String id = scanner.nextLine();
                        System.out.print("고객 이름: ");
                        String name = scanner.nextLine();
                        bank.addCustomer(new Customer(id, name));
                        System.out.println("고객 등록 완료!");
                    }
                    case 2 -> {
                        System.out.print("고객 ID: ");
                        String id = scanner.nextLine();
                        Customer customer = bank.findCustomer(id);
                        System.out.print("계좌 번호: ");
                        String accountNumber = scanner.nextLine();
                        System.out.print("초기 입금액: ");
                        double initialDeposit = scanner.nextDouble();
                        customer.addAccount(new Account(accountNumber, initialDeposit));
                        System.out.println("계좌 생성 완료!");
                    }
                    case 3 -> {
                        System.out.print("계좌 번호: ");
                        String accountNumber = scanner.nextLine();
                        System.out.print("입금액: ");
                        double amount = scanner.nextDouble();
                        Account account = bank.findAccount(accountNumber);
                        account.deposit(amount);
                        System.out.println("입금 완료!");
                    }
                    case 4 -> {
                        System.out.print("계좌 번호: ");
                        String accountNumber = scanner.nextLine();
                        System.out.print("출금액: ");
                        double amount = scanner.nextDouble();
                        Account account = bank.findAccount(accountNumber);
                        account.withdraw(amount);
                        System.out.println("출금 완료!");
                    }
                    case 5 -> {
                        System.out.print("계좌 번호: ");
                        String accountNumber = scanner.nextLine();
                        Account account = bank.findAccount(accountNumber);
                        System.out.println("현재 잔액: " + account.getBalance());
                    }
                    case 6 -> running = false;
                    default -> System.out.println("Select between 1 and 6");
                }
            } catch (Exception e) {
                System.out.println("오류: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("프로그램을 종료합니다.");
    }
}
