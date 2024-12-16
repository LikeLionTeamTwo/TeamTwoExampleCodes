package Donggyu.src.bankproject.exception;

// 은행 작업 중 일반적인 문제를 나타내는 예외
public class BankOperationException extends Exception {
    public BankOperationException(String message) {
        super(message);
    }
}