package Junho.실습문제.bankProject.exception;

public class InvalidTransactionException extends BankException {

    public InvalidTransactionException(){
        super("입출금 금액이 0 이하이거나 잔액이 부족합니다.");
    }
    public InvalidTransactionException(String message){
        super(message);
    }
}
