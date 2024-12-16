package Donggyu.src.bankproject.exception;

// 계좌를 찾을 수 없을 때 발생하는 예외
public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}