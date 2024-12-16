package Junho.실습문제.bankProject.exception;

public class BankOperationException extends BankException {

    public BankOperationException(){
        super("고객이나 계좌 등록 시 최대 개수를 초과합니다.");
    }
    public BankOperationException(String message){
        super(message);
    }
}
