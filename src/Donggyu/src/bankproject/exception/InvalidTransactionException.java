package Donggyu.src.bankproject.exception;

// 입출금과 같은 트랜잭션이 잘못되었을 때 발생하는 예외
public class InvalidTransactionException extends Exception {
    public InvalidTransactionException(String message) {
        super(message);
    }
}