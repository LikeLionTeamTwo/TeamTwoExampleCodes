package Junho.실습문제.bankProject.exception;

public class AccountNotFoundException extends BankException{

    public AccountNotFoundException(){
        super("계좌 번호로 조회할 때 존재하지 않습니다.");
    }

    public AccountNotFoundException(String message){
        super(message);
    }


}
